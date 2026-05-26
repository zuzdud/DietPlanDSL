/*package interpreter;

import grammar.firstLexer;
import grammar.firstParser;
import models.Dish;
import models.Guest;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromStream(System.in);
        firstLexer lexer = new firstLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        firstParser parser = new firstParser(tokens);

        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));

        // create dish visitor
        DishVisitor visitor = new DishVisitor();
        visitor.visit(tree);

        // importing lists of guest and dish obj
        List<Guest> guests = visitor.guests;
        List<Dish> dishes = visitor.dishes;

        // checking for allergies in guests and matching the dishes for them
        for (Guest guest : guests) {
            System.out.println("\nDish for: " + guest.name);
            for (Dish dish : dishes) {
                boolean safe = true;
                for (String allergy : guest.allergies) {
                    if (dish.allergens.contains(allergy)) {
                        safe = false;
                        break;
                    }
                }
                if (safe) {
                    System.out.println("- " + dish.name);
                }
            }
        }
    }
}
*/