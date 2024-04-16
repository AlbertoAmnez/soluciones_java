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
	PRIMARY KEY("id")
);

CREATE TABLE "repartos" (
	"id_pelicula"	INTEGER NOT NULL,
	"descripcion"	TEXT,
	PRIMARY KEY("id_pelicula")
);

/*
INSERT INTO tipos_movimiento (id, descripcion) VALUES("I", "INGRESOS");
INSERT INTO tipos_movimiento (id, descripcion) VALUES("G", "GASTOS");

INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 1, "EMPLEO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 2, "PASIVO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 3, "NEGOCIOS");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 4, "PENSIONES");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 5, "OTROS");

INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 1, "NECESIDAD");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 2, "OCIO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 3, "CULTURA");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 4, "EXTRA");
