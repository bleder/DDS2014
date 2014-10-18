---INSERTS

----Tabla Jugador
INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(1,'Pedro','pepe@gmail.com',4,'Pepe',NULL);

INSERT INTO DDS_F5.jugador(id_jugador,nombre,mail,nivelDeJuego,apodo,fecha_Nacimiento)
VALUES
(2,'Roberto','robert22@gmail.com',9,'Robert',NULL);


---Tabla Administrador

INSERT INTO DDS_F5.Administrador(id_admin, nombre ,mail)
VALUES
(1,'Ramon','ramoncito@hotmail.com');


---Tabla Equipo

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(1,'BOCA');

INSERT INTO DDS_F5.equipo(id_equipo,nombre )
VALUES
(2,'RIVER');



---Tabla Partido

INSERT INTO DDS_F5.Partido(id_partido,nombre ,id_admin ,confirmado ,id_equipo1 ,id_equipo2)
VALUES
(1,'DISEÑO DOPARTI',1,'N',1,2);

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

---Tabla Calificaciones

INSERT INTO DDS_F5.calificacion(id_calificacion,id_jugador, id_jugador_calificador ,id_partido,nota ,critica)
VALUES
(1,1,2,1,6,'Jugo bien pero no la paso mucho');

---Tabla Infracciones

INSERT INTO DDS_F5.infraccion (id_infraccion,id_jugador,fecha,motivo )
VALUES
(1,1,NULL,'Se saco la remera en el partido');

---Tabla equipo_Jugador

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(1,1);

INSERT INTO DDS_F5.equipo_jugador (id_jugador, id_equipo )
VALUES
(2,2);
---Tabla amigos
create table DDS_F5.amigo
(id_jugador int not null,
mail_amigo varchar(100) not null,
constraint pk_amigo_jugador primary key(id_jugador,mail_amigo));

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


