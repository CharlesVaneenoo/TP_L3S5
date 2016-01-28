#
# Java Makefile
#

JC = javac
JVM = java

all: gJadeLex cJadeLex eJadeLex

gJadeLex:
	$(JVM) -jar jflex-1.6.1.jar src/jadelex/jade.lex

cJadeLex:
	$(JC) -cp src -d bin src/jadelex/*.java 
	$(JC) -cp src -d bin src/jade/Direction.java 
	$(JC) -cp src -d bin src/jade/JadeException.java 
	$(JC) -cp src -d bin src/jade/JadeMachine.java 
	$(JC) -cp src -d bin src/jade/JadeParser.java 
	$(JC) -cp src -d bin src/jade/ParserLevel1.java 
	$(JC) -cp bin -d bin src/jade/JadeRunner.java 

eJadeLex: 
	$(JVM) -cp bin jadelex.Test testJadelex.txt

help: 
	nano lisezmoi.txt


