package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoDoc;
import modelo.ModeloTblTipoDoc;

@ManagedBean(name="tblTipoDocController")
@ViewScoped
public class TblTipoDocController {

	
	private TblTipoDoc tblTipoDoc;
	private List<TblTipoDoc>listadoTblTipoDoc;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		tblTipoDoc=new TblTipoDoc();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblTipoDoc=new ModeloTblTipoDoc().listarTblTipoDoc();
	}
	public void seleccionar(){
		tblTipoDoc=(TblTipoDoc)dtFila.getRowData();
	}
	public TblTipoDoc getTblTipoDoc() {
		return tblTipoDoc;
	}
	public void setTblTipoDoc(TblTipoDoc tblTipoDoc) {
		this.tblTipoDoc = tblTipoDoc;
	}
	public List<TblTipoDoc> getListadoTblTipoDoc() {
		return listadoTblTipoDoc;
	}
	public void setListadoTblTipoDoc(List<TblTipoDoc> listadoTblTipoDoc) {
		this.listadoTblTipoDoc = listadoTblTipoDoc;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
	
}
