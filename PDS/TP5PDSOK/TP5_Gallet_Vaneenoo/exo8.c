#include  <stdio.h>
#include <stdlib.h> 
#include <unistd.h>
#include <sys/types.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>

void exo8(int n){
	pid_t pid;
	int i;
	int j;
	int status;
	for (i = 0 ; i < n ; i++){
			switch(pid = fork()){
				case -1:
					perror("errno");
					exit(EXIT_FAILURE);
				break;
				case 0:
					printf("PID processus toujours vivant: %d\n",getpid());
					sleep(5); 
					exit(EXIT_SUCCESS);
				break;
			}
	}

	system("ps -a");

	// affichage des bon pid à faire 
	for (j=0;j<n;j++){
		wait(&status);
		printf("Processus en cours d'arrêt : %d\n",getpid());

		kill(getpid(),EXIT_SUCCESS);
		}	
}


int main(int argc, char *argv[]){
	
	int nbProcessus = atoi(argv[argc-1]);
	exo8(nbProcessus);
	return 0;
}