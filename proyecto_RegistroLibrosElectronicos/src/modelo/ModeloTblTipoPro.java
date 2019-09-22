package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.TblTipoPro;

public class ModeloTblTipoPro {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblTipoPro>listarTblTipoPro(){
		EntityManager manager=factory.createEntityManager();
		List<TblTipoPro>listadoTblTipoPro=new ArrayList<>();
		TypedQuery<TblTipoPro>resultado=null;
		try {
			String hql="Select to from TblTipoPro to";
			resultado=manager.createQuery(hql,TblTipoPro.class);
			listadoTblTipoPro=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblTipoPro;
	}
	
	
	
	
}
