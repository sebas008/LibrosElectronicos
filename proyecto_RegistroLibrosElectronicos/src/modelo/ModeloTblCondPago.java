package modelo;



import java.util.ArrayList;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TblCondPago;




public class ModeloTblCondPago {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");
	
	public List<TblCondPago>listarTblCondPago(){
	
		
     EntityManager manager = factory.createEntityManager();
	List<TblCondPago> listarTblCondPago = new ArrayList<>();
	 TypedQuery<TblCondPago> resultado = null;
	 
	 try {
		 
		 String hql = "select e from TblCondPago e";
		resultado = manager.createQuery(hql,TblCondPago.class);
		listarTblCondPago = resultado.getResultList();
		 	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		factory.close();
	}
	 
	return listarTblCondPago;
	
	}
	 

public void insertTblCondPago(TblCondPago tblCondPago) {
	
	
	EntityManager manager = factory.createEntityManager();

try {
	
	manager.getTransaction().begin();
   insertarSql(tblCondPago, manager);
	manager.getTransaction().commit();
	
} catch (Exception e) {
	manager.getTransaction().rollback();
	e.printStackTrace();
}
	
    manager.close();
	factory.close();
	
}

public void actalizarTblCondPago(TblCondPago tblCondPago) {
	
	EntityManager manager = factory.createEntityManager();
	
	
	try {
		manager.getTransaction().begin();
		manager.merge(tblCondPago);
		manager.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally {
		manager.close();
		factory.close();
	}
}

public void eliminarCondPago(String tblCondPago) {
	
	EntityManager manager = factory.createEntityManager();
	
	try {
	
		TblCondPago condicionPago = manager.find(TblCondPago.class, tblCondPago);
		manager.getTransaction().begin();
		manager.remove(condicionPago);
		manager.getTransaction().commit();
		
		
		
	} catch (Exception e) {
		manager.getTransaction().rollback();
		System.out.println(e.getMessage());
		// TODO: handle exception
	}finally {
		manager.close();
		factory.close();
		
		
	}
}


public void insertarSql(TblCondPago tblCondPago, EntityManager entityManager) {
	
	Query query = entityManager.createNativeQuery("insert into condPago()");
	
	query.setParameter(1, tblCondPago.getCodigo());
	query.setParameter(2, tblCondPago.getDescripcion());
	query.executeUpdate();
	
}





}
