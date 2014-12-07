package com.sd.app.bean.orders;

// Generated Nov 22, 2014 1:10:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ExportImport.
 * @see com.sd.app.bean.orders.ExportImport
 * @author Hibernate Tools
 */
public class ExportImportHome {

	private static final Log log = LogFactory.getLog(ExportImportHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExportImport transientInstance) {
		log.debug("persisting ExportImport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExportImport instance) {
		log.debug("attaching dirty ExportImport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExportImport instance) {
		log.debug("attaching clean ExportImport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExportImport persistentInstance) {
		log.debug("deleting ExportImport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExportImport merge(ExportImport detachedInstance) {
		log.debug("merging ExportImport instance");
		try {
			ExportImport result = (ExportImport) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExportImport findById(com.sd.app.bean.orders.ExportImportId id) {
		log.debug("getting ExportImport instance with id: " + id);
		try {
			ExportImport instance = (ExportImport) sessionFactory.getCurrentSession().get("com.sd.app.bean.orders.ExportImport", id);
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

	public List<ExportImport> findByExample(ExportImport instance) {
		log.debug("finding ExportImport instance by example");
		try {
			List<ExportImport> results = (List<ExportImport>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.orders.ExportImport").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
