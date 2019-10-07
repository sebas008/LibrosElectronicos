package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.MntCliente;
import entity.TblCondPago;
import entity.TblTipoCli;
import entity.TblTipoPer;

public class ModeloMntCliente {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<MntCliente>listarCliente(){
		EntityManager manager=factory.createEntityManager();
		List<MntCliente>listadoCliente=new ArrayList<>();
		TypedQuery<MntCliente>resultado=null;
		try {
			String hql="Select c from MntCliente c";
			resultado=manager.createQuery(hql,MntCliente.class);
			listadoCliente=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoCliente;
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
	public List<TblTipoCli>listarTipoCliente(TblTipoCli tblTipoCli){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoCli>listadoTipoCliente=new ArrayList<>();
		TypedQuery<TblTipoCli>resultado=null;
		try {
			String hql="Select tc from TblTipoCli tc where tc.codigo.tipo_cli=?1";
			resultado=manager.createQuery(hql,TblTipoCli.class);
			resultado.setParameter(1, tblTipoCli.getCodigo());
			listadoTipoCliente=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTipoCliente;
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

	
	public void insertarSede(MntCliente cliente){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(cliente, manager);
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
	public void actualizarSede(MntCliente cliente) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(cliente);
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
		public void eliminarMntCliente(String mntCliente){
			EntityManager manager=factory.createEntityManager();
					
					try {
						MntCliente cliente=manager.find(MntCliente.class, mntCliente);
						manager.getTransaction().begin();
						manager.remove(cliente);
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
	
	public void insertarSql(MntCliente mntCliente, EntityManager entityManager){
		Query query = entityManager.createNativeQuery("insert into cliente (cod_pe, cod_cli, razonS_cli, direc_cli, tipo_cli, contacto_cli, telefono_cli, condicionPago, correo_cli) " +
	            " values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        query.setParameter(1, mntCliente.getTblTipoPer().getCodigo());
	        query.setParameter(2, mntCliente.getCodigo());
	        query.setParameter(3, mntCliente.getRazonSocial());
	        query.setParameter(4, mntCliente.getDireccion());
	        query.setParameter(5, mntCliente.getTblTipoCli().getCodigo());
	        query.setParameter(6, mntCliente.getContacto());
	        query.setParameter(6, mntCliente.getTelefono());
	        query.setParameter(6, mntCliente.getTblCondPago().getCodigo());
	        query.setParameter(6, mntCliente.getCorreo());
	        query.executeUpdate();
	}

}
