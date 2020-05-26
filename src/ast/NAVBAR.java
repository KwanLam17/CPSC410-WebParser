package ast;

import libs.Node;
import java.util.HashMap;
import java.util.Map;

public class NAVBAR extends Node {

    Map<ITEM, ITEM> navLinks  = new HashMap<ITEM, ITEM>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("\\[");

        ITEM firstName = new ITEM();
        firstName.parse();
        tokenizer.getAndCheckNext(",");
        ITEM firstLink = new ITEM();
        firstLink.parse();
        navLinks.put(firstName, firstLink);

        while(!tokenizer.checkToken("\\]")){
            tokenizer.getAndCheckNext("\\|");
            ITEM name = new ITEM();
            name.parse();
            tokenizer.getAndCheckNext(",");
            ITEM link = new ITEM();
            link.parse();
            navLinks.put(name, link);
        }

        tokenizer.getAndCheckNext("\\]");
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
