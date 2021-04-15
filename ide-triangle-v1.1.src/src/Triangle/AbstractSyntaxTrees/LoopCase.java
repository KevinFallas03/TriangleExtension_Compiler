/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Kevin
 */
public abstract class LoopCase extends Command {
    
    public LoopCase(SourcePosition thePosition) {
        super(thePosition);
    }
    
}
