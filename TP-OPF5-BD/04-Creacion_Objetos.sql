---a) Saber los jugadores malos, con un handicap de 5 ó menos
CREATE FUNCTION DDS_F5.jugadores_malos ()
RETURNS TABLE (id_jugador INT,nombre VARCHAR(50),mail VARCHAR(100),nivelDeJuego INT,apodo VARCHAR(50),fecha_Nacimiento DATE)
READS SQL DATA
RETURN TABLE ( SELECT * FROM DDS_F5.jugador );
