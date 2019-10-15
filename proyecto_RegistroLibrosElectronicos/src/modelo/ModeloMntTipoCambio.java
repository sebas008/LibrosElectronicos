package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.MntTipoCambio;

public class ModeloMntTipoCambio {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	public List<MntTipoCambio> listarTipoCambio() {
		EntityManager manager = factory.createEntityManager();
		List<MntTipoCambio> listadoTipoCambio = new ArrayList<>();
		TypedQuery<MntTipoCambio> resultado = null;
		try {
			String hql = "Select tc from MntTipoCambio tc";
			resultado = manager.createQuery(hql, MntTipoCambio.class);
			listadoTipoCambio = resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
		return listadoTipoCambio;
	}

	public void insertarTipoCambio(MntTipoCambio mntTipoCambio) {

		EntityManager manager = factory.createEntityManager();

		try {

			manager.getTransaction().begin();
			insertarSql(mntTipoCambio, manager);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		} finally {
			manager.close();
			factory.close();
		}

	}

	public void actualizarTipoCambio(MntTipoCambio mntTipoCambio) {

		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(mntTipoCambio);
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			// TODO: handle exception
		} finally {
			manager.close();
			factory.close();
		}

	}

	public void insertarSql(MntTipoCambio mntTipoCambio, EntityManager entityManager) {

		Query query = entityManager.createNativeQuery("insert into ");

		query.setParameter(1, mntTipoCambio.getFecha());
		query.setParameter(2, mntTipoCambio.getCompra());
		query.setParameter(2, mntTipoCambio.getVenta());
		query.executeUpdate();

	}

	public void eliminarTipoCambio(String mntTipoCambio) {

		EntityManager manager = factory.createEntityManager();

		try {

			MntTipoCambio tipoCambio = manager.find(MntTipoCambio.class, mntTipoCambio);
			manager.getTransaction().begin();
			manager.remove(tipoCambio);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		} finally {
			manager.close();
			factory.close();

		}
	}
}
