package br.com.cesar.maestroAnalytics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;
import br.com.cesar.maestroAnalytics.api.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	Turma findBySku(String sku);

	@Transactional
	void deleteBySku(String sku);

	Optional<Turma> findByCodigo(String sku);

	Turma save(Turma turma);

}
