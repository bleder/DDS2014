
----Tabla Jugador
create table  jugador
(id_jugador int  not null,
nombre varchar(50) not null,
mail varchar(100),
nivelDeJuego int,
apodo varchar(50),
fecha_Nacimiento date,
constraint pk_jugador primary key(id_jugador));

---Tabla Administrador
create table  Administrador
(id_admin int not null, 
nombre varchar(50) not null,
mail varchar(100),
constraint pk_admin primary key(id_admin));

---Tabla Equipo
create table  equipo
(id_equipo int not null,
nombre varchar(100),
constraint pk_equipo primary key(id_equipo));


---Tabla Partido
create table  Partido
(id_partido int not null,
nombre varchar(100),
id_admin int,
confirmado varchar(1),
id_equipo1 int,
id_equipo2 int,
constraint pk_partido primary key(id_partido),
constraint fk_administrador FOREIGN KEY (id_admin) REFERENCES  administrador(id_admin),
constraint fk_equipo1 FOREIGN KEY (id_equipo1) REFERENCES  equipo(id_equipo),
constraint fk_equipo2 FOREIGN KEY (id_equipo2) REFERENCES  equipo(id_equipo));

---Tabla Tipo inscripcion
create table  tipo_inscripcion
(id_tipo_ins int not null,
descripcion varchar(100) not null,
constraint pk_tipo_ins primary key(id_tipo_ins));


---Tabla Incripcion
create table  inscripcion
(id_inscripcion int not null, 
id_jugador int not null,
id_partido int not null,
id_tipo_ins int not null,
confirmada varchar(1) not null,
constraint pk_inscripcion primary key(id_inscripcion),
constraint fk_jugador_inscripto FOREIGN KEY (id_jugador) REFERENCES  jugador(id_jugador),
constraint fk_partido_inscripto FOREIGN KEY (id_partido) REFERENCES  partido(id_partido),
constraint fk_tipo_ins FOREIGN KEY (id_tipo_ins) REFERENCES  tipo_inscripcion(id_tipo_ins));

---Tabla Calificaciones
create table  calificacion
(id_calificacion int not null,
id_jugador int not null, 
id_jugador_calificador int not null,
id_partido int not null,
nota int not null,
critica varchar(255),
constraint pk_calificacion primary key(id_calificacion),
constraint fk_jugador_calificado FOREIGN KEY (id_jugador) REFERENCES  jugador(id_jugador),
constraint fk_jugador_calificador FOREIGN KEY (id_jugador_calificador) REFERENCES  jugador(id_jugador),
constraint fk_partido FOREIGN KEY (id_partido) REFERENCES  partido(id_partido));

---Tabla Infracciones
create table  infraccion
(id_infraccion int not null,
id_jugador int not null,
fecha date ,
motivo varchar(255) not null,
constraint pk_infraccion primary key(id_infraccion),
constraint fk_jugador_infraccion FOREIGN KEY (id_jugador) REFERENCES  jugador(id_jugador));

---Tabla equipo_Jugador
create table  equipo_jugador
(id_jugador int not null, 
id_equipo int not null,
constraint pk_equipo_jugador primary key(id_jugador,id_equipo),
constraint fk_jugador_de_equipo FOREIGN KEY (id_jugador) REFERENCES  jugador(id_jugador),
constraint fk_equipo FOREIGN KEY (id_equipo) REFERENCES  equipo(id_equipo));

---Tabla amigos
create table  amigo
(id_jugador int not null,
mail_amigo varchar(100) not null,
constraint pk_amigo_jugador primary key(id_jugador,mail_amigo));

---Tabla propuesta
create table  propuesta
(id_propuesta int not null,
id_jugador_amigo int not null,
mail_amigo_propuesto varchar(100) not null,
nombre_amigo_propuesto varchar(50) not null,
estado varchar(1) not null, --'R'=RECHAZADA/'A'=ACEPTADA/'E'=EN ESPERA
observacion varchar(255),
constraint pk_propuesta primary key(id_propuesta),
constraint fk_jugador_amigo FOREIGN KEY (id_jugador_amigo) REFERENCES  jugador(id_jugador));


----Tabla Reemplazo
create table  reemplazo
(id_reemplazo int  not null,
id_jugador_viejo int,
id_jugador_nuevo int,
id_partido_reem int,
constraint pk_reemplazo primary key(id_reemplazo),
constraint fk_jugador_viejo FOREIGN KEY (id_jugador_viejo) REFERENCES  jugador(id_jugador),
constraint fk_jugador_nuevo FOREIGN KEY (id_jugador_nuevo) REFERENCES  jugador(id_jugador),
constraint fk_partido_reem FOREIGN KEY (id_partido_reem) REFERENCES  partido(id_partido));






