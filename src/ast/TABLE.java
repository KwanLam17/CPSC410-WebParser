package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class TABLE extends Node {
    TITLE title;
    List<TABLE_ROW> TABLERows = new ArrayList<>();
    @Override
    public void parse() {

        // Check if there is a title
        if (!tokenizer.checkToken("\\[")) {
            // Parse Title
            title = new TITLE();
            title.parse();
        }

        // Parse Rows
        while (tokenizer.checkToken("\\[")){
            TABLE_ROW TABLERow = new TABLE_ROW();
            TABLERow.parse();
            TABLERows.add(TABLERow);
        }
    }

    @Override
    public void evaluate() {
        // TODO: implement table
    }
}
