package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TblMoneda;

public class ModeloTblMoneda {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblMoneda>listarTblMoneda(){
		EntityManager manager=factory.createEntityManager();
		List<TblMoneda>listadoTblMoneda=new ArrayList<>();
		TypedQuery<TblMoneda>resultado=null;
		try {
			String hql="Select m from TblMoneda m";
			resultado=manager.createQuery(hql,TblMoneda.class);
			listadoTblMoneda=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblMoneda;
	}
	
	public void insertarTblMoneda(TblMoneda tblMoneda){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblMoneda, manager);
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
	
	public void actualizarTblMoneda(TblMoneda tblMoneda) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblMoneda);
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

	private void insertarSql(TblMoneda tblMoneda, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into moneda (cod_mo, des_mo) " +
	            " values (?, ?)");
	        query.setParameter(1, tblMoneda.getCodigo());
	        query.setParameter(2, tblMoneda.getDescripcion());
	        query.executeUpdate();
	}

}
