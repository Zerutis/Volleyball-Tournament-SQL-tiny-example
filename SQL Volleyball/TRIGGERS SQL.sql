CREATE TRIGGER ToksPat
BEFORE INSERT ON Zaidejas
FOR EACH ROW
EXECUTE PROCEDURE ToksPat();

CREATE FUNCTION ToksPat() RETURNS TRIGGER AS $$
DECLARE 
	Numeris INT;
BEGIN
	/* Naujas zaidejo numeris*/
	SELECT markškinėlių_nr INTO numeris
		FROM Zaidejas;
	
	IF Numeris = NEW.markškinėlių_nr
	THEN
		RAISE EXCEPTION 'Marškinėlių NR toks pat';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;


drop trigger tokspat on Zaidejas;
drop function tokspat();

insert into zaidejas
values ('2111','20', 'libero');


/* Alga ne didesnė nei ... */


CREATE TRIGGER MAX_Alga
BEFORE INSERT or UPDATE ON NARYS
FOR EACH ROW
EXECUTE PROCEDURE MAX_Alga();


CREATE FUNCTION MAX_Alga() RETURNS TRIGGER AS $$
DECLARE 
	Maximum constant INT := 6000;
BEGIN

	IF NEW.alga > Maximum
	THEN
		RAISE EXCEPTION 'Atlyginimas per didelis';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

drop trigger MAX_Alga on NARYS;
drop function MAX_Alga();