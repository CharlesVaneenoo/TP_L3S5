CC      = gcc
CFLAGS  = -Wall -Werror
CFLAGS += -g
LDFLAGS = -g -pthread

BINS    = aleazard compteur-gc

all: ${BINS}

aleazard: aleazard.o
	${CC} ${LDFLAGS} -o $@ $^

compteur-gc: compteur-gc.o
	${CC} ${LDFLAGS} -o $@ $^

test:
	./test.sh

%.o: %.c %.h
	${CC} ${CFLAGS} -c $<
%.o: %.c
	${CC} ${CFLAGS} -c $<

deltxt:
	rm *.txt || true

deldat:
	rm res.dat || true

clean:
	rm *.o || true

realclean: clean deldat 
	rm ${BINS} || true

.PHONY: all clean realclean
