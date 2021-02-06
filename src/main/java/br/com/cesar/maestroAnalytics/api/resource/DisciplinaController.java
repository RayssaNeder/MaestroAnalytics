package br.com.cesar.maestroAnalytics.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesar.maestroAnalytics.api.event.ResourceCreatedEvent;
import br.com.cesar.maestroAnalytics.api.model.Disciplina;
import br.com.cesar.maestroAnalytics.api.repository.DisciplinaRepository;
import br.com.cesar.maestroAnalytics.api.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private DisciplinaRepository disciplinasRepository;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and #oauth2.hasScope('read')")
	public List<Disciplina> listar(){
		return disciplinasRepository.findAll();
	}
	
	  @PostMapping 
	  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CURSO') and #oauth2.hasScope('write')")
	  public ResponseEntity<Disciplina> criar(@Valid @RequestBody Disciplina disciplina, HttpServletResponse response){ 
		  Disciplina disciplinaSalva =   disciplinaService.save(disciplina);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  disciplinaSalva.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaSalva); 
	  }
	
	 @DeleteMapping("/{codigo}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable Long codigo) {
		 disciplinasRepository.delete(codigo);
	  }

}
