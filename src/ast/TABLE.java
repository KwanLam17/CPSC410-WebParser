package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class TABLE extends Node {
    TITLE title;
    List<ROW> rows = new ArrayList<>();

    @Override
    public void parse() {

        // Parse Title
        if (tokenizer.checkToken("Title:"))
            title = new TITLE();
            title.parse();

        // Parse Rows
        while (tokenizer.moreTokens() && tokenizer.checkToken("\\[")) {
            ROW row = new ROW();
            row.parse();
            rows.add(row);
        }
    }

    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
