/*
 *  JavaSMT is an API wrapper for a collection of SMT solvers.
 *  This file is part of JavaSMT.
 *
 *  Copyright (C) 2007-2016  Dirk Beyer
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

package org.sosy_lab.java_smt.solvers.bitwuzla;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

public final class BitwuzlaKind {
  public static final BitwuzlaKind BITWUZLA_KIND_CONSTANT =
      new BitwuzlaKind("BITWUZLA_KIND_CONSTANT", bitwuzlaJNI.BITWUZLA_KIND_CONSTANT_get());
  public static final BitwuzlaKind BITWUZLA_KIND_CONST_ARRAY =
      new BitwuzlaKind("BITWUZLA_KIND_CONST_ARRAY");
  public static final BitwuzlaKind BITWUZLA_KIND_VALUE = new BitwuzlaKind("BITWUZLA_KIND_VALUE");
  public static final BitwuzlaKind BITWUZLA_KIND_VARIABLE =
      new BitwuzlaKind("BITWUZLA_KIND_VARIABLE");
  public static final BitwuzlaKind BITWUZLA_KIND_AND = new BitwuzlaKind("BITWUZLA_KIND_AND");
  public static final BitwuzlaKind BITWUZLA_KIND_DISTINCT =
      new BitwuzlaKind("BITWUZLA_KIND_DISTINCT");
  public static final BitwuzlaKind BITWUZLA_KIND_EQUAL = new BitwuzlaKind("BITWUZLA_KIND_EQUAL");
  public static final BitwuzlaKind BITWUZLA_KIND_IFF = new BitwuzlaKind("BITWUZLA_KIND_IFF");
  public static final BitwuzlaKind BITWUZLA_KIND_IMPLIES =
      new BitwuzlaKind("BITWUZLA_KIND_IMPLIES");
  public static final BitwuzlaKind BITWUZLA_KIND_NOT = new BitwuzlaKind("BITWUZLA_KIND_NOT");
  public static final BitwuzlaKind BITWUZLA_KIND_OR = new BitwuzlaKind("BITWUZLA_KIND_OR");
  public static final BitwuzlaKind BITWUZLA_KIND_XOR = new BitwuzlaKind("BITWUZLA_KIND_XOR");
  public static final BitwuzlaKind BITWUZLA_KIND_ITE = new BitwuzlaKind("BITWUZLA_KIND_ITE");
  public static final BitwuzlaKind BITWUZLA_KIND_EXISTS = new BitwuzlaKind("BITWUZLA_KIND_EXISTS");
  public static final BitwuzlaKind BITWUZLA_KIND_FORALL = new BitwuzlaKind("BITWUZLA_KIND_FORALL");
  public static final BitwuzlaKind BITWUZLA_KIND_APPLY = new BitwuzlaKind("BITWUZLA_KIND_APPLY");
  public static final BitwuzlaKind BITWUZLA_KIND_LAMBDA = new BitwuzlaKind("BITWUZLA_KIND_LAMBDA");
  public static final BitwuzlaKind BITWUZLA_KIND_ARRAY_SELECT =
      new BitwuzlaKind("BITWUZLA_KIND_ARRAY_SELECT");
  public static final BitwuzlaKind BITWUZLA_KIND_ARRAY_STORE =
      new BitwuzlaKind("BITWUZLA_KIND_ARRAY_STORE");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ADD = new BitwuzlaKind("BITWUZLA_KIND_BV_ADD");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_AND = new BitwuzlaKind("BITWUZLA_KIND_BV_AND");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ASHR =
      new BitwuzlaKind("BITWUZLA_KIND_BV_ASHR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_COMP =
      new BitwuzlaKind("BITWUZLA_KIND_BV_COMP");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_CONCAT =
      new BitwuzlaKind("BITWUZLA_KIND_BV_CONCAT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_DEC = new BitwuzlaKind("BITWUZLA_KIND_BV_DEC");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_INC = new BitwuzlaKind("BITWUZLA_KIND_BV_INC");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_MUL = new BitwuzlaKind("BITWUZLA_KIND_BV_MUL");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_NAND =
      new BitwuzlaKind("BITWUZLA_KIND_BV_NAND");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_NEG = new BitwuzlaKind("BITWUZLA_KIND_BV_NEG");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_NOR = new BitwuzlaKind("BITWUZLA_KIND_BV_NOR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_NOT = new BitwuzlaKind("BITWUZLA_KIND_BV_NOT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_OR = new BitwuzlaKind("BITWUZLA_KIND_BV_OR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_REDAND =
      new BitwuzlaKind("BITWUZLA_KIND_BV_REDAND");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_REDOR =
      new BitwuzlaKind("BITWUZLA_KIND_BV_REDOR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_REDXOR =
      new BitwuzlaKind("BITWUZLA_KIND_BV_REDXOR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ROL = new BitwuzlaKind("BITWUZLA_KIND_BV_ROL");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ROR = new BitwuzlaKind("BITWUZLA_KIND_BV_ROR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SADD_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SADD_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SDIV_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SDIV_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SDIV =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SDIV");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SGE = new BitwuzlaKind("BITWUZLA_KIND_BV_SGE");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SGT = new BitwuzlaKind("BITWUZLA_KIND_BV_SGT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SHL = new BitwuzlaKind("BITWUZLA_KIND_BV_SHL");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SHR = new BitwuzlaKind("BITWUZLA_KIND_BV_SHR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SLE = new BitwuzlaKind("BITWUZLA_KIND_BV_SLE");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SLT = new BitwuzlaKind("BITWUZLA_KIND_BV_SLT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SMOD =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SMOD");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SMUL_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SMUL_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SREM =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SREM");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SSUB_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SSUB_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SUB = new BitwuzlaKind("BITWUZLA_KIND_BV_SUB");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UADD_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_UADD_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UDIV =
      new BitwuzlaKind("BITWUZLA_KIND_BV_UDIV");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UGE = new BitwuzlaKind("BITWUZLA_KIND_BV_UGE");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UGT = new BitwuzlaKind("BITWUZLA_KIND_BV_UGT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ULE = new BitwuzlaKind("BITWUZLA_KIND_BV_ULE");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ULT = new BitwuzlaKind("BITWUZLA_KIND_BV_ULT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UMUL_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_UMUL_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_UREM =
      new BitwuzlaKind("BITWUZLA_KIND_BV_UREM");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_USUB_OVERFLOW =
      new BitwuzlaKind("BITWUZLA_KIND_BV_USUB_OVERFLOW");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_XNOR =
      new BitwuzlaKind("BITWUZLA_KIND_BV_XNOR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_XOR = new BitwuzlaKind("BITWUZLA_KIND_BV_XOR");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_EXTRACT =
      new BitwuzlaKind("BITWUZLA_KIND_BV_EXTRACT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_REPEAT =
      new BitwuzlaKind("BITWUZLA_KIND_BV_REPEAT");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ROLI =
      new BitwuzlaKind("BITWUZLA_KIND_BV_ROLI");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_RORI =
      new BitwuzlaKind("BITWUZLA_KIND_BV_RORI");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_SIGN_EXTEND =
      new BitwuzlaKind("BITWUZLA_KIND_BV_SIGN_EXTEND");
  public static final BitwuzlaKind BITWUZLA_KIND_BV_ZERO_EXTEND =
      new BitwuzlaKind("BITWUZLA_KIND_BV_ZERO_EXTEND");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_ABS = new BitwuzlaKind("BITWUZLA_KIND_FP_ABS");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_ADD = new BitwuzlaKind("BITWUZLA_KIND_FP_ADD");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_DIV = new BitwuzlaKind("BITWUZLA_KIND_FP_DIV");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_EQUAL =
      new BitwuzlaKind("BITWUZLA_KIND_FP_EQUAL");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_FMA = new BitwuzlaKind("BITWUZLA_KIND_FP_FMA");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_FP = new BitwuzlaKind("BITWUZLA_KIND_FP_FP");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_GEQ = new BitwuzlaKind("BITWUZLA_KIND_FP_GEQ");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_GT = new BitwuzlaKind("BITWUZLA_KIND_FP_GT");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_INF =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_INF");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_NAN =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_NAN");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_NEG =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_NEG");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_NORMAL =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_NORMAL");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_POS =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_POS");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_SUBNORMAL =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_SUBNORMAL");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_IS_ZERO =
      new BitwuzlaKind("BITWUZLA_KIND_FP_IS_ZERO");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_LEQ = new BitwuzlaKind("BITWUZLA_KIND_FP_LEQ");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_LT = new BitwuzlaKind("BITWUZLA_KIND_FP_LT");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_MAX = new BitwuzlaKind("BITWUZLA_KIND_FP_MAX");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_MIN = new BitwuzlaKind("BITWUZLA_KIND_FP_MIN");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_MUL = new BitwuzlaKind("BITWUZLA_KIND_FP_MUL");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_NEG = new BitwuzlaKind("BITWUZLA_KIND_FP_NEG");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_REM = new BitwuzlaKind("BITWUZLA_KIND_FP_REM");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_RTI = new BitwuzlaKind("BITWUZLA_KIND_FP_RTI");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_SQRT =
      new BitwuzlaKind("BITWUZLA_KIND_FP_SQRT");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_SUB = new BitwuzlaKind("BITWUZLA_KIND_FP_SUB");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_FP_FROM_BV =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_FP_FROM_BV");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_FP_FROM_FP =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_FP_FROM_FP");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_FP_FROM_SBV =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_FP_FROM_SBV");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_FP_FROM_UBV =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_FP_FROM_UBV");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_SBV =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_SBV");
  public static final BitwuzlaKind BITWUZLA_KIND_FP_TO_UBV =
      new BitwuzlaKind("BITWUZLA_KIND_FP_TO_UBV");
  public static final BitwuzlaKind BITWUZLA_KIND_NUM_KINDS =
      new BitwuzlaKind("BITWUZLA_KIND_NUM_KINDS");

  public int swigValue() {
    return swigValue;
  }

  @Override
  public String toString() {
    return swigName;
  }

  public static BitwuzlaKind swigToEnum(int swigValue) {
    if (swigValue < swigValues.length
        && swigValue >= 0
        && swigValues[swigValue].swigValue == swigValue) return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue) return swigValues[i];
    throw new IllegalArgumentException(
        "No enum " + BitwuzlaKind.class + " with value " + swigValue);
  }

  private BitwuzlaKind(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  @SuppressWarnings("StaticAssignmentInConstructor")
  private BitwuzlaKind(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue + 1;
  }

  //  private BitwuzlaKind(String swigName, BitwuzlaKind swigEnum) {
  //    this.swigName = swigName;
  //    this.swigValue = swigEnum.swigValue;
  //    swigNext = this.swigValue + 1;
  //  }

  private static BitwuzlaKind[] swigValues = {
    BITWUZLA_KIND_CONSTANT,
    BITWUZLA_KIND_CONST_ARRAY,
    BITWUZLA_KIND_VALUE,
    BITWUZLA_KIND_VARIABLE,
    BITWUZLA_KIND_AND,
    BITWUZLA_KIND_DISTINCT,
    BITWUZLA_KIND_EQUAL,
    BITWUZLA_KIND_IFF,
    BITWUZLA_KIND_IMPLIES,
    BITWUZLA_KIND_NOT,
    BITWUZLA_KIND_OR,
    BITWUZLA_KIND_XOR,
    BITWUZLA_KIND_ITE,
    BITWUZLA_KIND_EXISTS,
    BITWUZLA_KIND_FORALL,
    BITWUZLA_KIND_APPLY,
    BITWUZLA_KIND_LAMBDA,
    BITWUZLA_KIND_ARRAY_SELECT,
    BITWUZLA_KIND_ARRAY_STORE,
    BITWUZLA_KIND_BV_ADD,
    BITWUZLA_KIND_BV_AND,
    BITWUZLA_KIND_BV_ASHR,
    BITWUZLA_KIND_BV_COMP,
    BITWUZLA_KIND_BV_CONCAT,
    BITWUZLA_KIND_BV_DEC,
    BITWUZLA_KIND_BV_INC,
    BITWUZLA_KIND_BV_MUL,
    BITWUZLA_KIND_BV_NAND,
    BITWUZLA_KIND_BV_NEG,
    BITWUZLA_KIND_BV_NOR,
    BITWUZLA_KIND_BV_NOT,
    BITWUZLA_KIND_BV_OR,
    BITWUZLA_KIND_BV_REDAND,
    BITWUZLA_KIND_BV_REDOR,
    BITWUZLA_KIND_BV_REDXOR,
    BITWUZLA_KIND_BV_ROL,
    BITWUZLA_KIND_BV_ROR,
    BITWUZLA_KIND_BV_SADD_OVERFLOW,
    BITWUZLA_KIND_BV_SDIV_OVERFLOW,
    BITWUZLA_KIND_BV_SDIV,
    BITWUZLA_KIND_BV_SGE,
    BITWUZLA_KIND_BV_SGT,
    BITWUZLA_KIND_BV_SHL,
    BITWUZLA_KIND_BV_SHR,
    BITWUZLA_KIND_BV_SLE,
    BITWUZLA_KIND_BV_SLT,
    BITWUZLA_KIND_BV_SMOD,
    BITWUZLA_KIND_BV_SMUL_OVERFLOW,
    BITWUZLA_KIND_BV_SREM,
    BITWUZLA_KIND_BV_SSUB_OVERFLOW,
    BITWUZLA_KIND_BV_SUB,
    BITWUZLA_KIND_BV_UADD_OVERFLOW,
    BITWUZLA_KIND_BV_UDIV,
    BITWUZLA_KIND_BV_UGE,
    BITWUZLA_KIND_BV_UGT,
    BITWUZLA_KIND_BV_ULE,
    BITWUZLA_KIND_BV_ULT,
    BITWUZLA_KIND_BV_UMUL_OVERFLOW,
    BITWUZLA_KIND_BV_UREM,
    BITWUZLA_KIND_BV_USUB_OVERFLOW,
    BITWUZLA_KIND_BV_XNOR,
    BITWUZLA_KIND_BV_XOR,
    BITWUZLA_KIND_BV_EXTRACT,
    BITWUZLA_KIND_BV_REPEAT,
    BITWUZLA_KIND_BV_ROLI,
    BITWUZLA_KIND_BV_RORI,
    BITWUZLA_KIND_BV_SIGN_EXTEND,
    BITWUZLA_KIND_BV_ZERO_EXTEND,
    BITWUZLA_KIND_FP_ABS,
    BITWUZLA_KIND_FP_ADD,
    BITWUZLA_KIND_FP_DIV,
    BITWUZLA_KIND_FP_EQUAL,
    BITWUZLA_KIND_FP_FMA,
    BITWUZLA_KIND_FP_FP,
    BITWUZLA_KIND_FP_GEQ,
    BITWUZLA_KIND_FP_GT,
    BITWUZLA_KIND_FP_IS_INF,
    BITWUZLA_KIND_FP_IS_NAN,
    BITWUZLA_KIND_FP_IS_NEG,
    BITWUZLA_KIND_FP_IS_NORMAL,
    BITWUZLA_KIND_FP_IS_POS,
    BITWUZLA_KIND_FP_IS_SUBNORMAL,
    BITWUZLA_KIND_FP_IS_ZERO,
    BITWUZLA_KIND_FP_LEQ,
    BITWUZLA_KIND_FP_LT,
    BITWUZLA_KIND_FP_MAX,
    BITWUZLA_KIND_FP_MIN,
    BITWUZLA_KIND_FP_MUL,
    BITWUZLA_KIND_FP_NEG,
    BITWUZLA_KIND_FP_REM,
    BITWUZLA_KIND_FP_RTI,
    BITWUZLA_KIND_FP_SQRT,
    BITWUZLA_KIND_FP_SUB,
    BITWUZLA_KIND_FP_TO_FP_FROM_BV,
    BITWUZLA_KIND_FP_TO_FP_FROM_FP,
    BITWUZLA_KIND_FP_TO_FP_FROM_SBV,
    BITWUZLA_KIND_FP_TO_FP_FROM_UBV,
    BITWUZLA_KIND_FP_TO_SBV,
    BITWUZLA_KIND_FP_TO_UBV,
    BITWUZLA_KIND_NUM_KINDS
  };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
