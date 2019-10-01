package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
	
	public void insertarTblTipoPro(TblTipoPro tblTipoPro){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoPro, manager);
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
	
	public void actualizarTblTipoPro(TblTipoPro tblTipoPro) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoPro);
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
	
	public void eliminarTblTipoPro(String tblTipoPro){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoPro tipoProveedor=manager.find(TblTipoPro.class, tblTipoPro);
					manager.getTransaction().begin();
					manager.remove(tipoProveedor);
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

	private void insertarSql(TblTipoPro tblTipoPro, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tipoproveedor (cod_pe, des_pe) " +
	            " values (?, ?)");
	        query.setParameter(1, tblTipoPro.getCodigo());
	        query.setParameter(2, tblTipoPro.getDescripcion());
	        query.executeUpdate();
	}
	
	
	
}
