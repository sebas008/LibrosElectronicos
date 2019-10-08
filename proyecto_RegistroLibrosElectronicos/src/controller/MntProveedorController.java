package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.MntProveedor;
import entity.TblCondPago;
import entity.TblTipoPro;
import entity.TblTipoPer;
import modelo.ModeloMntCliente;
import modelo.ModeloMntProveedor;

@ManagedBean(name="mntProveedorController")
@ViewScoped
public class MntProveedorController {

	private MntProveedor mntProveedor;
	private List<TblTipoPer>listadoTipoPersona;
	private List<MntProveedor>listadoProveedor;
	private List<TblCondPago>listadoCondicionPago;
	private List<TblTipoPro>listadoTipoProveedor;
	private UIData dtTable;
	
	@PostConstruct
	public void init() {
		cargarCondicionPago();
		cargarTipoPersona();
		cargarTipoProveedor();
		cargarProveedor();
	}


	private void cargarTipoPersona() {
		// TODO Auto-generated method stub
		listadoTipoPersona=new ModeloMntCliente().listarTipoPersona();
	}


	private void cargarCondicionPago() {
		// TODO Auto-generated method stub
		listadoCondicionPago=new ModeloMntCliente().listarCondicionPago();
	}

	private void cargarTipoProveedor() {
		// TODO Auto-generated method stub
		listadoTipoProveedor=new ModeloMntProveedor().listarTipoProveedor();
	}
	
	private void cargarProveedor() {
		// TODO Auto-generated method stub
		listadoProveedor=new ModeloMntProveedor().listarProveedor();
	}
	
	public void seleccionar() {
		mntProveedor=(MntProveedor)dtTable.getRowData();
	}

	public void actualizarProveedor() {
		new ModeloMntProveedor().actualizarProveedor(mntProveedor);
		cargarProveedor();
	}

	public void insertarProveedor() {
		new ModeloMntProveedor().insertarProveedor(mntProveedor);
		cargarProveedor();
	}
	
	
	public void eliminarProveedor() {
		new ModeloMntProveedor().eliminarProveedor(mntProveedor.getCodigo());
		cargarProveedor();
	}	
	

	public void nuevoProveedor() {
		mntProveedor=new MntProveedor();
		TblCondPago tblCondPago=new TblCondPago();
		TblTipoPro tblTipoPro=new TblTipoPro();
		TblTipoPer tblTipoPer=new TblTipoPer();
		mntProveedor.setTblCondPago(tblCondPago);
		mntProveedor.setTblTipoPro(tblTipoPro);
		mntProveedor.setTblTipoPer(tblTipoPer);
	}


	public MntProveedor getMntProveedor() {
		return mntProveedor;
	}


	public void setMntProveedor(MntProveedor mntProveedor) {
		this.mntProveedor = mntProveedor;
	}


	public List<TblTipoPer> getListadoTipoPersona() {
		return listadoTipoPersona;
	}


	public void setListadoTipoPersona(List<TblTipoPer> listadoTipoPersona) {
		this.listadoTipoPersona = listadoTipoPersona;
	}


	public List<MntProveedor> getListadoProveedor() {
		return listadoProveedor;
	}


	public void setListadoProveedor(List<MntProveedor> listadoProveedor) {
		this.listadoProveedor = listadoProveedor;
	}


	public List<TblCondPago> getListadoCondicionPago() {
		return listadoCondicionPago;
	}


	public void setListadoCondicionPago(List<TblCondPago> listadoCondicionPago) {
		this.listadoCondicionPago = listadoCondicionPago;
	}


	public List<TblTipoPro> getListadoTipoProveedor() {
		return listadoTipoProveedor;
	}


	public void setListadoTipoProveedor(List<TblTipoPro> listadoTipoProveedor) {
		this.listadoTipoProveedor = listadoTipoProveedor;
	}


	public UIData getDtTable() {
		return dtTable;
	}


	public void setDtTable(UIData dtTable) {
		this.dtTable = dtTable;
	}
	
	
	
	
	
}
