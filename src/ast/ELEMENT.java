package ast;

import libs.Node;

public class ELEMENT extends Node {
    TABLE table;
    NAVBAR navbar;
    PARAGRAPH paragraph;
    IMAGE image;
    LIST list;

    String element;
    String placement;

    @Override
    public void parse() {

        tokenizer.getAndCheckNext("Placement:");
        placement = tokenizer.getNext();

        if (tokenizer.checkToken("Table:")) {
            element = "Table";
            table = new TABLE();
            tokenizer.getAndCheckNext("Table:");
            table.parse();

        } else if (tokenizer.checkToken("Navbar:")) {
            element = "Navbar";
            navbar = new NAVBAR();
            tokenizer.getAndCheckNext("Navbar:");
            navbar.parse();

        } else if (tokenizer.checkToken("Paragraph:")) {
            element = "Paragraph";
            paragraph = new PARAGRAPH();
            tokenizer.getAndCheckNext("Paragraph:");
            paragraph.parse();

        } else if (tokenizer.checkToken("Image:")) {
            element = "Image";
            image = new IMAGE();
            tokenizer.getAndCheckNext("Image:");
            image.parse();

        } else if (tokenizer.checkToken("List:")) {
            element = "List";
            list = new LIST();
            tokenizer.getAndCheckNext("List:");
            list.parse();
        }


    }


    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }
}
