---a) Saber los jugadores malos, con un handicap de 5 ó menos
CREATE VIEW DDS_F5.jugadores_malos AS
SELECT * FROM DDS_F5.jugador WHERE niveldejuego < 5;


---b) Saber qué jugadores son traicioneros, los que tuvieron más de 3 infracciones el último mes
CREATE VIEW DDS_F5.jugadores_traicioneros AS
SELECT * FROM DDS_F5.jugador j 
WHERE 3<(SELECT COUNT(*) FROM DDS_F5.infraccion i WHERE j.id_jugador=i.id_jugador AND (i.fecha > CURRENT_DATE - (30 DAY)) );


---c) Saber cuántos jugadores podrían “mejorar�? con el tiempo, son los jugadores malos que tienen menos de 25 años (nota: debe evitar lógica duplicada)
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
