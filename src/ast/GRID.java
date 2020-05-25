package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class GRID extends Node {
    String cssStart = "body {\n" +
            "    display: grid;\n" +
            "    grid-template-areas:";
    String cssEnd = ";}";

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

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }
}
