--Classes--
	insert into Classes values('ECO');
	insert into Classes values('PREMIERE');
	insert into Classes values('AFFAIRE');

--Positions--
	insert into Positions values('HUBLOT');
	insert into Positions values('COULOIR');
	insert into Positions values('CENTRE');
	

--Clients--
	insert into Clients values(10,'Lyass','Imane','17','Stade de la france',92000,'Paris','France','HJ12356',45);
	insert into Clients values(11,'Vigne','Mathis','14','Rue de Rome',14000,'Venise','Italie','AB7896',30);
	insert into Clients values(12,'EL-Aouadi','Rayhana','16','Rue de l"Italie',23000,'NEW YORK ','USA','ZZ1478',25);
	insert into Clients values(25,'Rodriguez','Camilla','17','Rue Georges Gabriel',16400,'Madrid','Espagne','ET36900',35);
	insert into Clients values(38,'Escobar','Pablo','26','Rue de chili',18560,'Pogota','Colombie','BY2356',105);
	insert into Clients values(45,'Imrane','Mariem','16','Rue de l"Algérie',10000,'Rabat','Maroc','RO2586',75);

--Reservations--
	insert into Reservations values(1,10,to_date('20200105','yyyymmdd'));
	insert into Reservations values(2,11,to_date('20200208','yyyymmdd'));
	insert into Reservations values(3,12,to_date('20200304','yyyymmdd'));
	insert into Reservations values(4,25,to_date('20200110','yyyymmdd'));

--Modeles--
	insert into Modeles values('Boeing737',1,70.89);
	insert into Modeles values('Airbus737',1,80);
	insert into Modeles values('TBM700',1,95.69);
	
--Avions--
	insert into Avions values(6,'Boeing737');
	insert into Avions values(7,'Airbus737');
	insert into Avions values(8,'TBM700');
	
--Places--
	insert into Places values(45,6,'ECO','CENTRE');
	insert into Places values(15,6,'AFFAIRE','HUBLOT');
	insert into Places values(36,7,'ECO','CENTRE');
	insert into Places values(40,8,'AFFAIRE','COULOIR');
	
--Vols--
	insert into Vols values('19E56','CasablancaM5','OrlyParis',to_date('16:00:00','HH24:MI:SS'),to_date('20200205','yyyymmdd'),3,2500,0,6);
	insert into Vols values('18B56','BarajasMadrid','MarrakeshM6',to_date('18:00:00','HH24:MI:SS'),to_date('20200315','yyyymmdd'),2,1500,0,7);
	insert into Vols values('11B00','TangerIbnBatouta','MilanMalpensa',to_date('12:00:00','HH24:MI:SS'),to_date('20200415','yyyymmdd'),4,3500,1,8);

--Catalogue--
	insert into Catalogue values('19E56','AFFAIRE',3500);
	insert into Catalogue values('18B56','ECO',400);
	insert into Catalogue values('11B00','AFFAIRE',4800);
	
--Pilote--
	insert into pilote values(1,'Park','Edward','17','Rue Gangnam',1236,'Seoul','Corée du Sud');
	insert into pilote values(2,'Lee','Jessica','10','Rue Seoul',1236,'Busan','Corée du Sud');
	insert into pilote values(3,'Croft','Hannah','25','Rue NYC',13965,'California','USA');

--Hotesse--
	insert into hotesse values(4,'Go','Hae-ri','11','Rue Gangnam',1236,'Seoul','Corée du Sud',140);
	insert into hotesse values(5,'Anderson','Lara','5','Rue California',1567,'Washinton','USA',200);
	insert into hotesse values(9,'Housten','Sabrina','69','Rue Gabriel Fauré',93000,'Paris','France',210);

--Qualification--
	insert into Qualification values(1,'Boeing737',23);
	insert into Qualification values(1,'TBM700',8);
	insert into Qualification values(2,'Airbus737',0);
	insert into Qualification values(3,'Airbus737',0);

--PlacesMini--
	insert into PlacesMini values(6,'ECO',100);
	insert into PlacesMini values(7,'AFFAIRE',20);
	insert into PlacesMini values(8,'ECO',70);


--Equipages--
	insert into Equipages values(1,'19E56',1,null);
	insert into Equipages values(2,'18B56',2,null);
	insert into Equipages values(3,'11B00',null,5);
	insert into Equipages values(4,'18B56',null,9);


--Parler--
	insert into Parler values(4,'Anglais');
	insert into Parler values(4,'Coréen');
	insert into Parler values(4,'Arabe');
	insert into Parler values(5,'Francais');
	insert into Parler values(4,'Espagnol');

--PlaceReserver--
	insert into PlaceReserver values(1,'11B00',45,250);
	insert into PlaceReserver values(2,'11B00',15,2500);
	insert into PlaceReserver values(2,'11B00',40,3500);
	insert into PlaceReserver values(3,'18B56',40,300);
