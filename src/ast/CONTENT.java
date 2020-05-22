package ast;

import libs.Node;

public class CONTENT extends Node {
    TABLE table;
    NAVBAR navbar;
    PARAGRAPH paragraph;
    IMAGE image;
    LIST list;

    PLACEMENT placement;

    @Override
    public void parse() {
        if (tokenizer.checkToken("Table:")) {
            table = new TABLE();
            tokenizer.getAndCheckNext("Table:");
            table.parse();

        } else if (tokenizer.checkToken("Navbar:")) {
            navbar = new NAVBAR();
            tokenizer.getAndCheckNext("Navbar:");
            navbar.parse();

        } else if (tokenizer.checkToken("Paragraph:")) {
            paragraph = new PARAGRAPH();
            tokenizer.getAndCheckNext("Paragraph:");
            paragraph.parse();

        } else if (tokenizer.checkToken("Image:")) {
            image = new IMAGE();
            tokenizer.getAndCheckNext("Image:");
            image.parse();

        } else if (tokenizer.checkToken("List:")) {
            list = new LIST();
            tokenizer.getAndCheckNext("List:");
            list.parse();

        }

        placement = new PLACEMENT();
        placement.parse();

    }

    @Override
    public void evaluate() {
        // TODO: implement evaluate
    }
}
