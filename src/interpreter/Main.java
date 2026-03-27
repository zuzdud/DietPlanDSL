package interpreter;

import grammar.firstLexer;
import grammar.firstParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromStream(System.in);
        firstLexer lexer = new firstLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        firstParser parser = new firstParser(tokens);

        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));

    }
}
