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
 * Home object for domain model class OptHead.
 * @see com.sd.app.bean.optimization.OptHead
 * @author Hibernate Tools
 */
public class OptHeadHome {

	private static final Log log = LogFactory.getLog(OptHeadHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OptHead transientInstance) {
		log.debug("persisting OptHead instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OptHead instance) {
		log.debug("attaching dirty OptHead instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OptHead instance) {
		log.debug("attaching clean OptHead instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OptHead persistentInstance) {
		log.debug("deleting OptHead instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OptHead merge(OptHead detachedInstance) {
		log.debug("merging OptHead instance");
		try {
			OptHead result = (OptHead) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OptHead findById(com.sd.app.bean.optimization.OptHeadId id) {
		log.debug("getting OptHead instance with id: " + id);
		try {
			OptHead instance = (OptHead) sessionFactory.getCurrentSession().get("com.sd.app.bean.optimization.OptHead", id);
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

	public List<OptHead> findByExample(OptHead instance) {
		log.debug("finding OptHead instance by example");
		try {
			List<OptHead> results = (List<OptHead>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.optimization.OptHead")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
