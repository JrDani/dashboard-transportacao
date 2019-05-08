package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_veiculo;
	
	@NotNull	
	@ManyToOne
	@JoinColumn(name = "id_tipo_veiculo")
	private TipoVeiculo tipoVeiculo;

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_veiculo == null) ? 0 : id_veiculo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (id_veiculo == null) {
			if (other.id_veiculo != null)
				return false;
		} else if (!id_veiculo.equals(other.id_veiculo))
			return false;
		return true;
	}
	
	
}
