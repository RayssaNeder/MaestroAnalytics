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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesar.maestroAnalytics.api.event.ResourceCreatedEvent;
import br.com.cesar.maestroAnalytics.api.model.Aluno;
import br.com.cesar.maestroAnalytics.api.model.Curso;
import br.com.cesar.maestroAnalytics.api.model.Pessoa;
import br.com.cesar.maestroAnalytics.api.repository.AlunoRepository;
import br.com.cesar.maestroAnalytics.api.repository.PessoaRepository;
import br.com.cesar.maestroAnalytics.api.service.AlunoService;
import br.com.cesar.maestroAnalytics.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class pessoaController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	
	  @PostMapping 
	  public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){ 
		  Pessoa pessoaSalva =   pessoaService.save(pessoa);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  pessoaSalva.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	  
	  }
	  
	  @DeleteMapping("/{codigo}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable Long codigo) {
		  pessoaRepository.delete(codigo);
	  }
	  
	  @GetMapping ("/{codigo}")
	  @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and #oauth2.hasScope('read')")
	  public ResponseEntity<Pessoa> buscar(@Valid @PathVariable Long codigo, HttpServletResponse response){ 
		  Pessoa pessoaSalva =   pessoaService.findByCodigo(codigo);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  pessoaSalva.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva); 
	  }
	  
	  @GetMapping ("/cpf/{cpf}")
	  @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and #oauth2.hasScope('read')")
	  public ResponseEntity<Pessoa> buscarPorCpf(@Valid @PathVariable String cpf, HttpServletResponse response){ 
		  Pessoa pessoaSalva =   pessoaService.findByCpf(cpf);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  pessoaSalva.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva); 
	  }
	  
	  @PutMapping ("/{codigo}")
	  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CURSO') and #oauth2.hasScope('write')")
	  public ResponseEntity<Pessoa> atualizar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){ 
		  Pessoa pessoaSalva =   pessoaService.save(pessoa);
	  
	  publisher.publishEvent(new ResourceCreatedEvent(this, response,
			  pessoaSalva.getCodigo()));
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva); 
	  }
	 


}
