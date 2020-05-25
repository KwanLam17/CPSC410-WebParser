package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class LIST extends Node {

    List<ITEM> listItems = new ArrayList<>();
    String start = "<ul>";
    String end = "</ul>";

    @Override
    public void parse() {
//        tokenizer.getAndCheckNext("List:");
        tokenizer.getAndCheckNext("\\[");

        ITEM firstItem = new ITEM();
        firstItem.parse();
        listItems.add(firstItem);

        while(!tokenizer.checkToken("\\]")){
            tokenizer.getAndCheckNext("\\|");
            ITEM item = new ITEM();
            item.parse();
            listItems.add(item);
        }

        tokenizer.getAndCheckNext("\\]");
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
