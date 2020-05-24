package ui;

import ast.CSS;
import ast.HTML;
import libs.Node;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       List<String> literals = Arrays.asList("Grid:", "Title:", "Table:","[","]","|","End of table", "Content:", "Paragraph:", "List:", "Navbar:", "Image:" );
        Tokenizer.makeTokenizer("input.thtml",literals);
        Node.setWriter("output.css");
        CSS css = new CSS();
        css.parse();
        css.evaluate();
        Node.closeWriter();

        Node.setWriter("output.html");
        HTML p = new HTML();
        p.parse();
        p.evaluate();
        Node.closeWriter();

        System.out.println("Done evaluation");
    }

}
