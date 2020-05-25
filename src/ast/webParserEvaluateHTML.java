package ast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class webParserEvaluateHTML implements webParserVisitor<Void> {
    private PrintWriter writer; // nothing stops a visitor from having other features

    public webParserEvaluateHTML(String outFilename) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(outFilename, "UTF-8");
        System.out.println("tinyDotEvaluator will write evaluated output to file: " + outFilename);
    }

    public void closeFile() {
        writer.close();
    }

    @Override
    public Void visit(ELEMENT b) {
        System.out.println("ELEMENT");
        switch(b.element) {
            case "Table":
                b.table.accept(this);
                break;
            case "Navbar":
                b.navbar.accept(this);
                break;
            case "Paragraph":
                b.paragraph.accept(this);
                break;
            case "Image":
                b.image.accept(this);
                break;
            case "List":
                b.list.accept(this);
                break;
        }
        return null;
    }

    @Override
    public Void visit(GRID b) {
        return null;
    }

    @Override
    public Void visit(GRIDROW b) {
        return null;
    }

    @Override
    public Void visit(HTML b) {
        System.out.println("HTML");
        writer.println(b.start);

        for (ELEMENT element : b.elements) {
            element.accept(this);
        }

        writer.println(b.end);
        return null;
    }

    @Override
    public Void visit(IMAGE b) {
        return null;
    }

    @Override
    public Void visit(LIST b) {
        return null;
    }

    @Override
    public Void visit(ITEM b) {
        System.out.println("ITEM");

        writer.print(b.itemName);
        return null;
    }

    @Override
    public Void visit(NAVBAR b) {
        return null;
    }

    @Override
    public Void visit(PARAGRAPH b) {
        return null;
    }

    @Override
    public Void visit(ROW b) {
        System.out.println("ROW");

        writer.println("\t<tr>");

        // Evaluate Items
        for (ITEM item : b.items) {
            writer.print("\t\t<td bgcolor=white>");
            item.accept(this);
            writer.println("</td>");
        }

        writer.println("\t</tr>");
        return null;
    }

    @Override
    public Void visit(TABLE b) {
        System.out.println("TABLE");
//        writer.println("<table bgcolor=black " + "style=\"grid-area: " + placement + "\" >");
        writer.println("<table bgcolor=black " + "id=\"" + b.hashCode() + "\" >");
        for (ROW r : b.rows){
            r.accept(this);
        }
        writer.println("</table>");
        return null;
    }

    @Override
    public Void visit(TITLE b) {
        System.out.println("TITLE");
        writer.println(b.title);
        return null;
    }
}
