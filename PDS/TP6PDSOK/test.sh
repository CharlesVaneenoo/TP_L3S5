make
echo "Essai mdo une seule commande (ls)\n"

./do ls

echo "Essai mdo mode AND sur ls & commandeNonExistante\n"

./do -a ls commandeNonExistante || echo "Erreur: and ls commandeNonExistante a renvoyé false\n"

echo "Essai mdo mode AND toutes les commandes ok\n"

./do -a ls "ls -a" "ps -a" && echo "Toutes les commandes se sont exécutées\n"

echo "Essai mdo mode OR sur ls & commandeNonExistante\n"

./do -o ls commandeNonExistante || echo "Erreur: or ls commandeNonExistante a renvoyé false\n"

echo "Essai mdo mode OR toutes les commandes ok\n"

./do -o ls "ls -a" "ps -a" && echo "Toutes les commandes se sont exécutées\n"

echo "Essai mdo mode AND une des commandes echoue plus rapidement que les autres\n"

./do -a -c ls commandeNonExistante "ls -a" || echo "Erreur: or ls commandeNonExistante a renvoyé false\n"

echo "Essai mdo mode OR une des commandes echoue plus rapidement que les autres\n"

./do -o -c ls commandeNonExistante "ls -a" || echo "Erreur: or ls commandeNonExistante a renvoyé false\n"

echo "Essai mdo mode AND une des commandes echoue plus rapidement que les autres\n"

./do -a -c -k ls "ls -a" commandeNonExistante xeyes || echo "Erreur: or ls commandeNonExistante a renvoyé false\n"

echo "Essai mdo mode OR une des commandes echoue plus rapidement que les autres\n"

./do -o -c -k ls "ls -a" commandeNonExistante xeyes || echo "Erreur: or ls commandeNonExistante a renvoyé false\n"

echo "Suppression fichiers..."
make realclean