/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>

#include "jobs.h"
#include "common.h"
#include "sighandlers.h"

/*
 * wrapper for the sigaction function
 */
int sigaction_wrapper(int signum, handler_t * handler) {
    struct sigaction siga; 
    /*struct pour modifier action d'un processus*/
    siga.sa_handler=handler;
    /*Permet de reprendre la lecture du buffer et supprimer l'erreur fgets error*/ 
    siga.sa_flags=SA_RESTART; 
    /*sa_handler indique l'action affectée au signal  signum*/
    sigemptyset(&siga.sa_mask);  
    /*sigemptyset() vide l'ensemble de  signaux  fourni  par  set,  tous  les signaux étant exclus de cet ensemble.*/
    /*sa_mask fournit un masque de signaux à bloquer pendant l'exécution du gestionnaire*/
    sigaction(signum,&siga,NULL); 
    /*L'appel système sigaction() sert à modifier l'action effectuée par un processus à la réception d'un signal spécifique (signum).*/
    return 1;
    
}

/*
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received a SIGSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children
 */
void sigchld_handler(int sig) {
    pid_t pid;
    int status;

    if (verbose)
        printf("sigchld_handler: entering\n");
    pid=waitpid(-1,&status,WNOHANG|WUNTRACED);
        if(WIFEXITED(status)){
            jobs_deletejob(pid);
           /* printf("le job a été terminé normalement\n");*/
        }
        if(WIFSIGNALED(status)){
            jobs_deletejob(pid);
           /* printf("le job a été terminé par un signal\n");*/
        }
        if(WIFSTOPPED(status)){
            jobs_getjobpid(pid)->jb_state = ST; /*ST stoppe le job*/
           /* printf("le job a été stoppé\n");*/
        }
    if (verbose)
        printf("sigchld_handler: exiting\n");

    return;
}

/*
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.
 */
void sigint_handler(int sig) {
    pid_t pid;
    if (verbose)
        printf("sigint_handler: entering\n");
        if ((pid = jobs_fgpid()) >0){
            kill(pid,SIGINT);
        }
    if (verbose)
        printf("sigint_handler: exiting\n");
    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.
 */
void sigtstp_handler(int sig) { 
    pid_t pid;
    if (verbose)
        printf("sigtstp_handler: entering\n");
        if ((pid = jobs_fgpid()) >0){
            kill(pid,SIGTSTP);
        }
    if (verbose)
        printf("sigtstp_handler: exiting\n");

    return;
}
