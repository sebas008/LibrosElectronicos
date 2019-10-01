package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
	
	public void insertarTblTipoDoc(TblTipoDoc tblTipoDoc){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoDoc, manager);
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
	
	public void actualizarTblTipoDoc(TblTipoDoc tblTipoDoc) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoDoc);
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
	
	public void eliminarTblTipoDoc(String tblTipoDoc){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoDoc tipoDocumento=manager.find(TblTipoDoc.class, tblTipoDoc);
					manager.getTransaction().begin();
					manager.remove(tipoDocumento);
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

	private void insertarSql(TblTipoDoc tblTipoDoc, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tipodocumento (cod_td, des_td) " +
	            " values (?, ?)");
	        query.setParameter(1, tblTipoDoc.getCodigo());
	        query.setParameter(2, tblTipoDoc.getDescripcion());
	        query.executeUpdate();
	}
	
	
}
