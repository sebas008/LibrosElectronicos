package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//notaciones
//@Entity
@Table(name="condicionpago")
public class TblCondPago {

@Id
private String codigo, descripcion;

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
