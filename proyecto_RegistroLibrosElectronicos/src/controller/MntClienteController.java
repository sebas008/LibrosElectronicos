package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.MntCliente;
import entity.TblCondPago;
import entity.TblTipoCli;
import entity.TblTipoPer;
import modelo.ModeloMntCliente;

@ManagedBean(name="mntClienteController")
@ViewScoped
public class MntClienteController {

	private MntCliente mntCliente;
	private List<TblTipoPer>listadoTipoPersona;
	private List<MntCliente>listadoCliente;
	private List<TblCondPago>listadoCondicionPago;
	private List<TblTipoCli>listadoTipoCliente;
	private UIData dtTable;
	
	@PostConstruct
	public void init() {
		cargarCondicionPago();
		cargarTipoPersona();
		cargarTipoCliente();
		cargarCliente();
	}


	private void cargarTipoPersona() {
		// TODO Auto-generated method stub
		listadoTipoPersona=new ModeloMntCliente().listarTipoPersona();
	}


	private void cargarCondicionPago() {
		// TODO Auto-generated method stub
		listadoCondicionPago=new ModeloMntCliente().listarCondicionPago();
	}

	private void cargarTipoCliente() {
		// TODO Auto-generated method stub
		listadoTipoCliente=new ModeloMntCliente().listarTipoCliente();
	}
	
	private void cargarCliente() {
		// TODO Auto-generated method stub
		listadoCliente=new ModeloMntCliente().listarCliente();
	}
	
	public void seleccionar() {
		mntCliente=(MntCliente)dtTable.getRowData();
	}

	public void actualizarCliente() {
		new ModeloMntCliente().actualizarCliente(mntCliente);
		cargarCliente();
	}

	public void insertarCliente() {
		new ModeloMntCliente().insertarCliente(mntCliente);
		cargarCliente();
	}
	
	
	public void eliminarCliente() {
		new ModeloMntCliente().eliminarCliente(mntCliente.getCodigo());
		cargarCliente();
	}	
	

	public void nuevoCliente() {
		mntCliente=new MntCliente();
		TblCondPago tblCondPago=new TblCondPago();
		TblTipoCli tblTipoCli=new TblTipoCli();
		TblTipoPer tblTipoPer=new TblTipoPer();
		mntCliente.setTblCondPago(tblCondPago);
		mntCliente.setTblTipoCli(tblTipoCli);
		mntCliente.setTblTipoPer(tblTipoPer);
	}


	public MntCliente getMntCliente() {
		return mntCliente;
	}


	public void setMntCliente(MntCliente mntCliente) {
		this.mntCliente = mntCliente;
	}


	public List<TblTipoPer> getListadoTipoPersona() {
		return listadoTipoPersona;
	}


	public void setListadoTipoPersona(List<TblTipoPer> listadoTipoPersona) {
		this.listadoTipoPersona = listadoTipoPersona;
	}


	public List<MntCliente> getListadoCliente() {
		return listadoCliente;
	}


	public void setListadoCliente(List<MntCliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}


	public List<TblCondPago> getListadoCondicionPago() {
		return listadoCondicionPago;
	}


	public void setListadoCondicionPago(List<TblCondPago> listadoCondicionPago) {
		this.listadoCondicionPago = listadoCondicionPago;
	}


	public List<TblTipoCli> getListadoTipoCliente() {
		return listadoTipoCliente;
	}


	public void setListadoTipoCliente(List<TblTipoCli> listadoTipoCliente) {
		this.listadoTipoCliente = listadoTipoCliente;
	}


	public UIData getDtTable() {
		return dtTable;
	}


	public void setDtTable(UIData dtTable) {
		this.dtTable = dtTable;
	}
	
	
}
