
create table usuario (id integer primary key
                  auto_increment,
                nombre varchar(80),
                sueldo float);

create table alumno (id_alumno  integer primary key auto_increment,
                     nombre varchar(80),
                     email varchar(80) );

create table calificacion (id_calificacion integer primary key auto_increment, id_alumno integer, examen_parcial float,
                           examen_final  float, total float,
                           foreign key (id_alumno) references  
                            alumno (id_alumno));


create table nomina (id integer , id_nomina integer auto_increment primary key, fecha_pago date, saldo float,
                     constraint foreign key(id) references usuario(id));

