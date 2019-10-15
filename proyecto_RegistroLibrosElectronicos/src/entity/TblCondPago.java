package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//notaciones
@Entity
@Table(name="condicionPago")
public class TblCondPago {

@Id
private String codigo;
private String descripcion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
