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
EXEC=do makeargv 

TP=6

NOM1=Gallet

NOM2=Vaneenoo

all: $(EXEC)

test: 
	./test.sh

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

makeargv: makeargv.c 
	${CC} ${LDFLAGS} -o $@ -c $^

do: do.o makeargv.o
	${CC} ${LDFLAGS} -o $@ $^

clean:
	rm *.o || true

realclean: clean
	rm do || true
	rm makeargv || true

.PHONY: all clean realclean

archive: realclean

	rm -rf ../TP${TP}_${NOM1}_${NOM2}

	mkdir ../TP${TP}_${NOM1}_${NOM2}

	cp -r * ../TP${TP}_${NOM1}_${NOM2}

	cd .. ; zip -r TP${TP}_${NOM1}_${NOM2}.zip TP${TP}_${NOM1}_${NOM2}/*

