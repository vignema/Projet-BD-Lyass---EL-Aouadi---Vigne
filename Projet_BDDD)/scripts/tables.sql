drop table Catalogue;
drop table PlaceReserver;
drop table Places;
drop table Reservations;
drop table Parler;
drop table Equipages;
drop table PlacesMini;
drop table Qualification;
drop table hotesse;
drop table Pilote;
drop table Positions;
drop table Clients;
drop table Vols;
drop table Avions;
drop table Classes;
drop table Modeles;

create Table Modeles(
	numMod varchar2(10) not null,
	nbPilotMod integer not null,
	rayonActMod number not null,
	constraint pk_Modeles_num primary key(numMod));

create table Classes(
	idClass varchar2(10) not null,
	constraint pk_CLASSES_id primary key(idClass));

create table Avions(
	numAv integer not null,
	numModAv varchar2(10) not null,
	constraint pk_Avions_num primary key(numAv),
	constraint fk_Num_MODELE_AVION foreign key (numModAv) references MODELES(numMod));


create table Vols(
	numVol varchar2(10) not null,
	aeroDepVol  varchar2(50) not null, 
	aeroArrVol varchar2(50) not null, 
	heureDepVol date,
	dateDepVol date not null,
	dureeVol integer not null,
	distVol number not null,
	terminVol number(1) not null, 
	numAvVol integer not null,
	constraint pk_VOL_NUM primary key(numVol),
	constraint fk_Num_AVION_VOL foreign key (numAvVol) references Avions(numAv));

create table Clients(
	numCli integer not null,
	nomCli varchar2(20) not null,
	prenomCli varchar2(20) not null,
	numRueCli integer not null,
	rueCli varchar2(20),
	cpCli integer, 
	villeCli varchar2(30) not null,
	paysCli varchar2(20) not null,
	numPassCli varchar2(20) not null,
	nbHCli integer,
	constraint pk_CLIENT_NUM primary key(numCli));

create table Positions(
	idPos varchar2(10) not null,
	constraint pk_POSITIONS_id primary key(idPos));

create table Pilote(
	numPilo integer,
	nomPilo varchar2(20) not null,
	prenomPilo varchar2(20) not null,
	numRuePilo integer not null,
	ruePilo varchar2(20),
	cpPilo integer, 
	villePilo varchar2(30) not null,
	paysPilo varchar2(20) not null,
	constraint pk_PILOTE_NUM primary key(numPilo));

create table hotesse(
	numHot integer,
	nomHot varchar2(20) not null,
	prenomHot varchar2(20) not null,
	numRueHot integer not null,
	rueHot varchar2(20),
	cpHot integer, 
	villeHot varchar2(30) not null,
	paysHot varchar2(20) not null,
	nbHHot integer,
	constraint pk_HOTESSE_NUM primary key(numHot));

create table Qualification(
	numPiloQual integer not null,
	numModQual varchar2(10) not null,
	nbHQual integer,
	constraint pk_Quali_NUM primary key(numPiloQual,numModQual),
	constraint fk_Num_PILO_QUALI foreign key (numPiloQual) references pilote(numPilo),
	constraint fk_Num_MOD_QUALI foreign key (numModQual) references Modeles(numMod));

create table PlacesMini(
	numAvMini integer not null,
	idClassMini varchar2(10),
	nbPlaceMini integer not null,
	constraint pk_Places_MINI primary key(numAvMini,idClassMini),
	constraint fk_Num_AVION_MIN foreign key (numAvMini) references Avions(numAv),
	constraint fk_ID_CLASS_MINI foreign key (idClassMini) references Classes(idClass));

create table Equipages(
	numEqui integer,
	numVolEqui varchar2(10) not null,
	numPiloEqui integer,
	numHotEqui integer,
	constraint pk_EUIPA primary key(numEqui),
	constraint fk_VOL_EQUIP foreign key (numVolEqui) references Vols(numVol),
	constraint fk_PILO_EQUIP foreign key (numPiloEqui) references pilote(numPilo),
	constraint fk_Hotesse_EQUIP foreign key (numHotEqui) references hotesse(numHot));

create table Parler(
	numHotPar integer not null,
	langPar varchar2(10) not null,
	constraint pk_PARLER primary key(numHotPar,langPar),
	constraint fk_Hotesse_PARLER foreign key (numHotPar) references hotesse(numHot));

create table Reservations(
	numReser integer not null,
	numCliReser integer not null,
	dateReser date not null,
	constraint pk_RESERV primary key(numReser),
	constraint fk_RESERV_client foreign key (numCliReser) references Clients(numCli));

create table Places(
	numPla integer not null,
	numAvPla integer not null,
	idClassPla varchar2(10) not null,
	positionPla varchar2(10) not null,
	constraint pk_Places primary key(numPla),
	constraint fk_Places_Avions foreign key (numAvPla) references Avions(numAv),
	constraint fk_Places_Class foreign key (idClassPla) references Classes(idClass),
	constraint fk_Places_Position foreign key (positionPla) references Positions(idPos));

create table PlaceReserver(
	numReserPlaRes integer not null,
	numVolPlaRes varchar2(10) not null,
	numPlaPlacRes integer not null,
	prixPlaRes number not null,
	constraint pk_PlacesRes primary key(numReserPlaRes,numVolPlaRes,numPlaPlacRes),
	constraint fk_PlacesRes_Reservations foreign key (numReserPlaRes) references Reservations(numReser),
	constraint fk_PlacesRes_Vols foreign key (numVolPlaRes) references Vols(numVol),
	constraint fk_PlacesRes_Places foreign key (numPlaPlacRes) references Places(numPla));

create table Catalogue(
	numVolCat varchar2(10) not null,
	idClassCat varchar2(10) not null,
	prix number not null,
	constraint pk_CATALOGUE primary key(numVolCat,idClassCat),
	constraint fk_CATALOGUE_VOL foreign key (numVolCat) references Vols(numVol),
	constraint fk_CATALOGUE_Class foreign key (idClassCat) references Classes(idClass));