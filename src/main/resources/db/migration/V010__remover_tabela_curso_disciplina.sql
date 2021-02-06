drop table curso_disciplina;
Alter table disciplina Add curso_codigo BIGINT(20)NOT NULL;
Alter table disciplina Add FOREIGN KEY (curso_codigo) REFERENCES curso(codigo)