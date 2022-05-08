package com.exacta.control.finance.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.exacta.control.finance.api.model.Gasto;
import com.exacta.control.finance.api.model.enums.Tags;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GastoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idGasto;

	private String nome;

	@NotEmpty(message = "O campo DESCRIÇÂO é obrigatório")
	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime datahora;

	private BigDecimal valor;

	private Integer tags;

	public GastoDto() {
		super();
	}

	public GastoDto(Gasto gasto) {
		super();
		this.idGasto = gasto.getIdGasto();
		this.descricao = gasto.getDescricao();
		this.nome = gasto.getNome();
		this.datahora = gasto.getDatahora();
		this.valor = gasto.getValor();
		this.tags = gasto.getTags().getCod();
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

	public void setTags(Integer tags) {
		this.tags = tags;
	}

}
