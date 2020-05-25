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
    public Void visit(ELEMENT b) {
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
        return null;
    }

    @Override
    public Void visit(LIST_ITEMS b) {
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
        return null;
    }

    @Override
    public Void visit(TABLE b) {
        return null;
    }

    @Override
    public Void visit(TITLE b) {
        return null;
    }
}
