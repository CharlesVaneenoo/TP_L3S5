#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <errno.h>

typedef int (*func_t) (int);

int returnInt(int n){
	printf("Appel à f(%d)\n",n);fflush(stdout);
	return (n<10);
}

func_t fonction1(){
	return returnInt;
}

int multif (func_t f[], int args[], int n){
	pid_t pid;
	int res;
	int status;
	int valFinale = 0;

	for (int i = 0 ; i < n ; i++){
		switch(pid = fork()){
			case -1:
				perror("errno");
				exit(EXIT_FAILURE);
			break;
			case 0:
				printf("PID processus fils : %d\n",getpid());
				res = f[i](args[i]);
				exit(res);
			break;
		}
	}
	
	for (int j = 0 ; j < n ; j++){
		wait(&status);
		if (WIFEXITED (status)){
			if (WEXITSTATUS(status) == 1) {
				valFinale = 1;
			}
		}
	}
return valFinale;
}


/** Il faut placer tous les arguments dans la ligne de commande **/

int main(int argc, char *argv[]){
	
	int sizeTab = argc - 1;

	int args[sizeTab];
	func_t f[sizeTab];
	
		for (int i =0;i<sizeTab;i++){
			args[i]=atoi(argv[i+1]);
			f[i]=fonction1(args[i]);
		}

	return multif(f,args,sizeTab);
}
