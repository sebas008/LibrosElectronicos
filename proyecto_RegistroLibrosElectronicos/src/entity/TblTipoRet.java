package entity;

public class TblTipoRet {

	private String codigo, descripcion;
	private int tasa;
	private double valor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTasa() {
		return tasa;
	}

	public void setTasa(int tasa) {
		this.tasa = tasa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
