package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="minerio")
public class Minerio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_minerio;
	
	@NotNull
	@Size(min=3, max=60)
	private String nome;
	
	@NotNull
	private Double valor_grama;	

	public Long getId_minerio() {
		return id_minerio;
	}

	public void setId_minerio(Long id_minerio) {
		this.id_minerio = id_minerio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor_grama() {
		return valor_grama;
	}

	public void setValor_grama(Double valor_grama) {
		this.valor_grama = valor_grama;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_minerio == null) ? 0 : id_minerio.hashCode());
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
		Minerio other = (Minerio) obj;
		if (id_minerio == null) {
			if (other.id_minerio != null)
				return false;
		} else if (!id_minerio.equals(other.id_minerio))
			return false;
		return true;
	}

	
}
