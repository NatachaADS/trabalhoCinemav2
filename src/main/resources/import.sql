insert into cliente (id, nome_cliente, cpf_cliente) values (1, 'Brenda Guimaraes', '000.000.000-00');
insert into cliente (id, nome_cliente, cpf_cliente) values (2, 'Daniel Rodrigues', '111.111.111-11');
insert into cliente (id, nome_cliente, cpf_cliente) values (3, 'Fernanda Nunes', '222.222.222-22');

insert into orcamento (id, diario_orcamento, semanal_orcamento, mensal_orcamento) values (1, 10000, 50000, 500000);
insert into orcamento (id, diario_orcamento, semanal_orcamento, mensal_orcamento) values (2, 20000, 40000, 400000);
insert into orcamento (id, diario_orcamento, semanal_orcamento, mensal_orcamento) values (3, 30000, 80000, 800000);

insert into atendente (nome_atendente, matricula_atendente, cliente_id, orcamento_id) values ('Amanda Farias', 100200300, 3, 1);
insert into atendente (nome_atendente, matricula_atendente, cliente_id, orcamento_id) values ('Rafael V', 100400500, 2, 2);
insert into atendente (nome_atendente, matricula_atendente, cliente_id, orcamento_id) values ('Carol P', 100600700, 1, 3);

insert into filme (id, titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values (1, 'Encanto', '109 minutos', 'L - Livre para todos os públicos', 'Animação, Família, Fantasia', 'Encanto é um abraço no coração de muitas formas diferentes - da casa que ganha vida para proteger suas raízes à uma grande história sobre família e autopercepção, A nova animação da Disney arremata um trama doce com a trilha sonora inspirada do indicado ao Oscar Lin-Manuel Miranda, responsável pela trilha sonora de Moana.');
insert into filme (id, titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values (2, 'A Caminho da Lua', '100 minutos', 'L - Livre para todos os públicos', 'Animação, Aventura, Comédia, Família', 'Na animação da Netflix, A Caminho da Lua, depois de ter finalizado a construção de uma engenhosa nave espacial, uma garota embarca para a lua para provar ao seu pai a existência de uma deusa mística que habitaria no astro..');
insert into filme (id, titulo_filme, duracao_filme, classificacao_filme, genero_filme, sinopse_filme) values (3, 'Viva - A Vida é uma Festa', '1h 45min', 'L - Livre para todos os públicos', 'Animação, Família, Fantasia', 'Um menino de 12 anos, na tentativa de ser um músico famoso, enfrenta a desaprovação de sua família, acabando por se envolver em um mistério de 100 anos.');

insert into sala (id, numero_sala, qnt_assentos) values (1, 'A10', 110);
insert into sala (id, numero_sala, qnt_assentos) values (2, 'A20', 220);
insert into sala (id, numero_sala, qnt_assentos) values (3, 'A30', 330);

insert into sessao (horario_sessao, sala_id, filme_id) values ('20:00', 1, 3);
insert into sessao (horario_sessao, sala_id, filme_id) values ('14:00', 2, 2);
insert into sessao (horario_sessao, sala_id, filme_id) values ('10:00', 3, 1);


--insert into sessao (id, horario_sessao, filme_id) values (1, '20:00', 3);
--insert into sessao (id, horario_sessao, filme_id) values (2, '14:00', 2);
--insert into sessao (id, horario_sessao, filme_id) values (3, '10:00', 1);

insert into venda_ingresso (horario_venda_ingresso, sessao_id) values ('22:55', 1);
insert into venda_ingresso (horario_venda_ingresso, sessao_id) values ('07:45', 2);
insert into venda_ingresso (horario_venda_ingresso, sessao_id) values ('10:00', 3);