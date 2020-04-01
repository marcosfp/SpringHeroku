
insert into PROFESOR (NOMBRE, APELLIDOS,NICKNAME, PASSWORD) values ('Marcos', 'Puente','marcos.puente','$2a$10$TZ9CaFDyasyi.TiuomF9o.OS.JKLy0T4C.JTQmuQF4RJw5YtQ7M2.');
insert into PROFESOR (NOMBRE, APELLIDOS,NICKNAME, PASSWORD) values ('Roger', 'Pressman','roger.pressman','$2a$10$TZ9CaFDyasyi.TiuomF9o.OS.JKLy0T4C.JTQmuQF4RJw5YtQ7M2.');
insert into PROFESOR (NOMBRE, APELLIDOS,NICKNAME, PASSWORD) values ('Martin', 'Fawler','martin.fawler','$2a$10$TZ9CaFDyasyi.TiuomF9o.OS.JKLy0T4C.JTQmuQF4RJw5YtQ7M2.');
insert into PROFESOR (NOMBRE, APELLIDOS,NICKNAME, PASSWORD) values ('Steve', 'Wozniak','steve.wozniak','$2a$10$TZ9CaFDyasyi.TiuomF9o.OS.JKLy0T4C.JTQmuQF4RJw5YtQ7M2.');

insert into ROL (ID_ROL, NOMBRE_ROL ) values (1, 'ROL_PROFESOR');
insert into ROL (ID_ROL, NOMBRE_ROL ) values (2,'ROL_ADMIN');

insert into PROFESOR_ROL (ID_PROFESOR, ID_ROL ) values (1,1);
insert into PROFESOR_ROL (ID_PROFESOR, ID_ROL ) values (1,2);
insert into PROFESOR_ROL (ID_PROFESOR, ID_ROL ) values (2,1);
insert into PROFESOR_ROL (ID_PROFESOR, ID_ROL ) values (3,1);
insert into PROFESOR_ROL (ID_PROFESOR, ID_ROL ) values (4,1);


insert into MODULO (NOMBRE_MODULO) values ('Desarrollo Entono Servidor');
insert into MODULO (NOMBRE_MODULO) values ('Entornos de desarrollo');
insert into MODULO (NOMBRE_MODULO) values ('Sistemas Operativos');
insert into MODULO (NOMBRE_MODULO) values ('Montaje');
insert into MODULO (NOMBRE_MODULO) values ('Programacion');

insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('marcos@des.com',1);
insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('marcosfppf@gmail.com',1);
insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('roger@des.com',2);
insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('martin@des.com',3);
insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('steve@des.com',4);
insert into EMAIL (DIRECCION_EMAIL,ID_PROFESOR) values ('steve@apple.com',4);

insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (1, 1);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (1, 5);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (1, 3);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (2, 2);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (3, 5);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (3, 2);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (4, 4);
insert into PROFESOR_MODULO(ID_PROFESOR, ID_MODULO) values (4, 3);