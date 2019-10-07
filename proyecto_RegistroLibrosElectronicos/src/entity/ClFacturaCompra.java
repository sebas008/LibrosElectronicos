package entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facturaCompra")
public class ClFacturaCompra {
	
	@EmbeddedId
	private ClFacturaCompraID id;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="periodoContable")
	private String periodo;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="moneda")
	private String moneda;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoCambio")
	private String fecha; 
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoDocumento")
	private String tipoDoc;
	private String razonS_Pro;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoRetencion")
	private String cod_Re; 
	private String des_Re; 
	private String glosa_Compra;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="estadoDoc")
    private String cod_estado; 
    private String des_estado;    
    private String fechaRet; 
    private String nroRet;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoCompra")
    private String codcom; 
    private String desCodcom;
	private double tipoCambio; 
	private double valorVenta; 
	private double valorInafecto; 
	private double igv;
	private double total;
	private double montoRet;
	

	public String getFechaRet() {
		return fechaRet;
	}

	public String getDesCodcom() {
		return desCodcom;
	}

	public void setDesCodcom(String desCodcom) {
		this.desCodcom = desCodcom;
	}

	public void setFechaRet(String fechaRet) {
		this.fechaRet = fechaRet;
	}

	public String getNroRet() {
		return nroRet;
	}

	public void setNroRet(String nroRet) {
		this.nroRet = nroRet;
	}

	public String getCodcom() {
		return codcom;
	}

	public void setCodcom(String codcom) {
		this.codcom = codcom;
	}

	public double getMontoRet() {
		return montoRet;
	}

	public void setMontoRet(double montoRet) {
		this.montoRet = montoRet;
	}

	private int tasa_re;

	public String getPeriodo() {
		return periodo;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getRazonS_Pro() {
		return razonS_Pro;
	}

	public void setRazonS_Pro(String razonS_Pro) {
		this.razonS_Pro = razonS_Pro;
	}

	public String getCod_Re() {
		return cod_Re;
	}

	public void setCod_Re(String cod_Re) {
		this.cod_Re = cod_Re;
	}

	public String getDes_Re() {
		return des_Re;
	}

	public void setDes_Re(String des_Re) {
		this.des_Re = des_Re;
	}

	public String getGlosa_Compra() {
		return glosa_Compra;
	}

	public void setGlosa_Compra(String glosa_Compra) {
		this.glosa_Compra = glosa_Compra;
	}

	public String getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getValorInafecto() {
		return valorInafecto;
	}

	public void setValorInafecto(double valorInafecto) {
		this.valorInafecto = valorInafecto;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTasa_re() {
		return tasa_re;
	}

	public void setTasa_re(int tasa_re) {
		this.tasa_re = tasa_re;
	}

	public ClFacturaCompraID getId() {
		return id;
	}

	public void setId(ClFacturaCompraID id) {
		this.id = id;
	}
	
}
