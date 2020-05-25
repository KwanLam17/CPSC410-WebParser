package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class GRIDROW extends Node{
    List<String> placements = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("\\[");

        // Parse first Item
        String firstPlacement = tokenizer.getNext();
        placements.add(firstPlacement);

        // Parse Items
        while(!tokenizer.checkToken("\\]")){
            tokenizer.getAndCheckNext("\\|");
            String placement = tokenizer.getNext();
            placements.add(placement);
        }

        tokenizer.getAndCheckNext("\\]");
    }

//    @Override
//    public void evaluate() {
//        writer.print("\"");
//
//        for (String placement : placements) {
//            writer.print(placement + " ");
//        }
//
//        writer.print("\"\n");
//    }


    //@Override
    public <T> T accept(webParserVisitor<T> v) {
        return v.visit(this);
    }
}
