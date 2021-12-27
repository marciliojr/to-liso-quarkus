-- Usuario
insert into Usuario (email, nick, senha) values ('a@a.com', 'a', '123'),
('admin@admin.com', 'Marcilio', '123'),
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
(1, 1, 1,0),
(2, 2, 2,30),
(3, 3, 3,-10);

-- categoria
insert into Categoria (descricao) values
('Alimentação'),
('Aluguel'),
('Mensalidade Educação'),
('Serviço Streaming'),
('Serviços'),
('Agua'),
('Luz'),
('Gás'),
('Combustivel'),
('Manutenção Automotiva'),
('Dizimo'),
('Ofertas'),
('Roupas'),
('Higiene'),
('Farmacia'),
('Beleza'),
('Saude'),
('Lazer'),
('Livros'),
('Faturas'),
('Impostos'),
('Multas'),
('Doação'),
('Investimento'),
('Mercado'),
('Viagens'),
('Pets'),
('Familia e Filhos'),
('Outros');

-- Receita
insert into Receita (dataHoraReceita, descricao, valor, conta_id, categoria_id) values
('2021-02-14 18:42:26', 'Receitas teste usuario a', 10, 1, 1),
('2021-12-26 15:19:56', 'Receitas teste usuario admin', 20, 2, 2),
('2021-12-25 18:42:26', 'Receitas teste usuario admin 2', 20, 2, 2),
('2021-04-02 16:51:05', 'Receitas teste usuario teste', 10, 3, 3);


-- Despesa
insert into Despesa (dataHoraDespesa, descricao, valor, conta_id, categoria_id) values
('2021-02-14 18:42:26', 'Compras teste usuario a', 10, 1, 1),
('2021-12-26 15:19:56', 'Compras teste usuario admin', 10, 2, 2),
('2021-04-02 16:51:05', 'Compras teste usuario teste', 10, 3, 3);