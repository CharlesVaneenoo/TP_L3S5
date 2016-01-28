make

echo "Changement chmod fichiers sh\n" 

chmod +x creationFichierLourd.sh

echo "Creation en cours du fichier bigfile ...\n"
./creationFichierLourd.sh > bigfile
echo "Creation du fichier bigfile terminée\n"

#! /bin/sh -uf
#
# mcat -- campagne d'appels à mcat-scd
#
# squelette de shell script

# La commande à tester
MCAT=./mcat
# le fichier à lui mettre en entrée
MCAT_INPUT=bigfile
# Le fichier de temps à générer
TIME_FILE=mcat-tm.dat

# la commande gnu time
TIME_CMD="/usr/bin/time"
# les options de cette commande
TIME_OPT="-f %e %U %S"

# initialisation du fichier de résultats
rm -f $TIME_FILE && echo "# sizebuffer real user sys" > $TIME_FILE

# un autre exemple de boucle
for size in `awk 'BEGIN { for( i=1; i<=8388608; i*=2 ) print i }'`; do
export MCAT_BUFSIZ=$size
echo $MCAT_BUFSIZ
echo -n "$size" >> $TIME_FILE
($TIME_CMD "$TIME_OPT" $MCAT $MCAT_INPUT) > /dev/null 2>> $TIME_FILE
done
# eof

gnuplot run.gnu
make realclean

