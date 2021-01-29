package br.com.cesar.maestroAnalytics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cesar.maestroAnalytics.api.model.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{

	Optional<Instituicao> findBySku(String sku);

}
