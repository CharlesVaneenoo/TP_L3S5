#include "sys/wait.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "graphe.h"





/* N´ecessaire pour la macro WEXITSTATUS */
void graphe2visu(tGraphe graphe, char *outfile) {
FILE *fic;
char commande[80];
char dotfile[80]; /* le fichier dot pour cr´eer le ps */
int ret;
/* on va creer un fichier pour graphviz, dans le fichier "outfile".dot */
strcpy(dotfile, outfile);
strcat(dotfile, ".dot");
fic = fopen(dotfile, "w");
if (fic==NULL)
halt ("Ouverture du fichier %s en ´ecriture impossible\n", dotfile);



fprintf(fic, "graph {\n");







fclose(fic);
sprintf(commande, "dot -Tps %s -o %s", dotfile, outfile);
ret = system(commande);
if (WEXITSTATUS(ret))
halt("La commande suivante a ´echou´e\n%s\n", commande);
}


int main(int argc, char *argv[]) {
tGraphe graphe;
graphe = grapheAlloue();
grapheChargeFichier(graphe,  argv[1]);
graphe2visu(graphe, argv[2]);
grapheLibere(graphe);
exit(EXIT_SUCCESS);


}