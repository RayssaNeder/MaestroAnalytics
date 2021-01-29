package br.com.cesar.maestroAnalytics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	Curso findBySku(String sku);

	@Transactional
	void deleteBySku(String sku);

}
