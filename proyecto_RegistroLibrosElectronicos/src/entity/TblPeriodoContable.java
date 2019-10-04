package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name="periodoContable")
public class TblPeriodoContable {

	@Id
	private String codPerdiodo; 
	private String desPeriodo;

	public String getCodPerdiodo() {
		return codPerdiodo;
	}

	public void setCodPerdiodo(String codPerdiodo) {
		this.codPerdiodo = codPerdiodo;
	}

	public String getDesPeriodo() {
		return desPeriodo;
	}

	public void setDesPeriodo(String desPeriodo) {
		this.desPeriodo = desPeriodo;
	}
	
}
