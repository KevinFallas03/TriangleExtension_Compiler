/*
 * @(#)Scanner.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import Triangle.SyntacticAnalyzer.SourceFile;


public final class HTMLGenerator {

  private SourceFile sourceFile;
  public boolean isDone = false;
  private FileWriter fileWriter;

  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;
    private int cont;
  public StringBuffer getCP(){
      return this.currentSpelling;
  }
  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }

  public HTMLGenerator(SourceFile source,String fileName ) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    try {
        fileWriter = new FileWriter(fileName + ".html");

        fileWriter.write("<!DOCTYPE html>\n" +
                         "<head>\n" +
                         "  \t<meta charset=\"utf-8\">\n" +
                         "  \t<title>FileHTML</title>\n" +
                         "</head>\n"+
                         "<style type=\"text/css\">\n"
                + "div {display: inline;" +
                         "      font-family: courier;" +
                         "      font-size:1em;" +
                         "    }"
                + "p {display: inline;" +
                         "      font-family: courier;" +
                         "      font-size:1em;" +
                         "    }" +
                         "\n" +
                         "</style>" +
                         "<body>");
        this.generateHTML();
        //HTML footer
        fileWriter.write("</body>\n" +
                         "</html>");

        fileWriter.close();

    } catch (IOException e) {
        System.err.println("Error while creating file for print the AST");
        e.printStackTrace();
    }
  }


  private void takeIt() {
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();
  }

  private void scanToken() {

    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      if (this.isReserved(this.currentSpelling.toString())){
          writeBoldBlack(this.currentSpelling.toString());
      }else{
          writeSimpleBlack(this.currentSpelling.toString());
      }
      break;
    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
        writeSimpleBlue(this.currentSpelling.toString());
        break;
    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      while (isOperator(currentChar))
        takeIt();
            writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '\'':
      takeIt();
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        writeSimpleBlue(this.currentSpelling.toString());
      } else
        System.out.println("Error");
    break;
    // agrega caso para RANGE y DOT
    case '.':
      takeIt();
      if(currentChar == '.'){
          takeIt();
                writeSimpleBlack(this.currentSpelling.toString());
      }else{
                writeSimpleBlack(this.currentSpelling.toString());
      }
    break;
    case ':':
      takeIt();
      if (currentChar == '=') {
        takeIt();
        writeSimpleBlack(this.currentSpelling.toString());
      } else{
          writeSimpleBlack(this.currentSpelling.toString());
      }
    break;
    case ';':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case ',':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '~':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;      
    // agrega case PIPE, DOLLAR
    case '|':
        takeIt();
        writeSimpleBlack(this.currentSpelling.toString());
    break;        
    case '$':
        takeIt();
        writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '(':
        takeIt();
        writeSimpleBlack(this.currentSpelling.toString());
    break;
    case ')':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '[':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case ']':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '{':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;

    case '}':
      takeIt();
      writeSimpleBlack(this.currentSpelling.toString());
    break;
    case SourceFile.EOT:
      this.isDone = true;
    break;    
    case '!':
      {
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT))
          takeIt();
        writeSimpleGreen(this.currentSpelling.toString());
      }
    break;  
    case ' ':
        takeIt();
        writeSimpleBlack(this.currentSpelling.toString());
    break;
    case '\n':
    case '\r': 
        takeIt();
        try {
            fileWriter.write("<br>");
        } catch (IOException e) {
            System.err.println("Error while writing HTML file for print the AST");
            e.printStackTrace();
        }
    break;
    case '\t':
        takeIt();
        writeSimpleBlack("&emsp;");
    break;
    default:
      takeIt();
      System.out.println("Error");
      break;
    }
  }

  public void scan () {
    SourcePosition pos;

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();
    this.scanToken();
    pos.finish = sourceFile.getCurrentLine();
  }
  
  public void generateHTML(){
      while(!this.isDone){
          this.scan();
      }
  }
  
  public boolean isReserved(String word){
      for(String rw : this.reservedWords){
          if(rw.equals(word)){
              return true;
          }
      }
      return false;
  }
  private static String[] reservedWords = new String[] {
    "array",
    "choose",   // Se agrega el caracter de la palabra reservada choose
    "const",
    "do",
    "else",
    "elsif",    // Se agrega el caracter de la palabra reservada elsif
    "end",      // Se agrega el caracter de la palabra reservada for
    "for",      // Se agrega el caracter de la palabra reservada from
    "from",
    "func",
    "if",
    "in",
    "let",
    "loop",     // Se agrega el caracter de la palabra reservada loop
    "nothing",  // Se agrega el caracter de la palabra reservada nothing
    "of",
    "package",  // Se agrega el caracter de la palabra reservada package
    "private",  // Se agrega el caracter de la palabra reservada private
    "proc",
    "record",
    "recursive",// Se agrega el caracter de la palabra reservada recursive
    "then",
    "to",       // Se agrega el caracter de la palabra reservada to
    "type",
    "until",    // Se agrega el caracter de la palabra reservada until
    "var",
    "when",     // Se agrega el caracter de la palabra reservada when
    "while"
  };
  public void writeSimpleBlack(String word){
    try {
        fileWriter.write("<p>"+word+"</p>");
    } catch (IOException e) {
        System.err.println("Error while writing HTML file for print the AST");
        e.printStackTrace();
    }
  }
  public void writeBoldBlack(String word){
    try {
        fileWriter.write("<strong>"+word+"</strong>");
    } catch (IOException e) {
        System.err.println("Error while writing HTML file for print the AST");
        e.printStackTrace();
    }
  }
  public void writeSimpleGreen(String word){
    try {
        fileWriter.write("<span style = \"color:#00b300;\">"+word+"</span>");
    } catch (IOException e) {
        System.err.println("Error while writing HTML file for print the AST");
        e.printStackTrace();
    }
  }
  public void writeSimpleBlue(String word){
    try {
        fileWriter.write("<span style = \"color:#0000cd;\">"+word+"</span>");
    } catch (IOException e) {
        System.err.println("Error while writing HTML file for print the AST");
        e.printStackTrace();
    }
  }
}
