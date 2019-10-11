package entity;

public class ClFacturaVentaID {

	private String serieDoc;	
	private String numDoc;	
	private MntCliente mntCliente;
	public String getSerieDoc() {
		return serieDoc;
	}
	public void setSerieDoc(String serieDoc) {
		this.serieDoc = serieDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public MntCliente getMntCliente() {
		return mntCliente;
	}
	public void setMntCliente(MntCliente mntCliente) {
		this.mntCliente = mntCliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mntCliente == null) ? 0 : mntCliente.hashCode());
		result = prime * result + ((numDoc == null) ? 0 : numDoc.hashCode());
		result = prime * result + ((serieDoc == null) ? 0 : serieDoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClFacturaVentaID other = (ClFacturaVentaID) obj;
		if (mntCliente == null) {
			if (other.mntCliente != null)
				return false;
		} else if (!mntCliente.equals(other.mntCliente))
			return false;
		if (numDoc == null) {
			if (other.numDoc != null)
				return false;
		} else if (!numDoc.equals(other.numDoc))
			return false;
		if (serieDoc == null) {
			if (other.serieDoc != null)
				return false;
		} else if (!serieDoc.equals(other.serieDoc))
			return false;
		return true;
	}

	
	
	
	
}
