package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblEstadoDoc;
import modelo.ModeloTblEstadoDoc;

@ManagedBean(name="tblEstadoDocController")
@ViewScoped
public class TblEstadoDocController {

	private TblEstadoDoc tblEstadoDoc;
	private List<TblEstadoDoc>listadoTblEstadoDoc;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		tblEstadoDoc=new TblEstadoDoc();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblEstadoDoc=new ModeloTblEstadoDoc().listarTblEstadoDoc();
	}
	public void seleccionar(){
		tblEstadoDoc=(TblEstadoDoc)dtFila.getRowData();
	}
	public TblEstadoDoc getTblEstadoDoc() {
		return tblEstadoDoc;
	}
	public void setTblEstadoDoc(TblEstadoDoc tblEstadoDoc) {
		this.tblEstadoDoc = tblEstadoDoc;
	}
	public List<TblEstadoDoc> getListadoTblEstadoDoc() {
		return listadoTblEstadoDoc;
	}
	public void setListadoTblEstadoDoc(List<TblEstadoDoc> listadoTblEstadoDoc) {
		this.listadoTblEstadoDoc = listadoTblEstadoDoc;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	public void registrarTblEstadoDoc() {
		tblEstadoDoc.getCodigo();
		new ModeloTblEstadoDoc().insetarTblEstadoDoc(tblEstadoDoc);
		cargarTable();
	}
	
	public void actualizarTblEstadoDoc() {
		tblEstadoDoc.getCodigo();
		new ModeloTblEstadoDoc().actualizarTblEstadoDoc(tblEstadoDoc);
		cargarTable();
	}
	
	public void eliminarTblEstadoDoc() {
		new ModeloTblEstadoDoc().eliminarTblEstadoDoc(tblEstadoDoc.getCodigo());
		cargarTable();
	}	
	
	
}
