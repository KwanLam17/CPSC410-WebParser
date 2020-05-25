package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class ROW extends Node{
    List<ITEM> items = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("\\[");

        // Parse first Item
        ITEM firstItem = new ITEM();
        firstItem.parse();
        items.add(firstItem);

        // Parse Items
        while(!tokenizer.checkToken("\\]")){
            tokenizer.getAndCheckNext("\\|");
            ITEM item = new ITEM();
            item.parse();
            items.add(item);
        }

        tokenizer.getAndCheckNext("\\]");
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
