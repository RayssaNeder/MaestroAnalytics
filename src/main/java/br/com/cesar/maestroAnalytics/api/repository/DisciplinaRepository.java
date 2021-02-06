package br.com.cesar.maestroAnalytics.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cesar.maestroAnalytics.api.model.Disciplina;



public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	Disciplina findBySku(String sku);

	@Transactional
	void deleteBySku(String sku);

	Optional<Disciplina> findByCodigo(Long codigo);

	//Optional<Disciplina> findByDisciplina(Disciplina disciplina);

}
