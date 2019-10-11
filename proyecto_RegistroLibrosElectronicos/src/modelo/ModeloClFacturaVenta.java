package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.ClFacturaVenta;
import entity.MntCliente;

public class ModeloClFacturaVenta {


	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");

    public List<MntCliente>listarCliente(){
		EntityManager manager=factory.createEntityManager();
		List<MntCliente>listadoCliente=new ArrayList<>();
		TypedQuery<MntCliente>resultado=null;
		try {
			String hql="Select c from MntCliente c";
			resultado=manager.createQuery(hql,MntCliente.class);
			listadoCliente=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoCliente;
	}
    
    public List<ClFacturaVenta>listarFacturaVenta(MntCliente mntCliente){
		EntityManager manager=factory.createEntityManager();
		List<ClFacturaVenta>listadoFacturaVenta = new ArrayList<>();
		TypedQuery<ClFacturaVenta>resultado=null;
		try {
			String hql="Select fc from ClFacturaCompra fc where fc.id.cod_cli=?1";
			resultado=manager.createQuery(hql,ClFacturaVenta.class);
			resultado.setParameter(1, mntCliente.getCodigo());
			listadoFacturaVenta=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoFacturaVenta;
	}
	
    public void insertarFacturaVenta(ClFacturaVenta clFacturaVenta){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(clFacturaVenta, manager);
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
	public void actualizarFacturaVenta(ClFacturaVenta clFacturaVenta) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(clFacturaVenta);
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
	
	public void eliminarFacturaVenta(String clFacturaVenta){
		EntityManager manager=factory.createEntityManager();
				
				try {
					ClFacturaVenta facturaCompra=manager.find(ClFacturaVenta.class, clFacturaVenta);
					manager.getTransaction().begin();
					manager.remove(facturaCompra);
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
	

	
	public void insertarSql(ClFacturaVenta clFacturaVenta, EntityManager entityManager){
		Query query = entityManager.createNativeQuery("insert into facturaVenta (periodo, moneda, fecha, tipoCambio, tipoDoc, serieDoc,numDoc,cod_cli ,razonS_cli ,valor_venta,valor_inafecto,igv,total,cod_re,des_re,tasa_re,glosa_venta,cod_estado) " +
	            " values (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        query.setParameter(1, clFacturaVenta.getTblPeriodoContable().getCodPerdiodo());
	        query.setParameter(2, clFacturaVenta.getTblMoneda().getCodigo());
	        query.setParameter(3, clFacturaVenta.getMntTipoCambio().getFecha());
	        query.setParameter(4, clFacturaVenta.getTblTipoDoc().getCodigo());
	        query.setParameter(5, clFacturaVenta.getId().getSerieDoc());
	        query.setParameter(6, clFacturaVenta.getId().getNumDoc());
	        query.setParameter(7, clFacturaVenta.getId().getMntCliente().getCodigo());
	        query.setParameter(8, clFacturaVenta.getRazonS_Cli());
	        query.setParameter(9, clFacturaVenta.getValorVenta());
	        query.setParameter(10, clFacturaVenta.getValorInafecto());
	        query.setParameter(11, clFacturaVenta.getIgv());
	        query.setParameter(12, clFacturaVenta.getTotal());
	        query.setParameter(13, clFacturaVenta.getTblTipoRet().getCodigo());
	        query.setParameter(14, clFacturaVenta.getDes_Re());
	        query.setParameter(15, clFacturaVenta.getTasa_re());
	        query.setParameter(16, clFacturaVenta.getGlosa_venta());
	        query.setParameter(17, clFacturaVenta.getTblEstadoDoc().getCodigo());
	        query.executeUpdate();
	}
	
}
