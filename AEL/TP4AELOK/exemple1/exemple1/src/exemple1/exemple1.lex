/* Exemple 1 */
package exemple1;

%%

%unicode

MOT_USUEL=[:letter:]+
ENTIER_SIMPLE=[0-9]+
OPERATEUR="+"|"-"|"/"|"*"
IDENTIFICATEUR=[A-Za-z]+[0-9]*(_[A-Za-z0-9]+)*([0-9]|[A-Za-z])*

%% 

{MOT_USUEL}|{ENTIER_SIMPLE}|{OPERATEUR}|{IDENTIFICATEUR}
      {return new Yytoken(yytext());}


.|\n 
	{}
