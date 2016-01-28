package postfixees;

%%

%unicode
%line
%column

ENTIER_SIMPLE=[0-9]+
PLUS=[+]|plus
MINUS=[-]|minus
Q=[/]|q
MULT=[*]|mult
OPP=opp

%% 

{ENTIER_SIMPLE}
      { return new Valeur(yytext()); }

{PLUS}
      { return new Plus(yytext()); }

{MINUS}
      { return new Minus(yytext()); }

{Q}
      { return new Q(yytext()); }

{MULT}
      { return new Mult(yytext()); }

{OPP}
      { return new Opp(yytext()); }



.|\n 
	{}
