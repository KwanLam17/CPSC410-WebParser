package ast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class webParserEvaluateHTML implements webParserVisitor<Void> {
    private PrintWriter writer; // nothing stops a visitor from having other features

    public webParserEvaluateHTML(String outFilename) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(outFilename, "UTF-8");
        System.out.println("tinyDotEvaluator will write evaluated output to file: " + outFilename);
    }

    public void closeFile() {
        writer.close();
    }

    private void printIndentedLine(String line, int indent) {
        for (int i=0; i<indent; i++) {
            writer.print("\t");
        }
        writer.println(line);
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
    public Void visit(GRID b) { return null; }

    @Override
    public Void visit(GRIDROW b) { return null; }

    @Override
    public Void visit(IMAGE b) {
        System.out.println("IMAGE");
        writer.println("<div class=\"class" + b.hashCode() + "\">");

        printIndentedLine("<img src=\"", 1);
        printIndentedLine(b.imageSrc, 2);
        printIndentedLine("\"", 1);
        printIndentedLine("width=\"200\"\n" +
                "       height=\"141\">", 1);
        writer.println("</div>");

        return null;
    }

    @Override
    public Void visit(LIST b) {

        writer.println("<div class=\"class" + b.hashCode() + "\">");

        writer.println(b.start);

        for (ITEM item : b.listItems) {
            printIndentedLine("<li>", 3);
            item.accept(this);
            printIndentedLine("</li>", 3);
        }

        writer.println(b.end);

        writer.println("</div>");

        return null;
    }

    @Override
    public Void visit(ITEM b) {
        System.out.println("ITEM");

        printIndentedLine(b.itemName, 4);
        return null;
    }

    @Override
    public Void visit(NAVBAR b) {
        System.out.println("NAVBAR");
        writer.println("<div class=\"class" + b.hashCode() + "\">");

        printIndentedLine("<nav>", 1);

        for (Map.Entry<ITEM, ITEM> entry : b.navLinks.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            printIndentedLine("<a href=\"", 1);
            entry.getValue().accept(this);
            printIndentedLine("\">", 1);
            entry.getKey().accept(this);
            printIndentedLine("</a> |", 1);
        }

        printIndentedLine("</nav>", 1);
        writer.println("</div>");
        return null;
    }

    @Override
    public Void visit(PARAGRAPH b) {

        writer.println("<div class=\"class" + b.hashCode() + "\">");

        writer.println(b.start);

        printIndentedLine(b.paragraph, 4);
        writer.println(b.end);

        writer.println("</div>");

        return null;
    }

    @Override
    public Void visit(ROW b) {
        System.out.println("ROW");

        printIndentedLine("<tr>", 2);

        // Evaluate Items
        for (ITEM item : b.items) {
            printIndentedLine("<td bgcolor=white>", 3);
            item.accept(this);
            printIndentedLine("</td>", 3);
        }

        printIndentedLine("</tr>", 2);
        return null;
    }

    @Override
    public Void visit(TABLE b) {
        System.out.println("TABLE");
        writer.println("<div class=\"class" + b.hashCode() + "\">");

        if (b.title != null) {
            b.title.accept(this);
        }
        printIndentedLine("<table bgcolor=black>", 1);
        for (ROW r : b.rows){
            r.accept(this);
        }
        printIndentedLine("</table>", 1);
        writer.println("</div>");
        return null;
    }

    @Override
    public Void visit(TITLE b) {
        System.out.println("TITLE");
        writer.println("\t" + b.title);
        return null;
    }
}
