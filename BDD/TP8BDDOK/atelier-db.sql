DROP TABLE IF EXISTS machines CASCADE;
DROP TABLE IF EXISTS compomach CASCADE;
DROP TABLE IF EXISTS pieces CASCADE;
DROP TABLE IF EXISTS fournisseurs CASCADE;
DROP TABLE IF EXISTS commandes CASCADE;



#TABLES
CREATE TABLE machines(
	mnom varchar(50) primary key,
	prix int NOT NULL,
	mdescription varchar(200)
);

CREATE TABLE fournisseurs(
	fnom varchar(20) primary key,
	adresse varchar(300) NOT NULL,
	ville varchar(20) NOT NULL,
	tel varchar(10) NOT NULL,
	fax varchar(30) NOT NULL
);


CREATE TABLE pieces(
	pid INTEGER primary key,
	pnom varchar(20) NOT NULL,
	nb_stock INTEGER NOT NULL,
	fnom varchar(20) NOT NULL,
	foreign key (fnom) references fournisseurs(fnom) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE compomach(
	mnom varchar(50),
	pid INTEGER,
	nb_piece INTEGER NOT NULL,
	primary key(mnom, pid),
	foreign key(mnom) references machines(mnom) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key(pid) references pieces(pid) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE commandes(
	mnom varchar(50),
	cnom varchar(20),
	date_prevue date NOT NULL,
	quantite INTEGER NOT NULL,
	primary key(mnom, cnom, date_prevue),
	foreign key (mnom) references machines(mnom) ON DELETE CASCADE ON UPDATE CASCADE
);

#DONNEES
INSERT INTO machines(mnom, prix) VALUES ('Presse', 35000);
INSERT INTO machines(mnom, prix) VALUES ('Moissonneuse-­batteuse', 50000);

INSERT INTO fournisseurs(fnom, adresse,ville, tel, fax) VALUES ('Recharges Agricoles', '1 rue du berger', 'Boulogne','0633445179', '3618787');
INSERT INTO fournisseurs(fnom, adresse,ville, tel, fax) VALUES ('MultiRoues', '1 rue des pompiers','Tourcoing', '0354978513', '1697816987');
INSERT INTO fournisseurs(fnom, adresse,ville, tel, fax) VALUES ('Pouce Vert', '54 avenue Charles de Gaulle', 'Lille', '0648759557', '13867187');
INSERT INTO fournisseurs(fnom, adresse,ville, tel, fax) VALUES ('fournitout', '5 avenue Charles de Gaulle', 'Lille', '0648758887', '1358185');
 
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 1,'arbre',100 , 'Recharges Agricoles');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 2,'deroulement',1500 , 'MultiRoues');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 3,'embrayage',1000 , 'Recharges Agricoles');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 4,'roue',700 , 'MultiRoues');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 5,'structure primaire',200 , 'fournitout');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 6,'van', 50, 'fournitout');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 7,'batteur',50 , 'fournitout');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 8,'ascenseur',60 , 'Pouce Vert');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 9,'fiche',100 , 'Recharges Agricoles');
INSERT INTO pieces(pid,pnom,nb_stock,fnom) values ( 10,'tuyau',100 , 'Pouce Vert');


INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Presse',1,1);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Presse',2,10);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Presse',3,4);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Presse',4,4);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Presse',5,1);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Moissonneuse-­batteuse',6,1);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Moissonneuse-­batteuse',7,1);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Moissonneuse-­batteuse',8,1);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Moissonneuse-­batteuse',4,4);
INSERT INTO compomach(mnom, pid, nb_piece) VALUES ('Moissonneuse-­batteuse',5,1);



INSERT INTO commandes(mnom, cnom, date_prevue, quantite) VALUES ('Presse','Mécanique Lucien','2016/03/15' , 15);
INSERT INTO commandes(mnom, cnom, date_prevue, quantite) VALUES ('Presse','Saponnier','2016/03/30' , 50);
INSERT INTO commandes(mnom, cnom, date_prevue, quantite) VALUES ('Presse','Chicorée','2016/04/30' , 10);
INSERT INTO commandes(mnom, cnom, date_prevue, quantite) VALUES ('Moissonneuse-­batteuse','Chicorée','2016/04/30' , 30);
INSERT INTO commandes(mnom, cnom, date_prevue, quantite) VALUES ('Moissonneuse-­batteuse','Gremise','2016/05/20' , 1);


