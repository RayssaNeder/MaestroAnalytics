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

import br.com.cesar.maestroAnalytics.api.model.Disciplina;
import br.com.cesar.maestroAnalytics.api.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private DisciplinaRepository disciplinasRepository;
	
	@GetMapping
	public List<Disciplina> listar(){
		return disciplinasRepository.findAll();
	}
	
	 @DeleteMapping("/{codigo}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable Long codigo) {
		 disciplinasRepository.delete(codigo);
	  }

}
