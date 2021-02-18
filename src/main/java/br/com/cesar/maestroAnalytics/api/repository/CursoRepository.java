package br.com.cesar.maestroAnalytics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Optional<Curso> findBySku(String sku);

	@Transactional
	void deleteBySku(String sku);

	Optional<Curso> findByCodigo(Long codigo);

}
