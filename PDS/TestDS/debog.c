#include <unistd.h>
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int status;
	switch(fork()){
		case -1: exit(EXIT_FAILURE);
		case 1: 
			printf("Je suis le fils\n");
			exit(123);
		case 0:
			printf("Je suis le pere\n");
	}
	assert(wait(&status)!=-1);
	printf("Mon fils s'est termine en retournant %d\n",status );
	return 0;

}