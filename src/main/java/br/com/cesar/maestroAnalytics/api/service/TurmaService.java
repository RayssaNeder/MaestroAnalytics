package br.com.cesar.maestroAnalytics.api.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cesar.maestroAnalytics.api.model.Disciplina;
import br.com.cesar.maestroAnalytics.api.model.Turma;
import br.com.cesar.maestroAnalytics.api.repository.TurmaRepository;
import br.com.cesar.maestroAnalytics.api.repository.DisciplinaRepository;


@Service
public class TurmaService {
	
	private static Log log = LogFactory.getLog(TurmaService.class);
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Transactional
	public Turma save(Turma turma) {
		
		Optional<Disciplina> disciplinaExistente = disciplinaRepository.findByCodigo(turma.getDisciplina().getCodigo());
		
		// TO DO APLIOCAR MULT TENACY
		
		  if(!disciplinaExistente.isPresent()) {
		  System.out.println("NÃO EXISTE DISCIPLINA COM O CODIGO " +
		  turma.getDisciplina().getSku());
		  log.error("Erro de sistema- NÃO EXISTE INSTITUICAO COM O CODIGO: " +
		  turma.getDisciplina().getSku()); }
		  
		  log.error("EXISTE sim INSTITUICAO COM O CODIGO: " +
		  turma.getDisciplina().getSku());
		  
		  turma.setDisciplina(disciplinaExistente.get());
		 
		
		turma = turmaRepository.save(turma);
		return turma;
	}

	public Turma findBySku(String sku) {
		return turmaRepository.findBySku(sku);
		
	}

}
