package br.com.cesar.maestroAnaltics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "turma")
public class Turma {
	
	@Id
	private Long codigo;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "turma_id", nullable = false)
	private Curso curso;
}
