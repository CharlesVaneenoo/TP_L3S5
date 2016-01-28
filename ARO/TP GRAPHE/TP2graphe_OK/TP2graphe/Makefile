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
EXEC = realclean graphe2visu en_largeur
TP=1

NOM1=Gallet

NOM2=Vaneenoo

all: ${EXEC}

test: 
	./test.sh

testAnalyseur:
	$(CC) ${CFLAGS} testAnalyseur.c graphe.c -o testAnalyseur

graphe2visu:
	$(CC) ${CFLAGS} graphe2visu.c graphe.c -o graphe2visu	

en_largeur:
	$(CC) ${CFLAGS} en_largeur.c graphe.c -o en_largeur

clean:
	rm *.o || true

realclean: clean
	rm graphe2visu || true
	rm en_largeur || true

.PHONY: all clean realclean

archive: realclean

	rm -rf ../TP${TP}_${NOM1}_${NOM2}

	mkdir ../TP${TP}_${NOM1}_${NOM2}

	cp -r * ../TP${TP}_${NOM1}_${NOM2}

	cd .. ; zip -r TP${TP}_${NOM1}_${NOM2}.zip TP${TP}_${NOM1}_${NOM2}/*

