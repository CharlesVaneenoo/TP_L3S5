#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>


int race(){
	pid_t pid;
	int j;
	int k;
	int status;

	for (int i = 0 ; i < 10 ; i++){
		switch (pid =fork()){
			case -1 : 
				perror("errno");
				exit(EXIT_FAILURE);
			case 0 : 
			//printf("PID processus pere : %d\n",getppid());
			printf("PID processus fils : %d\n",getpid());
				while (j<100000000){
					j++;
				}
				printf("Début de la deuxieme phase de comptage...\n");
				while (k<100000000){
					k++;
				}
				printf("PID processus fils : %d\n",getpid());
				exit(EXIT_SUCCESS);
		}
	}

	for (int j = 0 ; j < 10 ; j++){
		wait(&status);
		kill(getpid(),0); 
	}
	
return 0;
}


//les proccessus sont tous lancés en meme temps 
int main(int argc, char *argv[]){
	race();
	return 0;
}