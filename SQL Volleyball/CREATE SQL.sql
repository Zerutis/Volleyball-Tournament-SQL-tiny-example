CREATE TABLE NARYS (
	Licencijos_NR int NOT NULL UNIQUE,
	Vardas varchar(15),
	Pavarde varchar(20),
	Gimimo_data date,
	Alga int CHECK (ALGA < 5000),
	Komanda varchar(20),
	PRIMARY KEY (Licencijos_NR)
);

CREATE TABLE ZAIDEJAS (
	Licencijos_NR int,
	Marškinėlių_NR int CHECK (Marškinėlių_NR < 100),
	Pozicija varchar(20),
	FOREIGN KEY(Licencijos_NR) REFERENCES NARYS(Licencijos_NR) ON DELETE CASCADE
);

CREATE TABLE TRENERIU_STABAS (
	Licencijos_NR int,
	Pareigos varchar(20) DEFAULT 'ASISTENTAS',
	FOREIGN KEY(Licencijos_NR) REFERENCES NARYS(Licencijos_NR) ON DELETE CASCADE
);

CREATE TABLE RUNGTYNES (
	Rungtynių_NR SERIAL PRIMARY KEY,
	_Data date
);

CREATE TABLE KOMANDA (
	Licencijos_NR int PRIMARY KEY NOT NULL UNIQUE,
	Pavadinimas varchar(15),
	Rungtynių_sk int,
	Pergalių_sk int
);

CREATE TABLE STATISTIKA (
	ZaidejoID int,
	Rungtynių_NR int,
	Padavimai int DEFAULT '0',
	Smūgiai int DEFAULT '0',
	Blokai int DEFAULT '0',
	FOREIGN KEY(ZaidejoID) REFERENCES NARYS(Licencijos_NR) ON DELETE CASCADE,
	FOREIGN KEY(Rungtynių_NR) REFERENCES RUNGTYNES(Rungtynių_NR) ON DELETE CASCADE
);