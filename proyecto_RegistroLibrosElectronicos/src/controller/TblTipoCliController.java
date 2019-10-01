package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.TblTipoCli;
import modelo.ModeloTblTipoCli;

@ManagedBean(name="tblTipoCliController")
@ViewScoped
public class TblTipoCliController {


		private TblTipoCli tblTipoCli;
		private List<TblTipoCli>listadoTblTipoCli;
		private UIData dtFila;
		@PostConstruct
		public void init(){
			tblTipoCli=new TblTipoCli();
			cargarTable();
		}
		public void cargarTable(){
			listadoTblTipoCli=new ModeloTblTipoCli().listarTblTipoCli();
		}
		public void seleccionar(){
			tblTipoCli=(TblTipoCli)dtFila.getRowData();
		}
		public TblTipoCli getTblTipoCli() {
			return tblTipoCli;
		}
		public void setTblTipoCli(TblTipoCli tblTipoCli) {
			this.tblTipoCli = tblTipoCli;
		}
		public List<TblTipoCli> getListadoTblTipoCli() {
			return listadoTblTipoCli;
		}
		public void setListadoTblTipoCli(List<TblTipoCli> listadoTblTipoCli) {
			this.listadoTblTipoCli = listadoTblTipoCli;
		}
		public UIData getDtFila() {
			return dtFila;
		}
		public void setDtFila(UIData dtFila) {
			this.dtFila = dtFila;
		}
		
		public void registrarTipoCliente() {
			tblTipoCli.getCodigo();
			new ModeloTblTipoCli().insertarTblTipoCli(tblTipoCli);
			cargarTable();
		}
		
		public void actualizarTipoCliente() {
			tblTipoCli.getCodigo();
			new ModeloTblTipoCli().actualizarTblTipoCli(tblTipoCli);
			cargarTable();
		}
		
}
