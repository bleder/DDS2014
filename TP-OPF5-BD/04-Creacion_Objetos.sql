---a) Saber los jugadores malos, con un handicap de 5 ó menos
CREATE FUNCTION DDS_F5.jugadores_malos ()
RETURNS TABLE (id_jugador INT,nombre VARCHAR(50),mail VARCHAR(100),nivelDeJuego INT,apodo VARCHAR(50),fecha_Nacimiento DATE)
READS SQL DATA
RETURN TABLE ( SELECT * FROM DDS_F5.jugador WHERE niveldejuego < 5);

---b) Saber qué jugadores son traicioneros, los que tuvieron más de 3 infracciones el último mes
CREATE FUNCTION DDS_F5.jugadores_traicioneros ()
RETURNS TABLE (id_jugador INT,nombre VARCHAR(50),mail VARCHAR(100),nivelDeJuego INT,apodo VARCHAR(50),fecha_Nacimiento DATE)
READS SQL DATA
RETURN TABLE ( SELECT * FROM DDS_F5.jugador j 
        	WHERE 3<(SELECT COUNT(*) FROM DDS_F5.infraccion i WHERE j.id_jugador=i.id_jugador AND (i.fecha > CURRENT_DATE - (30 DAY)) )
)



