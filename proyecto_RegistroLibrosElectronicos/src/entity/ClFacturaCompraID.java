package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class ClFacturaCompraID implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serieDoc; 
	private String numDoc; 
	private String cod_Pro;
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
	public String getCod_Pro() {
		return cod_Pro;
	}
	public void setCod_Pro(String cod_Pro) {
		this.cod_Pro = cod_Pro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_Pro == null) ? 0 : cod_Pro.hashCode());
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
		ClFacturaCompraID other = (ClFacturaCompraID) obj;
		if (cod_Pro == null) {
			if (other.cod_Pro != null)
				return false;
		} else if (!cod_Pro.equals(other.cod_Pro))
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
