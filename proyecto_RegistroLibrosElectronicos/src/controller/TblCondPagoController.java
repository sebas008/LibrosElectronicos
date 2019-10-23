package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblCondPago;
import modelo.ModeloTblCondPago;

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
		tblCondPago=(TblCondPago)dtFila.getRowData();
	}
	public TblCondPago getTblCondPago() {
		return tblCondPago;
	}

	public void setTblCondPago(TblCondPago tblCondPago) {
		this.tblCondPago = tblCondPago;
	}

	public List<TblCondPago> getListarTblCondPago() {
		return listarTblCondPago;
	}

	public void setListarTblCondPago(List<TblCondPago> listarTblCondPago) {
		this.listarTblCondPago = listarTblCondPago;
	}

	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	public UIData getDtFila() {
		return dtFila;
	}
	
	public void registrarTblCondPago() {
		
		tblCondPago.getCodigo();
		new ModeloTblCondPago().insertTblCondPago(tblCondPago);
		cargarTable();
		
	}
	
	public void actualizarTblCondPago() {
		
		tblCondPago.getCodigo();
		new ModeloTblCondPago().actalizarTblCondPago(tblCondPago);
		cargarTable();
		
	}
	
  public void eliminarTblCondPago() {
	  
	  tblCondPago.getCodigo();
	  new ModeloTblCondPago().eliminarCondPago(tblCondPago.getCodigo());
	  cargarTable();
	  
	  
  }
	
	

}
