CREATE TABLE t_candidato (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  cpf VARCHAR(20) NULL,
  partido VARCHAR(20) NULL,
  numero VARCHAR(20) NULL,
  ano VARCHAR(20) NULL,
  cargo_pleiteado VARCHAR(45) NULL,
  resultado_eleicao VARCHAR(45) NULL,
  dominio VARCHAR(45) NULL,
  arrecadacao VARCHAR(45) NULL,
  despesa VARCHAR(45) NULL,
  PRIMARY KEY(id)
);

CREATE  TABLE t_receita (
  id INT NOT NULL ,
  emNomeDe VARCHAR(45) NULL ,
  ano VARCHAR(45) NULL ,
  horaRegistro VARCHAR(45) NULL ,
  entregaEmConjunto VARCHAR(45) NULL ,
  numeroDoc VARCHAR(45) NULL ,
  data VARCHAR(45) NULL ,
  valor VARCHAR(45) NULL ,
  fonte VARCHAR(45) NULL ,
  tipo VARCHAR(45) NULL ,
  especie VARCHAR(45) NULL ,
  descricao VARCHAR(45) NULL ,
  reciboEleitoral VARCHAR(45) NULL ,
  nomeDoador VARCHAR(45) NULL ,
  cadastroDoador VARCHAR(45) NULL ,
  PRIMARY KEY (id) 
);

CREATE TABLE t_partido (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  sigla MEDIUMTEXT NOT NULL ,
  numero MEDIUMTEXT NOT NULL ,
  PRIMARY KEY(id)
 );

CREATE  TABLE t_despesa (
  id INT NOT NULL ,
  emNomeDe VARCHAR(45) NULL ,
  ano VARCHAR(45) NULL ,
  horaRegistro VARCHAR(45) NULL ,
  entregaEmConjunto VARCHAR(45) NULL ,
  numeroDoc VARCHAR(45) NULL ,
  data VARCHAR(45) NULL ,
  valor VARCHAR(45) NULL ,
  fonte VARCHAR(45) NULL ,
  tipo VARCHAR(45) NULL ,
  especie VARCHAR(45) NULL ,
  descricao VARCHAR(45) NULL ,
  tipoDoc VARCHAR(45) NULL ,
  nomeFornecedor VARCHAR(45) NULL ,
  cadastroFornecedor VARCHAR(45) NULL ,
  PRIMARY KEY (id) 
);