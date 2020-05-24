package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class TABLE extends Node {
    TITLE title = new TITLE();
    List<ROW> rows = new ArrayList<>();
    String placement;

    @Override
    public void parse() {

        // Parse Title
        title.parse();

        // Parse BoldRow
        BOLDROW boldRow = new BOLDROW();
        boldRow.parse();
        rows.add(boldRow);

        // Parse Rows
        while (tokenizer.moreTokens() && tokenizer.checkToken("\\[")) {
            ROW row = new ROW();
            row.parse();
            rows.add(row);
        }

        placement = tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        writer.println("<table bgcolor=black " + "style=\"grid-area: " + placement + "\" >");
        for (ROW r : rows){
            r.evaluate();
        }
        writer.println("</table>");
    }
}
