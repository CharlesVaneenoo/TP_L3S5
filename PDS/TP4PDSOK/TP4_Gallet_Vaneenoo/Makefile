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

TP=4

NOM1=Gallet

NOM2=Vaneenoo

all: mcat

test: 
	./test.sh

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

mcat: mcat.o
	${CC} ${LDFLAGS} -o $@ $^

clean:
	rm *.o || true
	rm mcat-tm.dat || true
	rm bigfile || true

realclean: clean
	rm mcat || true

.PHONY: all clean realclean

archive: realclean

	rm -rf ../TP${TP}_${NOM1}_${NOM2}

	mkdir ../TP${TP}_${NOM1}_${NOM2}

	cp -r * ../TP${TP}_${NOM1}_${NOM2}

	cd .. ; zip -r TP${TP}_${NOM1}_${NOM2}.zip TP${TP}_${NOM1}_${NOM2}/*

