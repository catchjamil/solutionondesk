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
 * Home object for domain model class OptDetails.
 * @see com.sd.app.bean.optimization.OptDetails
 * @author Hibernate Tools
 */
public class OptDetailsHome {

	private static final Log log = LogFactory.getLog(OptDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OptDetails transientInstance) {
		log.debug("persisting OptDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OptDetails instance) {
		log.debug("attaching dirty OptDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OptDetails instance) {
		log.debug("attaching clean OptDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OptDetails persistentInstance) {
		log.debug("deleting OptDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OptDetails merge(OptDetails detachedInstance) {
		log.debug("merging OptDetails instance");
		try {
			OptDetails result = (OptDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OptDetails findById(com.sd.app.bean.optimization.OptDetailsId id) {
		log.debug("getting OptDetails instance with id: " + id);
		try {
			OptDetails instance = (OptDetails) sessionFactory.getCurrentSession().get("com.sd.app.bean.optimization.OptDetails", id);
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

	public List<OptDetails> findByExample(OptDetails instance) {
		log.debug("finding OptDetails instance by example");
		try {
			List<OptDetails> results = (List<OptDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.optimization.OptDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
