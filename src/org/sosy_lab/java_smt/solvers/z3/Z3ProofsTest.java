
package org.sosy_lab.java_smt.solvers.z3;

import com.microsoft.z3.*;


import static org.junit.Assert.assertTrue;

import com.microsoft.z3.Context;
import com.microsoft.z3.Solver;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sosy_lab.common.NativeLibraries;
import org.sosy_lab.common.ShutdownManager;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.log.BasicLogManager;
import org.sosy_lab.common.log.LogManager;

import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.FloatingPointRoundingMode;

import org.sosy_lab.java_smt.api.SolverException;
import org.sosy_lab.java_smt.basicimpl.AbstractNumeralFormulaManager.NonLinearArithmetic;


public class Z3ProofsTest {

  private Z3SolverContext context;
  private Z3FormulaManager mgr;
  private Z3BooleanFormulaManager bmgr;

  @Before
  public void setUpSolver() throws Exception {
    Configuration config =
        Configuration.builder().setOption("solver.z3.requireProofs", "true").build();
    LogManager logger = BasicLogManager.create(config);
    ShutdownManager shutdown = ShutdownManager.create();

    // Create new context with SMTInterpol
    context = Z3SolverContext.create(
        logger,
        config,
        shutdown.getNotifier(),
        null,  // no logfile
        42,    // random seed value
        FloatingPointRoundingMode.NEAREST_TIES_TO_EVEN,
        NonLinearArithmetic.USE,
        NativeLibraries::loadLibrary
    );
    mgr = (Z3FormulaManager) context.getFormulaManager();
    bmgr = (Z3BooleanFormulaManager) mgr.getBooleanFormulaManager();
  }

  @After
  public void closeSolver() {
    if (context != null) {
      context.close();
    }
  }

  @Test
  public void testTraverseProof() throws SolverException, InterruptedException {
    //example from the 2022 paper
    BooleanFormula q1 = bmgr.makeVariable("q1");
    BooleanFormula q2 = bmgr.makeVariable("q2");

    Z3TheoremProver prover = (Z3TheoremProver) context.newProverEnvironment0(Set.of());
    try {
      System.out.println("proofs enabled: " + context.getGenerateProofs());
      prover.addConstraint(bmgr.or(bmgr.not(q1), q2));
      prover.addConstraint(q1);
      prover.addConstraint(bmgr.not(q2));
      assertTrue(prover.isUnsat());

      long proof = prover.getZ3Proof();


    } finally {
      prover.close();
    }
  }

  public static Context createContextWithRawPointer(long m_ctx) {
    try {
      Constructor<Context> constructor = Context.class.getDeclaredConstructor(long.class);
      constructor.setAccessible(true); // allow access even if non‑public
      return constructor.newInstance(m_ctx);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create Context instance", e);
    }
  }

  @Test
  public void Z3ProofTest() {
    HashMap<String, String> cfg = new HashMap<>();
    cfg.put("proof", "true");
    Context ctx = new Context(cfg);
    try {
      // Create boolean variables
      BoolExpr q1 = ctx.mkBoolConst("q1");
      BoolExpr q2 = ctx.mkBoolConst("q2");

      // Create solver
      Solver solver = ctx.mkSolver();

      // Assert (or (not q1) q2)
      solver.add(ctx.mkOr(ctx.mkNot(q1), q2));

      // Assert q1
      solver.add(q1);

      // Assert (not q2)
      solver.add(ctx.mkNot(q2));

      Status status = solver.check();

      System.out.println("Unsat: " + (status == Status.UNSATISFIABLE));

      Expr<?> proof = solver.getProof();
      System.out.println("proof: " + proof);
      System.out.println(Version.getFullVersion());
    } finally {
      ctx.close();
    }
  }

  public void encapsulateTest() {
    HashMap<String, String> cfg = new HashMap<>();
    cfg.put("proof", "true");
    Context ctx = new Context(cfg);
    try {
      // Create boolean variables
      BoolExpr q1 = ctx.mkBoolConst("q1");
      BoolExpr q2 = ctx.mkBoolConst("q2");

      // Create solver
      Solver solver = ctx.mkSolver();

      // Assert (or (not q1) q2)
      solver.add(ctx.mkOr(ctx.mkNot(q1), q2));

      // Assert q1
      solver.add(q1);

      // Assert (not q2)
      solver.add(ctx.mkNot(q2));

      Status status = solver.check();

      System.out.println("Unsat: " + (status == Status.UNSATISFIABLE));

      //Formula proof = Native.solverGetProof(ctx.nCtx(), );
     // System.out.println("proof: " + proof);
      System.out.println(Version.getFullVersion());
    } finally {
      ctx.close();
    }
  }
}

