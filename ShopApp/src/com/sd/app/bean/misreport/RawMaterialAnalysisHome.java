package com.sd.app.bean.misreport;

// Generated Nov 22, 2014 1:06:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RawMaterialAnalysis.
 * @see com.sd.app.bean.misreport.RawMaterialAnalysis
 * @author Hibernate Tools
 */
public class RawMaterialAnalysisHome {

	private static final Log log = LogFactory.getLog(RawMaterialAnalysisHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawMaterialAnalysis transientInstance) {
		log.debug("persisting RawMaterialAnalysis instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawMaterialAnalysis instance) {
		log.debug("attaching dirty RawMaterialAnalysis instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawMaterialAnalysis instance) {
		log.debug("attaching clean RawMaterialAnalysis instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawMaterialAnalysis persistentInstance) {
		log.debug("deleting RawMaterialAnalysis instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawMaterialAnalysis merge(RawMaterialAnalysis detachedInstance) {
		log.debug("merging RawMaterialAnalysis instance");
		try {
			RawMaterialAnalysis result = (RawMaterialAnalysis) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawMaterialAnalysis findById(com.sd.app.bean.misreport.RawMaterialAnalysisId id) {
		log.debug("getting RawMaterialAnalysis instance with id: " + id);
		try {
			RawMaterialAnalysis instance = (RawMaterialAnalysis) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.misreport.RawMaterialAnalysis", id);
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

	public List<RawMaterialAnalysis> findByExample(RawMaterialAnalysis instance) {
		log.debug("finding RawMaterialAnalysis instance by example");
		try {
			List<RawMaterialAnalysis> results = (List<RawMaterialAnalysis>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.misreport.RawMaterialAnalysis").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
