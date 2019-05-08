package com.example.api.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;
	
	@NotNull	
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@NotNull	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@NotNull	
	@ManyToOne
	@JoinColumn(name = "id_minerio")
	private Minerio minerio;
	
	@NotNull
	private String destino;
	
	@NotNull	
	private Double quantidade_kg;		
	
	@CreationTimestamp
	private Timestamp data_pedido;	
	
	@Transient	
	@JsonProperty(access = Access.READ_ONLY)
	private Double total;
	
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}		
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getQuantidade_kg() {
		return quantidade_kg;
	}
	public void setQuantidade_kg(Double quantidade_kg) {
		this.quantidade_kg = quantidade_kg;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Minerio getMinerio() {
		return minerio;
	}
	public void setMinerio(Minerio minerio) {
		this.minerio = minerio;
	}
		
	public Timestamp getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(Timestamp data_pedido) {
		this.data_pedido = data_pedido;
	}	
	public void setTotal() {
		total = 0.0;
	}
	public Double getTotal() {
		return this.quantidade_kg*this.minerio.getValor_grama()*1000;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pedido == null) ? 0 : id_pedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id_pedido == null) {
			if (other.id_pedido != null)
				return false;
		} else if (!id_pedido.equals(other.id_pedido))
			return false;
		return true;
	}
	
	
}
