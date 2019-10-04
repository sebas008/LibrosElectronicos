package entity;

public class ClFacturaVentaID {

	private String serieDoc;	
	private String numDoc;	
	private String cod_Cli;
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
	public String getCod_Cli() {
		return cod_Cli;
	}
	public void setCod_Cli(String cod_Cli) {
		this.cod_Cli = cod_Cli;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_Cli == null) ? 0 : cod_Cli.hashCode());
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
		if (cod_Cli == null) {
			if (other.cod_Cli != null)
				return false;
		} else if (!cod_Cli.equals(other.cod_Cli))
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
