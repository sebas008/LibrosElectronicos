package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoRet;
import modelo.ModeloTblTipoRet;

@ManagedBean(name="tblTipoRetController")
@ViewScoped
public class TblTipoRetController {

	private TblTipoRet tblTipoRet;
	private List<TblTipoRet>listadoTblTipoRet;
	private UIData dtFila;
	
	@PostConstruct
	public void init(){
		tblTipoRet=new TblTipoRet();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblTipoRet=new ModeloTblTipoRet().listarTblTipoRet();
	}
	public void seleccionar(){
		tblTipoRet=(TblTipoRet)dtFila.getRowData();
	}
	public TblTipoRet getTblTipoRet() {
		return tblTipoRet;
	}
	public void setTblTipoRet(TblTipoRet tblTipoRet) {
		this.tblTipoRet = tblTipoRet;
	}
	public List<TblTipoRet> getListadoTblTipoRet() {
		return listadoTblTipoRet;
	}
	public void setListadoTblTipoRet(List<TblTipoRet> listadoTblTipoRet) {
		this.listadoTblTipoRet = listadoTblTipoRet;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
	
	public void registrarTipoRetencion() {
		tblTipoRet.getCodigo();
		new ModeloTblTipoRet().insertarTblTipoRet(tblTipoRet);
		cargarTable();
	}
	
	public void actualizarTipoRetencion() {
		tblTipoRet.getCodigo();
		new ModeloTblTipoRet().actualizarTblTipoRet(tblTipoRet);
		cargarTable();
	}
	
	public void eliminarTipoRetencion() {
		new ModeloTblTipoRet().eliminarTblTipoRet(tblTipoRet.getCodigo());
		cargarTable();
	}
	
	
}
