
#Q1
SELECT mnom|| ' à '|| prix || ' euros' as resultatq1 FROM machines;

#Q2
SELECT f.fnom||' de '|| f.ville as resultatq2 FROM fournisseurs f natural join pieces where pnom='roue';

#Q3
select p.pnom||' - '||c.nb_piece as resultatq3 from compomach c natural join pieces p where c.mnom = 'Presse';

#Q4
select sum(nb_piece) from compomach where mnom='Presse';

#Q5
select distinct p.pnom from compomach c natural join pieces p group by p.pnom having count(c.pid)>1

#Q6
select pnom || ' - ' || nb_piece || ' - ' || ville || ' - ' || pieces.fnom as resultatQ6 from compomach natural join pieces , fournisseurs where mnom='Moissonneuse-­batteuse' AND pieces.fnom = fournisseurs.fnom;

#Q7
select mnom||' - '||sum(quantite) as resultatq7 from commandes  where date_prevue<='2016/04/30' group by mnom

