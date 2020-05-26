package ast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class webParserEvaluateCSS implements webParserVisitor<Void> {
    private PrintWriter writer; // nothing stops a visitor from having other features

    public webParserEvaluateCSS(String outFilename) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(outFilename, "UTF-8");
        System.out.println("tinyDotEvaluator will write evaluated output to file: " + outFilename);
    }

    public void closeFile() {
        writer.close();
    }

    @Override
    public Void visit(HTML b) {
        b.grid.accept(this);

        for (ELEMENT element : b.elements) {
            element.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ELEMENT b) {
        writer.print(b.cssStart);

        switch(b.element) {
            case "Table":
                writer.print(b.table.hashCode());
                b.table.accept(this);
                break;
            case "Navbar":
                writer.print(b.navbar.hashCode());
                break;
            case "Paragraph":
                writer.print(b.paragraph.hashCode());
                break;
            case "Image":
                writer.print(b.image.hashCode());
                break;
            case "List":
                writer.print(b.list.hashCode());
                break;
        }

        writer.println(b.cssMiddle + b.placement + b.cssEnd);
        return null;
    }

    @Override
    public Void visit(GRID b) {
        System.out.println("GRID");
        writer.println(b.cssStart);

        for (GRIDROW gridrow : b.gridRows) {
            gridrow.accept(this);
        }

        writer.println(b.cssEnd);
        return null;
    }

    @Override
    public Void visit(GRIDROW b) {
        writer.print("\"");

        for (String placement : b.placements) {
            writer.print(placement + " ");
        }

        writer.print("\"\n");
        return null;
    }

    @Override
    public Void visit(IMAGE b) {
        return null;
    }

    @Override
    public Void visit(LIST b) {
        writer.println(b.cssStart);

        for (ITEM item : b.listItems) {
            item.accept(this);
        }

        writer.println(b.cssEnd);

        return null;
    }

    @Override
    public Void visit(ITEM b) {
        return null;
    }

    @Override
    public Void visit(NAVBAR b) {
        b.accept(this);
        return null;
    }

    @Override
    public Void visit(PARAGRAPH b) {
        writer.println(b.cssStart);

        writer.println(b.cssEnd);

        return null;
    }

    @Override
    public Void visit(ROW b) {
        // styles for individual row
        return null;
    }

    @Override
    public Void visit(TABLE b) {
        b.title.accept(this);
        for (ROW row: b.rows) {
            // probably best to style all rows for specific table (here)
            row.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TITLE b) {
        // styles for title
        writer.println("font-weight: normal;");
        return null;
    }
}
