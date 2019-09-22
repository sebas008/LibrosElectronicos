package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.TblTipoRet;

public class ModeloTblTipoRet {

EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoRet>listarTblTipoRet(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoRet>listadoTblTipoRet=new ArrayList<>();
		TypedQuery<TblTipoRet>resultado=null;
		try {
			String hql="Select tr from TblTipoRet tr";
			resultado=manager.createQuery(hql,TblTipoRet.class);
			listadoTblTipoRet=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoRet;
	}
	
	
	
	
}
