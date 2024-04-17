CREATE TABLE "artistas" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id")
);

CREATE TABLE "directores" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id")
);

CREATE TABLE "generos" (
	"id"	INTEGER NOT NULL,
	"descripcion"	TEXT,
	PRIMARY KEY("id")
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
	"descripcion"	TEXT,
	PRIMARY KEY("id_pelicula")
);

