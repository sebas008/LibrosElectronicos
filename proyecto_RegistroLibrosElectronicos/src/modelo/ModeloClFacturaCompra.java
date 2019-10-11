package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import entity.ClFacturaCompra;
import entity.MntProveedor;


public class ModeloClFacturaCompra {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");

    public List<MntProveedor>listarProveedor(){
		EntityManager manager=factory.createEntityManager();
		List<MntProveedor>listadoProveedor=new ArrayList<>();
		TypedQuery<MntProveedor>resultado=null;
		try {
			String hql="Select p from MntProveedor p";
			resultado=manager.createQuery(hql,MntProveedor.class);
			listadoProveedor=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoProveedor;
	}
    
    public List<ClFacturaCompra>listarFacturaCompra(MntProveedor mntProveedor){
		EntityManager manager=factory.createEntityManager();
		List<ClFacturaCompra>listadoFacturaCompra = new ArrayList<>();
		TypedQuery<ClFacturaCompra>resultado=null;
		try {
			String hql="Select cc from ClFacturaCompra cc where cc.id.cod_pro=?1";
			resultado=manager.createQuery(hql,ClFacturaCompra.class);
			resultado.setParameter(1, mntProveedor.getCodigo());
			listadoFacturaCompra=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		return listadoFacturaCompra;
	}
	
    public void insertarFacturaCompra(ClFacturaCompra clFacturaCompra){
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			insertarSql(clFacturaCompra, manager);
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
	public void actualizarFacturaCompra(ClFacturaCompra clFacturaCompra) {
		EntityManager manager=factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(clFacturaCompra);
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
	
	public void eliminarFacturaCompra(String clFacturaCompra){
		EntityManager manager=factory.createEntityManager();
				
				try {
					ClFacturaCompra facturaCompra=manager.find(ClFacturaCompra.class, clFacturaCompra);
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
	

	
	public void insertarSql(ClFacturaCompra clFacturaCompra, EntityManager entityManager){
		Query query = entityManager.createNativeQuery("insert into facturaCompra (periodo, moneda, fecha, tipoCambio, tipoDoc, serieDoc,numDoc,cod_pro,razonS_pro,valor_venta,valor_inafecto,igv,total,cod_re,des_re,tasa_re,fecha_re,nro_re,monto_re,glosa_compra,cod_com,cod_estado) " +
	            " values (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        query.setParameter(1, clFacturaCompra.getTblPeriodoContable().getCodPerdiodo());
	        query.setParameter(2, clFacturaCompra.getTblMoneda().getCodigo());
	        query.setParameter(3, clFacturaCompra.getMntTipoCambio().getFecha());
	        query.setParameter(4, clFacturaCompra.getTblTipoDoc().getCodigo());
	        query.setParameter(5, clFacturaCompra.getId().getSerieDoc());
	        query.setParameter(6, clFacturaCompra.getId().getNumDoc());
	        query.setParameter(7, clFacturaCompra.getId().getMntProveedor().getCodigo());
	        query.setParameter(8, clFacturaCompra.getRazonS_Pro());
	        query.setParameter(9, clFacturaCompra.getValorVenta());
	        query.setParameter(10, clFacturaCompra.getValorInafecto());
	        query.setParameter(11, clFacturaCompra.getIgv());
	        query.setParameter(12, clFacturaCompra.getTotal());
	        query.setParameter(13, clFacturaCompra.getTblTipoRet().getCodigo());
	        query.setParameter(14, clFacturaCompra.getDes_Re());
	        query.setParameter(15, clFacturaCompra.getTasa_re());
	        query.setParameter(16, clFacturaCompra.getFechaRet());
	        query.setParameter(17, clFacturaCompra.getNroRet());
	        query.setParameter(18, clFacturaCompra.getMontoRet());
	        query.setParameter(19, clFacturaCompra.getGlosa_Compra());
	        query.setParameter(20, clFacturaCompra.getTblTipoCom().getCodigo());
	        query.setParameter(21, clFacturaCompra.getTblEstadoDoc().getCodigo());
	        query.executeUpdate();
	}
	
}
