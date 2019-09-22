package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	
	
}
