-- Usuario
insert into Usuario (email, nick, senha) values ('a@a.com', 'a', '123'),
('marcilio@gmail.com', 'Marcilio', '123'),
('teste@teste.com', 'teste', '123');

-- criar tabela banco
insert into Banco (agencia, codigo, nome) values
('459', '8200', 'Banco do Brasil'),
('51', '28318', 'Bradesco'),
('622', '6', 'Santander'),
('095', '7600', 'NuBank'),
('5641', '0', 'BMG'),
('816', '6182', 'Banco Inter'),
('6', '2', 'C6 Bank'),
('0', '82082', 'Caixa'),
('97838', '62660', 'Banco Safra'),
('8', '2', 'Itau');

-- criar tabela conta
insert into Conta (banco_id, usuario_id, tipoConta, saldo)
values
(6, 2, 1,350);
(3, 1, 3,10),
(8, 2, 4,10),
(9, 2, 3,10),
(3, 1, 5,10),
(10, 2, 1,10),
(2, 1, 4,10),
(10, 2, 3,10),
(3, 2, 4,10),
(2, 1, 1,10);
