package ast;

import libs.Node;

public class PARAGRAPH extends Node {

    String paragraph;

    @Override
    public void parse() {
//        literal to end paragraph
        tokenizer.getAndCheckNext("Paragraph:");
        paragraph = tokenizer.getNext();

    }

    @Override
    public void evaluate() {
        writer.print(paragraph);
    }
}
