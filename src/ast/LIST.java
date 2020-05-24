package ast;

import libs.Node;

import java.util.ArrayList;

public class LIST extends Node {

    java.util.List<LIST_ITEMS> listItems = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("List:");
        tokenizer.getAndCheckNext("[");

        LIST_ITEMS firstItem = new LIST_ITEMS();
        firstItem.parse();
        listItems.add(firstItem);

        while(!tokenizer.checkToken("\\]")){
            tokenizer.getAndCheckNext("\\|");
            LIST_ITEMS listItem = new LIST_ITEMS();
            listItem.parse();
            listItems.add(listItem);
        }

        tokenizer.getAndCheckNext("\\]");
    }

    @Override
    public void evaluate() {

    }
}
