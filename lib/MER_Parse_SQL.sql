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
  horaRegistro VARCHAR(45) NULL ,
  entregaEmConjunto VARCHAR(45) NULL ,
  numero VARCHAR(45) NULL ,
  data VARCHAR(45) NULL ,
  valor VARCHAR(45) NULL ,
  fonte VARCHAR(45) NULL ,
  tipo VARCHAR(45) NULL ,
  especie VARCHAR(45) NULL ,
  descricao VARCHAR(45) NULL ,
  PRIMARY KEY (id) 
);

