### Modèle pour vos Makefile

## Compilateur C et éditeur de liens
CC      = gcc

## Options pour la compilation du C
CFLAGS  = -Wall -Werror -ansi -pedantic -Wdeclaration-after-statement
#  Spécifie la version de la norme POSIX à respecter
CFLAGS += -D_XOPEN_SOURCE=500
#  Active les informations de débogage
CFLAGS += -g

## Options de l’édition de liens
LDFLAGS  = -g

all: prlimit maccess maccess+

session_sh: 
	./session.sh

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<

prlimit_test: 
	./prlimit

prlimit: prlimit.o
	${CC} ${LDFLAGS} -o $@ $^

maccess: maccess.o
	${CC} ${LDFLAGS} -o $@ $^


maccess+: maccess+.o
	${CC} ${LDFLAGS} -o $@ $^

clean:
	rm *.o || true

realclean: clean
	rm prlimit|| true
	rm maccess|| true
	rm maccess+|| true

.PHONY: all clean realclean
