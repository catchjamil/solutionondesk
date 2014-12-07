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
 * Home object for domain model class ExciseItem.
 * @see com.sd.app.bean.masters.ExciseItem
 * @author Hibernate Tools
 */
public class ExciseItemHome {

	private static final Log log = LogFactory.getLog(ExciseItemHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseItem transientInstance) {
		log.debug("persisting ExciseItem instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseItem instance) {
		log.debug("attaching dirty ExciseItem instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseItem instance) {
		log.debug("attaching clean ExciseItem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseItem persistentInstance) {
		log.debug("deleting ExciseItem instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseItem merge(ExciseItem detachedInstance) {
		log.debug("merging ExciseItem instance");
		try {
			ExciseItem result = (ExciseItem) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseItem findById(java.lang.Integer id) {
		log.debug("getting ExciseItem instance with id: " + id);
		try {
			ExciseItem instance = (ExciseItem) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.ExciseItem", id);
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

	public List<ExciseItem> findByExample(ExciseItem instance) {
		log.debug("finding ExciseItem instance by example");
		try {
			List<ExciseItem> results = (List<ExciseItem>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.ExciseItem")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
