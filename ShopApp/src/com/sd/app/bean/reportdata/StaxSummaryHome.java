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
 * Home object for domain model class StaxSummary.
 * @see com.sd.app.bean.reportdata.StaxSummary
 * @author Hibernate Tools
 */
public class StaxSummaryHome {

	private static final Log log = LogFactory.getLog(StaxSummaryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StaxSummary transientInstance) {
		log.debug("persisting StaxSummary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StaxSummary instance) {
		log.debug("attaching dirty StaxSummary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StaxSummary instance) {
		log.debug("attaching clean StaxSummary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StaxSummary persistentInstance) {
		log.debug("deleting StaxSummary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StaxSummary merge(StaxSummary detachedInstance) {
		log.debug("merging StaxSummary instance");
		try {
			StaxSummary result = (StaxSummary) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StaxSummary findById(com.sd.app.bean.reportdata.StaxSummaryId id) {
		log.debug("getting StaxSummary instance with id: " + id);
		try {
			StaxSummary instance = (StaxSummary) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.StaxSummary", id);
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

	public List<StaxSummary> findByExample(StaxSummary instance) {
		log.debug("finding StaxSummary instance by example");
		try {
			List<StaxSummary> results = (List<StaxSummary>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.StaxSummary").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
