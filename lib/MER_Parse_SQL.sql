ALTER DATABASE c_on CHARSET = Latin1 COLLATE = latin1_swedish_ci;

DROP TABLE IF EXISTS  campanha;
DROP TABLE IF EXISTS  candidato;
DROP TABLE IF EXISTS  partido;
DROP TABLE IF EXISTS  cargo;
DROP TABLE IF EXISTS  resultado;
DROP TABLE IF EXISTS  despesa;
DROP TABLE IF EXISTS  receita;
DROP TABLE IF EXISTS  doador;
DROP TABLE IF EXISTS  fornecedor;

CREATE TABLE campanha (
  id_campanha INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ano INTEGER UNSIGNED NOT NULL,
  numero_candidato INTEGER UNSIGNED NOT NULL,
  resultado_cod_resultado INTEGER NOT NULL,
  cargo_cod_cargo INTEGER NOT NULL,
  partido_numero  INTEGER UNSIGNED NULL,
  candidato_titulo_eleitoral VARCHAR(255) NOT NULL,
  nome_de_urna VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  despesa_maxima_declarada VARCHAR(255) NULL,
  despesa_maxima_calculada VARCHAR(255) NULL,
  receita_maxima_calculada VARCHAR(255) NULL,
  PRIMARY KEY(id_campanha),
  INDEX campanha_sk_1(ano),
  INDEX campanha_sk_2(numero_candidato),
  INDEX campanha_sk_3(cargo_cod_cargo),
  INDEX campanha_sk_4(nome_de_urna),
  INDEX campanha_fk_1(resultado_cod_resultado),
  INDEX campanha_fk_2(cargo_cod_cargo),
  INDEX campanha_fk_3(candidato_titulo_eleitoral),
  INDEX campanha_fk_4(partido_numero)
);

CREATE TABLE partido (
  numero INTEGER UNSIGNED NULL,
  sigla VARCHAR(8) NOT NULL,
  nome VARCHAR(255) NULL,
  deferimento VARCHAR(255) NULL,
  PRIMARY KEY(sigla),
  INDEX partido_sk_1(numero)
);

CREATE TABLE candidato (
  titulo_eleitoral VARCHAR(255) NOT NULL,
  nome VARCHAR(80) NOT NULL,
  PRIMARY KEY(titulo_eleitoral),
  INDEX candidato_sk_1(nome)
);

CREATE TABLE cargo (
  cod_cargo INTEGER NOT NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(cod_cargo),
  INDEX cargo_sk_1(descricao)
);

CREATE TABLE resultado (
  cod_resultado INTEGER NOT NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(cod_resultado)
);

CREATE TABLE despesa (
  id_despesa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  campanha_ano INTEGER UNSIGNED NOT NULL,
  campanha_numero_candidato INTEGER UNSIGNED NOT NULL,
  valor FLOAT NULL,
  forma_pagamento VARCHAR(255) NULL,
  descricao TEXT NULL,
  data_despesa VARCHAR(255) NULL,
  tipo_movimentacao VARCHAR(255) NULL,
  tipo_documento VARCHAR(255) NULL,
  numero_documento VARCHAR(255) NULL,
  fornecedor_nome VARCHAR(255) NULL,
  fornecedor_cpf_cnpj VARCHAR(255) NULL,
  cargo VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_despesa),
  INDEX despesa_sk_1(cargo),
  INDEX despesa_fk_1(campanha_ano),
  INDEX despesa_fk_2(campanha_numero_candidato),
  INDEX despesa_fk_3(fornecedor_nome),
  INDEX despesa_fk_4(fornecedor_cpf_cnpj)

);


CREATE TABLE receita (
  id_receita INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  campanha_ano INTEGER UNSIGNED NOT NULL,
  campanha_numero_candidato INTEGER UNSIGNED NOT NULL, 
  valor FLOAT NULL,
  forma_pagamento VARCHAR(255) NULL,
  descricao TEXT NULL,
  data_receita VARCHAR(255) NULL,
  tipo_movimentacao VARCHAR(255) NULL,
  recibo_eleitoral VARCHAR(255) NULL,
  numero_documento VARCHAR(255) NULL,
  doador_nome VARCHAR(255) NULL,
  doador_cpf_cnpj VARCHAR(255) NULL,
  cargo VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_receita),
  INDEX receita_sk_1(cargo),
  INDEX despesa_fk_1(campanha_ano),
  INDEX despesa_fk_2(campanha_numero_candidato),
  INDEX despesa_fk_3(doador_nome),
  INDEX despesa_fk_4(doador_cpf_cnpj)

);

CREATE TABLE doador (
  id_doador INTEGER NOT NULL AUTO_INCREMENT,
  cpf_cnpj VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(id_doador),
  INDEX doador_sk_1(cpf_cnpj),
  INDEX doador_sk_2(nome)
);

CREATE TABLE fornecedor (
  id_fornecedor INTEGER NOT NULL AUTO_INCREMENT,
  cpf_cnpj VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(id_fornecedor),
  INDEX fornecedor_sk_1(cpf_cnpj),
  INDEX fornecedor_sk_2(nome)

);