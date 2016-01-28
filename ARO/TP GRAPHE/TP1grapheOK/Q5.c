#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "graphe.h"

int main(int argc, char *argv[]) {

 tGraphe graphe;
graphe = grapheAlloue();
grapheChargeFichier(graphe,  argv[1]);
	
int nbsommet=grapheNbSommets(graphe);
tNumeroSommet i=0;
tNumeroSommet j=0;
tNumeroSommet k=0;
tNomSommet nom;
tNumeroSommet maxvoisin;


	while (i< nbsommet){
		if(grapheNbVoisinsSommet (graphe, i)==0){
			
			grapheRecupNomSommet(graphe,i,nom);
			printf("Sommet sans voisin : %s\n",nom);
		}
		i++;
	}






	while (j< nbsommet){
		if (maxvoisin <= grapheNbVoisinsSommet(graphe, j)){
			maxvoisin = grapheNbVoisinsSommet(graphe, j);
		}
		j++;
	}
	while (k<nbsommet){
		if (maxvoisin == grapheNbVoisinsSommet(graphe, k) ){

			grapheRecupNomSommet(graphe,k,nom);
			printf("Sommet avec voisin max : %s\n",nom);
	}
	k++;
}




/*Q7 display graphique*/
	













grapheLibere(graphe);
exit(EXIT_SUCCESS);
}