package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
	
	public void insertarUsuarioDTO(UsuarioDTO usuarioDTO){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(usuarioDTO, manager);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally{
			manager.close();
			factory.close();
		}
	}
	
	public void actualizarUsuarioDTO(UsuarioDTO usuarioDTO) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(usuarioDTO);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			manager.close();
			factory.close();
		}
	}
	
	public void eliminarUsuarioDTO(String usuarioDTO){
		EntityManager manager=factory.createEntityManager();
				
				try {
					UsuarioDTO usuario=manager.find(UsuarioDTO.class, usuarioDTO);
					manager.getTransaction().begin();
					manager.remove(usuario);
					manager.getTransaction().commit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					manager.getTransaction().rollback();
					System.out.println(e.getMessage());
				}finally{
					manager.close();
					factory.close();
				}
			}

	private void insertarSql(UsuarioDTO usuarioDTO, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into usuarios (cod_usu, clave_usu) " +
	            " values (?, ?)");
	        query.setParameter(1, usuarioDTO.getCod_usu());
	        query.setParameter(2, usuarioDTO.getClave_usu());
	        query.executeUpdate();
	}
	
	
}
