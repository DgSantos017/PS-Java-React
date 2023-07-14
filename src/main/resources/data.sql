CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3,'Diogo');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);

INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5, '2020-06-08 10:15:01+03', 3241.23, 'TRANSFERENCIA', 'Joao', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6, '2021-04-01 12:12:04+03', -2173.09, 'SAQUE', 'Maria', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7, '2021-08-21 09:30:00+03', 5000.00, 'DEPOSITO', 'Pedro', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8, '2022-01-15 16:45:12+03', 750.50, 'TRANSFERENCIA', 'Ana', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9, '2022-06-29 14:22:30+03', 15000.00, 'DEPOSITO', 'Jose', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10, '2022-09-05 11:10:45+03', 1000.00, 'TRANSFERENCIA', 'Rafael', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11, '2023-02-12 08:05:23+03', -500.75, 'SAQUE', 'Luisa', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12, '2023-05-30 17:30:15+03', 12500.00, 'DEPOSITO', 'Marcos', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13, '2023-07-01 14:56:40+03', 2300.00, 'TRANSFERENCIA', 'Carolina', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14, '2023-07-10 09:12:18+03', -670.50, 'SAQUE', 'Daniel', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15, '2023-07-12 15:25:59+03', 10500.00, 'DEPOSITO', 'Luciana', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16, '2023-07-14 11:40:02+03', 920.20, 'TRANSFERENCIA', 'Renato', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (17, '2023-07-14 16:55:37+03', -4200.75, 'SAQUE', 'Juliana', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (18, '2023-07-14 19:20:14+03', 1500.00, 'DEPOSITO', 'Roberto', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (19, '2023-07-14 22:48:05+03', 780.50, 'TRANSFERENCIA', 'Mariana', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (20, '2023-07-14 23:59:59+03', -200.00, 'SAQUE', 'Gabriel', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (21, '2023-07-15 06:30:10+03', 1250.75, 'DEPOSITO', 'Tatiana', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (22, '2023-07-15 09:15:55+03', 4800.00, 'TRANSFERENCIA', 'Felipe', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (23, '2023-07-15 13:55:30+03', -900.20, 'SAQUE', 'Camila', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (24, '2023-07-15 17:40:45+03', 5600.75, 'DEPOSITO', 'Rodrigo', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (25, '2023-07-15 20:30:22+03', 1800.00, 'TRANSFERENCIA', 'Aline', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (26, '2023-07-15 23:12:50+03', -960.50, 'SAQUE', 'Ricardo', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (27, '2023-07-16 02:45:18+03', 7500.00, 'DEPOSITO', 'Lara', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (28, '2023-07-16 07:22:37+03', 1050.75, 'TRANSFERENCIA', 'Fernando', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (29, '2023-07-16 11:10:04+03', -3900.00, 'SAQUE', 'Patricia', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30, '2023-07-16 14:55:33+03', 750.20, 'DEPOSITO', 'Eduardo', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (31, '2023-07-16 18:40:12+03', 8400.75, 'TRANSFERENCIA', 'Isabela', 3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (32, '2023-07-16 21:25:51+03', -2200.00, 'SAQUE', 'Vinicius', 3);

