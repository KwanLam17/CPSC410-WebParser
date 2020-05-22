package ast;

import libs.Node;

import java.util.ArrayList;

public class LIST extends Node {

    java.util.List<LIST_ITEMS> listItems = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("List:");

//        Must discuss what the literal to use end_list
        while(!tokenizer.checkToken("end list")){
//            tokenizer.getAndCheckNext("");
            LIST_ITEMS listItem = new LIST_ITEMS();
            listItem.parse();
            listItems.add(listItem);
        }

        tokenizer.getAndCheckNext("end list");
    }

    @Override
    public void evaluate() {

    }
}
