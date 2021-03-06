/* ------------------------------
   $Id: makeargv-main.c,v 1.2 2006/04/11 12:01:25 marquet Exp $
   ------------------------------------------------------------

   Squelette d'utilisation de makeargv

   Philippe Marquet, Apr 2006
   
*/

#include <unistd.h>
#include "makeargv.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[])
{
    int i, status;

    for (i=1; i<argc; i++) { /* traiter argv[i] */
        char **cmdargv;
        char **arg;

        /* création du argv de l'argument i */
        status = makeargv(argv[i], " \t", &cmdargv);
        assert(status>0);

        /* test: affichage */
        fprintf(stderr, "[%s]\t%% ", cmdargv[0]);
        for (arg=cmdargv; *arg; arg++)
            fprintf(stderr, "%s ", *arg);
        fprintf(stderr, "\n");

        /* libération mémoire */
        freeargv(cmdargv);
    }

    exit(EXIT_SUCCESS);
}
