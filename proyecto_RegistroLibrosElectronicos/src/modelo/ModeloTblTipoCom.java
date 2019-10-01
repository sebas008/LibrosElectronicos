package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
	
	public void insertarTblTipoCom(TblTipoCom tblTipoCom){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(tblTipoCom, manager);
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
	
	public void actualizarTblTipoCom(TblTipoCom tblTipoCom) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(tblTipoCom);
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

	
	public void eliminarTblTipoCom(String tblTipoCom){
		EntityManager manager=factory.createEntityManager();
				
				try {
					TblTipoCom tipoCompra=manager.find(TblTipoCom.class, tblTipoCom);
					manager.getTransaction().begin();
					manager.remove(tipoCompra);
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

	
	
	private void insertarSql(TblTipoCom tblTipoCom, EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("insert into tipocompra (cod_com, des_com) " +
	            " values (?, ?)");
	        query.setParameter(1, tblTipoCom.getCodigo());
	        query.setParameter(2, tblTipoCom.getDescripcion());
	        query.executeUpdate();
	}
	
	
	
	
	
}
