ALTER TABLE Zaidejas
	ADD CONSTRAINT licencijos_nr
		FOREIGN KEY (licencijos_nr) REFERENCES NARYS
			ON DELETE CASCADE
			ON UPDATE RESTRICT;
			
ALTER TABLE STATISTIKA
	ADD CONSTRAINT zaidejoID
		FOREIGN KEY (zaidejoID) REFERENCES NARYS
			ON DELETE CASCADE
			ON UPDATE RESTRICT;