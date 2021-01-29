package br.com.cesar.maestroAnalytics.api.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;
import br.com.cesar.maestroAnalytics.api.repository.CursoRepository;
import br.com.cesar.maestroAnalytics.api.repository.InstituicaoRepository;


@Service
public class CursoService {
	
	private static Log log = LogFactory.getLog(CursoService.class);
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	@Transactional
	public Curso save(Curso curso) {
		
		Optional<Instituicao> instituicaoExistente = instituicaoRepository.findBySku(curso.getInstituicao().getSku());
		
		// TO DO APLIOCAR MULT TENACY
		/*
		 * if(!instituicaoExistente.isPresent()) {
		 * System.out.println("NÃO EXISTE INSTITUICAO COM O CODIGO " +
		 * curso.getInstituicao().getCodigo());
		 * log.error("Erro de sistema- NÃO EXISTE INSTITUICAO COM O CODIGO: " +
		 * curso.getInstituicao().getCodigo()); }
		 * 
		 * log.error("EXISTE sim INSTITUICAO COM O CODIGO: " +
		 * curso.getInstituicao().getCodigo());
		 * 
		 * curso.setInstituicao(instituicaoExistente.get());
		 */
		
		Instituicao instituicao = new Instituicao();
		instituicao.setCodigo(Long.parseLong("1"));
		instituicao.setSku("00001");
		instituicao.setNome("Cesar School");
		curso.setInstituicao(instituicao);
		
		curso = cursoRepository.save(curso);
		return curso;
	}

	public Curso findBySku(String sku) {
		return cursoRepository.findBySku(sku);
		
	}

}
