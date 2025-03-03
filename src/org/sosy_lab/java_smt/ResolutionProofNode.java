/*
 * This file is part of JavaSMT,
 * an API wrapper for a collection of SMT solvers:
 * https://github.com/sosy-lab/java-smt
 *
 * SPDX-FileCopyrightText: 2024 Dirk Beyer <https://www.sosy-lab.org>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.sosy_lab.java_smt;

import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.proofs.ProofNode;
import org.sosy_lab.java_smt.basicimpl.AbstractProofNode;
import org.sosy_lab.java_smt.ResProofRule.ResAxiom;

public class ResolutionProofNode extends AbstractProofNode<ResAxiom>
    implements ProofNode<ResAxiom> {

  private final Formula pivot;

  public ResolutionProofNode(Formula formula, Formula pivot) {
    super(ResAxiom.RESOLUTION, formula);
    this.pivot = pivot;
  }


  @Override
  public boolean isSource() {
    return false;
  }

  public Formula getPivot() {
    return pivot;
  }

  public ResAxiom getRule() {
    return super.getRule();
  }
}
