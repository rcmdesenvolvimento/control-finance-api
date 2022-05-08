package com.exacta.control.finance.api.model.enums;

public enum Tags {

	CARTAO(0, "Cartão"), DINHEIRO(1, "Dinheiro");

	private Integer cod;
	private String descricao;

	private Tags(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Tags toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Tags x : Tags.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Tipo de Pagamento inválido!" + cod);
	}

}
