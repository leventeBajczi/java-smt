/*
 *  JavaSMT is an API wrapper for a collection of SMT solvers.
 *  This file is part of JavaSMT.
 *
 *  Copyright (C) 2007-2015  Dirk Beyer
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
package org.sosy_lab.solver.mathsat5;

import static com.google.common.base.Preconditions.checkArgument;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_decl_get_arg_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_decl_get_arity;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_decl_get_name;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_decl_get_return_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_declare_function;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_get_function_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_is_bv_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_is_fp_roundingmode_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_is_integer_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_is_rational_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_make_bv_uleq;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_make_leq;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_make_term;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_make_uf;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_arity;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_get_arg;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_get_decl;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_get_type;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_is_atom;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_is_constant;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_is_equal;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_is_number;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_is_uf;
import static org.sosy_lab.solver.mathsat5.Mathsat5NativeApi.msat_term_repr;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;

import org.sosy_lab.solver.api.Formula;
import org.sosy_lab.solver.basicimpl.AbstractUnsafeFormulaManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Mathsat5UnsafeFormulaManager extends AbstractUnsafeFormulaManager<Long, Long, Long> {

  private final long msatEnv;
  private final Mathsat5FormulaCreator creator;

  Mathsat5UnsafeFormulaManager(Mathsat5FormulaCreator pCreator) {
    super(pCreator);
    this.msatEnv = pCreator.getEnv();
    this.creator = pCreator;
  }

  @Override
  public boolean isAtom(Long t) {
    return msat_term_is_atom(msatEnv, t);
  }

  @Override
  public int getArity(Long pT) {
    return msat_term_arity(pT);
  }

  @Override
  public Formula getArg(Formula pF, int pN) {
    long f = Mathsat5FormulaManager.getMsatTerm(pF);
    long arg = msat_term_get_arg(f, pN);
    if (msat_is_fp_roundingmode_type(msatEnv, msat_term_get_type(arg))) {
      // We have terms that are of type fp_roundingmode
      // (for example, arguments to floating-point arithmetic operators),
      // but we do not want to work with them.
      // So we just return an untyped formula here.
      return new Mathsat5Formula(arg) {};
    }
    return super.getArg(pF, pN);
  }

  @Override
  public Long getArg(Long t, int n) {
    return msat_term_get_arg(t, n);
  }

  @Override
  public boolean isVariable(Long t) {
    return msat_term_is_constant(msatEnv, t);
  }

  @Override
  public boolean isUF(Long t) {
    return msat_term_is_uf(msatEnv, t);
  }

  @Override
  public String getName(Long t) {
    if (isUF(t)) {
      return msat_decl_get_name(msat_term_get_decl(t));
    } else if (isVariable(t)) {
      return msat_term_repr(t);
    } else {
      throw new IllegalArgumentException("Can't get the name from the given formula!");
    }
  }

  @Override
  public Long replaceArgs(Long t, List<Long> newArgs) {
    long tDecl = msat_term_get_decl(t);
    return msat_make_term(msatEnv, tDecl, Longs.toArray(newArgs));
  }

  @Override
  public Long replaceArgsAndName(Long t, String newName, List<Long> newArgs) {
    if (isUF(t)) {
      long decl = msat_term_get_decl(t);
      int arity = msat_decl_get_arity(decl);
      long retType = msat_decl_get_return_type(decl);
      long[] argTypes = new long[arity];
      for (int i = 0; i < arity; i++) {
        argTypes[i] = msat_decl_get_arg_type(decl, i);
      }
      long funcType = msat_get_function_type(msatEnv, argTypes, argTypes.length, retType);
      long funcDecl = msat_declare_function(msatEnv, newName, funcType);
      return msat_make_uf(msatEnv, funcDecl, Longs.toArray(newArgs));
    } else if (isVariable(t)) {
      checkArgument(newArgs.isEmpty());
      return creator.makeVariable(msat_term_get_type(t), newName);
    } else {
      throw new IllegalArgumentException("Can't set the name from the given formula!");
    }
  }

  @Override
  protected List<Long> splitNumeralEqualityIfPossible(Long pF) {
    if (msat_term_is_equal(msatEnv, pF) && getArity(pF) == 2) {
      long arg0 = msat_term_get_arg(pF, 0);
      long arg1 = msat_term_get_arg(pF, 1);
      long type = msat_term_get_type(arg0);
      if (msat_is_bv_type(msatEnv, type)) {
        return ImmutableList.of(
            msat_make_bv_uleq(msatEnv, arg0, arg1), msat_make_bv_uleq(msatEnv, arg1, arg0));
      } else if (msat_is_integer_type(msatEnv, type) || msat_is_rational_type(msatEnv, type)) {
        return ImmutableList.of(
            msat_make_leq(msatEnv, arg0, arg1), msat_make_leq(msatEnv, arg1, arg0));
      }
    }
    return ImmutableList.of(pF);
  }

  @Override
  public boolean isNumber(Long pT) {
    return msat_term_is_number(msatEnv, pT);
  }

  @Override
  protected Long substitute(Long expr, List<Long> substituteFrom, List<Long> substituteTo) {
    checkArgument(substituteFrom.size() == substituteTo.size());
    Map<Long, Long> replacements = new HashMap<>();
    for (int i = 0; i < substituteFrom.size(); i++) {
      replacements.put(substituteFrom.get(i), substituteTo.get(i));
    }
    return recSubstitute(expr, replacements);
  }

  private long recSubstitute(Long expr, Map<Long, Long> memoization) {

    Long out = memoization.get(expr);

    if (out == null) {
      int arity = getArity(expr);
      long[] updatedChildren = new long[arity];
      for (int childIdx = 0; childIdx < arity; childIdx++) {
        long child = getArg(expr, childIdx);
        updatedChildren[childIdx] = recSubstitute(child, memoization);
      }

      long decl = msat_term_get_decl(expr);
      out = msat_make_term(msatEnv, decl, updatedChildren);

      memoization.put(expr, out);
    }

    return out;
  }

  @Override
  protected boolean isQuantification(Long pT) {
    return false;
  }

  @Override
  protected boolean isFreeVariable(Long pT) {
    return isVariable(pT);
  }

  @Override
  protected boolean isBoundVariable(Long pT) {
    return false;
  }

  @Override
  protected Long getQuantifiedBody(Long pT) {
    throw new UnsupportedOperationException();
  }

  @Override
  protected Long replaceQuantifiedBody(Long pF, Long pBody) {
    throw new UnsupportedOperationException();
  }
}
