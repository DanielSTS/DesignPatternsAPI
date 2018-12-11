create database eventos;
use eventos;
create table eventos.usuario (nome varchar(100),
															rg integer primary key,
															login varchar(100),
															senha varchar(100));

create table eventos.evento (
															codigo  integer PRIMARY KEY auto_increment,
															nome varchar(100),
															codigo_adm integer,
															local_e varchar(100),
															data_e varchar(100),
															horario varchar(100),
															foreign key(codigo_adm) references eventos.usuario(rg) on delete cascade);

#INSERT  INTO usuario (nome,rg,login,senha) VALUES("sadsd",2323,"dsdsdsree","sdsds");

#INSERT  INTO evento (nome,codigo_adm,local_e,data_e,horario) VALUES("sadsd",2323,"dsdsdsree","sdsds","sjhjsd")  ;


create table eventos.evento_usuario(codigo_evento integer,
																		codigo_usuario integer,
																		foreign key (codigo_evento) references eventos.evento(codigo) on delete cascade,
																		foreign key (codigo_usuario) references eventos.usuario(rg) on delete cascade) ;
