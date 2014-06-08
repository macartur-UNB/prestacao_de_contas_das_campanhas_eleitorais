ALTER DATABASE gpp CHARSET = Latin1 COLLATE = latin1_swedish_ci;

DROP TABLE IF EXISTS  campanha;
DROP TABLE IF EXISTS  candidato;
DROP TABLE IF EXISTS  cargo;
DROP TABLE IF EXISTS  despesa;
DROP TABLE IF EXISTS  doador;
DROP TABLE IF EXISTS  forma_de_pagamento;
DROP TABLE IF EXISTS  fornecedor;
DROP TABLE IF EXISTS  partido;
DROP TABLE IF EXISTS  receita;
DROP TABLE IF EXISTS  resultado;
DROP TABLE IF EXISTS  tipo_documento;
DROP TABLE IF EXISTS  tipo_movimentacao;

CREATE TABLE campanha (
  id_campanha INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  resultado_cod_resultado INTEGER NOT NULL,
  cargo_cod_cargo INTEGER NOT NULL,
  partido_numero  INTEGER UNSIGNED NULL,
  candidato_titulo_eleitoral VARCHAR(255) NOT NULL,
  ano INTEGER UNSIGNED NULL,
  numero_candidatura VARCHAR(255) NULL,
  nome_de_urna VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  despesa_maxima_declarada VARCHAR(255) NULL,
  despesa_maxima_calculada VARCHAR(255) NULL,
  receita_maxima_calculada VARCHAR(255) NULL,
  PRIMARY KEY(id_campanha),
  INDEX campanha_fk_1(resultado_cod_resultado),
  INDEX campanha_fk_2(cargo_cod_cargo),
  INDEX campanha_fk_3(candidato_titulo_eleitoral),
  INDEX campanha_fk_4(partido_numero)
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

CREATE TABLE despesa (
  id_despesa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo_movimentacao_id_tipo_movimentacao INTEGER UNSIGNED NOT NULL,
  tipo_documento_id_tipo_documento INTEGER UNSIGNED NOT NULL,
  forma_pagamento_id_forma_pagamento INTEGER UNSIGNED NOT NULL,
  campanha_id_campanha INTEGER UNSIGNED NOT NULL,
  fornecedor_cpf_cnpj VARCHAR(255) NULL,
  numero_documento INTEGER UNSIGNED NULL,
  valor FLOAT NULL,
  descricao VARCHAR(255) NULL,
  data_despesa VARCHAR(255) NULL,
  PRIMARY KEY(id_despesa),
  INDEX despesa_fk_1(tipo_movimentacao_id_tipo_movimentacao),
  INDEX despesa_fk_2(tipo_documento_id_tipo_documento),
  INDEX despesa_fk_3(forma_pagamento_id_forma_pagamento),
  INDEX despesa_fk_4(campanha_id_campanha),
  INDEX despesa_fk_5(fornecedor_cpf_cnpj)
);

CREATE TABLE doador (
  cpf_cnpj VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(cpf_cnpj)
);

CREATE TABLE forma_de_pagamento (
  id_forma_pagamento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(255) NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(id_forma_pagamento)
);

CREATE TABLE fornecedor (
  cpf_cnpj VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  situacao_cadastral VARCHAR(255) NULL,
  PRIMARY KEY(cpf_cnpj)
);

CREATE TABLE partido (
  numero INTEGER UNSIGNED NULL,
  sigla VARCHAR(8) NOT NULL,
  nome VARCHAR(255) NULL,
  deferimento VARCHAR(255) NULL,
  PRIMARY KEY(numero)
);

CREATE TABLE receita (
  id_receita INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo_movimentacao_id_tipo_movimentacao INTEGER UNSIGNED NOT NULL,
  forma_de_pagamento_id_forma_pagamento INTEGER UNSIGNED NOT NULL,
  campanha_id_campanha INTEGER UNSIGNED NOT NULL,
  doador_cpf_cnpj VARCHAR(255) NOT NULL,
  recibo_eleitoral VARCHAR(255) NULL,
  numero_documento INTEGER UNSIGNED NULL,
  ano INTEGER UNSIGNED NULL,
  data_receita VARCHAR(255) NULL,
  valor FLOAT NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(id_receita),
  INDEX receita_fk_1(tipo_movimentacao_id_tipo_movimentacao),
  INDEX receita_fk_2(forma_de_pagamento_id_forma_pagamento),
  INDEX receita_fk_3(campanha_id_campanha),
  INDEX receita_fk_4(doador_cpf_cnpj)
);

CREATE TABLE resultado (
  cod_resultado INTEGER NOT NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(cod_resultado)
);

CREATE TABLE tipo_documento (
  id_tipo_documento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(255) NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(id_tipo_documento)
);

CREATE TABLE tipo_movimentacao (
  id_tipo_movimentacao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  codigo INTEGER UNSIGNED NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(id_tipo_movimentacao)
);
