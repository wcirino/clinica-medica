idlogin int auto_increment,
login varchar(100) not null,
senha varchar(100) not null,
email varchar(300) not null,
senhainicial varchar(2) not null,
ativo int,
ultimologin datetime,


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
  
  use clinicamedicacon;
  
  select * from login
  
  ALTER TABLE login MODIFY ativo varchar(2);
  
  insert into perfil (perfil) values("ADMIN"); 
  insert into perfil (perfil) values("PERFIL PRESTADOR 1");
  insert into perfil (perfil) values("PERFIL PRESTADOR 2");
  insert into perfil (perfil) values("PERFIL PRESTADOR 3");
  insert into perfil (perfil) values("PERFIL BENEFICIARIO");
  insert into perfil (perfil) values("PERFIL PRESTADOR 4");
  insert into perfil (perfil) values("PERFIL PRESTADOR 5");
  
  insert into perfil_prestador (idperfil,idprestador) value (2,1);
  insert into perfil_prestador (idperfil,idprestador) value (3,1);
  insert into perfil_prestador (idperfil,idprestador) value (4,1);
  insert into perfil_prestador (idperfil,idprestador) value (6,1);
  insert into perfil_prestador (idperfil,idprestador) value (2,2);
  insert into perfil_prestador (idperfil,idprestador) value (3,2);
  insert into perfil_prestador (idperfil,idprestador) value (2,3);
  insert into perfil_prestador (idperfil,idprestador) value (7,3);
  insert into perfil_prestador (idperfil,idprestador) value (1,4);
  insert into perfil_prestador (idperfil,idprestador) value (2,5);
  insert into perfil_prestador (idperfil,idprestador) value (6,6);
  insert into perfil_prestador (idperfil,idprestador) value (6,7);
  insert into perfil_prestador (idperfil,idprestador) value (4,8);
  insert into perfil_prestador (idperfil,idprestador) value (4,9);
  insert into perfil_prestador (idperfil,idprestador) value (4,10);
  insert into perfil_prestador (idperfil,idprestador) value (2,1);
  insert into perfil_prestador (idperfil,idprestador) value (6,10);
  insert into perfil_prestador (idperfil,idprestador) value (2,11);
  insert into perfil_prestador (idperfil,idprestador) value (6,7);
  insert into perfil_prestador (idperfil,idprestador) value (5,8);
  insert into perfil_prestador (idperfil,idprestador) value (6,9);
  insert into perfil_prestador (idperfil,idprestador) value (6,3);
  insert into perfil_prestador (idperfil,idprestador) value (3,9);
  
  insert into perfil_prestador (idperfil,idprestador) value (7,1);
  insert into perfil_prestador (idperfil,idprestador) value (8,1);
  insert into perfil_prestador (idperfil,idprestador) value (2,7);
  
  select l1.login,p2.perfil,p2.idperfil from perfil_prestador as  p1 
  inner join perfil as p2
  on p1.idperfil = p2.idperfil
  inner join prestador as p3
  on p1.idprestador = p3.idprestador
  inner join login as l1
  on p3.idlogin = l1.idlogin
  where l1.idlogin = 3

  select * from   

  select * from prestador
  select * from login
  select * from perfil
  select * from histconsulta
  
  select * from login
  
  
  
update login set senha = "$2a$10$zYPBrwgNO5i271FJTtHnuuxIcK3fnoj6r7JAluBggHs4r1w2k9uwq" where idlogin = 1
  
  select * from perfil_prestador 
  
 /* insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);
  insert into perfil_prestador (idperfil,idprestador) value (1,2);*/
     
  