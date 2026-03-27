grammar first;

program:	stat EOF ;

stat: ID ;

ID : [a-zA-Z_][a-zA-Z0-9_]* ;