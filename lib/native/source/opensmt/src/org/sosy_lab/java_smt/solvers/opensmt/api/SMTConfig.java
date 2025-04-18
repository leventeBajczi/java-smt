// This file is part of JavaSMT,
// an API wrapper for a collection of SMT solvers:
// https://github.com/sosy-lab/java-smt
//
// SPDX-FileCopyrightText: 2025 Dirk Beyer <https://www.sosy-lab.org>
//
// SPDX-License-Identifier: Apache-2.0

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sosy_lab.java_smt.solvers.opensmt.api;

public class SMTConfig {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SMTConfig(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SMTConfig obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(SMTConfig obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        OsmtNativeJNI.delete_SMTConfig(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static void setO_produce_unsat_cores(String value) {
    OsmtNativeJNI.SMTConfig_o_produce_unsat_cores_set(value);
  }

  public static String getO_produce_unsat_cores() {
    return OsmtNativeJNI.SMTConfig_o_produce_unsat_cores_get();
  }

  public static void setO_minimal_unsat_cores(String value) {
    OsmtNativeJNI.SMTConfig_o_minimal_unsat_cores_set(value);
  }

  public static String getO_minimal_unsat_cores() {
    return OsmtNativeJNI.SMTConfig_o_minimal_unsat_cores_get();
  }

  public static void setO_print_cores_full(String value) {
    OsmtNativeJNI.SMTConfig_o_print_cores_full_set(value);
  }

  public static String getO_print_cores_full() {
    return OsmtNativeJNI.SMTConfig_o_print_cores_full_get();
  }

  public SMTConfig() {
    this(OsmtNativeJNI.new_SMTConfig__SWIG_0(), true);
  }

  public SMTConfig(SMTConfig arg0) {
    this(OsmtNativeJNI.new_SMTConfig__SWIG_1(SMTConfig.swigRelease(arg0), arg0), true);
  }

  public void setProduceProofs() {
    OsmtNativeJNI.SMTConfig_setProduceProofs(swigCPtr, this);
  }

  public boolean produce_unsat_cores() {
    return OsmtNativeJNI.SMTConfig_produce_unsat_cores(swigCPtr, this);
  }

  public boolean minimal_unsat_cores() {
    return OsmtNativeJNI.SMTConfig_minimal_unsat_cores(swigCPtr, this);
  }

  public boolean print_cores_full() {
    return OsmtNativeJNI.SMTConfig_print_cores_full(swigCPtr, this);
  }

  public boolean produce_proof() {
    return OsmtNativeJNI.SMTConfig_produce_proof(swigCPtr, this);
  }

  public void setOption(String option, SMTOption value) {
    OsmtNativeJNI.SMTConfig_setOption(swigCPtr, this, option, SMTOption.getCPtr(value), value);
  }

}
