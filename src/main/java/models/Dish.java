package models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    public String name;
    public List<String> allergens = new ArrayList<>();
    public List<String> ingredients = new ArrayList<>();
}