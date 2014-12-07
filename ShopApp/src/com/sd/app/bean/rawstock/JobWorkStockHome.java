package com.sd.app.bean.rawstock;

// Generated Nov 22, 2014 1:16:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class JobWorkStock.
 * @see com.sd.app.bean.rawstock.JobWorkStock
 * @author Hibernate Tools
 */
public class JobWorkStockHome {

	private static final Log log = LogFactory.getLog(JobWorkStockHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(JobWorkStock transientInstance) {
		log.debug("persisting JobWorkStock instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JobWorkStock instance) {
		log.debug("attaching dirty JobWorkStock instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobWorkStock instance) {
		log.debug("attaching clean JobWorkStock instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JobWorkStock persistentInstance) {
		log.debug("deleting JobWorkStock instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobWorkStock merge(JobWorkStock detachedInstance) {
		log.debug("merging JobWorkStock instance");
		try {
			JobWorkStock result = (JobWorkStock) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JobWorkStock findById(com.sd.app.bean.rawstock.JobWorkStockId id) {
		log.debug("getting JobWorkStock instance with id: " + id);
		try {
			JobWorkStock instance = (JobWorkStock) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.JobWorkStock", id);
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

	public List<JobWorkStock> findByExample(JobWorkStock instance) {
		log.debug("finding JobWorkStock instance by example");
		try {
			List<JobWorkStock> results = (List<JobWorkStock>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.JobWorkStock").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
