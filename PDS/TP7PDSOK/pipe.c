/* mshell - a job manager */
#include <stdlib.h>
#include <stdio.h> 
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <assert.h>
#include "pipe.h"
#include "jobs.h"
#include "cmd.h"


void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
	pid_t *pid;	
	int status,execvpstatus,i,j,k;
	int ** fds;
	pid = malloc(nbcmd*sizeof(pid_t));
	fds = (int **)malloc(nbcmd*sizeof(int *));	
	assert(pid);
	assert(fds);		
	j=0;

	if (verbose)
        printf("do_pipe: entering\n");

		for (i = 0; i<nbcmd-1; i++){
			fds[i] = malloc(2*sizeof(int));
			if ((fds[i] == NULL) & verbose){
				printf("do_pipe : failed malloc on fds\n");
			}
		}
		for (i = 0; i<nbcmd-1; i++){
			pipe(fds[i]);
		}

		for(j = 0 ; j<=nbcmd-1 ; j++){
			switch (pid[j]=fork()){
				case -1:
					perror("do_pipe : fork failed\n");
					exit(EXIT_FAILURE);
				break;
				case 0:
					if (j == 0){
					dup2(fds[0][1],STDOUT_FILENO);
						for (i=0;i<nbcmd-1;i++){
							close(fds[i][0]);
							close(fds[i][1]);
						}
					execvpstatus = execvp(cmds[0][0],cmds[0]);
					assert(execvpstatus != 0);
					}
					else if (j == nbcmd-1){
						 dup2(fds[nbcmd-2][0],STDIN_FILENO);
						for (i=0;i<nbcmd-1;i++){
							close(fds[i][0]);
							close(fds[i][1]);
									}
						execvpstatus = execvp(cmds[nbcmd-1][0],cmds[nbcmd-1]);
						assert(execvpstatus != 0);			
					}
					else {
						 dup2(fds[j-1][0],STDIN_FILENO);
						 dup2(fds[j][1],STDOUT_FILENO);
							for (i=0;i<nbcmd-1;i++){
								close(fds[i][0]);
								close(fds[i][1]);
							}
						execvpstatus = execvp(cmds[j][0],cmds[j]);
						assert(execvpstatus != 0);		
					}
				break;	
			}
		}

	for(k = 0 ; k<nbcmd-1 ; k++){
		close(fds[k][0]);
		close(fds[k][1]);
	}


	if (bg ==1){
		jobs_addjob(*pid, BG, cmds[0][0]);
	}
	else{
		jobs_addjob(*pid, FG, cmds[0][0]);
		pid_t pid_fg = jobs_fgpid();
		waitfg(pid_fg);
	}

	if (bg==1){
		printf("[%d] %d\n", jobs_pid2jid(*pid),(int) *pid );
	}	

	for (int l=0; l < nbcmd-1;l++){
		wait(&status);
	}

	free(fds);

	if (verbose)
      	  printf("do_pipe: exiting\n");

    return;
}
/**** PIPE SIMPLE ****/
/*
void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
    struct job_t *j;	
	pid_t pid;
	int fd[2], status;
	pipe(fd);
	if (verbose)
        printf("do_pipe: entering\n");
				if (nbcmd < 2) {
			perror("On a besoin d'au moins 2 commandes pour utiliser le pipe");
			exit(EXIT_FAILURE);
		}
		if (pipe(fd) !=0){
			printf("Erreur de creation du tube");
			exit(EXIT_FAILURE);
		}
		switch (pid=fork()){
						case -1:
							perror("Errno");
							exit(EXIT_FAILURE);
						break;
						case 0:		
							close(fd[0]);
							dup2(fd[1],STDOUT_FILENO);
							close(fd[1]);
							execvp(cmds[0][0],cmds[0]);
						break;	
		}
		switch (pid=fork()){
						case -1:
							perror("Errno");
							exit(EXIT_FAILURE);
						break;
						case 0:	
							close(fd[1]); 
							dup2(fd[0],STDIN_FILENO);
							close(fd[0]);
							execvp(cmds[1][0],cmds[1]);
							if (bg == 1){
								j = jobs_getjobpid(pid);
								j->jb_state = BG;
							}
						break;	
		}
		close(fd[0]);
		close(fd[1]);
		wait(&status);
		wait(&status);
	if (verbose)
      	  printf("do_pipe: exiting\n");

    return;
}*/