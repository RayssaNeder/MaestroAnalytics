package br.com.cesar.maestroAnalytics.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesar.maestroAnalytics.api.event.ResourceCreatedEvent;
import br.com.cesar.maestroAnalytics.api.model.Aluno;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;
import br.com.cesar.maestroAnalytics.api.repository.AlunoRepository;
import br.com.cesar.maestroAnalytics.api.repository.InstituicaoRepository;
import br.com.cesar.maestroAnalytics.api.service.AlunoService;
import br.com.cesar.maestroAnalytics.api.service.InstituicaoService;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoController {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private InstituicaoRepository insitituicaoRepository;

	@Autowired
	private InstituicaoService instituicaoService;

	@GetMapping
	public List<Instituicao> listar() {
		return insitituicaoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Instituicao> criar(@Valid @RequestBody Instituicao instituicao,
			HttpServletResponse response) {
		Instituicao instituicaoSalva = instituicaoService.save(instituicao);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, instituicaoSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoSalva);
	}
	
	 @DeleteMapping("/{codigo}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void remover(@PathVariable Long codigo) {
		 insitituicaoRepository.delete(codigo);
	  }

}
