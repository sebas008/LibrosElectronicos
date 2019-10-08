package modelo;



import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.TblEstadoDoc;



public class ModeloTblCondPago {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");
	
	public List<TblEstadoDoc>listarTblEstadoDoc(){
	
		
     EntityManager manager = factory.createEntityManager();
	List<TblEstadoDoc> listarTblEstadoDoc = new ArrayList<>();
	 TypedQuery<TblEstadoDoc> resultado = null;
	 
	 try {
		 
		 String hql = "select e from TblEstadoDoc e";
		resultado = manager.createQuery(hql,TblEstadoDoc.class);
		listarTblEstadoDoc = resultado.getResultList();
		 	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		factory.close();
	}
	 
	return listarTblEstadoDoc;
	
	}
	 

public void insertTblEstadoDoc(TblEstadoDoc tblEstadoDoc) {
	
	
	EntityManager manager = factory.createEntityManager();

	try {
		// iniciar la transacion
		manager.getTransaction().begin();

		insertarSql(tblEstadoDoc, manager);
		manager.getTransaction().commit();

	} catch (Exception e) {
		manager.getTransaction().rollback();

		System.out.println(e.getMessage());
	} finally {
		manager.close();
		factory.close();
	}
	
	
	
	
}

}
