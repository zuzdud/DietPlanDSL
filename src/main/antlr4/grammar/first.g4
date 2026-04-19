grammar first;

/* stat* would mean 0 or more statements
 so empty input would be fine
 and I don't feel like allowing that */
// so our program contains one or more statements
program:	stat+ EOF ;

// statement will be defining guest and dish for now
// syntax is "guest "name" { lists of atributes }"
// or dish ...
stat:
    GUEST QUOTE full_name QUOTE LCURLY guest_attr* RCURLY #guest_stat
|   DISH QUOTE full_name QUOTE LCURLY dish_attr* RCURLY #dish_stat
;

// guest attributes are diet, allergies
// syntax:  "ingredients: nazwa, nazwa, nazwa;"
guest_attr:
 DIET COLON full_name (COMMA full_name)* SEMI #diet_list
 | ALLERGIES COLON full_name (COMMA full_name)* SEMI #allergies_list
;

//dish attributes are ingredients, type, allegrens, tags
// syntax:  "ingredients: nazwa, nazwa, nazwa;"
dish_attr:
INGREDIENTS COLON full_name (COMMA full_name)* SEMI #ing_list
 | TYPE COLON full_name (COMMA full_name)* SEMI #type_list
 | ALLERGENS COLON full_name (COMMA full_name)* SEMI #allergens_list
 | TAGS COLON full_name (COMMA full_name)* SEMI #tag_list
 ;

// not allowing numbers in guest or dish names
// name of dish or guest is a-z, with capital letters and spaces
full_name : NAME+ ;

// keywords
GUEST : 'guest';
DISH : 'dish';
INGREDIENTS : 'ingredients';
TYPE : 'type';
DIET : 'diet';
ALLERGIES : 'allergies';
ALLERGENS : 'allergens';
TAGS : 'tags';

NAME : [a-zA-Z]+ ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;

QUOTE : '"';
EQ : '=' ;
ADD: '+' ;
COMMA : ',' ;
SEMI : ';' ;
COLON : ':' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;

// do we need comments in here?
// cause i dunno
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
NEWLINE : [\r\n]+ -> channel(HIDDEN);
WS : [ \t]+ -> channel(HIDDEN) ;