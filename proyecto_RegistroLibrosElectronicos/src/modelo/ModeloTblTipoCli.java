package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	
	
	
	
}
