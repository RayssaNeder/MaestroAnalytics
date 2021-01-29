package br.com.cesar.maestroAnalytics.api.repository.curso;

import java.util.List;

import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.dto.CursoDTO;


public interface CursoRepositoryQuery {

	public List<Curso> filtrar();
	
	public List<CursoDTO> porSkuOuNome(String skuOuNome);

}
