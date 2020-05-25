package ast;

import libs.Node;

public class TITLE extends Node{
    String title;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Title:");
        title = tokenizer.getNext();
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }


}
