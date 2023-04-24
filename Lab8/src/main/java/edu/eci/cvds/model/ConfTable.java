package edu.eci.cvds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class ConfTable{

	@Id
	@Column(name = "PROPIEDAD")
	private String propiedad = "Premio";

	@Column(name = "VALOR")
	private String valor = "100";

	public ConfTable() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propiedad == null) ? 0 : propiedad.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		ConfTable other = (ConfTable) obj;
		if (propiedad == null) {
			if (other.propiedad != null)
				return false;
		} else if (!propiedad.equals(other.propiedad))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	public String getConfTableId() {
		return propiedad;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setConfTableId(String newProp) {
		this.propiedad = newProp;
	}

	public String getValor() {
		return valor;
	}

	public void setFirstName(String newVal) {
		this.valor = newVal;
	}

	@Override
	public String toString() {
		return "ConfTable [propiedad=" + propiedad + ", valor=" + valor + "]";
	}

}