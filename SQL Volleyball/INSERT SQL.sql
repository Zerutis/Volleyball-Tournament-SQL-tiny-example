INSERT INTO NARYS (licencijos_nr,vardas, pavarde, gimimo_data, alga, komanda)
VALUES ('1111','Rokas', 'Žeruolis', '1999-03-20', '4200', 'Dragons'),
	   ('1112','Jonas', 'Jonaitis', '2001-05-10', '4300', 'Dragons'),
	   ('1113','Kazys', 'Kazaitis', '1959-01-20', '4000', 'Dragons'),
	   ('1114','Bolis', 'Kampa', '1988-04-20', '1750', 'Dragons'),
	   ('1115','Jucis', 'Povas', '1987-05-12', '1700', 'Dragons'),
	   ('1116','Kazys', 'Klička', '1998-02-04', '1500', 'Dragons'),
	   ('1500','Gvidas', 'Juškas', '1970-07-20', '4000', 'Dragons'),
	   ('1600','Arnoldas', 'Kurikas', '1975-04-10', '2500', 'Dragons'),
	   ('2111','Lukas', 'Staikūnas', '1996-05-07', '3500', 'Wolves'),
	   ('2112','Almantas', 'Kvėpša', '1990-07-25', '4300', 'Wolves'),
	   ('2113','Mantas', 'Karnas', '1994-01-25', '2000', 'Wolves'),
	   ('2114','Justas', 'Kybartas', '1990-07-25', '4100', 'Wolves'),
	   ('2115','Juozapas', 'Laucius', '1980-08-24', '1700', 'Wolves'),
	   ('2116','Zygmantas', 'Jonvabalis', '1999-04-15', '3300', 'Wolves'),
	   ('2500','Andrius', 'Šikšnius', '1970-09-19', '3300', 'Wolves'),
	   ('2600','Benediktas', 'Vanagas', '1987-06-18', '2700', 'Wolves');
	   
INSERT INTO TRENERIU_STABAS(licencijos_nr,pareigos)
VALUES ('1500', 'Vyr. Treneris'),
	   ('1600', 'Asistentas'),
	   ('2500', 'Vyr. Treneris'),
	   ('2600', 'Asistentas');
	   
INSERT INTO ZAIDEJAS(licencijos_nr,marškinėlių_nr,pozicija)
VALUES ('1111','20','Libero'),
	   ('1112','99','Antras'),
	   ('1113','00','Trečias'),
	   ('1114','13','Pirmas'),
	   ('1115','07','Penktas'),
	   ('1116','24','Ketvirtas'),
	   ('2111','17','Libero'),
	   ('2112','19','Trečias'),
	   ('2113','06','Ketvirtas'),
	   ('2114','14','Libero'),
	   ('2115','01','Penktas'),
	   ('2116','36','Antras');
	   
INSERT INTO KOMANDA (licencijos_nr, pavadinimas, rungtynių_sk, pergalių_sk)
VALUES ('123','Dragons', '3', '2'),
	   ('101','Wolves', '3', '1');
	  
INSERT INTO RUNGTYNES(_data)
VALUES ('2020-03-20'),
	   ('2020-03-27'),
	   ('2020-04-03');	  

INSERT INTO STATISTIKA (zaidejoID, rungtynių_nr, padavimai, smūgiai, blokai)
VALUES ('1111','1','8','0','0'),  ('1111','2','9','0','0'), ('1111','3','4','0','0'),
	('1112','1','4','9','1'),  ('1112','2','7','7','7'), ('1112','3','4','4','8'),
	('1113','1','3','17','4'), ('1113','2','4','4','1'), ('1113','3','16','7','1'),
	('1114','1','9','4','3'),  ('1114','2','7','0','6'), ('1114','3','3','15','9'),
	('1115','1','15','7','5'), ('1115','2','6','8','7'), ('1115','3','7','1','3'),
	('1116','1','9','3','7'),  ('1116','2','2','4','8'), ('1116','3','12','8','4'),
	('2111','1','5','0','0'),  ('2111','2','15','0','0'),('2111','3','9','0','0'),
	('2112','1','9','4','7'),  ('2112','2','9','9','9'), ('2112','3','10','3','6'),
	('2113','1','6','4','9'),  ('2113','2','4','2','7'), ('2113','3','1','5','2'),
	('2114','1','2','3','4'),  ('2114','2','6','2','3'), ('2114','3','2','6','7'),
	('2115','1','1','10','15'),('2115','2','4','1','1'), ('2115','3','7','1','8'),
	('2116','1','7','1','4'),  ('2116','2','7','9','8'), ('2116','3','2','3','4');