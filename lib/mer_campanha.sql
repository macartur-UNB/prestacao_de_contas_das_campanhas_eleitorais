ALTER DATABASE c_on CHARSET = Latin1 COLLATE = latin1_swedish_ci;

DROP TABLE IF EXISTS  campanha;
DROP TABLE IF EXISTS  candidato;
DROP TABLE IF EXISTS  partido;
DROP TABLE IF EXISTS  cargo;
DROP TABLE IF EXISTS  resultado;

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