package snippet;

public class Snippet {
	create table tb_dependentes (id int4 not null, idade int4, nome varchar(255), socio_id int4, primary key (id));
	create table tb_socio (id int4 not null, ativo boolean, nome varchar(255), renda numeric(19, 2), primary key (id));
}

