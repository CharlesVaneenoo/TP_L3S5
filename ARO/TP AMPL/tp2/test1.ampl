reset;

param budget > 0;
param consotv_mini > 0;
param cout_tv > 0;
param cout_magazine >0;
param impact_tv >0;
param impact_mag >0;
param personnel >0;
param personnel_tv >0;
param personnel_mag >0;
var nb_pages_mag >= 0;
var min_tv_mini >= consotv_mini;

/*contraintes*/

subject to budget_fixe :
10*nb_pages_mag+ 20*min_tv_mini <= budget;

subject to conso_tv : 
min_tv_mini >= consotv_mini;

/*Objectif*/

maximize Impact :
(nb_pages_mag*impact_mag + min_tv_mini*impact_tv);


data;
param budget :=1000;
param consotv_mini := 10;
param cout_tv := 20;
param cout_magazine :=10;
param impact_tv :=1800;
param impact_mag :=1000;
