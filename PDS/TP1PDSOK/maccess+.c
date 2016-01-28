#include <unistd.h>
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <errno.h>
#include <limits.h>

extern int errno;

int maccess_plus(char *pathname,int mode, int v) {	
	
	int valid;

	switch(mode){
		case 1:
				valid = access(pathname,R_OK);
		break;

		case 2:
				valid = access(pathname,W_OK);
		break;

		case 4:
				valid = access(pathname,X_OK);
		break;

		case 3:
				valid = access(pathname,(R_OK|W_OK));
		break;

		case 5:
				valid = access(pathname,(R_OK|X_OK));
		break;

		case 6:
				valid = access(pathname,(W_OK|X_OK));
		break;

		case 7:
				valid = access(pathname,(R_OK|W_OK|X_OK));
		break;

		default:	
			printf("Le mode n'est pas présent dans la fonction\n");
		break;
	}

		if (valid == 0){
				printf("Vous avez les droits pour accéder au fichier\n");
				}
				else if (valid !=0 && v==1) {
					printf("Erreur %d :\n",errno);
					switch(errno){
						case EACCES : printf("L'accès serait refusé au fichier lui-même, ou il n'est pas permis de parcourir l'un des répertoires. Pathname en question : %s\n",pathname);
						break;
						case ELOOP : printf("Trop de liens symboliques ont été rencontrés en parcourant %s.\n",pathname);
						break;
						case ENAMETOOLONG : printf("Un composant de %s a dépassé %d caractères ou le nom de chemin a dépassé %d caractères.\n",pathname,NAME_MAX,PATH_MAX);
						break;
						case ENOENT : printf("Le fichier %s n'existe pas.\n",pathname);
						break;
						case ENOTDIR : printf("Un composant de %s n'est pas un répertoire.\n",pathname);
						break;
						case EROFS : printf("L'accès à l'écriture est demandé pour un fichier en lecture seule.\n");
						break;
						case ETXTBSY : printf("L'accès à l'écriture est demandé pour un fichier en cours d'exécution.\n");
						break;
						case EIO  : printf("Une erreur d'entrée/sortie est survenue pendant la lecture ou l'écriture du fichier %s.\n",pathname);
						break;
						case EFAULT : printf("%s pointe à l'exterieur de l'espace d'adressage accessible.\n",pathname);
						break;
						default : printf("Le numéro d'erreur n'existe pas, il n'y a donc pas de description.\n");
						break;
					}
				}
			else {
				exit(EXIT_FAILURE);
			}
	return 0;
}

	
int main(int argc, char *argv[]) {
	int mode = 0;

	char *pathname = argv[argc-1];

	int c;
	int v = 0;
		while ( (c = getopt(argc,argv,"rwxv")) != -1 ) {
			switch(c) {
				
				case 'r' :
					mode += 1;
				break;
				
				case 'w' :
					mode += 2;
				break;
				
				case 'x' :
					mode += 4;
				break;
				
				case 'v':
					v=1;
				break;
			}
		}

		maccess_plus(pathname,mode,v);

		return 0;
}
