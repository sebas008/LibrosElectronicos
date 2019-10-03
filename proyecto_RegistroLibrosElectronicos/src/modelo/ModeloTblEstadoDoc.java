package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.faces.util.Cache.Factory;

import entity.TblEstadoDoc;


public class ModeloTblEstadoDoc {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");
	
	
	public List<TblEstadoDoc>listarTblEstadoDoc(){
		
		EntityManager manager = factory.createEntityManager();
		List<TblEstadoDoc> listadoTblEstadoDoc = new ArrayList<>();
		TypedQuery<TblEstadoDoc> resultado = null;
		
		try {
			
			String hql = "select e from TblEstadoDoc e";
			resultado = manager.createQuery(hql,TblEstadoDoc.class);
			listadoTblEstadoDoc = resultado.getResultList();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			manager.close();
			factory.close();
		}
		
		return listadoTblEstadoDoc;
	}
	
	
	
	public void insetarTblEstadoDoc(TblEstadoDoc tblEstadoDoc) {
		
		
		EntityManager manager = factory.createEntityManager();
		
		
		try {
			//iniciar la transacion
			manager.getTransaction().begin();
			
			insertarSql(tblEstadoDoc,manager);
			manager.getTransaction().commit();
			
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			
			System.out.println(e.getMessage());
		}finally {
			
			
			manager.close();
			factory.close();
		}
		
		
		
	}
	
	

	jj
	
	
	private void insertarSql(TblEstadoDoc tblEstadoDoc, EntityManager entityManager) {
		
		
		Query query = entityManager.createNativeQuery("insert into estadoDoc (cod_estado,des_estado)"
				+"(?,?)");
		
		query.setParameter(1, tblEstadoDoc.getCodigo());
		query.setParameter(2, tblEstadoDoc.getDescripcion());
		query.executeUpdate();
		
	}
	
	
	
	
	private void actualizar() {}

}
