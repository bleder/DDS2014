package repo


import java.util.List
import org.hibernate.HibernateException
import org.hibernate.SessionFactory
import org.hibernate.cfg.AnnotationConfiguration
import org.hibernate.criterion.Restrictions
import partido.core.Jugador

class RepoJugadores {

	private static RepoJugadores instance = null
	
	private new() {
	}
	
	static def getInstance() {
		if (instance == null) {
			instance = new RepoJugadores
		}
		instance
	}
	
	private static final SessionFactory sessionFactory = new AnnotationConfiguration()
			.configure()
			.addAnnotatedClass(Jugador)
			.buildSessionFactory()

	def getJugador(Jugador jug) {
		val session = sessionFactory.openSession
		try {
			var result = session.createCriteria(Jugador)
				.add(Restrictions.eq("nombre", jug.nombre)) 
				.list()
			if (result.isEmpty) {
				null
			} else {
				var jugador = result.get(0) as Jugador
				jugador
			}
		} catch (HibernateException e) {
			throw new RuntimeException(e)
		} finally {
			session.close
		}
	}

	
	def actualizarJugador(Jugador jug) {
		val session = sessionFactory.openSession
		try {
			session.beginTransaction
			session.saveOrUpdate(jug)
			session.getTransaction.commit
		} catch (HibernateException e) {
			session.getTransaction.rollback
			throw new RuntimeException(e)
		} finally {
			session.close
		}
	}
	
	def eliminarJugador(Jugador jug) {
		val session = sessionFactory.openSession
		try {
			session.beginTransaction
			session.delete(jug)
			session.getTransaction.commit
		} catch (HibernateException e) {
			session.getTransaction.rollback
			throw new RuntimeException(e)
		} finally {
			session.close
		}
	}
	
	}
