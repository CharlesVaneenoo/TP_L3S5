/*set USINE*/
reset;

var nbJoursUsineA >= 0;
var nbJoursUsineB >= 0;

param prixUsineA /*(USINE)*/ > 0;
param prixUsineB > 0;
param qte_produite_inferieur_A >0;
param qte_produite_moyen_A >0;
param qte_produite_superieur_A >0;
param qte_produite_inferieur_B >0;
param qte_produite_moyen_B >0;
param qte_produite_superieur_B >0;
param prod_inferieur >0;
param prod_moyen >0;
param prod_superieur >0;

/*contraintes*/

subject to budget_mini1 :
qte_produite_inferieur_A*nbJoursUsineA + qte_produite_inferieur_B*nbJoursUsineB >= prod_inferieur;

subject to budget_mini2 :
qte_produite_moyen_A*nbJoursUsineA + qte_produite_moyen_B*nbJoursUsineB >= prod_moyen;

subject to budget_mini3 :
qte_produite_superieur_A*nbJoursUsineA + qte_produite_superieur_B*nbJoursUsineB >= prod_superieur;

/*Objectif*/

minimize prix :
(prixUsineA*nbJoursUsineA+prixUsineB*nbJoursUsineB);

data;
param prixUsineA :=1000;
param prixUsineB :=2000;
param qte_produite_inferieur_A :=8;
param qte_produite_moyen_A :=1;
param qte_produite_superieur_A :=2;
param qte_produite_inferieur_B :=2;
param qte_produite_moyen_B :=1;
param qte_produite_superieur_B :=7;
param prod_inferieur :=16;
param prod_moyen :=5;
param prod_superieur :=20;