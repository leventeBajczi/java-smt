/*
 *  JavaSMT is an API wrapper for a collection of SMT solvers.
 *  This file is part of JavaSMT.
 *
 *  Copyright (C) 2007-2019  Dirk Beyer
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.sosy_lab.java_smt.solvers.yices2;

import static org.sosy_lab.java_smt.solvers.yices2.Yices2NativeApi.yices_get_major_version;
import static org.sosy_lab.java_smt.solvers.yices2.Yices2NativeApi.yices_get_patch_level;
import static org.sosy_lab.java_smt.solvers.yices2.Yices2NativeApi.yices_get_version;
import static org.sosy_lab.java_smt.solvers.yices2.Yices2NativeApi.yices_init;

import java.util.Set;
import org.sosy_lab.common.NativeLibraries;
import org.sosy_lab.common.ShutdownNotifier;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.InterpolatingProverEnvironment;
import org.sosy_lab.java_smt.api.OptimizationProverEnvironment;
import org.sosy_lab.java_smt.api.ProverEnvironment;
import org.sosy_lab.java_smt.basicimpl.AbstractNumeralFormulaManager.NonLinearArithmetic;
import org.sosy_lab.java_smt.basicimpl.AbstractSolverContext;

public class Yices2SolverContext extends AbstractSolverContext {

  private final Yices2FormulaCreator creator;
  private final BooleanFormulaManager bfmgr;
  private final ShutdownNotifier shutdownManager;

  private static boolean loaded = false;

  public Yices2SolverContext(
      FormulaManager pFmgr,
      Yices2FormulaCreator creator,
      BooleanFormulaManager pBfmgr,
      ShutdownNotifier pShutdownManager) {
    super(pFmgr);
    this.creator = creator;
    bfmgr = pBfmgr;
    shutdownManager = pShutdownManager;
  }

  public static Yices2SolverContext create(
      NonLinearArithmetic pNonLinearArithmetic, ShutdownNotifier pShutdownManager) {

    if (!loaded) {
      // Avoid loading and initializing twice,
      // because this would make all existing terms and types unavailable,
      // which is bad behavior and a potential memory leak.
      NativeLibraries.loadLibrary("yices2j");
      yices_init();
    }
    loaded = true;

    Yices2FormulaCreator creator = new Yices2FormulaCreator();
    Yices2UFManager functionTheory = new Yices2UFManager(creator);
    Yices2BooleanFormulaManager booleanTheory = new Yices2BooleanFormulaManager(creator);
    Yices2BitvectorFormulaManager bitvectorTheory = new Yices2BitvectorFormulaManager(creator);
    Yices2IntegerFormulaManager integerTheory =
        new Yices2IntegerFormulaManager(creator, pNonLinearArithmetic);
    Yices2RationalFormulaManager rationalTheory =
        new Yices2RationalFormulaManager(creator, pNonLinearArithmetic);
    Yices2FormulaManager manager =
        new Yices2FormulaManager(
            creator, functionTheory, booleanTheory, integerTheory, rationalTheory, bitvectorTheory);
    return new Yices2SolverContext(manager, creator, booleanTheory, pShutdownManager);
  }

  @Override
  public String getVersion() {
    return String.format(
        "%d.%d.%d", yices_get_version(), yices_get_major_version(), yices_get_patch_level());
  }

  @Override
  public Solvers getSolverName() {
    return Solvers.YICES2;
  }

  @Override
  public void close() {
    // exit disabled, because it crashes parallel Yices2 instances, see yices_init() above.
    // yices_exit();
  }

  @Override
  protected ProverEnvironment newProverEnvironment0(Set<ProverOptions> pOptions) {
    return new Yices2TheoremProver(creator, pOptions, bfmgr, shutdownManager);
  }

  @Override
  protected InterpolatingProverEnvironment<?> newProverEnvironmentWithInterpolation0(
      Set<ProverOptions> pSet) {
    throw new UnsupportedOperationException("Yices does not support interpolation");
  }

  @Override
  protected OptimizationProverEnvironment newOptimizationProverEnvironment0(
      Set<ProverOptions> pSet) {
    throw new UnsupportedOperationException("Yices does not support optimization");
  }

  @Override
  protected boolean supportsAssumptionSolving() {
    return true;
  }
}
