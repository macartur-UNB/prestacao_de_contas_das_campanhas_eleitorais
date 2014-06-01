DROP TABLE IF EXISTS t_partido;

CREATE TABLE t_partido (
  numero      VARCHAR(20) NOT NULL ,
  sigla       VARCHAR(20) NOT NULL ,
  nome        VARCHAR(255) NULL ,
  deferimento VARCHAR(255) NULL ,
  PRIMARY KEY(sigla)
 );