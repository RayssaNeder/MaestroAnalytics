package br.com.cesar.maestroAnalytics.api.repository.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.dto.CursoDTO;

public class CursoRepositoryimpl implements CursoRepositoryQuery {
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Curso> filtrar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoDTO> porSkuOuNome(String skuOuNome) {
		String jpql = "select new br.com.cesar.maestroAnalytics.dto.CursoDTO(codigo,sku,nome,grau,modalidade) "
				+ "from Curso where lower(sku) like lower(:skuOuNome) or lower(nome) like lower(:skuOuNome)";
		
		List<CursoDTO> cursosFiltrados = manager.createQuery(jpql, CursoDTO.class)
				.setParameter("skuOuNome", skuOuNome + "%")
				.getResultList();
		return cursosFiltrados;
	}





}
