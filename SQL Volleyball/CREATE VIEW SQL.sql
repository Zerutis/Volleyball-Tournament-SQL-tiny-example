CREATE VIEW LIBERO (Komanda, Pavarde, alga, pozicija)
AS SELECT n.Komanda, n.Pavarde, n.alga, z.pozicija
	From Narys n, Zaidejas z
		Where n.licencijos_nr = z.licencijos_nr AND z.pozicija = 'Libero';
		
CREATE VIEW MVP_Smūgiai(Pavarde, Smūgiai)
AS SELECT Pavarde, ROUND(AVG(Smūgiai),1)
	FROM NARYS n, Statistika s
		WHERE n.licencijos_nr = s.zaidejoID
			GROUP BY n.pavarde, n.licencijos_nr
				HAVING AVG(Smūgiai) >= 5;