#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <errno.h>
#include <assert.h>
#include <string.h>

#define SIZE_MAX_BUFFER 9999


/** Compte le nombre total de caracteres dans le fichier donné par pathname **/
int count_char(const char * pathname) {
	int file;
	int bytes_read;
	char actualChar;
	int nbChar = 0;

	file = open(pathname,O_RDONLY);
	bytes_read = read(file,&actualChar,1);

		while(bytes_read != 0){
			nbChar++;
			bytes_read = read(file,&actualChar,1);
		}

	close(file);
	return nbChar;
}

/** Compte le nombre total de lignes dans le fichier donné par pathname **/
int count_lines(const char * pathname) {
	int file;
	int nblines = 0;
	char buf[SIZE_MAX_BUFFER];
	int i = 0;
	int nbTotalChar = count_char(pathname);

	file = open(pathname,O_RDONLY);
	read(file,&buf,SIZE_MAX_BUFFER);


		while (i < nbTotalChar ){
			if (buf[i] == '\n') {
				nblines++;
			}
			i++;
		}
		if (buf[nbTotalChar] == '\0' && buf[nbTotalChar-1] != '\n'){
			nblines++;
		}

	close(file);
	return nblines;
}

/** Version simplistic_tail où la taille du buffer == SIZE_MAX_BUFFER **/

int simplistic_tail(const char * pathname, int nbLinesBeforeEnd) {

	int file;
	int displayLines;
	int i = 0;
	int cpt = 0;

	int nbTotalLines = count_lines(pathname); 
	int nbTotalChar = count_char(pathname);
	char buf[SIZE_MAX_BUFFER];	
	
	file = open(pathname,O_RDONLY);

	displayLines = read(file,&buf,SIZE_MAX_BUFFER);

	while(i < nbTotalChar && displayLines != 0){
		if(buf[i] == '\n'){
			cpt++;
		}
		if (nbLinesBeforeEnd != 0) {
			if (cpt >= (nbTotalLines - nbLinesBeforeEnd)){
			 	printf("%c",buf[i]);
			}
		}
		else{
			 	printf("%c",buf[i]);
			}
		
		i++;
	}
	close(file);
	return 0;
}

/** 

Pour le tail simpliste :

Pour gérer la taille max du buffer, pour les gros fichiers, on peut rajouter 
un paramètre qui compte la taille max du fichier en question, et qui, une fois
envoyé dans le tail via parametres, crée le buffer de la taille du fichier 

Sinon on définit SIZE_MAX_BUFFER a une très grande valeur 

**/

/** Main pour le tail simpliste **/

int main(int argc, char *argv[]) {
	int c;
	char *pathname = argv[argc-1];

	int nbLinesBeforeEnd = 0;

	if (argc == 2) {
		/** creer un string puis atoi **/
	}


	while ( (c = getopt(argc,argv,"n:")) != -1 ) {
			switch(c) {
				case 'n' :
					nbLinesBeforeEnd = atoi(optarg);
				break;

				default:
					printf("mtail_stupide [-n : number of line from the end] file_pathname\n");
					exit(EXIT_FAILURE);
				break;
			}
		}
	return simplistic_tail(pathname,nbLinesBeforeEnd);
}