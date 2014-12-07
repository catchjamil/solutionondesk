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
 * Home object for domain model class JobWorkReceipts.
 * @see com.sd.app.bean.rawstock.JobWorkReceipts
 * @author Hibernate Tools
 */
public class JobWorkReceiptsHome {

	private static final Log log = LogFactory.getLog(JobWorkReceiptsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(JobWorkReceipts transientInstance) {
		log.debug("persisting JobWorkReceipts instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JobWorkReceipts instance) {
		log.debug("attaching dirty JobWorkReceipts instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobWorkReceipts instance) {
		log.debug("attaching clean JobWorkReceipts instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JobWorkReceipts persistentInstance) {
		log.debug("deleting JobWorkReceipts instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobWorkReceipts merge(JobWorkReceipts detachedInstance) {
		log.debug("merging JobWorkReceipts instance");
		try {
			JobWorkReceipts result = (JobWorkReceipts) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JobWorkReceipts findById(com.sd.app.bean.rawstock.JobWorkReceiptsId id) {
		log.debug("getting JobWorkReceipts instance with id: " + id);
		try {
			JobWorkReceipts instance = (JobWorkReceipts) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.JobWorkReceipts", id);
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

	public List<JobWorkReceipts> findByExample(JobWorkReceipts instance) {
		log.debug("finding JobWorkReceipts instance by example");
		try {
			List<JobWorkReceipts> results = (List<JobWorkReceipts>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.JobWorkReceipts").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
