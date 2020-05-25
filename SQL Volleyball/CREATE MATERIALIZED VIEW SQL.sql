CREATE MATERIALIZED VIEW Alga (Vardas, Pavardė, Alga, Komanda)
	AS SELECT Vardas,Pavarde, Alga, Komanda
		FROM NARYS
			ORDER BY Alga
				WITH DATA;
				
REFRESH MATERIALIZED VIEW ALGA;