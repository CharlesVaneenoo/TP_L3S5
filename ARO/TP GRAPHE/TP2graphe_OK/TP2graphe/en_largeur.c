#include "sys/wait.h"
#include <stdio.h>
#include <stdlib.h> 
#include "graphe.h"
#include <string.h>

/* Couleurs */
typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleurs[MAX_SOMMETS];

char * couleur_sommet(tCouleur t){
  switch (t){
    case 0:
      return "ROUGE";
    break;
    case 1:
      return "BLEU";
    break;
    case 2:
      return "VERT";
    break;
  }
  return "PAS UNE COULEUR";
}

void en_largeur(tGraphe graphe, tNomSommet s) {	
	tFileSommets file;
	file = fileSommetsAlloue();
	fileSommetsLibere(file);
    
    tNumeroSommet i;
    tNumeroSommet k;
   	int nbSommets = grapheNbSommets(graphe);
    tNomSommet nomSommet;
    tNomSommet nomSommetFinale;
    tCouleur tTabCouleurs[MAX_SOMMETS];

/** Mettre tous les sommets sauf S en bleu **/

    for(i = 0; i < nbSommets; i++){
	      grapheRecupNomSommet(graphe,i,nomSommet);
	      if (nomSommet != s)
	      	tTabCouleurs[i] = 1; 	
    }
    
/** Mettre le sommet S en vert **/
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
   	  tTabCouleurs[x] = 0; 
    }

    for (k=0; k < nbSommets ; k++){
        grapheRecupNomSommet(graphe,k,nomSommetFinale);
        printf("Couleur : %s Sommet : %s\n",couleur_sommet(tTabCouleurs[k]),nomSommetFinale);
    }
}


int main(int argc, char *argv[]) {

tGraphe graphe;

  if (argc<3) {
    halt("Usage : %s FichierGraphe %s Nom Sommet %s\n", argv[0],argv[1],argv[2]);
  }

  graphe = grapheAlloue();
  grapheChargeFichier(graphe, argv[1]);

  en_largeur(graphe,argv[2]);

  grapheLibere(graphe);

  exit(EXIT_SUCCESS);
}