package com.sd.app.bean.lamproduction;

// Generated Nov 22, 2014 1:02:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Lamination.
 * @see com.sd.app.bean.lamproduction.Lamination
 * @author Hibernate Tools
 */
public class LaminationHome {

	private static final Log log = LogFactory.getLog(LaminationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Lamination transientInstance) {
		log.debug("persisting Lamination instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Lamination instance) {
		log.debug("attaching dirty Lamination instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lamination instance) {
		log.debug("attaching clean Lamination instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Lamination persistentInstance) {
		log.debug("deleting Lamination instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lamination merge(Lamination detachedInstance) {
		log.debug("merging Lamination instance");
		try {
			Lamination result = (Lamination) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Lamination findById(com.sd.app.bean.lamproduction.LaminationId id) {
		log.debug("getting Lamination instance with id: " + id);
		try {
			Lamination instance = (Lamination) sessionFactory.getCurrentSession().get("com.sd.app.bean.lamproduction.Lamination", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Lamination> findByExample(Lamination instance) {
		log.debug("finding Lamination instance by example");
		try {
			List<Lamination> results = (List<Lamination>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.lamproduction.Lamination").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
