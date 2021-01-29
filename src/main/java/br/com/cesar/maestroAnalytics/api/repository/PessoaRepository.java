package br.com.cesar.maestroAnalytics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {
	
	Pessoa findByCodigo(Long codigo);
	
	@Transactional
	void deleteByCodigo(Long sku);

}
