package br.com.cesar.maestroAnalytics.api.service;


import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Disciplina;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;
import br.com.cesar.maestroAnalytics.api.repository.CursoRepository;
import br.com.cesar.maestroAnalytics.api.repository.DisciplinaRepository;


@Service
public class DisciplinaService {
	
	private static Log log = LogFactory.getLog(CursoService.class);
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Transactional
	public Disciplina save(Disciplina disciplina) {
		
		
		
		//Optional<Disciplina> cursoExistente = disciplinaRepository.findBySku(disciplina.getSku());
		  
		/*
		 * if(!cursoExistente.isPresent()) {;
		 * log.error("Erro de sistema- NÃO EXISTE CURSO COM O CODIGO: " +
		 * disciplina.getCurso().getSku() + " - " + disciplina.getCurso().getNome()); }
		 * 
		 * 
		 * disciplina.setCurso(cursoExistente.get());
		 */
		 
		
		
		disciplina = disciplinaRepository.save(disciplina);
		return disciplina;
	}

	public Curso findBySku(String sku) {
		return cursoRepository.findBySku(sku);
		
	}

}
