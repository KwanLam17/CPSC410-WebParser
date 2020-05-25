package ast;

public interface webParserVisitor<T> {
    T visit(ELEMENT b);
    T visit(GRID b);
    T visit(GRIDROW b);
    T visit(HTML b);
    T visit(IMAGE b);
    T visit(LIST b);
    T visit(ITEM b);
    T visit(NAVBAR b);
    T visit(PARAGRAPH b);
    T visit(ROW b);
    T visit(TABLE b);
    T visit(TITLE b);
}
