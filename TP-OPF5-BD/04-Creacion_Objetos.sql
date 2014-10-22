---a) Saber los jugadores malos, con un handicap de 5 Ã³ menos
CREATE VIEW DDS_F5.jugadores_malos AS
SELECT * FROM DDS_F5.jugador WHERE niveldejuego < 5;


---b) Saber quÃ© jugadores son traicioneros, los que tuvieron mÃ¡s de 3 infracciones el Ãºltimo mes
CREATE VIEW DDS_F5.jugadores_traicioneros AS
SELECT * FROM DDS_F5.jugador j 
WHERE 3<(SELECT COUNT(*) FROM DDS_F5.infraccion i WHERE j.id_jugador=i.id_jugador AND (i.fecha > CURRENT_DATE - (30 DAY)) );


---c) Saber cuÃ¡ntos jugadores podrÃ­an â€œmejorarâ€? con el tiempo, son los jugadores malos que tienen menos de 25 aÃ±os (nota: debe evitar lÃ³gica duplicada)
CREATE FUNCTION DDS_F5.cuantos_pueden_mejorar ()
RETURNS INT
READS SQL DATA
RETURN ( SELECT COUNT(*) FROM DDS_F5.jugadores_malos WHERE
                (jugadores_malos.fecha_nacimiento > CURRENT_DATE - (25 YEAR))
        );
        
-- d) Reflejar que un jugador se dio de baja de un partido
CREATE PROCEDURE DDS_F5.baja_de_partido(id_part INT, id_jug_viejo INT, id_jug_nuevo INT)
        MODIFIES SQL DATA
        --Agregar al jugador nuevo a la table reemplazos ahora?
        DELETE FROM DDS_F5.inscripcion
                WHERE (id_jugador = id_jug_viejo AND id_partido = id_part);
                
-- e) Cada vez que un jugador se baje de un partido se le debe agregar una infracción si no ofrece reemplazante.
CREATE TRIGGER DDS_F5.prueba BEFORE UPDATE ON DDS_F5.inscripcion
   REFERENCING OLD AS insc_vieja FOR EACH ROW 
   BEGIN ATOMIC
     IF NOT EXISTS(SELECT * FROM DDS_F5.reemplazo r WHERE r.id_jugador_viejo=insc_vieja.id_jugador AND r.id_partido_reem=insc_vieja.id_partido) THEN
        INSERT INTO DDS_F5.infraccion VALUES ((SELECT COUNT(*) FROM DDS_F5.reemplazo)+1,insc_vieja.id_jugador,CURRENT_DATE,'No dio reemplazante');
     END IF;
END
       

