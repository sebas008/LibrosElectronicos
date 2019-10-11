package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblCondPago;
import entity.TblEstadoDoc;
import modelo.ModeloTblCondPago;
import modelo.ModeloTblEstadoDoc;

@ManagedBean(name="tblCondPagoController")
@ViewScoped
public class TblCondPagoController {
	
	
	private TblCondPago tblCondPago;
	private List<TblCondPago>listarTblCondPago;
	private UIData dtFila;
	
	
	public void init() {
		
		tblCondPago = new TblCondPago();
		cargarTable();
	}
	
	public void cargarTable(){
		listarTblCondPago = new ModeloTblCondPago().listarTblCondPago();
	}
	
	public void seleccionar() {
		
		
				
	}
	
	public TblCondPago getTblEstadoDoc() {
		return tblCondPago;
	}
	public void setTblCondPago(TblCondPago tblCondPago) {
		this.tblCondPago = tblCondPago;
	}
	public List<TblCondPago> getListarTblCondPago() {
		return listarTblCondPago;
	}
	public void setListarTblCondPago(List<TblCondPago> ListarTblCondPago) {
		this.listarTblCondPago = listarTblCondPago;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	
	
	
	
	
	
	

}
