package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.ClFacturaCompra;
import entity.ClFacturaCompraID;
import entity.MntProveedor;
import modelo.ModeloClFacturaCompra;


@ManagedBean(name="clFacturaCompraController")
@ViewScoped
public class ClFacturaCompraController {

	private ClFacturaCompra clFacturaCompra;
	private List<ClFacturaCompra>listadoFacturaCompra;
	private List<MntProveedor>listadoProveedor;
	private UIData dtTable;
	
	@PostConstruct
	public void init() {
		cargarFacturaCompra();
		cargarProveedor();
	}
	
	private void cargarFacturaCompra() {
		// TODO Auto-generated method stub
		listadoFacturaCompra=new ModeloClFacturaCompra().listarFacturaCompra(clFacturaCompra.getId().getMntProveedor());
	}


	private void cargarProveedor() {
		// TODO Auto-generated method stub
		listadoProveedor=new ModeloClFacturaCompra().listarProveedor();
	}
	
	public void seleccionar() {
		clFacturaCompra=(ClFacturaCompra)dtTable.getRowData();
	}

	public void actualizarFacturaCompra() {
		new ModeloClFacturaCompra().actualizarFacturaCompra(clFacturaCompra);
		cargarFacturaCompra();
	}

	public void insertarFacturaCompra() {
		new ModeloClFacturaCompra().insertarFacturaCompra(clFacturaCompra);
		cargarFacturaCompra();
	}
	
	
	public void eliminarFacturaCompra() {
		new ModeloClFacturaCompra().eliminarFacturaCompra(clFacturaCompra.getId().toString());
		cargarFacturaCompra();
	}	
	

	public void nuevoCliente() {
		clFacturaCompra=new ClFacturaCompra();
		ClFacturaCompra clFacturaCompra=new ClFacturaCompra();
		ClFacturaCompraID id=new ClFacturaCompraID();
		id.setMntProveedor(null);
		clFacturaCompra.setId(id);
		

	}

	public ClFacturaCompra getClFacturaCompra() {
		return clFacturaCompra;
	}

	public void setClFacturaCompra(ClFacturaCompra clFacturaCompra) {
		this.clFacturaCompra = clFacturaCompra;
	}

	public List<ClFacturaCompra> getListadoFacturaCompra() {
		return listadoFacturaCompra;
	}

	public void setListadoFacturaCompra(List<ClFacturaCompra> listadoFacturaCompra) {
		this.listadoFacturaCompra = listadoFacturaCompra;
	}

	public List<MntProveedor> getListadoProveedor() {
		return listadoProveedor;
	}

	public void setListadoProveedor(List<MntProveedor> listadoProveedor) {
		this.listadoProveedor = listadoProveedor;
	}

	public UIData getDtTable() {
		return dtTable;
	}

	public void setDtTable(UIData dtTable) {
		this.dtTable = dtTable;
	}
	
	
	

	
}
