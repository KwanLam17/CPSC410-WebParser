package ui;

//import ast.CSS;
import ast.HTML;
import ast.webParserEvaluateCSS;
import ast.webParserEvaluateHTML;
import libs.Node;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       List<String> literals = Arrays.asList("Grid:", "Title:", "Table:","[","]","|","End of table", "Content:", "Paragraph:", "List:", "Navbar:", "Image:", "Placement:");
        Tokenizer.makeTokenizer("input.thtml",literals);

        HTML html = new HTML();
        html.parse();

        webParserEvaluateHTML h = new webParserEvaluateHTML("output.html");
        html.accept(h);
        h.closeFile();

        webParserEvaluateCSS c = new webParserEvaluateCSS("output.css");
        html.accept(c);
        c.closeFile();

//        Node.setWriter("output.css");
//        CSS css = new CSS();
//        css.parse();
//        css.evaluate();
//        Node.closeWriter();
//
//        Node.setWriter("output.html");
//        HTML p = new HTML();
//        p.parse();
//        p.evaluate();
//        Node.closeWriter();

        System.out.println("Done evaluation");
    }

}
