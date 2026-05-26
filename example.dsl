// Przykładowy plik wejściowy dla DietPlanDSL
// Scenariusz: menu na wesele z różnymi ograniczeniami dietetycznymi

/* ── GOŚCIE ─────────────────────────────────────────────── */

guest "Anna Kowalska" {
    allergies: gluten, lactose;
    diet: vegetarian;
}

guest "Piotr Nowak" {
    allergies: nuts;
}

guest "Maria Wisniewska" {
    allergies: gluten, eggs, fish;
    diet: vegan;
}

guest "Tomasz Zielinski" {
    diet: none;
}

guest "Karolina Dabrowska" {
    allergies: lactose;
}

/* ── DANIA ──────────────────────────────────────────────── */

dish "Zupa pomidorowa" {
    ingredients: tomato, onion, garlic, olive oil, basil;
    allergens: none;
    tags: soup, vegan, glutenfree;
}

dish "Pierogi z kapusta i grzybami" {
    ingredients: flour, potato, cabbage, mushroom, onion;
    allergens: gluten, eggs;
    tags: polish, vegetarian;
}

dish "Losos pieczony z cytryna" {
    ingredients: salmon, lemon, garlic, olive oil, dill;
    allergens: fish;
    tags: fish, glutenfree, lowcarb;
}

dish "Spaghetti Bolognese" {
    ingredients: pasta, beef, tomato, onion, garlic, carrot;
    allergens: gluten;
    tags: italian, meat;
}

dish "Salatka grecka" {
    ingredients: tomato, cucumber, olive, onion, feta, olive oil;
    allergens: lactose;
    tags: vegetarian, glutenfree, mediterranean;
}

dish "Kotlet schabowy" {
    ingredients: pork, breadcrumbs, eggs, flour, lard;
    allergens: gluten, eggs;
    tags: polish, meat;
}

dish "Ryż z warzywami" {
    ingredients: rice, carrot, pea, corn, broccoli, soy sauce;
    allergens: none;
    tags: vegan, glutenfree, asian;
}

dish "Tiramisu" {
    ingredients: mascarpone, eggs, coffee, ladyfingers, cocoa;
    allergens: lactose, eggs, gluten;
    tags: dessert, italian;
}

dish "Sorbet owocowy" {
    ingredients: strawberry, raspberry, sugar, lemon;
    allergens: none;
    tags: dessert, vegan, glutenfree;
}

dish "Tarta orzechowa" {
    ingredients: flour, butter, eggs, nuts, honey, cream;
    allergens: gluten, eggs, lactose, nuts;
    tags: dessert, vegetarian;
}
