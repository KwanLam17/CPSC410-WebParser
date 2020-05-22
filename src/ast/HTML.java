package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;


public class HTML extends Node {
    List<TABLE> tables = new ArrayList<>();
    String start = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <link rel=\"stylesheet\" href=\"output.css\">\n" +
            "</head>\n" +
            "<body>\n";
    String end = "</body>\n" +
            "</html>\n" +
            "\n";

    public void parse(){
        // Parse Tables
        while(tokenizer.moreTokens()){
            TABLE t = new TABLE();
            t.parse();
            tables.add(t);
        }
    }

    @Override
    public void evaluate() {
        writer.println(start);

        for (TABLE table : tables) {
            table.evaluate();
        }

        writer.println(end);
    }
}
