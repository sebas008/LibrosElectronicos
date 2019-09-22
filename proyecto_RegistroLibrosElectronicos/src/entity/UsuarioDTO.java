package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioDTO {
	
	@Id
	private String cod_usu;
	private String clave_usu;
	
//	Generar métodos de acceso getters y setters
	public String getCod_usu() {
		return cod_usu;
	}
	public void setCod_usu(String cod_usu) {
		this.cod_usu = cod_usu;
	}
	public String getClave_usu() {
		return clave_usu;
	}
	public void setClave_usu(String clave_usu) {
		this.clave_usu = clave_usu;
	}
}

