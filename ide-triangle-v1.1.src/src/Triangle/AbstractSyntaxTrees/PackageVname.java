/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.VarName;
import Triangle.AbstractSyntaxTrees.Vname;
import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author emema
 */
public class PackageVname extends Vname {
    
    public PackageVname(PackageIdentifier piAST, VarName vnAST, SourcePosition thePosition) {
        super(thePosition);
        
        PI = piAST;
        VN = vnAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitPackageVname(this, o);
    }
    

    public Object visitXML(Visitor v, Object o) {
        return v.visitPackageVname(this, o);
    }
    
    public PackageIdentifier PI;
    public VarName VN;
    
}

