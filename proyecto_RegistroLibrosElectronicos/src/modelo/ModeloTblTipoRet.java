package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
	
	public void insertarTblTipoRet(TblTipoRet tblTipoRet){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoRet, manager);
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
	
	public void actualizarTblTipoRet(TblTipoRet tblTipoRet) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoRet);
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
	
	public void eliminarTblTipoRet(String tblTipoRet){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoRet tipoRetencion=manager.find(TblTipoRet.class, tblTipoRet);
					manager.getTransaction().begin();
					manager.remove(tipoRetencion);
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

	private void insertarSql(TblTipoRet tblTipoRet, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tiporetencion (cod_re, des_re,tasa_re,valor_aplicacion) " +
	            " values (?, ?,?,?)");
	        query.setParameter(1, tblTipoRet.getCodigo());
	        query.setParameter(2, tblTipoRet.getDescripcion());
	        query.setParameter(3, tblTipoRet.getTasa());
	        query.setParameter(4, tblTipoRet.getValor());
	        query.executeUpdate();
	}
	
	
}
