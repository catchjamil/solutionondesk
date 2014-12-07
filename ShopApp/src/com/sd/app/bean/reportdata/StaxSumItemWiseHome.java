package com.sd.app.bean.reportdata;

// Generated Nov 22, 2014 1:17:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class StaxSumItemWise.
 * @see com.sd.app.bean.reportdata.StaxSumItemWise
 * @author Hibernate Tools
 */
public class StaxSumItemWiseHome {

	private static final Log log = LogFactory.getLog(StaxSumItemWiseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StaxSumItemWise transientInstance) {
		log.debug("persisting StaxSumItemWise instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StaxSumItemWise instance) {
		log.debug("attaching dirty StaxSumItemWise instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StaxSumItemWise instance) {
		log.debug("attaching clean StaxSumItemWise instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StaxSumItemWise persistentInstance) {
		log.debug("deleting StaxSumItemWise instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StaxSumItemWise merge(StaxSumItemWise detachedInstance) {
		log.debug("merging StaxSumItemWise instance");
		try {
			StaxSumItemWise result = (StaxSumItemWise) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StaxSumItemWise findById(com.sd.app.bean.reportdata.StaxSumItemWiseId id) {
		log.debug("getting StaxSumItemWise instance with id: " + id);
		try {
			StaxSumItemWise instance = (StaxSumItemWise) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.StaxSumItemWise", id);
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

	public List<StaxSumItemWise> findByExample(StaxSumItemWise instance) {
		log.debug("finding StaxSumItemWise instance by example");
		try {
			List<StaxSumItemWise> results = (List<StaxSumItemWise>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.StaxSumItemWise").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
