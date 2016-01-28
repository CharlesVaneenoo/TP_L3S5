make
echo -e "Test du cas de base sur fichier mdu.c avec \"mdu\" et \"du\"\n"
./mdu mdu.c
du mdu.c
echo -e "\nTest du cas \"-b\" sur fichier mdu.c avec \"mdu\" et \"du\"\n"
./mdu -b mdu.c
du -b mdu.c
echo -e "\nTest du cas \"-B 512\" sur fichier mdu.c avec \"mdu\" et \"du\"\n"
./mdu -B 512 mdu.c
du -B 512 mdu.c
echo -e "\nTest sur un dossier avec \"mdu\" et \"du\"\n"
mkdir testdossier
mkdir testdossier/sousdossiertestdossier
./mdu testdossier
du testdossier
echo -e "\nTest \"mdu\" sur un fichier non existant.\n"
./mdu fichiernonexistant
echo -e "\nTest \"mdu\" sur un fichier avec longueur > PATH_MAX\n"
./mdu aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
echo -e "\nSuppression fichiers inutiles :"
make realclean
rm -rf testdossier