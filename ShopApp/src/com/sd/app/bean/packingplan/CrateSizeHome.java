package com.sd.app.bean.packingplan;

// Generated Nov 22, 2014 1:11:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CrateSize.
 * @see com.sd.app.bean.packingplan.CrateSize
 * @author Hibernate Tools
 */
public class CrateSizeHome {

	private static final Log log = LogFactory.getLog(CrateSizeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CrateSize transientInstance) {
		log.debug("persisting CrateSize instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CrateSize instance) {
		log.debug("attaching dirty CrateSize instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CrateSize instance) {
		log.debug("attaching clean CrateSize instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CrateSize persistentInstance) {
		log.debug("deleting CrateSize instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CrateSize merge(CrateSize detachedInstance) {
		log.debug("merging CrateSize instance");
		try {
			CrateSize result = (CrateSize) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CrateSize findById(com.sd.app.bean.packingplan.CrateSizeId id) {
		log.debug("getting CrateSize instance with id: " + id);
		try {
			CrateSize instance = (CrateSize) sessionFactory.getCurrentSession().get("com.sd.app.bean.packingplan.CrateSize", id);
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

	public List<CrateSize> findByExample(CrateSize instance) {
		log.debug("finding CrateSize instance by example");
		try {
			List<CrateSize> results = (List<CrateSize>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.packingplan.CrateSize")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
