# DietPlanDSL

Aplikacja do planowania menu na eventy z uwzględnieniem alergii gości. Projekt realizowany w ramach przedmiotu MIASI.

---

## Opis

DietPlanDSL umożliwia opisanie **gości** (wraz z ich alergiami) oraz **dań** (wraz z zawartymi alergenami) za pomocą dedykowanego języka DSL, a następnie automatycznie wyznacza, które dania są bezpieczne dla każdego gościa.

Typowe zastosowanie: organizacja wesela, konferencji lub innego przyjęcia. Gości opisuje się wraz z ich ograniczeniami dietetycznymi, dania wraz z alergenami, a aplikacja generuje dla każdego gościa listę bezpiecznych pozycji menu.

---

## Architektura

```
Plik .dsl / edytor DSL
        ↓
   ANTLR4 (Lexer + Parser, gramatyka: first.g4)
        ↓
   DishVisitor (przechodzi po drzewie składniowym)
        ↓
   Lista obiektów Guest i Dish
        ↓
   Dopasowanie: dla każdego gościa filtrowane są dania,
   których alergeny nie kolidują z jego alergiami
        ↓
   Wyniki prezentowane w interfejsie graficznym (JavaFX)
```

### Gramatyka DSL

Język obsługuje dwa typy deklaracji:

**Gość** — imię w cudzysłowie, opcjonalnie lista alergii i diety:
```
guest "Jan Kowalski" {
    allergies: gluten, lactose;
    diet: vegetarian;
}
```

**Danie** — nazwa w cudzysłowie, opcjonalnie lista składników, alergenów i tagów:
```
dish "Spaghetti Bolognese" {
    ingredients: pasta, tomato, beef, garlic;
    allergens: gluten;
    tags: italian, meat;
}
```

Obsługiwane są komentarze liniowe (`//`) oraz blokowe (`/* ... */`).

### Interfejs graficzny

Aplikacja zawiera trzy zakładki:

| Zakładka | Opis |
|----------|------|
| **Guests** | Formularz do dodawania gości i ich alergii |
| **Dishes** | Formularz do dodawania dań z alergenami i składnikami |
| **DSL Editor** | Podgląd i ręczna edycja wygenerowanego pliku DSL |

Przycisk **Run** parsuje aktualny DSL i otwiera ekran wyników, na którym dla każdego gościa wyświetlana jest lista bezpiecznych dań. Dane można zapisać do pliku `data.dsl` (przycisk **Save**) — są automatycznie wczytywane przy kolejnym uruchomieniu.

---

## Wymagania

- **Java 21+** (z obsługą JavaFX)
- **Maven 3.8+** (lub dołączony wrapper `mvnw`)
---

## Uruchomienie

```bash
git clone https://github.com/zuzdud/DietPlanDSL.git
cd DietPlanDSL
./mvnw javafx:run
```

Na Windows:
```cmd
mvnw.cmd javafx:run
```

Po uruchomieniu można:
- kliknąć **Load**, aby wczytać plik `data.dsl` z bieżącego katalogu,
- przejść do zakładki **DSL Editor**, wkleić własny DSL i kliknąć **Run**.
---

## Przykładowy plik DSL

Przykładowy plik wejściowy dostępny jest w [`example.dsl`](example.dsl) — scenariusz wesela z 5 gośćmi o różnych alergiach i 10 daniami różnych typów.

Użycie:
```bash
cp example.dsl data.dsl
./mvnw javafx:run  # następnie kliknij Load
```

Alternatywnie: zawartość pliku można wkleić bezpośrednio do zakładki **DSL Editor**.

---
 
## Potok parsowania ANTLR
 
Poniższy fragment (`MainController.java`, metoda `onRunClick`) pokazuje, jak aplikacja używa wygenerowanego przez ANTLR kodu do przetworzenia tekstu DSL:
 
```java
// 1. Lexer zamienia surowy tekst na strumień tokenów
firstLexer lexer = new firstLexer(CharStreams.fromString(dsl));
 
// 2. Parser buduje drzewo składniowe na podstawie gramatyki first.g4
firstParser parser = new firstParser(new CommonTokenStream(lexer));
 
// 3. Rejestracja własnego listenera błędów — domyślny ANTLR tylko wypisuje
//    błędy na stderr; SyntaxErrorListener zbiera je, żeby wyświetlić w UI
SyntaxErrorListener errorListener = new SyntaxErrorListener();
parser.removeErrorListeners();
parser.addErrorListener(errorListener);
 
// 4. Uruchomienie parsowania od reguły startowej 'program'
var tree = parser.program();
 
// 5. Sprawdzenie błędów składniowych przed dalszym przetwarzaniem
if (!errorListener.getErrors().isEmpty()) {
    setStatus("Syntax error: " + errorListener.getErrors().get(0), true);
    return;
}
 
// 6. Visitor przechodzi po drzewie i wypełnia listy Guest i Dish
DishVisitor visitor = new DishVisitor();
visitor.visit(tree);
 
// Od tego momentu visitor.guests i visitor.dishes zawierają
// sparsowane dane gotowe do dopasowania i wyświetlenia
rc.setData(visitor.guests, visitor.dishes);
```
 
Klasy `firstLexer` i `firstParser` są generowane automatycznie przez ANTLR4 na podstawie pliku `first.g4` podczas budowania projektu (`mvnw package`). `DishVisitor` rozszerza wygenerowaną klasę bazową `firstBaseVisitor` i nadpisuje tylko te metody, które odpowiadają regułom gramatyki istotnym dla logiki aplikacji (`visitGuest_stat`, `visitDish_stat`).

---

## Struktura projektu

```
src/main/
├── antlr4/grammar/
│   └── first.g4                     # Definicja gramatyki DSL
├── java/
│   ├── interpreter/
│   │   ├── Main.java                # Wejście CLI (zakomentowane)
│   │   └── DishVisitor.java         # Visitor przechodzący po drzewie ANTLR
│   ├── models/
│   │   ├── Guest.java               # Model gościa (imię + alergie)
│   │   └── Dish.java                # Model dania (nazwa + alergeny + składniki)
│   └── org/example/
│       ├── HelloApplication.java    # Główna klasa JavaFX
│       ├── MainController.java      # Kontroler głównego widoku
│       ├── ResultsController.java   # Kontroler ekranu wyników
│       └── SyntaxErrorListener.java # Obsługa błędów parsowania
└── resources/org/example/
    └── *.fxml                       # Definicje widoków JavaFX
```
