// Generated from grammar/first.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link firstParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface firstVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link firstParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(firstParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guest_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuest_stat(firstParser.Guest_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dish_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDish_stat(firstParser.Dish_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code diet_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiet_list(firstParser.Diet_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allergies_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllergies_list(firstParser.Allergies_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ing_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIng_list(firstParser.Ing_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_list(firstParser.Type_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allergens_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllergens_list(firstParser.Allergens_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tag_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag_list(firstParser.Tag_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link firstParser#full_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_name(firstParser.Full_nameContext ctx);
}