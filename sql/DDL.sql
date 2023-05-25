    -- Creazione del database
CREATE DATABASE IF NOT EXISTS agm_express;

-- Utilizzo del database
USE agm_express;

-- Creazione della tabella furgoni 
CREATE TABLE IF NOT EXISTS furgoni (
   targa VARCHAR(10) NOT NULL PRIMARY KEY,
   capacita FLOAT NOT NULL,
   modello VARCHAR(255) NOT NULL
);

-- Creazione della tabella stato consegne 
CREATE TABLE IF NOT EXISTS stato_consegne (
   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   avanzamento VARCHAR(255) NOT NULL, 
   stato_consegne VARCHAR(255) NOT NULL
);

-- Creazione della tabella clienti
CREATE TABLE IF NOT EXISTS clienti(
   id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   nome VARCHAR(50),
   p_iva BIGINT,
   cognome VARCHAR(30),
   n_telefono VARCHAR(15)
);

-- Creazione della tabella pacchi
CREATE TABLE IF NOT EXISTS pacchi(
   id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
   id_mittente INT NOT NULL,
   id_destinatario INT NOT NULL,
   peso FLOAT,
   tracking_code VARCHAR(20) NOT NULL,
   larghezza DOUBLE,
   profondita DOUBLE,
   altezza DOUBLE,
   stato VARCHAR (20) NOT NULL,
   tipo VARCHAR (30) NOT NULL,
   CONSTRAINT ritirati FOREIGN KEY (id_mittente) REFERENCES clienti (id),
   CONSTRAINT spediti_a FOREIGN KEY (id_destinatario) REFERENCES clienti (id)
);
-- Creazione della tabella consegne 
CREATE TABLE IF NOT EXISTS consegne (
   id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   inizio_consegna_data DATE NOT NULL,
   fine_consegna_data DATE NOT NULL,
   targa VARCHAR(10) NOT NULL, -- FK di furgoni
   id_pacchi INT NOT NULL, -- FK di pacchi
   id_stato_consegne INT NOT NULL, -- FK di stato consegna
   CONSTRAINT trasportate_da FOREIGN KEY (targa) REFERENCES furgoni (targa),
   CONSTRAINT possiedono FOREIGN KEY (id_pacchi) REFERENCES pacchi (id),
   CONSTRAINT hanno FOREIGN KEY (id_stato_consegne) REFERENCES stato_consegne (id)
);

-- Creazione della tabella clienti indirizzi
CREATE TABLE IF NOT EXISTS consegne_pacchi (
   id_consegne INT,
   id_pacchi INT,
   PRIMARY KEY (id_consegne, id_pacchi),
   FOREIGN KEY (id_consegne) REFERENCES consegne (id),
   FOREIGN KEY (id_pacchi) REFERENCES pacchi (id)
);

-- Creazione della tabella indirizzi
CREATE TABLE IF NOT EXISTS indirizzi(
   id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
   via VARCHAR(50),
   cap INT,
   nr_civico INT,
   interno VARCHAR(5),
   citta VARCHAR(50),
   id_cliente int ,
   CONSTRAINT clienti_hanno FOREIGN KEY (id_cliente) REFERENCES clienti (id)
);