# cibles qui ne sont pas des fichiers (évite conflit avec les éventuels fichiers de même nom)
.PHONY: clean, test, docs

# variables à redéfinir pour chaque applications
SOURCES= dungeon/*.java dungeon/room/*.java dungeon/weapon/*.java
			# nom du fichier jar généré							
JAR_NAME= dungeonGame.jar 
	        # nom du manifeste utilisé pour création jar
MANIFEST= myManifest
			# les packages utilisés
PACKAGES= dungeon dungeon.room dungeon.weapon
			# les répertoires utilisés
DIR=dungeon dungeon/room dungeon/weapon
			# le classpath à utiliser
CLASSPATH = .

# toutes les tâches
all: compile docs jar 	

#structurer l'environnement de travail 
init:
	mkdir classes
	mkdir tests
	mkdir docs
	mkdir src

#compilation des sources	
compile: 
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../classes

#création du jar
jar: 
	cd classes; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

#génération de la doc	
docs:
	cd src; javadoc $(PACKAGES) -d ../docs

#exécution	par 'make args="val" run' si le jar exige des paramètres à l'exécution
run:
	java -jar $(JAR_NAME) ${args}

# génération des tests	
test: compile
	javac -classpath test-1.7.jar tests/dungeon/*.java
	javac -classpath test-1.7.jar tests/dungeon/room/*.java

#exécution des tests en supposant les noms de classe de tests = XXXTest placées dans le dossier ./tests/
#%Test:
#	java -jar test-1.7.jar dungeon.$@


#nettoyage classes docs .jar et '.class' des tests
clean:
	rm $(JAR_NAME)
	rm -f -r classes; mkdir classes
	rm -f -r docs ; mkdir docs
	

