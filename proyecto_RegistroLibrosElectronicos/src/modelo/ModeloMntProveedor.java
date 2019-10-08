package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.MntProveedor;
import entity.TblCondPago;
import entity.TblTipoPer;
import entity.TblTipoPro;

public class ModeloMntProveedor {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<MntProveedor>listarProveedor(){
		EntityManager manager=factory.createEntityManager();
		List<MntProveedor>listadoProveedor=new ArrayList<>();
		TypedQuery<MntProveedor>resultado=null;
		try {
			String hql="Select p from MntProveedor p";
			resultado=manager.createQuery(hql,MntProveedor.class);
			listadoProveedor=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoProveedor;
	}	
	
	public List<TblTipoPer>listarTipoPersona(TblTipoPer tblTipoPer){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPer>listadoTipoPersona=new ArrayList<>();
		TypedQuery<TblTipoPer>resultado=null;
		try {
			String hql="Select tp from TblTipoPer tp where tp.cod_cli.cod_pe=?1";
			resultado=manager.createQuery(hql,TblTipoPer.class);
			resultado.setParameter(1, tblTipoPer.getCodigo());
			listadoTipoPersona=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTipoPersona;
		}
	
	public List<TblCondPago>listarCondicionPago(TblCondPago tblCondPago){
		EntityManager manager=factory.createEntityManager();
		List<TblCondPago>listadoCondicionPago=new ArrayList<>();
		TypedQuery<TblCondPago>resultado=null;
		try {
			String hql="Select cp TblCondPago cp.codigo.condicionPago=?1";
			resultado=manager.createQuery(hql,TblCondPago.class);
			resultado.setParameter(1, tblCondPago.getCodigo());
			listadoCondicionPago=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoCondicionPago;
  }
	

	public List<TblTipoPro>listarTipoProveedor(TblTipoPro tblTipoPro){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPro>listadoTipoProveedor=new ArrayList<>();
		TypedQuery<TblTipoPro>resultado=null;
		try {
			String hql="Select tp TblTipoPro tp.codigo.condicionPago=?1";
			resultado=manager.createQuery(hql,TblTipoPro.class);
			resultado.setParameter(1, tblTipoPro.getCodigo());
			listadoTipoProveedor=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTipoProveedor;
  }
	
	
}