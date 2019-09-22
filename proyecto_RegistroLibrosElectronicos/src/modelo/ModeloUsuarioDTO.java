package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.UsuarioDTO;

public class ModeloUsuarioDTO {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	
	public List<UsuarioDTO>listarUsuarioDTO(){
		EntityManager manager=factory.createEntityManager();
		List<UsuarioDTO>listadoUsuarioDTO=new ArrayList<>();
		TypedQuery<UsuarioDTO>resultado=null;
		try {
			String hql="Select u from UsuarioDTO u";
			resultado=manager.createQuery(hql,UsuarioDTO.class);
			listadoUsuarioDTO=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoUsuarioDTO;
	}
	
	
	
}
