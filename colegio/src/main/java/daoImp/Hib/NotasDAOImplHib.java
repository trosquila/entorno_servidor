package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.INotasDAO;

import dto.NotaDTO;
import entities.AlumnoEntity;
import entities.AsignaturaEntity;
import entities.NotasEntity;
import utils.DBUtils;


public class NotasDAOImplHib implements INotasDAO {

	@Override
	public ArrayList<NotaDTO> obtenerTodasNotas() {
		String hql = "FROM NotasEntity";
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        Query<NotaDTO> query = s.createQuery(hql, NotaDTO.class);
        ArrayList<NotaDTO> lista = (ArrayList<NotaDTO>) query.getResultList();
        
        s.close();
		return lista;
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(String idAlumno, String nombreAlumno, String asignatura,
			String nota, String fecha, int activo) {
		 Integer id = null;
		    try {
		        id = Integer.parseInt(idAlumno);
		    } catch (Exception e) {
		    }
		    
		 String jpq = "SELECT new dto.NotaDTO(n.id, n.nota, n.asignatura.id, a.nombre, n.alumno.id, al.nombre, n.fecha) "
		 		+ "FROM NotasEntity n "
		 		+ "JOIN n.asignatura a "
		 		+ "JOIN n.alumno al "
		 		+ "WHERE al.nombre LIKE :nombreAlumno "
		 		+ "  AND a.nombre LIKE :nombreAsignatura "
		 		+ "  AND n.nota LIKE :nota "
		 		+ "  AND n.fecha >= :fecha "
		 		+ "  AND al.activo = :activo";
		 
		    if (id != null) {
		        jpq = jpq +" AND n.alumno.id = :id";
		    }

		  SessionFactory factory = DBUtils.creadorSessionFactory();
		   Session s = factory.getCurrentSession();
		   s.beginTransaction();

		   Query<NotaDTO> query = s.createQuery(jpq, NotaDTO.class)
		            .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
		            .setParameter("nombreAsignatura", "%" + asignatura + "%")
		            .setParameter("nota", "%" + nota + "%")
		            .setParameter("fecha", fecha)
		            .setParameter("activo",  activo);
		   if (id != null) {
		        query.setParameter("id", id);
		    }

		   List<NotaDTO> lista = query.getResultList();

		    s.close();
		    return new ArrayList<>(lista);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
			String nota, int activo) {
	       Integer id = null;
	        try {
	            id = Integer.parseInt(idAlumno);
	        } catch (Exception e) {
	        }
	        
	        String jpq = "SELECT new dto.NotaDTO(n.id, n.nota, n.asignatura.id, a.nombre, n.alumno.id, al.nombre, n.fecha) "
	                + "FROM NotasEntity n "
	                + "JOIN n.asignatura a "
	                + "JOIN n.alumno al "
	                + "WHERE al.nombre LIKE :nombreAlumno "
	                + "AND a.nombre LIKE :nombreAsignatura "
	                + "AND n.nota LIKE :nota "
	                + "AND al.activo = :activo";
	        
	        if (id != null) {
	            jpq = jpq + " AND n.alumno.id = :id";
	        }

	        SessionFactory factory = DBUtils.creadorSessionFactory();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();

	        Query<NotaDTO> query = s.createQuery(jpq, NotaDTO.class)
	                .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
	                .setParameter("nombreAsignatura", "%" + asignatura + "%")
	                .setParameter("nota", "%" + nota + "%")
	                .setParameter("activo", activo);
	        
	        if (id != null) {
	            query.setParameter("id", id);
	        }

	        List<NotaDTO> lista = query.getResultList();
	        s.close();
	        return new ArrayList<>(lista);
	}

	@Override
	public int insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		   SessionFactory factory = DBUtils.creadorSessionFactory();
		    Session s = factory.getCurrentSession();
		    s.beginTransaction();

		    AlumnoEntity alumno = s.find(AlumnoEntity.class, Integer.parseInt(idAlumno));
		    AsignaturaEntity asignatura = s.find(AsignaturaEntity.class, Integer.parseInt(idAsignatura));

		    NotasEntity n = new NotasEntity();
		    n.setAlumno(alumno);
		    n.setAsignatura(asignatura);
		    n.setNota(nota);
		    n.setFecha(fecha);

		    Integer id = (Integer) s.save(n);

		    s.getTransaction().commit();
		    s.close();

		    return id;
	}

	@Override
	public int actualizarNota(String id, String idAlumno, String idAsignatura, String nota, String fecha) {
		 String jpql = "UPDATE NotasEntity n SET "
	                + "n.alumno = (SELECT a FROM AlumnoEntity a WHERE a.id = :idAlumno), "
	                + "n.asignatura = (SELECT asig FROM AsignaturaEntity asig WHERE asig.id = :idAsignatura), "
	                + "n.nota = :nota, "
	                + "n.fecha = :fecha "
	                + "WHERE n.id = :id";
	    
	    SessionFactory factory = DBUtils.creadorSessionFactory();
	    Session s = factory.getCurrentSession();
	    s.beginTransaction();
	    
	    int result = s.createQuery(jpql)
	            .setParameter("id", Integer.parseInt(id))
	            .setParameter("idAlumno", Integer.parseInt(idAlumno))
	            .setParameter("idAsignatura", Integer.parseInt(idAsignatura))
	            .setParameter("nota", nota)
	            .setParameter("fecha", fecha)
	            .executeUpdate();
	    
	    s.getTransaction().commit();
	    s.close();
	    return result;
	}

	@Override
	public int borrarNota(String id) {
		 SessionFactory factory = DBUtils.creadorSessionFactory();
		    Session s = factory.getCurrentSession();
		    s.beginTransaction();

		    NotasEntity n = s.get(NotasEntity.class, Integer.parseInt(id));

		    if (n == null) {
		        throw new RuntimeException("No existe la nota con id=" + id);
		    }

		    s.remove(n);

		    s.getTransaction().commit();
		    s.close();

		    return n.getId();
		
	}
	





}
