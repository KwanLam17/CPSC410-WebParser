package ast;

import libs.Node;

public class LIST_ITEMS extends Node {

    String listItem = "- ";

    @Override
    public void parse() {
//        discuss what literal used to seperate list items
        listItem += tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        writer.print(listItem);
    }
}
