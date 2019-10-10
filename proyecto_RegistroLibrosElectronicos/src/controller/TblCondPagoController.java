package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblCondPago;

@ManagedBean(name="tblCondPagoController")
@ViewScoped
public class TblCondPagoController {
	
	
	private TblCondPago tblCondPago;
	private List<TblCondPago>listarTblCondPago;
	private UIData dtFila;
	
	
	public void init() {
		
		tblCondPago = new TblCondPago();
		//cargarTable();
		
	}
	
	
	
	
	

}
