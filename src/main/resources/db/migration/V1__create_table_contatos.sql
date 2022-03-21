CREATE TABLE contatos(nome varchar(255) NOT NULL UNIQUE, numero varchar(20) NOT NULL UNIQUE, email varchar(255) UNIQUE, id serial PRIMARY KEY UNIQUE);

