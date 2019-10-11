package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipocambio")
public class MntTipoCambio {

	@Id
	private String fecha;
	private double compra;
	private double venta;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

}
