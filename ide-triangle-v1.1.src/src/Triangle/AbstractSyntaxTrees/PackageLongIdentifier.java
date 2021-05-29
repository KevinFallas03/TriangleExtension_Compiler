/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author emema
 */
public class PackageLongIdentifier extends LongIdentifier {
    
    public PackageLongIdentifier(PackageIdentifier piAST, Identifier iAST, SourcePosition thePosition) {
        super(thePosition);
        
        PI = piAST;
        I = iAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitPackageLongIdentifier(this, o);
    }

    public Object visitXML(Visitor v, Object o) {
        return v.visitPackageLongIdentifier(this, o);
    }
    
    public PackageIdentifier PI;
}
