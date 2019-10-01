package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TblPeriodoContable;

public class ModeloTblPeriodoContable {

	
EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblPeriodoContable>listarTblPeriodoContable(){
		EntityManager manager=factory.createEntityManager();
		List<TblPeriodoContable>listadoTblPeriodoContable=new ArrayList<>();
		TypedQuery<TblPeriodoContable>resultado=null;
		try {
			String hql="Select p from TblPeriodoContable p";
			resultado=manager.createQuery(hql,TblPeriodoContable.class);
			listadoTblPeriodoContable=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblPeriodoContable;
	}
	
	public void insertarTblPeriodoContable(TblPeriodoContable tblPeriodoContable){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblPeriodoContable, manager);
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
	
	public void actualizarTblPeriodoContable(TblPeriodoContable tblPeriodoContable) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblPeriodoContable);
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
	
	public void eliminarTblPeriodoContable(String tblPeriodoContable){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblPeriodoContable periodoContable=manager.find(TblPeriodoContable.class, tblPeriodoContable);
					manager.getTransaction().begin();
					manager.remove(periodoContable);
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


	private void insertarSql(TblPeriodoContable tblPeriodoContable, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into periodocontable (cod_periodo, des_periodo) " +
	            " values (?, ?)");
	        query.setParameter(1, tblPeriodoContable.getCodPerdiodo());
	        query.setParameter(2, tblPeriodoContable.getDesPeriodo());
	        query.executeUpdate();
	}
	
	
}
