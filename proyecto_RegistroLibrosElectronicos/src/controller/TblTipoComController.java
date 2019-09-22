package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoCom;
import modelo.ModeloTblTipoCom;

@ManagedBean(name="tblTipoComController")
@ViewScoped
public class TblTipoComController {

	private TblTipoCom tblTipoCom;
	private List<TblTipoCom>listadoTblTipoCom;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		tblTipoCom=new TblTipoCom();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblTipoCom=new ModeloTblTipoCom().listarTblTipoCom();
	}
	public void seleccionar(){
		tblTipoCom=(TblTipoCom)dtFila.getRowData();
		
		
	}
	public TblTipoCom getTblTipoCom() {
		return tblTipoCom;
	}
	public void setTblTipoCom(TblTipoCom tblTipoCom) {
		this.tblTipoCom = tblTipoCom;
	}
	public List<TblTipoCom> getListadoTblTipoCom() {
		return listadoTblTipoCom;
	}
	public void setListadoTblTipoCom(List<TblTipoCom> listadoTblTipoCom) {
		this.listadoTblTipoCom = listadoTblTipoCom;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
}
