DROP schema if exists TP2_gallet_vaneenoo cascade;
CREATE schema TP2_gallet_vaneenoo;
SET search_path to TP2_gallet_vaneenoo;


drop table if exists articles;
drop table if exists fournisseurs;
drop table if exists catalogue;


CREATE TYPE colors as  ENUM('rouge','jaune','rose','noir','argente','opaque','cyan','magenta','vert','superjaune');

CREATE TABLE Articles(
aid int primary key,                     
anom varchar(30), 
acoul colors not null
);

CREATE TABLE Fournisseurs(
fid int primary key,
fnom varchar(30),
fad varchar(70)
);

CREATE TABLE Catalogue(
fid int,   
aid int, 
prix numeric(8,2) not null check (prix >= 0),
primary key (aid,fid),
foreign key (aid) references Articles(aid) on delete cascade on update cascade,
foreign key (fid) references Fournisseurs(fid) on delete cascade on update cascade
);
