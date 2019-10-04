package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
@Table(name="proveedor")

public class MntProveedor {
  
	
	@Id
	private String codigo;
	private String descripcion; 
	private String direccion; 
	private String contacto; 
	private String telefono;
	private String correo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tblTipoPer",referencedColumnName="cod_pe")
	private TblTipoPer tblTipoPer;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tblTipoPro",referencedColumnName="tipo_prov")
	private TblTipoPro tblTipoPro;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tblCondPago",referencedColumnName="condicionPago")
	private TblCondPago tblCondPago;

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


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public TblTipoPer getTblTipoPer() {
		return tblTipoPer;
	}

	public void setTblTipoPer(TblTipoPer tblTipoPer) {
		this.tblTipoPer = tblTipoPer;
	}

	public TblCondPago getTblCondPago() {
		return tblCondPago;
	}

	public void setTblCondPago(TblCondPago tblCondPago) {
		this.tblCondPago = tblCondPago;
	}

}
