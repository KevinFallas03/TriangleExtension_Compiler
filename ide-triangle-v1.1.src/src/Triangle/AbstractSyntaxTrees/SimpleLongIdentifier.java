/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author emema
 */
public class SimpleLongIdentifier extends LongIdentifier {
    
    public SimpleLongIdentifier(Identifier iAST, SourcePosition thePosition) {
        super(thePosition);
        
        I = iAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitSimpleLongIdentifier(this, o);
    }

    public Object visitXML(Visitor v, Object o) {
        return v.visitSimpleLongIdentifier(this, o);
    }
    
    
}
