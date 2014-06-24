ALTER DATABASE c_on CHARSET = Latin1 COLLATE = latin1_swedish_ci;

DROP TABLE IF EXISTS  despesa;
DROP TABLE IF EXISTS  receita;
DROP TABLE IF EXISTS  doador;
DROP TABLE IF EXISTS  fornecedor;

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
  campanha_uf VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_despesa),
  INDEX despesa_sk_1(cargo),
  INDEX despesa_fk_1(campanha_ano),
  INDEX despesa_fk_2(campanha_numero_candidato),
  INDEX despesa_fk_3(fornecedor_nome),
  INDEX despesa_fk_4(fornecedor_cpf_cnpj),
  INDEX despesa_fk_5(campanha_uf)
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
  campanha_uf VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_receita),
  INDEX receita_sk_1(cargo),
  INDEX receita_fk_1(campanha_ano),
  INDEX receita_fk_2(campanha_numero_candidato),
  INDEX receita_fk_3(doador_nome),
  INDEX receita_fk_4(doador_cpf_cnpj),
  INDEX receita_fk_5(campanha_uf)
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
