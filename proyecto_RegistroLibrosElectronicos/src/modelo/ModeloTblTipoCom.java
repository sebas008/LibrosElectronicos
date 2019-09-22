package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.TblTipoCom;

public class ModeloTblTipoCom {

EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoCom>listarTblTipoCom(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoCom>listadoTblTipoCom=new ArrayList<>();
		TypedQuery<TblTipoCom>resultado=null;
		try {
			String hql="Select tm from TblTipoCom tm";
			resultado=manager.createQuery(hql,TblTipoCom.class);
			listadoTblTipoCom=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoCom;
	}
	
	
	
}
