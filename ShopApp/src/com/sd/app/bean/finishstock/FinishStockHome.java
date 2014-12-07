package com.sd.app.bean.finishstock;

// Generated Nov 22, 2014 12:55:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FinishStock.
 * @see com.sd.app.bean.finishstock.FinishStock
 * @author Hibernate Tools
 */
public class FinishStockHome {

	private static final Log log = LogFactory.getLog(FinishStockHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FinishStock transientInstance) {
		log.debug("persisting FinishStock instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FinishStock instance) {
		log.debug("attaching dirty FinishStock instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FinishStock instance) {
		log.debug("attaching clean FinishStock instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FinishStock persistentInstance) {
		log.debug("deleting FinishStock instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FinishStock merge(FinishStock detachedInstance) {
		log.debug("merging FinishStock instance");
		try {
			FinishStock result = (FinishStock) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FinishStock findById(com.sd.app.bean.finishstock.FinishStockId id) {
		log.debug("getting FinishStock instance with id: " + id);
		try {
			FinishStock instance = (FinishStock) sessionFactory.getCurrentSession().get("com.sd.app.bean.finishstock.FinishStock", id);
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

	public List<FinishStock> findByExample(FinishStock instance) {
		log.debug("finding FinishStock instance by example");
		try {
			List<FinishStock> results = (List<FinishStock>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.finishstock.FinishStock").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
