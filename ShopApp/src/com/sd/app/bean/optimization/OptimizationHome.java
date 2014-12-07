package com.sd.app.bean.optimization;

// Generated Nov 22, 2014 1:09:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Optimization.
 * @see com.sd.app.bean.optimization.Optimization
 * @author Hibernate Tools
 */
public class OptimizationHome {

	private static final Log log = LogFactory.getLog(OptimizationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Optimization transientInstance) {
		log.debug("persisting Optimization instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Optimization instance) {
		log.debug("attaching dirty Optimization instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Optimization instance) {
		log.debug("attaching clean Optimization instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Optimization persistentInstance) {
		log.debug("deleting Optimization instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Optimization merge(Optimization detachedInstance) {
		log.debug("merging Optimization instance");
		try {
			Optimization result = (Optimization) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Optimization findById(com.sd.app.bean.optimization.OptimizationId id) {
		log.debug("getting Optimization instance with id: " + id);
		try {
			Optimization instance = (Optimization) sessionFactory.getCurrentSession().get("com.sd.app.bean.optimization.Optimization", id);
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

	public List<Optimization> findByExample(Optimization instance) {
		log.debug("finding Optimization instance by example");
		try {
			List<Optimization> results = (List<Optimization>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.optimization.Optimization").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
