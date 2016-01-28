#include "sys/wait.h"
#include <stdio.h>
#include <stdlib.h> 
#include "graphe.h"
#include <string.h>

void graphe2visu(tGraphe graphe, char *outfile) {
				FILE *fic;
				char commande[80];
				char dotfile[80]; /* le fichier dot pour creer le ps */
				int ret,nbsommets;

				nbsommets = grapheNbSommets(graphe);
				
				int i,j;
				tNomSommet nomSommet;
				tNomSommet nomVoisin;

				/* on va creer un fichier pour graphviz, dans le fichier "outfile".dot */

				strcpy(dotfile, outfile);
				strcat(dotfile, ".dot");

				fic = fopen(dotfile, "w");

				if (fic==NULL)
				halt ("Ouverture du fichier %s en ecriture impossible\n", dotfile);
				

				fprintf(fic, "graph {\n");
				/*tester tous les sommets*/
					for (i=0; i<nbsommets; i++){
					/*nbvoisins =grapheNbVoisinsSommet(graphe,i); */
					/*tester les voisins du sommet*/
						for(j=0; j <nbsommets;j++){
							if (grapheExisteArcEntre(graphe,i,j)){
								
								grapheRecupNomSommet(graphe, i, nomSommet);

								grapheRecupNomSommet(graphe,j, nomVoisin);
								
								fprintf(fic, "  %s -- %s\n", nomSommet, nomVoisin);
							}
				
						}	
			    	}/*mettre ; ?????????,*/
				fprintf(fic, "}");
				fclose(fic);
				
				sprintf(commande, "dot -Tps %s -o %s", dotfile, outfile);

				ret = system(commande);

				if (WEXITSTATUS(ret))
				
				halt("La commande suivante a echouee\n%s\n", commande);
}

int main(int argc, char *argv[]) {

tGraphe graphe;

  if (argc<3) {
    halt("Usage : %s FichierGraphe %s Outfile\n", argv[0],argv[1]);
  }

  graphe = grapheAlloue();
  grapheChargeFichier(graphe, argv[1]);
  
  graphe2visu(graphe,argv[2]);

  grapheLibere(graphe);

  exit(EXIT_SUCCESS);
}