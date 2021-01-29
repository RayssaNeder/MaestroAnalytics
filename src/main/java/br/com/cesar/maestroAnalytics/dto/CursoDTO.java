package br.com.cesar.maestroAnalytics.dto;

import br.com.cesar.maestroAnalytics.api.model.Grau;
import br.com.cesar.maestroAnalytics.api.model.Instituicao;
import br.com.cesar.maestroAnalytics.api.model.Modalidade;

public class CursoDTO {
	
	private Long codigo;
	private String sku;
	private String nome;
	private String instituicao;
	private String grau;
	private String modalidade;
	
	
	public CursoDTO(Long codigo, String sku, String nome, Instituicao instituicao, Grau grau, Modalidade modalidade) {
		super();
		this.codigo = codigo;
		this.sku = sku;
		this.nome = nome;
		this.instituicao = instituicao.getNome();
		this.grau = grau.getDescricao();
		this.modalidade = modalidade.getDescricao();
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}


	public String getGrau() {
		return grau;
	}


	public void setGrau(String grau) {
		this.grau = grau;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}	

}
