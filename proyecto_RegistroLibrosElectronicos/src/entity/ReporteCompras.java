package entity;

import java.util.Date;

public class ReporteCompras {

	private String periodo, moneda, tipoDoc, serie, numero, codigo, nombre, codRet, desRet,  numRet, glosa, codCom;  
	private Date fechaDoc,fechaRet;
	private double tipoCambio, valorventa, inafecto, igv, total, montoRet;
	private int tasaRet, codEstado;
	public String getPeriodo() {
		return periodo;
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
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodRet() {
		return codRet;
	}
	public void setCodRet(String codRet) {
		this.codRet = codRet;
	}
	public String getDesRet() {
		return desRet;
	}
	public void setDesRet(String desRet) {
		this.desRet = desRet;
	}
	public String getNumRet() {
		return numRet;
	}
	public void setNumRet(String numRet) {
		this.numRet = numRet;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public String getCodCom() {
		return codCom;
	}
	public void setCodCom(String codCom) {
		this.codCom = codCom;
	}
	public Date getFechaDoc() {
		return fechaDoc;
	}
	public void setFechaDoc(Date fechaDoc) {
		this.fechaDoc = fechaDoc;
	}
	public Date getFechaRet() {
		return fechaRet;
	}
	public void setFechaRet(Date fechaRet) {
		this.fechaRet = fechaRet;
	}
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	public double getInafecto() {
		return inafecto;
	}
	public void setInafecto(double inafecto) {
		this.inafecto = inafecto;
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
	public double getMontoRet() {
		return montoRet;
	}
	public void setMontoRet(double montoRet) {
		this.montoRet = montoRet;
	}
	public int getTasaRet() {
		return tasaRet;
	}
	public void setTasaRet(int tasaRet) {
		this.tasaRet = tasaRet;
	}
	public int getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}
	
	
}
