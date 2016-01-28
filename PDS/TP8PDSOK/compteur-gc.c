#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include <pthread.h>

/*
vaneenoo@a13p19:~/Téléchargements/multithread$ ./compteur-gc test.txt
Nombres de GC:   53
Taux de GC:      0.530000
Durée de calcul: 0.000002005
*/


unsigned long compteur_gc(char *bloc, unsigned long taille) {
    unsigned long i, cptr = 0;
    for (i = 0; i < taille; i++){
        if (bloc[i] == 'G' || bloc[i] == 'C'){
            cptr++;
        }
    }
    return cptr;
}

/*
Arguments et resultat
*/ 
typedef struct arg_s {
    unsigned long taille_segment;
    char *bloc;
    double res;
} arg_t;

/*
decaster les arguments 
lancer compteur_gc
stocker le resultat de f dans res
*/
void *wrapper(void *arg){
    arg_t* mthread = arg;
    mthread->res = compteur_gc(mthread->bloc, mthread->taille_segment); 
    return NULL;
}


/*int nbthreads nb de thread a chercher dans argv[2]*/
/*
arg-> arg1 = ...
arg-> arg2 = ...
arg-> res0 = ...
pthread_creat(..,..,wrapper,arg)
*/
int main(int argc, char *argv[]) {
    struct stat st;    
    struct timespec debut, fin;
    int nb_threads= atoi(argv[argc-1]);
    arg_t args[nb_threads];
    pthread_t tab[nb_threads];
    int fd, i, lus,j;
    char *tampon;
    unsigned long cptr = 0;
    off_t taille = 0;

    assert(argv[1] != NULL);

    /* Quelle taille ? */
    assert(stat(argv[1], &st) != -1);
    tampon = malloc(st.st_size);
    assert(tampon != NULL);

    /* Chargement en mémoire */
    fd = open(argv[1], O_RDONLY);
    assert(fd != -1);
    while ((lus = read(fd, tampon + taille, st.st_size - taille)) > 0)
        taille += lus;
    assert(lus != -1);
    assert(taille == st.st_size);
    close(fd);

    /* Calcul proprement dit */
    assert(clock_gettime(CLOCK_MONOTONIC, &debut) != -1);

    //calcul pour nb-1 threads

    for (i = 0; i<nb_threads;i++){
        args[i].taille_segment = taille/nb_threads;
        args[i].bloc = &tampon[i*args[i].taille_segment];
        pthread_create(&tab[i],NULL,wrapper,&args[i]);
    }  

    //dernier cas pour nb thread
        args[nb_threads].taille_segment = taille-((taille/nb_threads)*nb_threads);
        args[nb_threads].bloc = &tampon[(taille/nb_threads)*nb_threads];
        pthread_create(&tab[nb_threads],NULL,wrapper,&args[nb_threads]);
        

    for (j=0; j <=nb_threads;j++){
        pthread_join(tab[j], NULL);
        cptr += (unsigned long)args[nb_threads].res;  
    }

    assert(clock_gettime(CLOCK_MONOTONIC, &fin) != -1);
    //printf("Nombre de génomes \t Nombre de threads \t Nombres de GC \t Taux de GC\t Durée de calcul\t\n");

    /* Affichage des résultats */
    /**printf("Nombre de génomes: %d\n", (int)taille);
    printf("Nombre de threads: %d\n",nb_threads );
    printf("Nombres de GC:   %ld\n", cptr);
    printf("Taux de GC:      %lf\n", ((double) cptr) / ((double) taille));
    **/

    fin.tv_sec  -= debut.tv_sec;
    fin.tv_nsec -= debut.tv_nsec;
    if (fin.tv_nsec < 0) {
        fin.tv_sec--;
        fin.tv_nsec += 1000000000;
    }
    //printf("Durée de calcul: %ld.%09ld\n", fin.tv_sec, fin.tv_nsec);
  //  printf("(Attention: très peu de chiffres après la virgule sont réellement significatifs !)\n");
    printf("%d %d %ld %lf %ld.%09ld\n",(int) taille, nb_threads, cptr,((double) cptr) / ((double) taille), fin.tv_sec, fin.tv_nsec);
    return 0;
}
