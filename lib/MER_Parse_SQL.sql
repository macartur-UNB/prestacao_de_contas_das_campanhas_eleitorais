DROP TABLE IF EXISTS t_despesaC;
DROP TABLE IF EXISTS t_receitaC;
DROP TABLE IF EXISTS t_despesaP;
DROP TABLE IF EXISTS t_receitaP;
DROP TABLE IF EXISTS t_doador;
DROP TABLE IF EXISTS t_fornecedor;
DROP TABLE IF EXISTS t_candidato;
DROP TABLE IF EXISTS t_partido;

CREATE TABLE t_partido (
  numero      VARCHAR(20) NOT NULL ,
  sigla       VARCHAR(20) NOT NULL ,
  nome        VARCHAR(45) NULL ,
  deferimento VARCHAR(20) NULL ,
  presidente  VARCHAR(255) NULL ,
  PRIMARY KEY(sigla)
 );

CREATE TABLE t_candidato (
  nome              VARCHAR(255) NOT NULL,
  partido_sigla     VARCHAR(20) NOT NULL,
  cpf          	    VARCHAR(20) NULL,
  numero            VARCHAR(20) NULL,
  ano               VARCHAR(20) NOT NULL,
  cargo_pleiteado   VARCHAR(45) NULL,
  uf                VARCHAR(45) NULL,
  resultado_eleicao VARCHAR(45) NULL,
  PRIMARY KEY(nome),
  FOREIGN KEY(partido_sigla) REFERENCES t_partido(sigla)
);

CREATE TABLE t_fornecedor (
  id                INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome              VARCHAR(255) NOT NULL,
  cadastro_nacional VARCHAR(255) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE t_doador (
  id                INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome              VARCHAR(255) NOT NULL,
  cadastro_nacional VARCHAR(255) NULL,
  PRIMARY KEY(id)
);

CREATE  TABLE t_receitaP (
  id                INTEGER UNSIGNED NOT NULL ,
  partido_sigla     VARCHAR(20) NOT NULL ,
  ano               VARCHAR(45) NULL ,
  horaRegistro      VARCHAR(45) NULL ,
  entregaEmConjunto VARCHAR(45) NULL ,
  numeroDoc         VARCHAR(45) NULL ,
  data              VARCHAR(45) NULL ,
  valor             VARCHAR(45) NULL ,
  fonte             VARCHAR(45) NULL ,
  tipo              VARCHAR(45) NULL ,
  especie           VARCHAR(45) NULL ,
  descricao         VARCHAR(45) NULL ,
  reciboEleitoral   VARCHAR(45) NULL ,
  nomeDoador        VARCHAR(45) NULL ,
  cadastroDoador    VARCHAR(45) NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (partido_sigla) REFERENCES t_partido(sigla)
);

CREATE TABLE t_despesaP (
  id                 INTEGER UNSIGNED NOT NULL ,
  partido_sigla      VARCHAR(20) NOT NULL ,
  ano                VARCHAR(45) NULL ,
  horaRegistro       VARCHAR(45) NULL ,
  entregaEmConjunto  VARCHAR(45) NULL ,
  numeroDoc          VARCHAR(45) NULL ,
  data               VARCHAR(45) NULL ,
  valor              VARCHAR(45) NULL ,
  fonte              VARCHAR(45) NULL ,
  tipo               VARCHAR(45) NULL ,
  especie            VARCHAR(45) NULL ,
  descricao          VARCHAR(45) NULL ,
  tipoDoc            VARCHAR(45) NULL ,
  nomeFornecedor     VARCHAR(45) NULL ,
  cadastroFornecedor VARCHAR(45) NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (partido_sigla) REFERENCES t_partido(sigla)
);

CREATE  TABLE t_receitaC (
  id                INTEGER UNSIGNED NOT NULL ,
  candidato_nome    VARCHAR(255) NOT NULL ,
  ano               VARCHAR(45) NULL ,
  horaRegistro      VARCHAR(45) NULL ,
  entregaEmConjunto VARCHAR(45) NULL ,
  numeroDoc         VARCHAR(45) NULL ,
  data              VARCHAR(45) NULL ,
  valor             VARCHAR(45) NULL ,
  fonte             VARCHAR(45) NULL ,
  tipo              VARCHAR(45) NULL ,
  especie           VARCHAR(45) NULL ,
  descricao         VARCHAR(45) NULL ,
  reciboEleitoral   VARCHAR(45) NULL ,
  nomeDoador        VARCHAR(45) NULL ,
  cadastroDoador    VARCHAR(45) NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (candidato_nome) REFERENCES t_candidato(nome)
);

CREATE  TABLE t_despesaC (
  id                 INTEGER UNSIGNED NOT NULL ,
  candidato_nome     VARCHAR(255) NOT NULL ,
  ano                VARCHAR(45) NULL ,
  horaRegistro       VARCHAR(45) NULL ,
  entregaEmConjunto  VARCHAR(45) NULL ,
  numeroDoc          VARCHAR(45) NULL ,
  data               VARCHAR(45) NULL ,
  valor              VARCHAR(45) NULL ,
  fonte              VARCHAR(45) NULL ,
  tipo               VARCHAR(45) NULL ,
  especie            VARCHAR(45) NULL ,
  descricao          VARCHAR(45) NULL ,
  tipoDoc            VARCHAR(45) NULL ,
  nomeFornecedor     VARCHAR(45) NULL ,
  cadastroFornecedor VARCHAR(45) NULL ,
  PRIMARY KEY (id) ,
  FOREIGN KEY (candidato_nome) REFERENCES t_candidato(nome)
);