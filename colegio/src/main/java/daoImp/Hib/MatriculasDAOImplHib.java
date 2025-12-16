package daoImp.Hib;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import dao.IMatriculacionesDAO;

import dto.MatriculacionDTO;
import entities.AlumnoEntity;
import entities.AsignaturaEntity;
import entities.CajaEntity;
import entities.MatriculasEntity;
import utils.DBUtils;

public class MatriculasDAOImplHib implements IMatriculacionesDAO {

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		 Session s = DBUtils.creadorSessionFactory().getCurrentSession();
		    s.beginTransaction();

		    String jpql =
		        "SELECT a.tasa " +
		        "FROM AsignaturaEntity a " +
		        "WHERE a.id = :id AND a.activo = 1";

		    Query query = s.createQuery(jpql);
		    query.setParameter("id", Integer.parseInt(idAsignatura));

		    Double tasa = (Double) query.uniqueResult();

		    s.getTransaction().commit();
		    s.close();

		    return tasa != null ? tasa : 0.0;
		}

	@Override
	public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa)
			throws SQLException {
		  SessionFactory factory = DBUtils.creadorSessionFactory();
		    Session s = factory.getCurrentSession();
		    s.beginTransaction();

		    AlumnoEntity alumno = s.find(AlumnoEntity.class, Integer.parseInt(idAlumno));
		    AsignaturaEntity asignatura = s.find(AsignaturaEntity.class, Integer.parseInt(idAsignatura));

		    MatriculasEntity matricula = new MatriculasEntity();
		    matricula.setAlumno(alumno);
		    matricula.setAsignatura(asignatura);
		    matricula.setFecha(fecha);
		    matricula.setActivo(1);

		    Integer idMatricula = (Integer) s.save(matricula);

		    CajaEntity caja = new CajaEntity();
		    caja.setMatricula(matricula);
		    caja.setImporte(Double.parseDouble(tasa));

		    s.save(caja);

		    s.getTransaction().commit();
		    s.close();

		    return idMatricula;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo) {

	    String jpql = "SELECT new dto.MatriculacionDTO(m.id, a.id, a.nombre, al.id, al.nombre, m.fecha, m.activo, m.caja.importe) "
	            + "FROM MatriculasEntity m "
	            + "JOIN m.asignatura a "
	            + "JOIN m.alumno al "
	            + "WHERE al.nombre LIKE :nombreAlumno "
	            + "AND a.nombre LIKE :nombreAsignatura "
	            + "AND m.fecha >= :fecha "
	            + "AND m.activo = :activo";

	    SessionFactory factory = DBUtils.creadorSessionFactory();
	    Session s = factory.getCurrentSession();
	    s.beginTransaction();

	    Query<MatriculacionDTO> query = s.createQuery(jpql, MatriculacionDTO.class)
	            .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
	            .setParameter("nombreAsignatura", "%" + nombreAsignatura + "%")
	            .setParameter("fecha", fecha)
	            .setParameter("activo", activo);

	    List<MatriculacionDTO> lista = query.getResultList();
	    s.getTransaction().commit();
	    s.close();

	    return new ArrayList<>(lista);
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
			String nombreAlumno, int activo) {
		String jpql = "SELECT new dto.MatriculacionDTO(m.id, a.id, a.nombre, al.id, al.nombre, m.fecha, m.activo, m.caja.importe) "
	            + "FROM MatriculasEntity m "
	            + "JOIN m.asignatura a "
	            + "JOIN m.alumno al "
	            + "WHERE al.nombre LIKE :nombreAlumno "
	            + "AND a.nombre LIKE :nombreAsignatura "
	            + "AND m.activo = :activo";

	    SessionFactory factory = DBUtils.creadorSessionFactory();
	    Session s = factory.getCurrentSession();
	    s.beginTransaction();

	    Query<MatriculacionDTO> query = s.createQuery(jpql, MatriculacionDTO.class)
	            .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
	            .setParameter("nombreAsignatura", "%" + nombreAsignatura + "%")
	            .setParameter("activo", activo);

	    List<MatriculacionDTO> lista = query.getResultList();
	    s.getTransaction().commit();
	    s.close();

	    return new ArrayList<>(lista);
	}

	@Override
	public int actualizarMatriculacion(String id, String idAsignatura, String idAlumno, String fecha, String tasa)
			throws SQLException {
		 Session s = DBUtils.creadorSessionFactory().getCurrentSession();
		    s.beginTransaction();

		    MatriculasEntity m = s.find(MatriculasEntity.class, Integer.parseInt(id));
		    if (m == null) {
		        throw new RuntimeException("No existe la matrícula");
		    }

		    AsignaturaEntity asignatura = s.find(AsignaturaEntity.class, Integer.parseInt(idAsignatura));
		    AlumnoEntity alumno = s.find(AlumnoEntity.class, Integer.parseInt(idAlumno));

		    m.setAsignatura(asignatura);
		    m.setAlumno(alumno);
		    m.setFecha(fecha);

		    CajaEntity caja = m.getCaja();
		    if (caja != null) {
		        caja.setImporte(Double.parseDouble(tasa));
		    }

		    s.getTransaction().commit();
		    s.close();

		    return m.getId();
	}

	@Override
	public int borrarMatriculacion(String id) throws SQLException {
		 Session s = DBUtils.creadorSessionFactory().getCurrentSession();
		    s.beginTransaction();

		    MatriculasEntity m = s.find(MatriculasEntity.class, Integer.parseInt(id));
		    if (m == null) {
		        throw new RuntimeException("No existe la matrícula");
		    }

		    if (m.getCaja() != null) {
		        s.remove(m.getCaja());
		    }

		    s.remove(m);

		    s.getTransaction().commit();
		    s.close();

		    return m.getId();
	}

}
