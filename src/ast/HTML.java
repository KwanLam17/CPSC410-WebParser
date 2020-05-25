package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;


public class HTML extends Node {
    List<ELEMENT> elements = new ArrayList<>();
    String start = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <link rel=\"stylesheet\" href=\"output.css\">\n" +
            "</head>\n" +
            "<body>\n";
    String end = "</body>\n" +
            "</html>\n" +
            "\n";

    GRID grid;

    public void parse(){

        grid = new GRID();
        grid.parse();

        // Parse Tables
        while(tokenizer.moreTokens()){
            ELEMENT element = new ELEMENT();
            element.parse();
            elements.add(element);
        }
    }

//    @Override
//    public void evaluate() {
//        writer.println(start);
//
//        for (CONTENT content : contents) {
//            content.evaluate();
//        }
//
//        writer.println(end);
//    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
