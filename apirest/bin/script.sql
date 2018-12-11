create database eventos;
use eventos;
create table eventos.usuario (nome varchar(100),
			rg integer primary key,
			login varchar(100),
			senha varchar(100));
			
create table eventos.evento (nome varchar(100),
			local varchar(100),
			data varchar(100),
			horario varchar(100));		

create table eventos.evento_usuario(codigo_evento integer,
			codigo_usuario integer,
                        foreign key (codigo_evento) references eventos.evento(codigo) on delete cascade,
						foreign key (codigo_usuario) references eventos.usuario(rg) on delete cascade) ;


