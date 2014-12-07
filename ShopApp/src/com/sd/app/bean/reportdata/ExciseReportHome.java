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
 * Home object for domain model class ExciseReport.
 * @see com.sd.app.bean.reportdata.ExciseReport
 * @author Hibernate Tools
 */
public class ExciseReportHome {

	private static final Log log = LogFactory.getLog(ExciseReportHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseReport transientInstance) {
		log.debug("persisting ExciseReport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseReport instance) {
		log.debug("attaching dirty ExciseReport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseReport instance) {
		log.debug("attaching clean ExciseReport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseReport persistentInstance) {
		log.debug("deleting ExciseReport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseReport merge(ExciseReport detachedInstance) {
		log.debug("merging ExciseReport instance");
		try {
			ExciseReport result = (ExciseReport) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseReport findById(com.sd.app.bean.reportdata.ExciseReportId id) {
		log.debug("getting ExciseReport instance with id: " + id);
		try {
			ExciseReport instance = (ExciseReport) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.ExciseReport", id);
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

	public List<ExciseReport> findByExample(ExciseReport instance) {
		log.debug("finding ExciseReport instance by example");
		try {
			List<ExciseReport> results = (List<ExciseReport>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.ExciseReport").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
