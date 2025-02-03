/*
 * This file is part of JavaSMT,
 * an API wrapper for a collection of SMT solvers:
 * https://github.com/sosy-lab/java-smt
 *
 * SPDX-FileCopyrightText: 2024 Dirk Beyer <https://www.sosy-lab.org>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.sosy_lab.java_smt.api.proofs;

import org.sosy_lab.java_smt.ResolutionProofNode;
import org.sosy_lab.java_smt.SourceProofNode;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.resProofRule.Rule;

public class ProofFactory {
  public static ProofNode<Rule> createSourceNode(Rule rule, Formula formula) {
    return new SourceProofNode(rule, formula);
  }

  public static ProofNode<Rule> createResolutionNode(Formula formula, Formula pivot) {
    return new ResolutionProofNode(formula, pivot);
  }
}
