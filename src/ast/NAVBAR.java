package ast;

import libs.Node;

public class NAVBAR extends Node {

    String name;
    String link;

    @Override
    public void parse() {
        // tokenizer.getAndCheckNext("Name:");
        // tokenizer.getAndCheckNext("Link:");
        name = tokenizer.getNext();
        link = name.substring(name.lastIndexOf("http"));  // TODO: treat name and link as two contents like table?
        name = name.replace(link,"");
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
