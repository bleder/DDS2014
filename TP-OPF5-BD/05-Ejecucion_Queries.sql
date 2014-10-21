---a) Saber los jugadores malos, con un handicap de 5 ó menos
SELECT * FROM TABLE(DDS_F5.jugadores_malos())

---b) Saber qué jugadores son traicioneros, los que tuvieron más de 3 infracciones el último mes
SELECT * FROM TABLE(DDS_F5.jugadores_traicioneros())
