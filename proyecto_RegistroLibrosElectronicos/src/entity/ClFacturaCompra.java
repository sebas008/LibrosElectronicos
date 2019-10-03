package entity;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="facturaCompra")
public class ClFacturaCompra {
	
	private String periodo, moneda, fecha, tipoDoc, serieDoc, numDoc, cod_Pro, razonS_Pro, cod_Re, des_Re, glosa_Compra,
			cod_estado, des_estado, fechaRet, nroRet, codcom, desCodcom;
	private double tipoCambio, valorVenta, valorInafecto, igv, total, montoRet;

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

	public String getSerieDoc() {
		return serieDoc;
	}

	public void setSerieDoc(String serieDoc) {
		this.serieDoc = serieDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getCod_Pro() {
		return cod_Pro;
	}

	public void setCod_Pro(String cod_Pro) {
		this.cod_Pro = cod_Pro;
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

}
