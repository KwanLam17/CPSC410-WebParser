package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class GRID extends Node {
    String start = "body {\n" +
            "    display: grid;\n" +
            "    grid-template-areas:";
    String end = "}";

    List<GRIDROW> gridRows = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Grid:");

        while (tokenizer.moreTokens() && tokenizer.checkToken("\\[")){
            GRIDROW gridRow = new GRIDROW();
            gridRow.parse();
            gridRows.add(gridRow);
        }
    }

//    @Override
//    public void evaluate() {
//        writer.println(start);
//
//        for (GRIDROW r : gridRows){
//            r.evaluate();
//        }
//
//        writer.println(";");
//
//        writer.println(end);
//    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }
}
