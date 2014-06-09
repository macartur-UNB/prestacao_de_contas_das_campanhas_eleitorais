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
  PRIMARY KEY(ano,numero_candidato,cargo_cod_cargo),
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
  PRIMARY KEY(numero)
);

CREATE TABLE candidato (
  titulo_eleitoral VARCHAR(255) NOT NULL,
  nome VARCHAR(80) NOT NULL,
  PRIMARY KEY(titulo_eleitoral)
);

CREATE TABLE cargo (
  cod_cargo INTEGER NOT NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(cod_cargo)
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
  descricao VARCHAR(255) NULL,
  data_despesa VARCHAR(255) NULL,
  tipo_movimentacao VARCHAR(255) NULL,
  tipo_documento VARCHAR(255) NULL,
  numero_documento INTEGER UNSIGNED NULL,
  fornecedor_cpf_cnpj_fornecedor VARCHAR(255) NULL,
  cargo VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_despesa),
  INDEX despesa_fk_1(campanha_ano),
  INDEX despesa_fk_2(campanha_numero_candidato),
  INDEX despesa_fk_3(fornecedor_cpf_cnpj_fornecedor)
);


CREATE TABLE receita (
  id_receita INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  campanha_ano INTEGER UNSIGNED NOT NULL,
  campanha_numero_candidato INTEGER UNSIGNED NOT NULL, 
  valor FLOAT NULL,
  forma_pagamento VARCHAR(255) NULL,
  descricao VARCHAR(255) NULL,
  data_receita VARCHAR(255) NULL,
  tipo_movimentacao VARCHAR(255) NULL,
  recibo_eleitoral VARCHAR(255) NULL,
  numero_documento INTEGER UNSIGNED NULL,
  doador_cpf_cnpj_doador VARCHAR(255) NULL,
  cargo VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_receita),
  INDEX despesa_fk_1(campanha_ano),
  INDEX despesa_fk_2(campanha_numero_candidato),
  INDEX despesa_fk_3(doador_cpf_cnpj_doador)
);

CREATE TABLE doador (
  cpf_cnpj_doador VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(cpf_cnpj_doador)
);

CREATE TABLE fornecedor (
  cpf_cnpj_fornecedor VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(cpf_cnpj_fornecedor)
);