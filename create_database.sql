CREATE TABLE "artistas" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "directores" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "generos" (
	"id"	INTEGER NOT NULL,
	"descripcion"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "peliculas" (
	"id"	INTEGER NOT NULL,
	"titulo"	TEXT NOT NULL,
	"id_director"	INTEGER NOT NULL,
	"año"	INTEGER NOT NULL,
	"url_caratula"	TEXT,
	"id_genero"	INTEGER NOT NULL,
	"es_animacion"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "repartos" (
	"id_pelicula"	INTEGER NOT NULL,
	"id_artistas"	INTEGER NOT NULL,
	FOREIGN KEY("id_pelicula") REFERENCES "peliculas"("id"),
	FOREIGN KEY("id_artista") REFERENCES "artistas"("id"),
	PRIMARY KEY("id_pelicula")
);

INSERT INTO peliculas (id, titulo, id_director, año, id_genero, es_animacion) VALUES (1, "Goodfellas", 3 , "1990", 4 , False );
INSERT INTO directores (id, nombre) VALUES (1, "Martin Scorsese");


INSERT INTO generos (id, descripcion ) VALUES (1, "ACCION");
INSERT INTO generos (id, descripcion ) VALUES (2, "AVENTURA");
INSERT INTO generos (id, descripcion ) VALUES (3, "COMEDIA");
INSERT INTO generos (id, descripcion ) VALUES (4, "DRAMA");
INSERT INTO generos (id, descripcion ) VALUES (5, "FANTASIA");
INSERT INTO generos (id, descripcion ) VALUES (6, "TERROR");
INSERT INTO generos (id, descripcion ) VALUES (7, "CFICCION");
INSERT INTO generos (id, descripcion ) VALUES (8, "MUSICAL");
INSERT INTO generos (id, descripcion ) VALUES (9, "SUSPENSE");
INSERT INTO generos (id, descripcion ) VALUES (10, "WESTERN");
INSERT INTO generos (id, descripcion ) VALUES (11, "DOCUMENTAL");
INSERT INTO generos (id, descripcion ) VALUES (12, "BIOPIC");
INSERT INTO generos (id, descripcion ) VALUES (13, "ROMANCE");