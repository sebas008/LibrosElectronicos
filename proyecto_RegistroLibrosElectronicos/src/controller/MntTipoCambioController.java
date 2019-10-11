package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import entity.MntTipoCambio;
import modelo.ModeloMntTipoCambio;


@ManagedBean(name="mntTipoCambioController")
@ViewScoped
public class MntTipoCambioController {
	
	private MntTipoCambio mntTipoCambio;
	private List<MntTipoCambio>listadoTipoCambio;
	private UIData dtFila;

	
	@PostConstruct
	
	public void init(){
		mntTipoCambio  =new MntTipoCambio();
		cargarTable();
	}
	
	public MntTipoCambio getMntTipoCambio() {
		return mntTipoCambio;
	}
	public void setMntTipoCambio(MntTipoCambio mntTipoCambio) {
		this.mntTipoCambio = mntTipoCambio;
	}
	public List<MntTipoCambio> getListadoTipoCambio() {
		return listadoTipoCambio;
	}
	public void setListadoTipoCambio(List<MntTipoCambio> listadoTipoCambio) {
		this.listadoTipoCambio = listadoTipoCambio;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	public void registrarTipoCambio() {
		
		mntTipoCambio.getCompra();
		new ModeloMntTipoCambio().insertarTipoCambio(mntTipoCambio);
	    cargarTable();
	}
	
	public void cargarTable(){
		listadoTipoCambio = new ModeloMntTipoCambio().listarTipoCambio();
	}
	
	public void eliminarTipoCambio() {
		
		
		mntTipoCambio.getCompra();
		
		
	}
	
	
	
}
