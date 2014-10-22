---a) Saber los jugadores malos, con un handicap de 5 ó menos
SELECT * FROM DDS_F5.jugadores_malos

---b) Saber qué jugadores son traicioneros, los que tuvieron más de 3 infracciones el último mes
SELECT * FROM DDS_F5.jugadores_traicioneros

---c) Saber cuántos jugadores podrían “mejorar” con el tiempo, son los jugadores malos que tienen menos de 25 años (nota: debe evitar lógica duplicada)
/* Como en HSQLDB no existe la tabla DUAL para aplicar la funcion use TOP 1 */
SELECT TOP 1 DDS_F5.cuantos_pueden_mejorar() FROM DDS_F5.jugador
