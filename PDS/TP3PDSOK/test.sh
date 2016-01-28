#Compilation
make

#Test mtail stupide
echo "Test de mtail stupide sur mtail.c pour les 10 dernieres lignes \n"
./mtail_stupide -n10 mtail.c

#Test mtail
echo "\n Test de mtail sur mtail.c pour les 10 dernieres lignes \n"
./mtail -n 10 mtail.c
echo "\n Test de tail sur mtail.c pour les 10 dernieres lignes \n"
tail -n 10 mtail.c

echo "\n Test de mtail sur mtail.c pour 0 lignes \n"
./mtail -n 0 mtail.c
echo "\n Test de tail sur mtail.c pour 0 lignes \n"
tail -n 0 mtail.c

#Suppression des fichiers crées
echo "Suppression fichiers inutiles en cours..."
make realclean
