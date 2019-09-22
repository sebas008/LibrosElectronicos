package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoPer;
import modelo.ModeloTblTipoPer;

@ManagedBean(name="tblTipoPerController")
@ViewScoped
public class TblTipoPerController {

	private TblTipoPer tblTipoPer;
	private List<TblTipoPer>listadoTblTipoPer;
	private UIData dtFila;
	
	@PostConstruct
	public void init(){
		tblTipoPer=new TblTipoPer();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblTipoPer=new ModeloTblTipoPer().listarTblTipoPer();
	}
	public void seleccionar(){
		tblTipoPer=(TblTipoPer)dtFila.getRowData();
	}
	public TblTipoPer getTblTipoPer() {
		return tblTipoPer;
	}
	public void setTblTipoPer(TblTipoPer tblTipoPer) {
		this.tblTipoPer = tblTipoPer;
	}
	public List<TblTipoPer> getListadoTblTipoPer() {
		return listadoTblTipoPer;
	}
	public void setListadoTblTipoPer(List<TblTipoPer> listadoTblTipoPer) {
		this.listadoTblTipoPer = listadoTblTipoPer;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
	
}
