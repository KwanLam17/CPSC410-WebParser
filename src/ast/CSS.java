package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;


public class CSS extends Node {
    GRID grid = new GRID();
    List<TABLE> tables = new ArrayList<>();

    public void parse(){
        // Parse Grid structure
        grid.parse();
    }

    @Override
    public void evaluate() {
        grid.evaluate();
    }
}
