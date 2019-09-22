package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	
	
	
}
