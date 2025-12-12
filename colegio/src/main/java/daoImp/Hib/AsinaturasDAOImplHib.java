package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import entities.AsignaturaEntity;
import utils.DBUtils;

public class AsinaturasDAOImplHib implements IAsignaturasDAO {

	@Override
	public ArrayList<AsignaturaDTO> obtenerTodasAsignaturas() {
		String hql = "FROM AsignaturaEntity";
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        Query<AsignaturaDTO> query = s.createQuery(hql, AsignaturaDTO.class);
        ArrayList<AsignaturaDTO> lista = (ArrayList<AsignaturaDTO>) query.getResultList();
        
        s.close();
		return lista;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(
	        String idString, String nombre, String curso, String tasa, int activo) {

	    Integer id = null;
	    try {
	        id = Integer.parseInt(idString);
	    } catch (Exception e) {
	    }

	    String jpq = "SELECT new dto.AsignaturaDTO(a.id, a.nombre, a.curso, a.tasa, a.activo) "
	               + "FROM AsignaturaEntity a "
	               + "WHERE (:id IS NULL OR a.id = :id) "
	               + "AND a.nombre LIKE :nombre "
	               + "AND a.curso LIKE :curso "
	               + "AND a.tasa >= :tasa "
	               + "AND a.activo = :activo";

	    SessionFactory factory = DBUtils.creadorSessionFactory();
	    Session s = factory.getCurrentSession();
	    s.beginTransaction();

	    Query<AsignaturaDTO> query = s.createQuery(jpq, AsignaturaDTO.class)
	            .setParameter("id", id) 
	            .setParameter("nombre", "%" + nombre + "%")
	            .setParameter("curso", "%" + curso + "%")
	            .setParameter("tasa", tasa)
	            .setParameter("activo",  String.valueOf(activo));

	    List<AsignaturaDTO> lista = query.getResultList();

	    s.close();
	    return new ArrayList<>(lista);
	}

	@Override
	public int insertarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
		    
		    SessionFactory factory = DBUtils.creadorSessionFactory();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();
	        
	        AsignaturaEntity a = new AsignaturaEntity(Integer.parseInt(id), nombre, curso, tasa, String.valueOf(activo));
	        

	        Integer idPk = (Integer) s.save(a);
	        
	        s.getTransaction().commit();
	        s.close();
	        return idPk;
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        AsignaturaEntity a = new AsignaturaEntity(Integer.parseInt(id), nombre, curso, tasa, String.valueOf(activo));
	    
	    s.update(a);
	    
	    s.getTransaction().commit();
	    
	    s.close();
	    
	    return a.getId();
	}

	@Override
	public int borrarAsignatura(String id) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
	    Session s = factory.getCurrentSession();
	    
	    s.beginTransaction();
	    
	    // Obtenemos el alumno cuyo campo "activo" queremos actualizar a cero
	    AsignaturaEntity a = s.get(AsignaturaEntity.class, Integer.parseInt(id));
	    
	    a.setActivo("0");
	   
	    s.update(a);
	    s.getTransaction().commit();
	    s.close();
	    
	    return a.getId();
	}

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		  Integer id = null;
		    try {
		        id = Integer.parseInt(idAsignatura);
		    } catch (Exception e) {
		    }

		    String jpq = "SELECT new dto.AsignaturaDTO(a.tasa) "
		               + "FROM AsignaturaEntity a "
		               + "WHERE "
		               + "AND a.tasa >= :tasa "
		               + "AND a.activo = 1";

		    SessionFactory factory = DBUtils.creadorSessionFactory();
		    Session s = factory.getCurrentSession();
		    s.beginTransaction();

		    Query<Double> query = s.createQuery(jpq, Double.class)
		            .setParameter("tasa", id);

		    Double tasa = query.uniqueResult();

		    s.close();
		    return  tasa != null ? tasa : 0.0;
	}



}
