package br.com.cesar.maestroAnalytics.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.cesar.maestroAnalytics.api.model.Professor;
import br.com.cesar.maestroAnalytics.api.repository.ProfessoresRepository;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessoresRepository professoresRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Professor> listar() {
		return professoresRepository.findAll();
	}
	
	 @DeleteMapping("/{codigo}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable Long codigo) {
		 professoresRepository.delete(codigo);
	  }

}
