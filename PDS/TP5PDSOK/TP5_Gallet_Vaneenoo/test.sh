echo "Compilation des fichiers"
make

echo "exercice multif:"
echo "Test multif avec les nombres 1 2 3 - Valeur de retour attendu 1"
./multif 1 2 3 
echo "Valeur de retour :" $?

echo "Test multif avec les nombres 11 12 13 - Valeur de retour attendu 0"
./multif 11 12 13 
echo "Valeur de retour :" $?


echo "exercice course:"
./race




make realclean

