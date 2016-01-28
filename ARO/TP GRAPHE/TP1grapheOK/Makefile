### Modèle pour vos Makefile

## Compilateur C et éditeur de liens
CC = gcc

## Options pour la compilation du C
CFLAGS  = -Wall -Werror -ansi -pedantic -std=c99
#  Spécifie la version de la norme POSIX à respecter
CFLAGS += -D_XOPEN_SOURCE=500
#  Active les informations de débogage
CFLAGS += -g 

## Options de l’édition de liens
LDFLAGS  = -g

## Options personnels



all: graphe graphe2

test: 
	./test.sh

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

graphe: 
	gcc -Wall -g -std=c99 testAnalyseur.c graphe.c -o testAnalyseur

Q5: 
	gcc -Wall -g -std=c99 Q5.c graphe.c -o Q5

Q8:
	gcc -Wall -g -std=c99 Q8.c graphe.c -o Q8

graphe2:
	gcc -Wall -g -std=c99 graphe2visu.c graphe.c -o graphe2visu

clean:
	rm *.o || true

realclean: clean
	rm graphe || true
	rm Q5 || true

.PHONY: all clean realclean

