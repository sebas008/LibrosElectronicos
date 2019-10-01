package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TblTipoPer;


public class ModeloTblTipoPer {

EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoPer>listarTblTipoPer(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPer>listadoTblTipoPer=new ArrayList<>();
		TypedQuery<TblTipoPer>resultado=null;
		try {
			String hql="Select tp from TblTipoPer tp";
			resultado=manager.createQuery(hql,TblTipoPer.class);
			listadoTblTipoPer=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoPer;
	}
	
	public void insertarTblTipoPer(TblTipoPer tblTipoPer){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoPer, manager);
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
	
	public void actualizarTblTipoPer(TblTipoPer tblTipoPer) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoPer);
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
	
	public void eliminarTblTipoPer(String tblTipoPer){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoPer tipoPersona=manager.find(TblTipoPer.class, tblTipoPer);
					manager.getTransaction().begin();
					manager.remove(tipoPersona);
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

	private void insertarSql(TblTipoPer tblTipoPer, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tipopersona (cod_pe, des_pe) " +
	            " values (?, ?)");
	        query.setParameter(1, tblTipoPer.getCodigo());
	        query.setParameter(2, tblTipoPer.getDescripcion());
	        query.executeUpdate();
	}
	
	
}
