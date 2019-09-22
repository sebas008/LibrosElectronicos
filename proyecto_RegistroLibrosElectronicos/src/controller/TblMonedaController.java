package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblMoneda;
import modelo.ModeloTblMoneda;

@ManagedBean(name="tblMonedaController")
@ViewScoped
public class TblMonedaController {

	private TblMoneda tblMoneda;
	private List<TblMoneda>listadoTblMoneda;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		tblMoneda=new TblMoneda();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblMoneda=new ModeloTblMoneda().listarTblMoneda();
	}
	public void seleccionar(){
		tblMoneda=(TblMoneda)dtFila.getRowData();
	}

	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	public TblMoneda getTblMoneda() {
		return tblMoneda;
	}
	public void setTblMoneda(TblMoneda tblMoneda) {
		this.tblMoneda = tblMoneda;
	}
	public List<TblMoneda> getListadoTblMoneda() {
		return listadoTblMoneda;
	}
	public void setListadoTblMoneda(List<TblMoneda> listadoTblMoneda) {
		this.listadoTblMoneda = listadoTblMoneda;
	}
	 
	
	
}
