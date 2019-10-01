package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TblTipoCli;

public class ModeloTblTipoCli {

	
EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoCli>listarTblTipoCli(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoCli>listadoTblTipoCli=new ArrayList<>();
		TypedQuery<TblTipoCli>resultado=null;
		try {
			String hql="Select tc from TblTipoCli tc";
			resultado=manager.createQuery(hql,TblTipoCli.class);
			listadoTblTipoCli=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoCli;
	}
	
	public void insertarTblTipoCli(TblTipoCli tblTipoCli){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoCli, manager);
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
	
	public void actualizarTblTipoCli(TblTipoCli tblTipoCli) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoCli);
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
	
	public void eliminarTblTipoCli(String tblTipoCli){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoCli tipoCliente=manager.find(TblTipoCli.class, tblTipoCli);
					manager.getTransaction().begin();
					manager.remove(tipoCliente);
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

	private void insertarSql(TblTipoCli tblTipoCli, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tipocliente (cod_tc, des_tc) " +
	            " values (?, ?)");
	        query.setParameter(1, tblTipoCli.getCodigo());
	        query.setParameter(2, tblTipoCli.getDescripcion());
	        query.executeUpdate();
	}
	
	
	
}
