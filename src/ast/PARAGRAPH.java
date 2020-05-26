package ast;

import libs.Node;

public class PARAGRAPH extends Node {

    String paragraph;
    String start ="<p>";
    String end ="</p>";
    String cssStart = ".class";
    String cssMiddle = " {\n" +
            "grid-area: ";
    String cssEnd = ";\n}";

    @Override
    public void parse() {
//        literal to end paragraph
        tokenizer.checkToken("Paragraph:");
//        tokenizer.getAndCheckNext("\\[");
        paragraph = tokenizer.getNext();
//        tokenizer.getAndCheckNext("\\]");

    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
