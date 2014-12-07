package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class QryApplication.
 * @see com.sd.app.bean.masters.QryApplication
 * @author Hibernate Tools
 */
public class QryApplicationHome {

	private static final Log log = LogFactory.getLog(QryApplicationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(QryApplication transientInstance) {
		log.debug("persisting QryApplication instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QryApplication instance) {
		log.debug("attaching dirty QryApplication instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QryApplication instance) {
		log.debug("attaching clean QryApplication instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QryApplication persistentInstance) {
		log.debug("deleting QryApplication instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QryApplication merge(QryApplication detachedInstance) {
		log.debug("merging QryApplication instance");
		try {
			QryApplication result = (QryApplication) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QryApplication findById(com.sd.app.bean.masters.QryApplicationId id) {
		log.debug("getting QryApplication instance with id: " + id);
		try {
			QryApplication instance = (QryApplication) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.QryApplication", id);
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

	public List<QryApplication> findByExample(QryApplication instance) {
		log.debug("finding QryApplication instance by example");
		try {
			List<QryApplication> results = (List<QryApplication>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.masters.QryApplication").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
