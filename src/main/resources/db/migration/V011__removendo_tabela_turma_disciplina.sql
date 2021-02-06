drop table disciplina_turma;
Alter table turma Add disciplina_codigo BIGINT(20)NOT NULL;
Alter table turma Add FOREIGN KEY (disciplina_codigo) REFERENCES disciplina(codigo);