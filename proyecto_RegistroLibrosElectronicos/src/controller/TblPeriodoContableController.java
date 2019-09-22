package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblPeriodoContable;
import modelo.ModeloTblPeriodoContable;

@ManagedBean(name="tblPeriodoContableController")
@ViewScoped
public class TblPeriodoContableController {

	private TblPeriodoContable tblPeriodoContable;
	private List<TblPeriodoContable>listadoTblPeriodoContable;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		tblPeriodoContable=new TblPeriodoContable();
		cargarTable();
	}
	public void cargarTable(){
		listadoTblPeriodoContable=new ModeloTblPeriodoContable().listarTblPeriodoContable();
	}
	public void seleccionar(){
		tblPeriodoContable=(TblPeriodoContable)dtFila.getRowData();
	}
	public TblPeriodoContable getTblPeriodoContable() {
		return tblPeriodoContable;
	}
	public void setTblPeriodoContable(TblPeriodoContable tblPeriodoContable) {
		this.tblPeriodoContable = tblPeriodoContable;
	}
	public List<TblPeriodoContable> getListadoTblPeriodoContable() {
		return listadoTblPeriodoContable;
	}
	public void setListadoTblPeriodoContable(List<TblPeriodoContable> listadoTblPeriodoContable) {
		this.listadoTblPeriodoContable = listadoTblPeriodoContable;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	
	
}
