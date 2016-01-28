package jadelex ;

%%

%class TokenizerV1
%implements Tokenizer
%public
%unicode
%line
%column

%{
	private int length;
	private int x ;
	private int y;
	private int occurences;
%}

BAISSER=baisser|BAISSER
LEVER=lever|LEVER
COMMENTAIRE=\/\/.*\n
NORD = north | nord | NORD | NORTH
SUD = sud | south | SOUTH | SUD
EST = est | east | EAST | EST
OUEST = ouest | OUEST | WEST | west
JUMP = aller\s[0-9]+\s[0-9]+
PAS = pas\s[0-9]+
REPEAT = [0-9]+\sfois

/** a faire **/
UNKNOWN = .|\n

%state PAS
%state JUMP
%state REPEAT

%%
{BAISSER}
		{return new PenMode(true); }

{LEVER}
		{return new PenMode(false); }

{JUMP}
		{
		int cpt=0;
		int cptspace=0;
		int a=0;
		String text = yytext();
		
			for (int i = 0; i < text.length();i++){
				if (text.charAt(i) == ' '){
					cptspace++;
				}
				if (cptspace == 2){
					a=i;
				}
			}
			
			while (text.charAt(cpt) != ' ' && cptspace < 3){
				cpt++;
			}
			
			
			x=Integer.parseInt(text.substring(6,a-1));
			y=Integer.parseInt(text.substring(a,text.length()));
		
			return new Jump(x,y);
		}
		
{PAS}
		{
		int cpt=0;
		String text = yytext();
		
		while (text.charAt(cpt) != ' '){
			cpt++;
		}
		length= Integer.parseInt(text.substring(cpt+1,text.length()));
		
		return new StepLength(length);
		}
		
{REPEAT}
		{
			String text = yytext();
			int cpt = 0;
			
				while (text.charAt(cpt) != ' '){
					cpt++;
				}
				
			occurences= Integer.parseInt(text.substring(0,cpt));
			return new Repeat(occurences);
		}
		
{UNKNOWN}
		{}
		
{NORD}
		{return new Move(Direction.NORTH); } 
{SUD}
		{return new Move(Direction.SOUTH); } 
{EST}
		{return new Move(Direction.EAST); } 
{OUEST}
		{return new Move(Direction.WEST); } 

.|\n 
	{}
