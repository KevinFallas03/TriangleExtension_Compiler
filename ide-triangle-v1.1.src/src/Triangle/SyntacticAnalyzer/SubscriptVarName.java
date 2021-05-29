/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

import Triangle.AbstractSyntaxTrees.Expression;
import Triangle.AbstractSyntaxTrees.VarName;
import Triangle.AbstractSyntaxTrees.Visitor;

/**
 *
 * @author emema
 */
public class SubscriptVarName extends VarName {
    public SubscriptVarName (VarName vAST, Expression eAST, SourcePosition thePosition) {
        super (thePosition);
        V = vAST;
        E = eAST;
    }

  public Object visit (Visitor v, Object o) {
    return v.visitSubscriptVarName(this, o);
  }
  public Object visitXML(Visitor v, Object o) {
    return v.visitSubscriptVarName(this, o);
  }

  public Expression E;
  public VarName V;
}
