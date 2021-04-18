/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.TreeWriter;

import Triangle.AbstractSyntaxTrees.AnyTypeDenoter;
import Triangle.AbstractSyntaxTrees.ArrayExpression;
import Triangle.AbstractSyntaxTrees.ArrayTypeDenoter;
import Triangle.AbstractSyntaxTrees.AssignCommand;
import Triangle.AbstractSyntaxTrees.BinaryExpression;
import Triangle.AbstractSyntaxTrees.BinaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.BoolTypeDenoter;
import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.CharTypeDenoter;
import Triangle.AbstractSyntaxTrees.CharacterExpression;
import Triangle.AbstractSyntaxTrees.CharacterLiteral;
import Triangle.AbstractSyntaxTrees.ConstActualParameter;
import Triangle.AbstractSyntaxTrees.ConstDeclaration;
import Triangle.AbstractSyntaxTrees.ConstFormalParameter;
import Triangle.AbstractSyntaxTrees.DoUntilCommand;
import Triangle.AbstractSyntaxTrees.DoWhileCommand;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;
import Triangle.AbstractSyntaxTrees.ForDoCommand;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.FuncActualParameter;
import Triangle.AbstractSyntaxTrees.FuncDeclaration;
import Triangle.AbstractSyntaxTrees.FuncFormalParameter;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.IfCommand;
import Triangle.AbstractSyntaxTrees.IfExpression;
import Triangle.AbstractSyntaxTrees.IntTypeDenoter;
import Triangle.AbstractSyntaxTrees.IntegerExpression;
import Triangle.AbstractSyntaxTrees.IntegerLiteral;
import Triangle.AbstractSyntaxTrees.LetCommand;
import Triangle.AbstractSyntaxTrees.LetExpression;
import Triangle.AbstractSyntaxTrees.MultipleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleArrayAggregate;
import Triangle.AbstractSyntaxTrees.MultipleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.MultipleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleRecordAggregate;
import Triangle.AbstractSyntaxTrees.Operator;
import Triangle.AbstractSyntaxTrees.ProcActualParameter;
import Triangle.AbstractSyntaxTrees.ProcDeclaration;
import Triangle.AbstractSyntaxTrees.ProcFormalParameter;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RecordExpression;
import Triangle.AbstractSyntaxTrees.RecordTypeDenoter;
import Triangle.AbstractSyntaxTrees.SequentialCommand;
import Triangle.AbstractSyntaxTrees.SequentialDeclaration;
import Triangle.AbstractSyntaxTrees.SimpleTypeDenoter;
import Triangle.AbstractSyntaxTrees.SimpleVname;
import Triangle.AbstractSyntaxTrees.SingleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleArrayAggregate;
import Triangle.AbstractSyntaxTrees.SingleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.SingleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleRecordAggregate;
import Triangle.AbstractSyntaxTrees.SubscriptVname;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.UnaryExpression;
import Triangle.AbstractSyntaxTrees.UnaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.VarActualParameter;
import Triangle.AbstractSyntaxTrees.VarDeclaration;
import Triangle.AbstractSyntaxTrees.VarFormalParameter;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.AbstractSyntaxTrees.VnameExpression;
import Triangle.AbstractSyntaxTrees.WhileCommand;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import Triangle.AbstractSyntaxTrees.PrivateDeclaration;
import Triangle.AbstractSyntaxTrees.RecursiveDeclaration;
import Triangle.AbstractSyntaxTrees.ForIdentifierExpression;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.SeqPackageDeclaration;
import Triangle.AbstractSyntaxTrees.UntilDoCommand;
import Triangle.AbstractSyntaxTrees.VarDeclarationBecomes;
import Triangle.AbstractSyntaxTrees.WhileDoCommand;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class HTMLWriterVisitor implements Visitor {
    
    //this code was modified------------------------------------------------------------------------------------
    int cont = 1;
    
    private FileWriter fileWriter;
            
    HTMLWriterVisitor(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    
    // Commands
    public Object visitAssignCommand(AssignCommand ast, Object obj) {
        writeLineHTML("<div class=\"AssignCommand\">");
        ast.V.visit(this, null);
        writeLineHTML("<p style=\"color: #000000;\"> := </p>");
        ast.E.visit(this, null);
        writeLineHTML("</div");
        return null;
    }

    public Object visitCallCommand(CallCommand ast, Object obj) {
        writeLineHTML("<div class=\"callCommand\">");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }
    
    public Object visitEmptyCommand(EmptyCommand ast, Object obj) {
        writeLineHTML("<div class=\"EmptyCommand\">\n<p style=\"color: #000000; \"><strong>&ensp;pass</strong> </p>\n</div>");
        return null;
    }
   
    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        writeLineHTML("<div class=\"ArrayExpression\"");
        writeLineHTML("<p style=\"color: #000000; \"> [ </p>");
        ast.AA.visit(this, null);
        writeLineHTML("<p style=\"color: #000000; \"> ] </p>");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        writeLineHTML("<div class=\"BinaryExpression\"");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitCallExpression(CallExpression ast, Object obj) {
        writeLineHTML("<div class=\"CallExpression\"");
        writeLineHTML("<p style=\"color: #2E6FE; \">" + ast.I.spelling + "</p>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        writeLineHTML("<div class=\"CharacterExpression\"");
        writeLineHTML("<p style=\"color: #2E64FE; \">"+ ast.CL.spelling + "</p>");
        ast.CL.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        writeLineHTML("<div class=\"EmptyExpression\"");
        writeLineHTML("</div>");
        return null;
    }

    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        writeLineHTML("<div class=\"MultipleArrayAggregate\"");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        writeLineHTML("<div class=\"SingleArrayAggregate\"");
        ast.E.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        writeLineHTML("<div class=\"MultipleRecordAggregate\"");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        writeLineHTML("<div class=\"SingleRecordAggregate\"");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    // Formal Parameters
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
        writeLineHTML("<div class=\"ConstFormalParameter\">");
        writeLineHTML("<p class=\"ConstFormalParameter\" style=\"color: #000000; \"></br><strong></strong></p>");
        ast.I.visit(this, null);
        writeLineHTML("<p class=\"ConstFormalParameter\" style=\"color: #000000; \">:</p>");
        ast.T.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
        writeLineHTML("<div class=\"FuncFormalParameter\">");
        writeLineHTML("<p class=\"FuncFormalParameter\" style=\"color: #000000; \"></br><strong>func</strong></p>");
        ast.I.visit(this, null);
        writeLineHTML("<p class=\"FuncFormalParameter\" style=\"color: #000000; \">(</p>");
        ast.FPS.visit(this, null);
        writeLineHTML("<p class=\"FuncFormalParameter\" style=\"color: #000000; \">)</p>");
        writeLineHTML("<p class=\"FuncFormalParameter\" style=\"color: #000000; \">:</p>");
        ast.T.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        writeLineHTML("<div class=\"ProcFormalParameter\">");
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \"></br><strong>proc</strong></p>");
        ast.I.visit(this, null);
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \">(</p>");
        ast.FPS.visit(this, null);
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \">)</p>");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        writeLineHTML("<div class=\"VarFormalParameter\">");
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \"></br><strong>&ensp;var</strong></p>");
        ast.I.visit(this, null);
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \">:</p>");
        ast.T.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }


    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"EmptyFormalParameterSequence\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"MultipleFormalParameterSequence\">");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"SingleFormalParameterSequence\">");
        ast.FP.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        writeLineHTML("<div class=\"ConstActualParameter\">");
        ast.E.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        writeLineHTML("<div class=\"FuncActualParameter\">");
        ast.I.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        writeLineHTML("<div class=\"ProcActualParameter\">");
        ast.I.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        writeLineHTML("<div class=\"VarActualParameter\">");
        ast.V.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }


    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"EmptyActualParameterSequence\">");
        writeLineHTML("<p class=\"emptyParameterSequence\" style=\"color: #000000;\">()</p>");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"MultipleActualParameterSequence\">");
        writeLineHTML("<p class=\"multipleParameterSequence\" style=\"color: #000000;\"></(");
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML(")  </p>");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        writeLineHTML("<div class=\"SingleActualParameterSequence\">");
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \">(</p>");
        ast.AP.visit(this, null);
        writeLineHTML("<p class=\"SingleActualParameterSequence\" style=\"color: #000000; \">)  </p>");
        writeLineHTML("</div>");
        return null;
    }

    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"AnyTypeDenoter\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"ArrayTypeDenoter\">");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) { // FALTA
        writeLineHTML("<div class=\"BoolTypeDenoter\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"CharTypeDenoter\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"ErrorTypeDenoter\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"SimpleTypeDenoter\">");
        ast.I.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"IntTypeDenoter\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"RecordTypeDenoter\">");
        ast.FT.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"RecordTypeDenoter\">");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<div class=\"SingleFieldTypeDenoter\">");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    // Literals
    public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"CharacterLiteral\">");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"IntegerLiteral\">");
        writeLineHTML("</div>");
        return null;
    }
    
    //Identifiers and Operators
    public Object visitIdentifier(Identifier ast, Object obj) { 
        writeLineHTML("<div class=\"Identifier\">");
        writeLineHTML("\t<p style=\"color: #000000;"
                                    + "\">&ensp;" 
                                + ast.spelling + 
                        "</p>");
        writeLineHTML("</div>");
        return null;
    }

    public Object visitOperator(Operator ast, Object obj) {
        writeLineHTML("<div class=\"Operator\">");
        writeLineHTML("\t<p style=\"color: #000000;"
                                    + "\">&ensp;" 
                                + ast.spelling + 
                        "</p>");
        writeLineHTML("</div>");
        return null;
    }

    // Value-or-variable names
    public Object visitDotVname(DotVname ast, Object obj) {
        writeLineHTML("<div class=\"DotVname\">");
        ast.V.visit(this, null);
        ast.I.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        writeLineHTML("<div class=\"SubscriptVname\">");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</div>");
        return null;
    }

    // Programs
    public Object visitProgram(Program ast, Object obj) { // FALTA 
        writeLineHTML("<div class=\"Program\">");
        // TERMINAR PROGRAM
        writeLineHTML("</div>");
        return null;
    }
    
    private void writeLineHTML(String line) {
        try {
            cont++;
            fileWriter.write(line);
            fileWriter.write('\n');
        } catch (IOException e) {
            System.err.println("Error while writing HTML file for print the AST");
            e.printStackTrace();
        }
    }

    /*
     * Convert the characters "<" & "<=" to their equivalents in html
     */
    private String transformOperator(String operator) {
        if (operator.compareTo("<") == 0)
            return "&lt;";
        else if (operator.compareTo("<=") == 0)
            return "&lt;=";
        else
            return operator;
    }

    @Override
    public Object visitWhileDoCommand(WhileDoCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUntilDoCommand(UntilDoCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitForIdentifierExpression(ForIdentifierExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitVarDeclarationBecomes(VarDeclarationBecomes ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSeqPackageDeclaration(SeqPackageDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPackageIdentifier(PackageIdentifier ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLongIdentifier(LongIdentifier ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitWhileCommand(WhileCommand ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDoWhileCommand(DoWhileCommand aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDoUntilCommand(DoUntilCommand aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitForDoCommand(ForDoCommand aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitForWhileCommand(ForWhileCommand aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitForUntilCommand(ForUntilCommand aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRecursiveDeclaration(RecursiveDeclaration aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPrivateDeclaration(PrivateDeclaration aThis, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitConstDeclaration(ConstDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitProcDeclaration(ProcDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitVarDeclaration(VarDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPackageDeclaration(PackageDeclaration ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSimpleVname(SimpleVname ast, Object o) { // FALTA 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
