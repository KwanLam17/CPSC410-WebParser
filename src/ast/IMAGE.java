package ast;

import libs.Node;

public class IMAGE extends Node {

    String image;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Image:");
        image = tokenizer.getNext();
        //TODO: resize()

    }
//
//    @Override
//    public void evaluate() {
//        writer.print(image);
//    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
