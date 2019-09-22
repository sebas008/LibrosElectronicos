package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.TblPeriodoContable;

public class ModeloTblPeriodoContable {

	
EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<TblPeriodoContable>listarTblPeriodoContable(){
		EntityManager manager=factory.createEntityManager();
		List<TblPeriodoContable>listadoTblPeriodoContable=new ArrayList<>();
		TypedQuery<TblPeriodoContable>resultado=null;
		try {
			String hql="Select p from TblPeriodoContable p";
			resultado=manager.createQuery(hql,TblPeriodoContable.class);
			listadoTblPeriodoContable=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTblPeriodoContable;
	}
	
	
	
}
