package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.ClFacturaVentaID;
import entity.ClFacturaVenta;
import entity.MntCliente;
import modelo.ModeloClFacturaVenta;

@ManagedBean(name="clFacturaVentaController")
@ViewScoped
public class ClFacturaVentaController {

	private ClFacturaVenta clFacturaVenta;
	private List<ClFacturaVenta>listadoFacturaVenta;
	private List<MntCliente>listadoCliente;
	private UIData dtTable;
	
	@PostConstruct
	public void init() {
		cargarFacturaCompra();
		cargarProveedor();
	}
	
	private void cargarFacturaCompra() {
		// TODO Auto-generated method stub
		listadoFacturaVenta=new ModeloClFacturaVenta().listarFacturaVenta(clFacturaVenta.getId().getMntCliente());
	}


	private void cargarProveedor() {
		// TODO Auto-generated method stub
		listadoCliente=new ModeloClFacturaVenta().listarCliente();
	}
	
	public void seleccionar() {
		clFacturaVenta=(ClFacturaVenta)dtTable.getRowData();
	}

	public void actualizarFacturaCompra() {
		new ModeloClFacturaVenta().actualizarFacturaVenta(clFacturaVenta);
		cargarFacturaCompra();
	}

	public void insertarFacturaCompra() {
		new ModeloClFacturaVenta().insertarFacturaVenta(clFacturaVenta);
		cargarFacturaCompra();
	}
	
	
	public void eliminarFacturaCompra() {
		new ModeloClFacturaVenta().eliminarFacturaVenta(clFacturaVenta.getId().toString());
		cargarFacturaCompra();
	}	
	

	public void nuevoCliente() {
		clFacturaVenta=new ClFacturaVenta();
		ClFacturaVenta clFacturaVenta=new ClFacturaVenta();
		ClFacturaVentaID id=new ClFacturaVentaID();
		id.setMntCliente(null);
		clFacturaVenta.setId(id);
		

	}

	public ClFacturaVenta getClFacturaVenta() {
		return clFacturaVenta;
	}

	public void setClFacturaVenta(ClFacturaVenta clFacturaVenta) {
		this.clFacturaVenta = clFacturaVenta;
	}

	public List<ClFacturaVenta> getListadoFacturaVenta() {
		return listadoFacturaVenta;
	}

	public void setListadoFacturaVenta(List<ClFacturaVenta> listadoFacturaVenta) {
		this.listadoFacturaVenta = listadoFacturaVenta;
	}

	public List<MntCliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(List<MntCliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public UIData getDtTable() {
		return dtTable;
	}

	public void setDtTable(UIData dtTable) {
		this.dtTable = dtTable;
	}

	
	
	
}
