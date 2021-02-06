package br.com.cesar.maestroAnalytics.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesar.maestroAnalytics.api.event.ResourceCreatedEvent;
import br.com.cesar.maestroAnalytics.api.model.Aluno;
import br.com.cesar.maestroAnalytics.api.model.Turma;
import br.com.cesar.maestroAnalytics.api.model.Turma;
import br.com.cesar.maestroAnalytics.api.repository.AlunoRepository;
import br.com.cesar.maestroAnalytics.api.repository.TurmaRepository;
import br.com.cesar.maestroAnalytics.api.repository.PessoaRepository;
import br.com.cesar.maestroAnalytics.api.service.AlunoService;
import br.com.cesar.maestroAnalytics.api.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	//@CrossOrigin(maxAge = 10, origins = {"http://localhost:8000"}) -- não vou adicionar a origem cruzada via anotação porque o spring não funciona bem com o oauth2. Em vez disso vou criar um filtro para o CORS
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and #oauth2.hasScope('read')")
	public List<Turma> listar(){
		return turmaRepository.findAll();
	}
	
	
	  @PostMapping 
	  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CURSO') and #oauth2.hasScope('write')")
	  public ResponseEntity<Turma> criar(@Valid @RequestBody Turma turma, HttpServletResponse response){ 
		  Turma turmaSalvo =   turmaService.save(turma);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  turmaSalvo.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalvo); 
	  }
	  
	  
	  @DeleteMapping("/{sku}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable String sku) {
		  turmaRepository.deleteBySku(sku);
	  }
	  
	  @PutMapping ("/{sku}")
	  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CURSO') and #oauth2.hasScope('write')")
	  public ResponseEntity<Turma> atualizar(@Valid @RequestBody Turma turma, HttpServletResponse response){ 
		  Turma turmaSalvo =   turmaService.save(turma);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  turmaSalvo.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalvo); 
	  }
	  
	  @GetMapping ("/{sku}")
	  @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and #oauth2.hasScope('read')")
	  public ResponseEntity<Turma> buscar(@Valid @PathVariable String sku, HttpServletResponse response){ 
		  Turma turmaSalvo =   turmaService.findBySku(sku);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  turmaSalvo.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalvo); 
	  }
	  
	 

}
