// Generated from grammar/first.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link firstParser}.
 */
public interface firstListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link firstParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(firstParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link firstParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(firstParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guest_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterGuest_stat(firstParser.Guest_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guest_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitGuest_stat(firstParser.Guest_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dish_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDish_stat(firstParser.Dish_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dish_stat}
	 * labeled alternative in {@link firstParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDish_stat(firstParser.Dish_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code diet_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 */
	void enterDiet_list(firstParser.Diet_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code diet_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 */
	void exitDiet_list(firstParser.Diet_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allergies_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 */
	void enterAllergies_list(firstParser.Allergies_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allergies_list}
	 * labeled alternative in {@link firstParser#guest_attr}.
	 * @param ctx the parse tree
	 */
	void exitAllergies_list(firstParser.Allergies_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ing_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void enterIng_list(firstParser.Ing_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ing_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void exitIng_list(firstParser.Ing_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void enterType_list(firstParser.Type_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void exitType_list(firstParser.Type_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allergens_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void enterAllergens_list(firstParser.Allergens_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allergens_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void exitAllergens_list(firstParser.Allergens_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tag_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void enterTag_list(firstParser.Tag_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tag_list}
	 * labeled alternative in {@link firstParser#dish_attr}.
	 * @param ctx the parse tree
	 */
	void exitTag_list(firstParser.Tag_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link firstParser#full_name}.
	 * @param ctx the parse tree
	 */
	void enterFull_name(firstParser.Full_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link firstParser#full_name}.
	 * @param ctx the parse tree
	 */
	void exitFull_name(firstParser.Full_nameContext ctx);
}