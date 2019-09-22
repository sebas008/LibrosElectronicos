package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import entity.TblTipoDoc;

public class ModeloTblTipoDoc {

EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoDoc>listarTblTipoDoc(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoDoc>listadoTblTipoDoc=new ArrayList<>();
		TypedQuery<TblTipoDoc>resultado=null;
		try {
			String hql="Select td from TblTipoDoc td";
			resultado=manager.createQuery(hql,TblTipoDoc.class);
			listadoTblTipoDoc=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoDoc;
	}
	
	
}
