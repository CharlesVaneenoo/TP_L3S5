echo "Modification chmod README, lecture seule \n"
chmod 444 README
echo "Test ecriture avec maccess sur README \n"
./maccess -w -v README
echo
echo "Test execution avec maccess sur README \n"
./maccess -x -v README
echo "Test ecriture avec maccess sur un fichier qui n'existe pas \n"
./maccess -w -v fichiernonexistant
echo " Test sur un fichier dont le nom est de 260 caractères"
./maccess -w -v aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
echo 
chmod 644 README