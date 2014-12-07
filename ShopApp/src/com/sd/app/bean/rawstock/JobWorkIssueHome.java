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
 * Home object for domain model class JobWorkIssue.
 * @see com.sd.app.bean.rawstock.JobWorkIssue
 * @author Hibernate Tools
 */
public class JobWorkIssueHome {

	private static final Log log = LogFactory.getLog(JobWorkIssueHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(JobWorkIssue transientInstance) {
		log.debug("persisting JobWorkIssue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JobWorkIssue instance) {
		log.debug("attaching dirty JobWorkIssue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JobWorkIssue instance) {
		log.debug("attaching clean JobWorkIssue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JobWorkIssue persistentInstance) {
		log.debug("deleting JobWorkIssue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JobWorkIssue merge(JobWorkIssue detachedInstance) {
		log.debug("merging JobWorkIssue instance");
		try {
			JobWorkIssue result = (JobWorkIssue) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JobWorkIssue findById(com.sd.app.bean.rawstock.JobWorkIssueId id) {
		log.debug("getting JobWorkIssue instance with id: " + id);
		try {
			JobWorkIssue instance = (JobWorkIssue) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.JobWorkIssue", id);
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

	public List<JobWorkIssue> findByExample(JobWorkIssue instance) {
		log.debug("finding JobWorkIssue instance by example");
		try {
			List<JobWorkIssue> results = (List<JobWorkIssue>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.JobWorkIssue").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
