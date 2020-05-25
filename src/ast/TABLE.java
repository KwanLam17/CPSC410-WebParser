package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class TABLE extends Node {
    TITLE title = new TITLE();
    List<ROW> rows = new ArrayList<>();

    @Override
    public void parse() {

        // Parse Title
        title.parse();

        // Parse Rows
        while (tokenizer.moreTokens() && tokenizer.checkToken("\\[")) {
            ROW row = new ROW();
            row.parse();
            rows.add(row);
        }
    }

//    @Override
//    public void evaluate() {
////        writer.println("<table bgcolor=black " + "style=\"grid-area: " + placement + "\" >");
//        writer.println("<table bgcolor=black " + "id=\"" + this.hashCode() + "\" >");
//        for (ROW r : rows){
//            r.evaluate();
//        }
//        writer.println("</table>");
//    }
    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }

}
