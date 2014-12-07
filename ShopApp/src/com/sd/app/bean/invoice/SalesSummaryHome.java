package com.sd.app.bean.invoice;

// Generated Nov 22, 2014 1:01:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SalesSummary.
 * @see com.sd.app.bean.invoice.SalesSummary
 * @author Hibernate Tools
 */
public class SalesSummaryHome {

	private static final Log log = LogFactory.getLog(SalesSummaryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SalesSummary transientInstance) {
		log.debug("persisting SalesSummary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SalesSummary instance) {
		log.debug("attaching dirty SalesSummary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalesSummary instance) {
		log.debug("attaching clean SalesSummary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SalesSummary persistentInstance) {
		log.debug("deleting SalesSummary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalesSummary merge(SalesSummary detachedInstance) {
		log.debug("merging SalesSummary instance");
		try {
			SalesSummary result = (SalesSummary) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SalesSummary findById(com.sd.app.bean.invoice.SalesSummaryId id) {
		log.debug("getting SalesSummary instance with id: " + id);
		try {
			SalesSummary instance = (SalesSummary) sessionFactory.getCurrentSession().get("com.sd.app.bean.invoice.SalesSummary", id);
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

	public List<SalesSummary> findByExample(SalesSummary instance) {
		log.debug("finding SalesSummary instance by example");
		try {
			List<SalesSummary> results = (List<SalesSummary>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.invoice.SalesSummary").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
