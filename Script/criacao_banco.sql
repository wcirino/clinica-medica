create database clinicamedicacon;

show databases;-- clinicamedicacon;

use clinicamedicacon;

show tables;

create table login(
idlogin int auto_increment,
login varchar(100) not null,
senha varchar(100) not null,
email varchar(300) not null,
senhainicial varchar(2) not null,
ativo int,
ultimologin datetime,

 constraint login_pk PRIMARY KEY (idlogin)

);

create table cidade(

idcidade int auto_increment,
cidade varchar(300) not null,
idestado int not null,

constraint pk_cidade PRIMARY KEY (idcidade)

);

create table estado(

idestado int auto_increment,
estado varchar(300) not null,

constraint Pk_estado PRIMARY KEY (idestado)

);

create table setor(
 
 idsetor int auto_increment,
 setor varchar(200),
 PRIMARY KEY (idsetor)
 
); 

CREATE TABLE prestador (

  idprestador int AUTO_INCREMENT,
  idlogin int not null,
  nome_comp varchar(500) not null,
  cpf varchar(20) not null,
  data_nasc datetime not null,
  data_admissao datetime,
  sexo int not null,
  idsetor int not null,
  telefone varchar(30),
  idestado int,
  ativo int,

  constraint pk_prestador PRIMARY KEY (idprestador),
  constraint fk_prestador_login foreign key(idlogin) references login(idlogin),
  constraint fk_prestador_setor foreign key(idsetor) references setor(idsetor),
  constraint fk_prestador_estado foreign key(idestado) references estado(idestado)

);

create table Beneficiario(

idbenef int auto_increment,
nome_comp varchar(255) not null,
cpfcnpj varchar(30),
RG varchar(30),
data_nasc datetime,
idestado int,
cidade int,
telefone varchar(20),
celular varchar(20),

constraint pk_benef PRIMARY KEY (idbenef),
constraint fk_benef_estado foreign key(idestado) references estado(idestado)
);

create table clienteparticular(

idclienteparticular int auto_increment,
nome_comp varchar(255) not null,
cpfcnpj varchar(30),
RG varchar(30),
data_nasc datetime,
idestado int,
cidade int,
telefone varchar(20),
celular varchar(20),

constraint pk_clienteparticular PRIMARY KEY (idclienteparticular),
constraint fk_clienteparticular_benef foreign key(idestado) references estado(idestado)

);

create table especialidadeMedico(

idespecialidade int auto_increment,
especialidade varchar(500) not null,
ativa varchar(5),

constraint pk_especialidadeMedica PRIMARY KEY (idespecialidade)

);

create table medico(

idmedico int auto_increment,
nome_comp varchar(300) not null,
idespecialidade int not null,
ativo varchar(2),


 constraint pk_medico PRIMARY KEY (idmedico),
 constraint fk_medico foreign key(idespecialidade) references especialidadeMedico(idespecialidade)

);

create table precoconsulta(

idpreco int auto_increment,
preco varchar(300),
idespecialidade int,

constraint pk_precoconsulta primary KEY (idpreco),
constraint fk_medico_preco foreign key(idespecialidade) references especialidadeMedico(idespecialidade)

);

create table histpreco(

idhist int auto_increment,
idpreco int not null,
data_alteracao datetime not null,

 constraint pk_histpreco PRIMARY KEY (idhist),
 constraint fk_hist_preco foreign key(idpreco) references precoconsulta(idpreco)

);

create table consulta(

idconsulta int auto_increment,
idmedico int  not null,
idbeneficiario int,
idclienteparticular int,
data_consulta datetime not null,
statusConsulta varchar(2),

 constraint pk_consulta PRIMARY KEY (idconsulta) 
);

create table histconsulta(

idhist int auto_increment,
idconsulta int not null,
data_his datetime not null,
comentario varchar(500),
constraint pk_histconsulta PRIMARY KEY (idhist),
 constraint fk_hist_consulta foreign key(idconsulta) references consulta(idconsulta)
);

create table examenome(

idnomeexame int auto_increment,
nome_exame varchar(500),
constraint pk_exame PRIMARY KEY (idnomeexame)
);

create table exame(

idexame int auto_increment,
idnomeexame int not null,
nome_paciente varchar(500) not null,
num_carteirinha int,
idclienteparticular int,
data_exame datetime not null,

constraint pk_exame_marcado PRIMARY KEY (idexame),
constraint fk_exame_marcado foreign key(idnomeexame) references examenome(idnomeexame)

);

create table perfil (

idperfil int auto_increment,
perfil varchar(500),
constraint pk_perfil primary key (idperfil)
);

create table perfil_prestador(

idper_prest int auto_increment,
idperfil int  not null,
idprestador int not null,

constraint pk_perfil_prestador primary key (idper_prest),
constraint fk_perfilPrestador_perfil foreign key (idperfil) references perfil(idperfil),
constraint fk_perfil_prestador foreign key (idprestador) references prestador(idprestador)

);