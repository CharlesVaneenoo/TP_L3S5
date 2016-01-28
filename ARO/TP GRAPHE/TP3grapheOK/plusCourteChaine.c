

#include <stdio.h>
#include <stdlib.h> 
#include "graphe.h"




typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleurs[MAX_SOMMETS];


/*calcule les tableaux d et pred*/
void plus_courte_chaine(tGraphe graphe, tNomSommet s) {	
/*creation de file et on la libere*/
	tFileSommets file;
	file = fileSommetsAlloue();
	fileSommetsLibere(file);



	int d[MAX_SOMMETS];
	tNumeroSommet pred [MAX_SOMMETS];
	tCouleur tTabCouleurs[MAX_SOMMETS];
	tNomSommet nomSommet;
   	int nbSommets = grapheNbSommets(graphe);

/*colorier en bleu tous les sommets sauf s*/
	   while(i<nbSommets){
	      grapheRecupNomSommet(graphe,i,nomSommet);
	      if (nomSommet != s){
	      	tTabCouleurs[i] = 1;
        }
	      else 
	      {
	      	tTabCouleurs[i] = 2;
	      }    	
	      i++;
    }
/*d(s) =0 et pred(s) est indéfini*/
		d[s] = 0;
		pred[s]=-1;

/*colorier s en vert et enfiler*/

 tNumeroSommet indexSommetS = grapheChercheSommetParNom(graphe,s);
      tTabCouleurs[indexSommetS] = 2;
      printf("Couleur du sommet S avant enfilage : %s\n",couleur_sommet(tTabCouleurs[indexSommetS]));
      fileSommetsEnfile(file,indexSommetS);

    while (!fileSommetsEstVide(file)){
    	tNumeroSommet x;
    	x = fileSommetsDefile(file);

    	      if(grapheNbVoisinsSommet(graphe,x) != 0){
    	      	for (int j = 0; j < grapheNbVoisinsSommet(graphe,x);j++){
	    	      	tNumeroSommet y;
	    	      	y = grapheVoisinSommetNumero(graphe,x,j); 
	    	      		if (tTabCouleurs[y] == 1){
	    	      		  tTabCouleurs[y] = 2;
	   			    		  fileSommetsEnfile(file, y);
	    	      		}
    	     	  }
    	      }  
/*faire d(y)=d(x)+1 et pred(y) := x*/


/*colorier x en rouge*/
   	  tTabCouleurs[x] = 0; 
    }







/*affichage du plus court chemin*/


}



int main(int argc, char *argv[]) {
tGraphe graphe;

  if (argc<3) {
    halt("Usage : %s FichierGraphe %s Nom Sommet %s\n", argv[0],argv[1],argv[2]);
  }

  graphe = grapheAlloue();
  grapheChargeFichier(graphe, argv[1]);

  plusCourteChaine(graphe,argv[2]);

  grapheLibere(graphe);

  exit(EXIT_SUCCESS);

}