Alter table professor Add pessoa_codigo  BIGINT(20)NOT NULL;
Alter table professor Add FOREIGN KEY (pessoa_codigo) REFERENCES pessoa(codigo);