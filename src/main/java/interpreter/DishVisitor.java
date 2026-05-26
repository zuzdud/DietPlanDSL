package interpreter;
import java.util.*;

import grammar.firstBaseVisitor;
import grammar.firstParser;
import models.*;

import java.util.ArrayList;

public class DishVisitor extends firstBaseVisitor<Object> {
    // lists to store information about guests and their allergies
    // and dishes with their allergens
    public List<Guest> guests = new ArrayList<>();
    public List<Dish> dishes = new ArrayList<>();

    // visitGuest to iterate through guests and collect information
    // about their allergens
    @Override
    public Object visitGuest_stat(firstParser.Guest_statContext ctx) {
        Guest guest = new Guest();
        // getting the id of a guest
        guest.name = ctx.full_name().getText();

        // iterating through allergens
        for (var attr : ctx.guest_attr()) {
            if (attr instanceof firstParser.Allergies_listContext a) {
                for (var name : a.full_name()) {
                    guest.allergies.add(name.getText());
                }
            }
        }
        guests.add(guest);
        return null;
    }

    // iterating through dishes and collecting
    // information about their allergens
    @Override
    public Object visitDish_stat(firstParser.Dish_statContext ctx) {
        Dish dish = new Dish();
        // getting the name of a dish
        dish.name = ctx.full_name().getText();

        // iterating through dishes to get all allergens
        for (var attr : ctx.dish_attr()) {
            // java magic,
            if (attr instanceof firstParser.Allergens_listContext a) {
                for (var name : a.full_name()) {
                    dish.allergens.add(name.getText());
                }
            }
        }

        dishes.add(dish);
        return null;
    }
}
