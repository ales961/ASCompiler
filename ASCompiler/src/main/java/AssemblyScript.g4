grammar AssemblyScript;

// Lexer rules (Tokens)
VAR         : 'var';
LET         : 'let';                    // Added support for 'let'
CONST       : 'const';
FUNCTION    : 'function';
EXPORT      : 'export';
RETURN      : 'return';
IF          : 'if';
ELSE        : 'else';
WHILE       : 'while';
TYPE_INT    : 'i32';
ASSIGN      : '=';
PLUS        : '+';
MINUS       : '-';
MULT        : '*';
DIV         : '/';
LT          : '<';
GT          : '>';
LTE         : '<=';
GTE         : '>=';
EQ          : '==';
NEQ         : '!=';
NOT         : '!';
AND         : '&&';
OR          : '||';
LPAREN      : '(';
RPAREN      : ')';
LBRACE      : '{';
RBRACE      : '}';
SEMI        : ';';
COMMA       : ',';
COLON       : ':';
DOT         : '.';
IDENTIFIER  : [a-zA-Z_][a-zA-Z_0-9]*;
INT_LITERAL : [0-9]+;
FLOAT_LITERAL : [0-9]+ '.' [0-9]+;
STRING_LITERAL : '"' ( ~["\\] | '\\' . )* '"';
BOOL_LITERAL : 'true' | 'false';

// Whitespace and comments
WS          : [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

// Parser rules (Syntax)
program     : (statement)* ;
statement   : varDecl | letDecl | assignment | functionDecl | returnStmt | ifStmt | whileStmt ;
varDecl     : VAR varList SEMI ;
letDecl     : LET varList SEMI ;          // Added rule for 'let' declarations
varList     : IDENTIFIER (ASSIGN expr)? (COMMA IDENTIFIER (ASSIGN expr)?)* ;
assignment  : IDENTIFIER ASSIGN expr SEMI ;
functionDecl
    : 'function' IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' '{' statement* 'return' expr ';' '}'
    ;
returnStmt  : RETURN expr SEMI ;
ifStmt      : IF LPAREN expr RPAREN LBRACE statement* RBRACE ;
whileStmt   : WHILE LPAREN expr RPAREN LBRACE statement* RBRACE ;
expr        : expr (PLUS | MINUS | MULT | DIV) expr   // Arithmetic operations
            | expr (GT | LT | GTE | LTE | EQ | NEQ) expr  // Comparison operations
            | IDENTIFIER
            | INT_LITERAL ;
