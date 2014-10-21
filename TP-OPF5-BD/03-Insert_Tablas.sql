---INSERTS

----Tabla Jugador
INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(1,'Pedro','pepe@gmail.com',4,'Pepe',NULL);

INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(2,'Roberto','robert22@gmail.com',9,'Robert',NULL);

INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(3,'Coco','coquito@gmail.com',2,'Coc',NULL);

INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(4,'Agustin','agus@gotmail.com',8,'Agus',NULL);

---Tabla Administrador

INSERT INTO DDS_F5.Administrador(id_admin, nombre ,mail)
VALUES
(1,'Ramon','ramoncito@hotmail.com');

INSERT INTO DDS_F5.Administrador(id_admin, nombre ,mail)
VALUES
(2,'Juan','juancito@hotmail.com');

INSERT INTO DDS_F5.Administrador(id_admin, nombre ,mail)
VALUES
(3,'Pedro','pedrito@hotmail.com');


---Tabla Equipo

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(1,'BOCA');

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(2,'RIVER');

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(3,'SAN LORENZO');

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(4,'ESTUDIANTES');


---Tabla Partido

INSERT INTO DDS_F5.Partido(id_partido,nombre ,id_admin ,confirmado ,id_equipo1 ,id_equipo2)
VALUES
(1,'DISEÑO DOPARTI',1,'N',1,2);

INSERT INTO DDS_F5.Partido(id_partido,nombre ,id_admin ,confirmado ,id_equipo1 ,id_equipo2)
VALUES
(2,'PDP DOPARTI',2,'S',3,4);

INSERT INTO DDS_F5.Partido(id_partido,nombre ,id_admin ,confirmado ,id_equipo1 ,id_equipo2)
VALUES
(3,'ADS DOPARTI',3,'N',1,4);

---Tabla Tipo inscripcion

INSERT INTO DDS_F5.tipo_inscripcion(id_tipo_ins,descripcion)
VALUES
(1,'CONDICIONAL');

INSERT INTO DDS_F5.tipo_inscripcion(id_tipo_ins,descripcion)
VALUES
(2,'ESTANDAR');

INSERT INTO DDS_F5.tipo_inscripcion(id_tipo_ins,descripcion)
VALUES
(3,'SOLIDARIA');




---Tabla Incripcion

INSERT INTO DDS_F5.inscripcion (id_inscripcion, id_jugador,id_partido,id_tipo_ins,confirmada)
VALUES
(1,1,1,1,'N');

INSERT INTO DDS_F5.inscripcion (id_inscripcion, id_jugador,id_partido,id_tipo_ins,confirmada)
VALUES
(2,2,1,2,'N');

INSERT INTO DDS_F5.inscripcion (id_inscripcion, id_jugador,id_partido,id_tipo_ins,confirmada)
VALUES
(3,3,2,1,'S');

INSERT INTO DDS_F5.inscripcion (id_inscripcion, id_jugador,id_partido,id_tipo_ins,confirmada)
VALUES
(4,4,2,3,'S');

---Tabla Calificaciones

INSERT INTO DDS_F5.calificacion(id_calificacion,id_jugador, id_jugador_calificador ,id_partido,nota ,critica)
VALUES
(1,1,2,1,6,'Jugo bien pero no la paso mucho');

INSERT INTO DDS_F5.calificacion(id_calificacion,id_jugador, id_jugador_calificador ,id_partido,nota ,critica)
VALUES
(2,2,1,1,2,'Metio goles en contra');

INSERT INTO DDS_F5.calificacion(id_calificacion,id_jugador, id_jugador_calificador ,id_partido,nota ,critica)
VALUES
(3,3,4,2,10,'Muy bueno. Juega como un campeon');

INSERT INTO DDS_F5.calificacion(id_calificacion,id_jugador, id_jugador_calificador ,id_partido,nota ,critica)
VALUES
(4,4,3,2,1,'Mal comportamiento. Expulsado por falta grave');

---Tabla Infracciones

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(1,1,CAST('2014-01-13' AS date),'Se saco la remera en el partido');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(2,4,CAST('2014-03-23' AS date),'Le quebro la pierna al delantero');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(3,3,CAST('2014-10-10' AS date),'Mal vocabulario');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(4,3,CAST('2014-10-11' AS date),'Muchas Faltas');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(5,3,CAST('2014-10-15' AS date),'Arreglo con el arbitro');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(6,3,CAST('2014-10-18' AS date),'Pelea de manos');

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(7,3,CAST('2014-10-20' AS date),'No cumplio las ordenes del arbitro');


---Tabla equipo_Jugador

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(1,1);

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(2,1);

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(3,2);

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(4,2);

---Tabla amigos

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(1,'cuervoTinelli@gmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(1,'solitaSilveyra@hotmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(2,'moria_casan@gmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(2,'polinitoLocura@gmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(2,'alfano40@gmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(3,'RicardoFort@gmail.com');

INSERT INTO DDS_F5.amigo (id_jugador,mail_amigo)
VALUES
(4,'pachupenia@gmail.com');



---Tabla propuesta


INSERT INTO DDS_F5.propuesta (id_propuesta,id_jugador_amigo,mail_amigo_propuesto,nombre_amigo_propuesto,estado,observacion)
VALUES
(1,1,'alfano40@gmail.com','Graciela','E',NULL);

INSERT INTO DDS_F5.propuesta (id_propuesta,id_jugador_amigo,mail_amigo_propuesto,nombre_amigo_propuesto,estado,observacion)
VALUES
(2,2,'polinitoLocura@gmail.com','Marcelo','R','No juega bien al futbol');

INSERT INTO DDS_F5.propuesta (id_propuesta,id_jugador_amigo,mail_amigo_propuesto,nombre_amigo_propuesto,estado,observacion)
VALUES
(3,1,'cuervoTinelli@gmail.com','Marcelo','A',null);


