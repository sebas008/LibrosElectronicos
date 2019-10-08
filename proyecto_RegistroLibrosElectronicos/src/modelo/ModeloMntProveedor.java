package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
		String hql="Select p from MntProveedor p";
		try {
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
	
	public List<TblTipoPer>listarTipoPersona(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPer>listadoTipoPersona=new ArrayList<>();
		TypedQuery<TblTipoPer>resultado=null;
		String hql="Select tp from TblTipoPer tp where tp.cod_cli.cod_pe=?1";
		try {
			resultado=manager.createQuery(hql,TblTipoPer.class);
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
	
	public List<TblCondPago>listarCondicionPago(){
		EntityManager manager=factory.createEntityManager();
		List<TblCondPago>listadoCondicionPago=new ArrayList<>();
		TypedQuery<TblCondPago>resultado=null;
		String hql="Select cp TblCondPago cp.codigo.condicionPago=?1";
		try {
			resultado=manager.createQuery(hql,TblCondPago.class);
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
	

	public List<TblTipoPro>listarTipoProveedor(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPro>listadoTipoProveedor=new ArrayList<>();
		TypedQuery<TblTipoPro>resultado=null;
		String hql="Select tp TblTipoPro tp.codigo.condicionPago=?1";
		try {		
			resultado=manager.createQuery(hql,TblTipoPro.class);
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
	
	
	public void insertarProveedor(MntProveedor mntProveedor){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(mntProveedor, manager);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally{
			manager.close();
			factory.close();
		}
	}
	public void actualizarProveedor(MntProveedor mntProveedor) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(mntProveedor);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			manager.close();
			factory.close();
		}
	}
		public void eliminarProveedor(String mntProveedor){
			EntityManager manager=factory.createEntityManager();
					
					try {
						MntProveedor proveedor=manager.find(MntProveedor.class, mntProveedor);
						manager.getTransaction().begin();
						manager.remove(proveedor);
						manager.getTransaction().commit();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						manager.getTransaction().rollback();
						System.out.println(e.getMessage());
					}finally{
						manager.close();
						factory.close();
					}
			
	}
	
	public void insertarSql(MntProveedor mntProveedor, EntityManager entityManager){
		Query query = entityManager.createNativeQuery("insert into proveedor (cod_pe, cod_pro, razonS_pro, direc_pro, tipo_prov, contacto_prov, telefono_prov, condicionPago, correo_prov) " +
	            " values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        query.setParameter(1, mntProveedor.getTblTipoPer().getCodigo());
	        query.setParameter(2, mntProveedor.getCodigo());
	        query.setParameter(3, mntProveedor.getRazonSocial());
	        query.setParameter(4, mntProveedor.getDireccion());
	        query.setParameter(5, mntProveedor.getTblTipoPer().getCodigo());
	        query.setParameter(6, mntProveedor.getContacto());
	        query.setParameter(6, mntProveedor.getTelefono());
	        query.setParameter(6, mntProveedor.getTblCondPago().getCodigo());
	        query.setParameter(6, mntProveedor.getCorreo());
	        query.executeUpdate();
	}
	
}