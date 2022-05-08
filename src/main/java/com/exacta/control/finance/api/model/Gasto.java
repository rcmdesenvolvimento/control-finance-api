package com.exacta.control.finance.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.exacta.control.finance.api.model.enums.Tags;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Gasto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long idGasto;

	@Column(name = "nome", length = 80, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 200, nullable = false)
	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "dataHora")
	private LocalDateTime datahora;

	@Column(name = "valor_gasto", nullable = false)
	private BigDecimal valor;

	@Column(name = "tags")
	private Integer tags;

	public Gasto() {
		super();
		this.setDatahora(LocalDateTime.now());
	}

	public Gasto(Long idGasto, String nome, String descricao, LocalDateTime datahora, BigDecimal valor, Tags tags) {
		super();
		this.idGasto = idGasto;
		this.nome = nome;
		this.descricao = descricao;
		this.datahora = datahora;
		this.valor = valor;
		this.tags = (tags == null) ? 0 : tags.getCod();
	}

	public Long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Tags getTags() {
		return Tags.toEnum(this.tags);
	}

	public void setTags(Tags tags) {
		this.tags = tags.getCod();
	}

}
