----------------Crea la base de datos-----------------------------
CREATE DATABASE "dbQuiz"
  WITH OWNER = "usrUTN"
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Costa Rica.1252'
       LC_CTYPE = 'Spanish_Costa Rica.1252'
       CONNECTION LIMIT = -1;

---------------Crea el esquema----------------------------------

CREATE SCHEMA "schQuiz"
  AUTHORIZATION "usrUTN";

--------------Crea la tabla provincia----------------------------------------

CREATE TABLE "schQuiz".provincia
(
  provincia character varying(20) NOT NULL,
  descripcion character varying(100),
  CONSTRAINT pk_provincia PRIMARY KEY (provincia)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "schQuiz".provincia
  OWNER TO "usrUTN";

--------------Crea la tabla canton----------------------------------------

CREATE TABLE "schQuiz".canton
(
  canton character varying(20) NOT NULL,
  descripcion character varying(100),
  provincia character varying(20) NOT NULL,
  CONSTRAINT pk_canton PRIMARY KEY (canton, provincia),
  CONSTRAINT fk_canton_provincia FOREIGN KEY (provincia)
      REFERENCES "schQuiz".provincia (provincia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "schQuiz".canton
  OWNER TO "usrUTN";

-----------inserta los datos de las provicias----------------

delete from  "schQuiz".provincia;
insert into  "schQuiz".provincia values('001','San Jose');
insert into  "schQuiz".provincia values('002','Alajuela');
insert into  "schQuiz".provincia values('003','Cartago');
insert into  "schQuiz".provincia values('004','Heredia');
insert into  "schQuiz".provincia values('005','Guanacaste');
insert into  "schQuiz".provincia values('006','Puntarenas');
insert into  "schQuiz".provincia values('007','Limon');
select * from  "schQuiz".provincia;


-----------inserta los datos de las cantones----------------


delete from  "schQuiz".canton;
select * from "schQuiz".canton;
insert into  "schQuiz".canton values('008','San Carlos', '002');
insert into  "schQuiz".canton values('006','Naranjo', '002');
insert into  "schQuiz".canton values('002','Escazu', '001');
insert into  "schQuiz".canton values('003','Desamparados', '001');
insert into  "schQuiz".canton values('003','Tres Rios', '003');
select * from "schQuiz".canton;