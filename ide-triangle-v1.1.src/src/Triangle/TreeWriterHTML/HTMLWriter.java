package Triangle.TreeWriterHTML;

import Triangle.AbstractSyntaxTrees.DoUntilCommand;
import Triangle.AbstractSyntaxTrees.DoWhileCommand;
import Triangle.AbstractSyntaxTrees.ForDoCommand;
import Triangle.AbstractSyntaxTrees.ForIdentifierExpression;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.PrivateDeclaration;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RecursiveDeclaration;
import Triangle.AbstractSyntaxTrees.SeqPackageDeclaration;
import Triangle.AbstractSyntaxTrees.UntilDoCommand;
import Triangle.AbstractSyntaxTrees.VarDeclarationBecomes;
import Triangle.AbstractSyntaxTrees.WhileDoCommand;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter {

  private String fileName;

  public HTMLWriter(String fileName) {
    this.fileName = fileName;
  }

  // Draw the AST representing a complete program.
  public void write(Program ast) {
    // Prepare the file to write
    try {
      FileWriter fileWriter = new FileWriter(fileName);

      //HTML header
      fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

      WriterVisitor layout = new WriterVisitor(fileWriter) {
          @Override
          public Object visitWhileDoCommand(WhileDoCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitUntilDoCommand(UntilDoCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitDoWhileCommand(DoWhileCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitDoUntilCommand(DoUntilCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitForIdentifierExpression(ForIdentifierExpression aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitForDoCommand(ForDoCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitForWhileCommand(ForWhileCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitForUntilCommand(ForUntilCommand aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitRecursiveDeclaration(RecursiveDeclaration aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitPrivateDeclaration(PrivateDeclaration aThis, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitVarDeclarationBecomes(VarDeclarationBecomes ast, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitPackageDeclaration(PackageDeclaration ast, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitSeqPackageDeclaration(SeqPackageDeclaration ast, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitPackageIdentifier(PackageIdentifier ast, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object visitLongIdentifier(LongIdentifier ast, Object o) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }
      };
      ast.visit(layout, null);

      fileWriter.close();

    } catch (IOException e) {
      System.err.println("Error while creating file for print the AST");
      e.printStackTrace();
    }
  }

}
