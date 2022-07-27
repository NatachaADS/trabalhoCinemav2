insert into cliente (id, nome_cliente, cpf_cliente) values (1, 'Brenda Guimaraes', '000.000.000-00');
insert into cliente (id, nome_cliente, cpf_cliente) values (2, 'Daniel Rodrigues', '111.111.111-11');
insert into cliente (id, nome_cliente, cpf_cliente) values (3, 'Fernanda Nunes', '222.222.222-22');

insert into atendente (nome_atendente, matricula_atendente, cliente_id) values ('Amanda Farias', 100200300, 3);
insert into atendente (nome_atendente, matricula_atendente, cliente_id) values ('Rafael V', 100400500, 2);
insert into atendente (nome_atendente, matricula_atendente, cliente_id) values ('Carol P', 100600700, 1);

insert into filme (titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values ('Encanto', '109 minutos', 'L - Livre para todos os públicos', 'Animação, Família, Fantasia', 'Encanto é um abraço no coração de muitas formas diferentes - da casa que ganha vida para proteger suas raízes à uma grande história sobre família e autopercepção, A nova animação da Disney arremata um trama doce com a trilha sonora inspirada do indicado ao Oscar Lin-Manuel Miranda, responsável pela trilha sonora de Moana.');
insert into filme (titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values ('A Caminho da Lua', '100 minutos', 'L - Livre para todos os públicos', 'Animação, Aventura, Comédia, Família', 'Na animação da Netflix, A Caminho da Lua, depois de ter finalizado a construção de uma engenhosa nave espacial, uma garota embarca para a lua para provar ao seu pai a existência de uma deusa mística que habitaria no astro..');
insert into filme (titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values ('Viva - A Vida é uma Festa', '1h 45min', 'L - Livre para todos os públicos', 'Animação, Família, Fantasia', 'Um menino de 12 anos, na tentativa de ser um músico famoso, enfrenta a desaprovação de sua família, acabando por se envolver em um mistério de 100 anos.');

insert into orcamento (diario_orcamento, semanal_orcamento, mensal_orcamento) values (10000, 50000, 500000);
insert into orcamento (diario_orcamento, semanal_orcamento, mensal_orcamento) values (20000, 40000, 400000);
insert into orcamento (diario_orcamento, semanal_orcamento, mensal_orcamento) values (30000, 80000, 800000);

insert into sala (numero_sala, qnt_assentos) values ('A10', 110);
insert into sala (numero_sala, qnt_assentos) values ('A20', 220);
insert into sala (numero_sala, qnt_assentos) values ('A30', 330);

insert into sessao (horario_sessao) values ('20:00');
insert into sessao (horario_sessao) values ('14:00');
insert into sessao (horario_sessao) values ('10:00');

insert into venda_ingresso (horario_venda_ingresso) values ('22:55');
insert into venda_ingresso (horario_venda_ingresso) values ('07:45');
insert into venda_ingresso (horario_venda_ingresso) values ('10:00');