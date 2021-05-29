/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.VarName;
import Triangle.AbstractSyntaxTrees.Visitor;

/**
 *
 * @author emema
 */
public class DotVarName extends VarName {
   public DotVarName (VarName vAST, Identifier iAST, SourcePosition thePosition) {
    super (thePosition);
    V = vAST;
    I = iAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitDotVarName(this, o);
  }

  public Object visitXML(Visitor v, Object o) {
    return v.visitDotVarName(this, o);
  }

  public Identifier I;
  public VarName V;
}
