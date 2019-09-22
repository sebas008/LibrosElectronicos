package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoPro;
import modelo.ModeloTblTipoPro;

@ManagedBean(name="tblTipoProController")
@ViewScoped
public class TblTipoProController {

	private TblTipoPro tblTipoPro;
	private List<TblTipoPro>listadoTblTipoPro;
	private UIData dtFila;
	
	@PostConstruct
	public void init(){
		tblTipoPro=new TblTipoPro();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblTipoPro=new ModeloTblTipoPro().listarTblTipoPro();
	}
	public void seleccionar(){
		tblTipoPro=(TblTipoPro)dtFila.getRowData();
	}
	public TblTipoPro getTblTipoPro() {
		return tblTipoPro;
	}
	public void setTblTipoPro(TblTipoPro tblTipoPro) {
		this.tblTipoPro = tblTipoPro;
	}
	public List<TblTipoPro> getListadoTblTipoPro() {
		return listadoTblTipoPro;
	}
	public void setListadoTblTipoPro(List<TblTipoPro> listadoTblTipoPro) {
		this.listadoTblTipoPro = listadoTblTipoPro;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
}
