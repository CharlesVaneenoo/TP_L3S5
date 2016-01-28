#include <unistd.h>
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <errno.h>
#include <limits.h>

extern int errno;

int maccess(char *pathname,int mode) {
	
	switch(mode){
		case R_OK:
			return access(pathname,R_OK);
		break;

		case W_OK:
			return access(pathname,W_OK);
		break;

		case X_OK:
			return access(pathname,X_OK);
		break;

		default:	
			printf("Le mode n'est pas présent dans la fonction\n");
		break;
	}
	
	return 0;
}


int main(int argc, char *argv[]) {

		int mode = -1;

	if (argc == 4 && (!strcmp(argv[2],"-v")) ) {
			if (!strcmp(argv[1],"-r")) {
						mode = R_OK;
			} else if (!strcmp(argv[1],"-w")) {
						mode = W_OK;
			} else if (!strcmp(argv[1],"-x")) {
						mode = X_OK;
			}
				if (maccess(argv[3],mode) == 0){
					exit(EXIT_SUCCESS);
				}
				else {
					printf("Erreur %d :\n",errno);
					switch(errno){
						case EACCES : printf("L'accès serait refusé au fichier lui-même, ou il n'est pas permis de parcourir l'un des répertoires. Pathname en question : %s\n",argv[3]);
						break;
						case ELOOP : printf("Trop de liens symboliques ont été rencontrés en parcourant %s.\n",argv[3]);
						break;
						case ENAMETOOLONG : printf("Un composant de %s a dépassé %d caractères ou le nom de chemin a dépassé %d caractères.\n",argv[3],NAME_MAX,PATH_MAX);
						break;
						case ENOENT : printf("Le fichier %s n'existe pas.\n",argv[3]);
						break;
						case ENOTDIR : printf("Un composant de %s n'est pas un répertoire.\n",argv[3]);
						break;
						case EROFS : printf("L'accès à l'écriture est demandé pour un fichier en lecture seule.\n");
						break;
						case ETXTBSY : printf("L'accès à l'écriture est demandé pour un fichier en cours d'exécution.\n");
						break;
						case EIO  : printf("Une erreur d'entrée/sortie est survenue pendant la lecture ou l'écriture du fichier %s.\n",argv[3]);
						break;
						case EFAULT : printf("%s pointe à l'exterieur de l'espace d'adressage accessible.\n",argv[3]);
						break;
						default : printf("Le numéro d'erreur n'existe pas, il n'y a donc pas de description.\n");
						break;
					}

				}
	} else if (argc == 3) {
		if (!strcmp(argv[1],"-r")) {
					mode = R_OK;
				} else if (!strcmp(argv[1],"-w")) {
					mode = W_OK;
				} else if (!strcmp(argv[1],"-x")) {
					mode = X_OK;
				}

				assert(maccess(argv[2],mode) == 0); 
			    	exit(EXIT_SUCCESS);
	}
	else {
		exit(EXIT_FAILURE);
	}
return 0;
}
