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
 * Home object for domain model class RawIssue.
 * @see com.sd.app.bean.rawstock.RawIssue
 * @author Hibernate Tools
 */
public class RawIssueHome {

	private static final Log log = LogFactory.getLog(RawIssueHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawIssue transientInstance) {
		log.debug("persisting RawIssue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawIssue instance) {
		log.debug("attaching dirty RawIssue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawIssue instance) {
		log.debug("attaching clean RawIssue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawIssue persistentInstance) {
		log.debug("deleting RawIssue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawIssue merge(RawIssue detachedInstance) {
		log.debug("merging RawIssue instance");
		try {
			RawIssue result = (RawIssue) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawIssue findById(com.sd.app.bean.rawstock.RawIssueId id) {
		log.debug("getting RawIssue instance with id: " + id);
		try {
			RawIssue instance = (RawIssue) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RawIssue", id);
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

	public List<RawIssue> findByExample(RawIssue instance) {
		log.debug("finding RawIssue instance by example");
		try {
			List<RawIssue> results = (List<RawIssue>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.rawstock.RawIssue")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
