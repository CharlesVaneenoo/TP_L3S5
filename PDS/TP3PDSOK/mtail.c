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

#define SIZE_MAX_BUFFER 10

/** Compte le nombre total de caracteres dans le fichier donné par pathname **/
int count_char_from_buffer(char * buf) {
	int nbChar = 0;
	int i = 0;

	while (buf[i] != '\0'){
			nbChar++;
			i++;
		}

	return nbChar;
}


/** Compte le nombre total de lignes dans le fichier donné par pathname **/
int count_lines_from_buf(char * buf) {
	int nblines = 0;
	int nbTotalChar = count_char_from_buffer(buf);
	int i = 0;

	while (i<nbTotalChar){
			if (buf[i] == '\n') {
				nblines++;
			}
			i++;
		}

	if (buf[nbTotalChar] == '\0' && buf[nbTotalChar-1] != '\n'){
			nblines++;
		}

	return nblines;
}

/**		 			Exercice 17 (Fin du tampon)					**/
int index_tail_buffer(const char * buffer, int bufsize, int ntail, int *nlines){

	int nlines_read = 0;
	int i = bufsize;

	while (i>=0 && nlines_read < ntail){
		if(buffer[i] == '\n'){
			nlines_read++;
		}
		i--;
	}

	*nlines = nlines_read;

	if (!(nlines_read<ntail)){
		i=i+2;
		return i;
	}
	return -1;
}

/** Fonction pour l'affichage des caractères d'un buffer, de la position from
						jusqu'à la position at 							  **/
void display_buffer(char * buf, int from, int at){
	for(int i = from;i < at; i++){
		printf("%c",buf[i]);
	}
}

/**		 			Exercice 18 (tail() relative)					**/

void tail_before_pos(int fd, unsigned int pos, int ntail){

	char * buffer;
	int read_bytes, index, nb_lines_read, lastByte;

	buffer = malloc(SIZE_MAX_BUFFER+1);

	/** On test pour voir si le buffer n'est pas vide **/
	if (buffer == NULL){
		printf("Le buffer est vide.");
		exit(EXIT_FAILURE);
	}

	if (lseek(fd,-(int)pos,SEEK_CUR) == -1){
		/** On place la tête de lecture au début du fichier 
		et on indique où se trouve
		le dernier byte à lire dans lastByte **/
		lseek(fd,0,SEEK_SET);
		lastByte = lseek(fd,0,SEEK_END);
		read_bytes = read(fd,buffer,lastByte);
	}
	else{
		lastByte = lseek(fd,0,SEEK_CUR);
		read_bytes = read(fd,buffer,SIZE_MAX_BUFFER); 
	}
	/** On cherche l'index des ntail derniere lignes, et si == -1 on replace la position, 
	puis on fait un appel récursif à tail_before_pos**/
	index = index_tail_buffer(buffer,read_bytes,ntail,&nb_lines_read);
	
	if (index == -1) {
		tail_before_pos(fd,SIZE_MAX_BUFFER+read_bytes,ntail-nb_lines_read);
		display_buffer(buffer,0,read_bytes);
	}
	else {
		display_buffer(buffer,index,read_bytes-index);
	}
	/** On libère l'espace alloué pour le buffer **/
free(buffer);
}

void tail(const char * pathname, int ntail){

	int fd = open(pathname,O_RDONLY);
	if (fd == -1) {
		printf("Problème lors de l'ouverture du fichier");
		exit(EXIT_FAILURE);
	}

	tail_before_pos(fd,SIZE_MAX_BUFFER,ntail);
	close(fd);
}


int main(int argc, char *argv[]) {
	char *pathname = argv[argc-1];
	int ntail = 0;
	int c; 	

	while ( (c = getopt(argc,argv,"n:")) != -1 ) {
			switch(c) {
				case 'n' :
					ntail = atoi(optarg);
				break;

				default:
					printf("mtail_stupide [-n : number of line from the end] file_pathname\n");
					exit(EXIT_FAILURE);
				break;
			}
		}
	tail(pathname,ntail);
	return 0;
}