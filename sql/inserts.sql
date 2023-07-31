-- Inserimenti della tabella Cliente con il campo ruolo
INSERT INTO clienti (nome, p_iva, cognome, n_telefono, ruolo) VALUES ('Mario', 123456789, 'Rossi', '1234567890', 'utente');
INSERT INTO clienti (nome, p_iva, cognome, n_telefono, ruolo) VALUES ('Luca', 987654321, 'Bianchi', '0987654321', 'amministratore');
INSERT INTO clienti (nome, p_iva, cognome, n_telefono, ruolo) VALUES ('Giulia', 555555555, 'Verdi', '5555555555', 'utente');
INSERT INTO clienti (nome, p_iva, cognome, n_telefono, ruolo) VALUES ('Laura', 111111111, 'Neri', '1111111111', 'utente');
INSERT INTO clienti (nome, p_iva, cognome, n_telefono, ruolo) VALUES ('Francesco', 999999999, 'Gialli', '9999999999', 'amministratore');

-- Inserimenti della tabella Indirizzo
INSERT INTO indirizzi (via, cap, nr_civico, interno, citta, cliente_id) VALUES ('Via Roma', 12345, 1, 'Interno 2', 'Milano', 1);
INSERT INTO indirizzi (via, cap, nr_civico, interno, citta, cliente_id) VALUES ('Via Verdi', 54321, 10, 'Interno 1', 'Roma', 2);
INSERT INTO indirizzi (via, cap, nr_civico, interno, citta, cliente_id) VALUES ('Via Manzoni', 67890, 5, 'Interno 3', 'Firenze', 3);

-- Inserimenti della tabella Furgone
INSERT INTO furgone (targa, capacita, modello) VALUES ('AB123CD', 1500.00, 'Fiat Ducato');
INSERT INTO furgone (targa, capacita, modello) VALUES ('DE456FG', 2000.00, 'Iveco Daily');
INSERT INTO furgone (targa, capacita, modello) VALUES ('HI789IJ', 1800.00, 'Mercedes Sprinter');

-- Inserimenti della tabella statoConsegna
INSERT INTO stato_consegna (avanzamento, stato_consegna) VALUES ('In transito', 'In corso');
INSERT INTO stato_consegna (avanzamento, stato_consegna) VALUES ('Consegnato', 'Completato');
INSERT INTO stato_consegna (avanzamento, stato_consegna) VALUES ('In attesa', 'In sospeso');

-- Inserimenti della tabella Consegna
INSERT INTO consegna (inizio_consegna_data, fine_consegna_data, targa, id_stato_consegna) VALUES ('2023-05-01', '2023-05-02', 'AB123CD', 1);
INSERT INTO consegna (inizio_consegna_data, fine_consegna_data, targa, id_stato_consegna) VALUES ('2023-05-03', '2023-05-04', 'DE456FG', 2);
INSERT INTO consegna (inizio_consegna_data, fine_consegna_data, targa, id_stato_consegna) VALUES ('2023-05-05', '2023-05-06', 'HI789IJ', 3);

-- Inserimenti della tabella Pacco
INSERT INTO pacchi (id_mittente, id_destinatario, peso, profondita, larghezza, altezza, tipo, stato, tracking_code) VALUES (1, 2, 2.5, 30.0, 20.0, 10.0, 'Documento', 'In transito', 'ABCD123456');
INSERT INTO pacchi (id_mittente, id_destinatario, peso, profondita, larghezza, altezza, tipo, stato, tracking_code) VALUES (2, 3, 1.8, 25.0, 15.0, 12.0, 'Pacco', 'In corso', 'WXYZ789012');
INSERT INTO pacchi (id_mittente, id_destinatario, peso, profondita, larghezza, altezza, tipo, stato, tracking_code) VALUES (3, 1, 5.2, 40.0, 30.0, 20.0, 'Pacco', 'In transito', '1234ABCD12');
