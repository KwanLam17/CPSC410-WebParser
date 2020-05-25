package ast;

import libs.Node;

public class IMAGE extends Node {

    String imageSrc;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Image:");
        imageSrc = tokenizer.getNext();
        //TODO: resize()

    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
