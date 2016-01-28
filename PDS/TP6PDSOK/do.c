#include <stdio.h>
#include <stdlib.h>
#include "makeargv.h"
#include <assert.h>
#include <errno.h> 
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <string.h>

#define SIZE_MAX_ARGS 100

/** Valeur de EXIT_SUCCESS // EXIT_FAILURE **/
	/** 0 // 1 **/

void true(){
	exit(EXIT_SUCCESS);
}

void false(){
	exit(EXIT_FAILURE);
}

/** 
Return the number of the finale value depending upon the option(s) used with do. 
**/

int modeChoice(int mode){
	int valFinale;
		switch(mode){
			case 1:
				valFinale = 0;
			break;

			case 4:
				valFinale = 0;
			break;

			case 2:
				valFinale = 1;
			break;

			case 5:
				valFinale = 1;
			break;

			default:
				valFinale = 0;
			break;
			}
	return valFinale;
}

/** 
Return the number of process the function do needs to execute.
I made this function to let me know how much process need to be execute depending upon
the number of option (-a -o -c -k) in the command line 
**/

int nbProcess(int argc,int mode,int killMode){

	int nbTotalProcess = 0;	
		switch(mode){
				case 1:
						if (killMode == 0) 
							nbTotalProcess = argc-2;
						else if (killMode == 1)
							nbTotalProcess = argc-3;
				break;

				case 4:
						if (killMode == 0) 
							nbTotalProcess = argc-3;
						else if (killMode == 1)
							nbTotalProcess = argc-4;
				break;

				case 2:
						if (killMode == 0) 
							nbTotalProcess = argc-2;
						else if (killMode == 1)
							nbTotalProcess = argc-3;			
				break;

				case 5:
						if (killMode == 0) 
							nbTotalProcess = argc-3;
						else if (killMode == 1)
							nbTotalProcess = argc-4;			
				break;	

				default:
					nbTotalProcess = argc-1;
				break;
				}
	return nbTotalProcess;
}

/** 
The do function.
**/
int mdo(int argc,char *argv[],int mode,int killMode){

	pid_t *pid;
	char ** cmdargs;
	pid_t current_pid;
	int status,res,valFinale,totalProcess,nbOptionsInArgs,i;
	pid = malloc(argc*sizeof(pid_t));

	totalProcess = nbProcess(argc,mode,killMode);
	nbOptionsInArgs = argc - totalProcess;
	valFinale = modeChoice(mode);

/** Ici on crée les processus fils en fonction du nombre d'arg  **/

		for (i=nbOptionsInArgs;i<argc;i++){
			makeargv(argv[i]," \t",&cmdargs);
			switch (pid[i]=fork()){
				case -1:
					perror("Errno");
					exit(EXIT_FAILURE);
				break;
				case 0:		
					printf("Process/Pid : %s/%d\n",cmdargs[0],getpid());
					fflush(stdout);
					if ( (res = execvp(cmdargs[0],cmdargs)) < 0){
						false();
					}
					else {
						true();
					}
				break;				
			}
		}


	while(totalProcess){
			current_pid = waitpid(0,&status,0);
			if (WIFEXITED (status)){
				if (WEXITSTATUS(status) == 1) {
					if (strcmp(argv[1],"-a") == 0){
						valFinale = 1;
							if (strcmp(argv[2],"-c") == 0){
								printf("Pid du processus quand le programme s'arrête : %d\n",current_pid);
							}
					}
					else if (strcmp(argv[1],"-o") == 0 ){
						valFinale = 0;
							if (strcmp(argv[2],"-c") == 0){
								printf("Pid du processus quand le programme s'arrête : %d\n",current_pid);
							}
					}				
				}
			}
				if (killMode == 1) {
						for (int j=nbOptionsInArgs;j<=totalProcess+nbOptionsInArgs;j++){
							kill(pid[j],9);
						}
					}
			totalProcess--; 
			printf("Le processus %d est terminé\n", current_pid);
		}
	printf("Le code de retour de do est %d\n", valFinale);
	return valFinale;
}

int main(int argc, char *argv[]) {

	char c;
	int mode = 0;
	int killMode = 0;

	while ( (c = getopt(argc,argv,"aock")) != -1 ) {
			switch(c) {
				case 'a' :
						mode+=1;
				break;

				case 'o':
						mode+= 2;
				break;

				case 'c':
						mode+=3;
				break;

				case 'k':
						killMode = 1;
				break; 
				default:
					if ((mode==0) && (killMode==1)){
						printf("do [-a||-o||-a -c||-o -c||-a -c -k||-o -c -k|| : mode used] process\n");
						exit(EXIT_FAILURE);					
					}
				break;
			}
		}

	return mdo(argc,argv,mode,killMode);
}	
