package entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
@Table(name="facturaVenta")

public class ClFacturaVenta {
	@EmbeddedId
	private ClFacturaVentaID id;
	@ManyToOne(optional = false)
	@JoinColumn(name="tblPeriodoContable",referencedColumnName="codPerdiodo")
	private TblPeriodoContable tblPeriodoContable;
	@ManyToOne(optional = false)
	@JoinColumn(name="tblMoneda",referencedColumnName="codigo")
	private TblMoneda tblMoneda;
	@ManyToOne(optional = false)
	@JoinColumn(name="mntTipoCambio",referencedColumnName="fecha")
	private MntTipoCambio mntTipoCambio;
	@ManyToOne(optional = false)
	@JoinColumn(name="tblTipoDoc",referencedColumnName="codigo")
private TblTipoDoc tblTipoDoc;
	private String razonS_Cli;
	@ManyToOne(optional = false)
	@JoinColumn(name="tblTipoRet",referencedColumnName="codigo")
	private TblTipoRet tblTipoRet;	
	private String des_Re;	
	private String glosa_venta;
	@ManyToOne(optional = false)
	@JoinColumn(name="tblEstadoDoc",referencedColumnName="codigo")
	private TblEstadoDoc tblEstadoDoc;
	private String des_estado;
	private double tipoCambio;
	private double valorVenta;
	private double valorInafecto;
	private double igv;
	private double total;
	private int tasa_re;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy="mntCliente")
	private Collection<MntCliente> listadoCliente;

	

	public Collection<MntCliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(Collection<MntCliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}


	public ClFacturaVentaID getId() {
		return id;
	}

	public void setId(ClFacturaVentaID id) {
		this.id = id;
	}

	public String getRazonS_Cli() {
		return razonS_Cli;
	}

	public void setRazonS_Cli(String razonS_Cli) {
		this.razonS_Cli = razonS_Cli;
	}


	public String getDes_Re() {
		return des_Re;
	}

	public void setDes_Re(String des_Re) {
		this.des_Re = des_Re;
	}

	public String getGlosa_venta() {
		return glosa_venta;
	}

	public void setGlosa_venta(String glosa_venta) {
		this.glosa_venta = glosa_venta;
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




}
