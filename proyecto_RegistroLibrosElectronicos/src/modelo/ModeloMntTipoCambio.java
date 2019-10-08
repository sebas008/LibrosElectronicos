package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.MntTipoCambio;

public class ModeloMntTipoCambio {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<MntTipoCambio>listarTipoCambio(){
		EntityManager manager=factory.createEntityManager();
		List<MntTipoCambio>listadoTipoCambio=new ArrayList<>();
		TypedQuery<MntTipoCambio>resultado=null;
		try {
			String hql="Select tc from MntTipoCambio tc";
			resultado=manager.createQuery(hql,MntTipoCambio.class);
			listadoTipoCambio=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoTipoCambio;
	}	
	
}
