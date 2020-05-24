package ast;

import libs.Node;

public class NAVBAR extends Node {

    String navbar;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Navbar:");
        navbar = tokenizer.getNext();
        //TODO: split into text and href

    }

    @Override
    public void evaluate() {
        writer.print(navbar);
    }
}
