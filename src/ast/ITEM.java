package ast;

import libs.Node;

public class ITEM extends Node {
    String itemName;

    @Override
    public void parse() {
        itemName = tokenizer.getNext();
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
