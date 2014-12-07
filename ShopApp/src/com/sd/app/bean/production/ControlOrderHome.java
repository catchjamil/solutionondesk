package com.sd.app.bean.production;

// Generated Nov 22, 2014 1:12:39 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ControlOrder.
 * @see com.sd.app.bean.production.ControlOrder
 * @author Hibernate Tools
 */
public class ControlOrderHome {

	private static final Log log = LogFactory.getLog(ControlOrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ControlOrder transientInstance) {
		log.debug("persisting ControlOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ControlOrder instance) {
		log.debug("attaching dirty ControlOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ControlOrder instance) {
		log.debug("attaching clean ControlOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ControlOrder persistentInstance) {
		log.debug("deleting ControlOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ControlOrder merge(ControlOrder detachedInstance) {
		log.debug("merging ControlOrder instance");
		try {
			ControlOrder result = (ControlOrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ControlOrder findById(java.lang.Integer id) {
		log.debug("getting ControlOrder instance with id: " + id);
		try {
			ControlOrder instance = (ControlOrder) sessionFactory.getCurrentSession().get("com.sd.app.bean.production.ControlOrder", id);
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

	public List<ControlOrder> findByExample(ControlOrder instance) {
		log.debug("finding ControlOrder instance by example");
		try {
			List<ControlOrder> results = (List<ControlOrder>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.production.ControlOrder").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
