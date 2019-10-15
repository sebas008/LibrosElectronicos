package entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
@Table(name="facturaCompra")
public class ClFacturaCompra {
	
	@EmbeddedId
	private ClFacturaCompraID id;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="periodoContable")
	private TblPeriodoContable tblPeriodoContable;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="moneda")
	private TblMoneda tblMoneda;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoCambio")
	private MntTipoCambio mntTipoCambio; 
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoDocumento")
	private TblTipoDoc  tblTipoDoc;
	private String razonS_Pro;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoRetencion")
	private TblTipoRet tblTipoRet; 
	private String des_Re; 
	private String glosa_Compra;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="estadoDoc")
    private TblEstadoDoc tblEstadoDoc; 
    private String des_estado;    
    private String fechaRet; 
    private String nroRet;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="tipoCompra")
    private TblTipoCom tblTipoCom; 
    private String desCodcom;
	private double tipoCambio; 
	private double valorVenta; 
	private double valorInafecto; 
	private double igv;
	private double total;
	private double montoRet;
	private int tasa_re;

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


	public double getMontoRet() {
		return montoRet;
	}

	public void setMontoRet(double montoRet) {
		this.montoRet = montoRet;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public String getRazonS_Pro() {
		return razonS_Pro;
	}

	public void setRazonS_Pro(String razonS_Pro) {
		this.razonS_Pro = razonS_Pro;
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

	public TblPeriodoContable getTblPeriodoContable() {
		return tblPeriodoContable;
	}

	public void setTblPeriodoContable(TblPeriodoContable tblPeriodoContable) {
		this.tblPeriodoContable = tblPeriodoContable;
	}

	public TblMoneda getTblMoneda() {
		return tblMoneda;
	}

	public void setTblMoneda(TblMoneda tblMoneda) {
		this.tblMoneda = tblMoneda;
	}

	public MntTipoCambio getMntTipoCambio() {
		return mntTipoCambio;
	}

	public void setMntTipoCambio(MntTipoCambio mntTipoCambio) {
		this.mntTipoCambio = mntTipoCambio;
	}

	public TblTipoDoc getTblTipoDoc() {
		return tblTipoDoc;
	}

	public void setTblTipoDoc(TblTipoDoc tblTipoDoc) {
		this.tblTipoDoc = tblTipoDoc;
	}

	public TblTipoRet getTblTipoRet() {
		return tblTipoRet;
	}

	public void setTblTipoRet(TblTipoRet tblTipoRet) {
		this.tblTipoRet = tblTipoRet;
	}

	public TblEstadoDoc getTblEstadoDoc() {
		return tblEstadoDoc;
	}

	public void setTblEstadoDoc(TblEstadoDoc tblEstadoDoc) {
		this.tblEstadoDoc = tblEstadoDoc;
	}

	public TblTipoCom getTblTipoCom() {
		return tblTipoCom;
	}

	public void setTblTipoCom(TblTipoCom tblTipoCom) {
		this.tblTipoCom = tblTipoCom;
	}
	
	
}
