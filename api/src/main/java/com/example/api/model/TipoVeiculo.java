package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipo_veiculo")
public class TipoVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_veiculo;
	
	@NotNull
	@Size(min=3, max=20)
	private String nome;

	public Long getId_tipo_veiculo() {
		return id_tipo_veiculo;
	}

	public void setId_tipo_veiculo(Long id_tipo_veiculo) {
		this.id_tipo_veiculo = id_tipo_veiculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipo_veiculo == null) ? 0 : id_tipo_veiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoVeiculo other = (TipoVeiculo) obj;
		if (id_tipo_veiculo == null) {
			if (other.id_tipo_veiculo != null)
				return false;
		} else if (!id_tipo_veiculo.equals(other.id_tipo_veiculo))
			return false;
		return true;
	}
	
	
}
