-- criação das tabelas
create table profissionais(
matricula int primary key,
nome varchar(100),
departamento varchar(50),
cargo varchar(50),
telefone varchar(11)
);

create table pacientes(
id int primary key,
nome varchar(100),
telefone varchar(11),
data_nascimento date
);

create table historico(
id int,
data_hora_entrada timestamp,
data_hora_saida timestamp,
diagnostico varchar,
medico_responsavel int,
id_paciente int,
constraint fk_profissionais
	foreign key(medico_responsavel)
	references profissionais(matricula),
constraint fk_pacientes
	foreign key(id_paciente)
	references pacientes(id)
);

-- inserção de dados nas tabelas
insert into pacientes
values
(1, 'Ana', '1191111111', '1990/02/02'),
(2, 'Bruna', '11922222222', '2000/04/04'),
(3, 'Carol', '1193333333', '2005/05/05');


insert into profissionais
values
(1, 'Daniel', 'Dpto de Cardiologia', 'Cardiologista', '11944444444'),
(2, 'Edna', 'Dpto de Pediatria', 'Pediatra', '11955555555'),
(3, 'Fatima', 'Dpto de Dermatologia', 'Dermatologista', '11966666666'),
(4, 'Gabriel', 'Dpto de Geriatria', 'Geriatra', '11977777777'),
(5, 'Helena', 'Dpto de Ginecologia', 'Ginecologista', '11988888888'),
(6, 'Ines', 'Dpto de Cardiologia', 'Cardiologista', '11944444444'),
(7, 'Julio', 'Dpto de Pediatria', 'Pediatra', '11955555555'),
(8, 'Luis', 'Dpto de Pediatria', 'Pediatra', '11966666666'),
(9, 'Maria', 'Dpto de Ginecologia', 'Ginecologia', '11977777777'),
(10, 'Nadia', 'Dpto de Ginecologia', 'Ginecologia', '11977777777');

insert into historico
values
(1, '2022-06-06 12:34:56', '2022-06-06 16:32:55', 'Dermatite', 3, 1),
(2, '2021-12-03 11:55:10', '2021-12-03 12:32:55', 'Exame de rotina', 5, 1),
(3, '2022-04-21 09:07:45', '2022-04-21 10:04:43', 'Arritmia', 1, 2),
(4, '2021-11-27 10:34:56', '2021-11-27 11:01:38', 'Gripe', 8, 3),
(5, '2022-01-01 18:00:45', '2022-01-01 21:04:43', 'Anemia', 4, 1),
(6, '2021-05-13 15:30:51', '2021-05-13 16:01:38', 'Colesterol alto', 6, 3);

-- consulta
select * from profissionais

select * from pacientes

select * from historico

-- agrupamento da quantidade de internações por paciente ordenados da maior quantidade para a menor
select id_paciente, p.nome as nome_paciente, telefone, data_nascimento,
count(id_paciente) as num_internacoes
from historico as h
inner join pacientes as p
on p.id = h.id_paciente
group by id_paciente, p.nome, telefone, data_nascimento
order by num_internacoes desc

-- agrupamento da quantidade de médicos por departamento
select departamento,
count(departamento) as num_medicos_dpto
from profissionais
group by departamento
order by num_medicos_dpto desc
