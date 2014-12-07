package com.sd.app.bean.misreport1;

// Generated Nov 22, 2014 1:07:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RawMaterialSummary.
 * @see com.sd.app.bean.misreport1.RawMaterialSummary
 * @author Hibernate Tools
 */
public class RawMaterialSummaryHome {

	private static final Log log = LogFactory.getLog(RawMaterialSummaryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawMaterialSummary transientInstance) {
		log.debug("persisting RawMaterialSummary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawMaterialSummary instance) {
		log.debug("attaching dirty RawMaterialSummary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawMaterialSummary instance) {
		log.debug("attaching clean RawMaterialSummary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawMaterialSummary persistentInstance) {
		log.debug("deleting RawMaterialSummary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawMaterialSummary merge(RawMaterialSummary detachedInstance) {
		log.debug("merging RawMaterialSummary instance");
		try {
			RawMaterialSummary result = (RawMaterialSummary) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawMaterialSummary findById(com.sd.app.bean.misreport1.RawMaterialSummaryId id) {
		log.debug("getting RawMaterialSummary instance with id: " + id);
		try {
			RawMaterialSummary instance = (RawMaterialSummary) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.misreport1.RawMaterialSummary", id);
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

	public List<RawMaterialSummary> findByExample(RawMaterialSummary instance) {
		log.debug("finding RawMaterialSummary instance by example");
		try {
			List<RawMaterialSummary> results = (List<RawMaterialSummary>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.misreport1.RawMaterialSummary").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
