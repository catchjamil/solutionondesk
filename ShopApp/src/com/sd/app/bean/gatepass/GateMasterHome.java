package com.sd.app.bean.gatepass;

// Generated Nov 22, 2014 12:57:03 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class GateMaster.
 * @see com.sd.app.bean.gatepass.GateMaster
 * @author Hibernate Tools
 */
public class GateMasterHome {

	private static final Log log = LogFactory.getLog(GateMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(GateMaster transientInstance) {
		log.debug("persisting GateMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GateMaster instance) {
		log.debug("attaching dirty GateMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GateMaster instance) {
		log.debug("attaching clean GateMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GateMaster persistentInstance) {
		log.debug("deleting GateMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GateMaster merge(GateMaster detachedInstance) {
		log.debug("merging GateMaster instance");
		try {
			GateMaster result = (GateMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GateMaster findById(com.sd.app.bean.gatepass.GateMasterId id) {
		log.debug("getting GateMaster instance with id: " + id);
		try {
			GateMaster instance = (GateMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.gatepass.GateMaster", id);
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

	public List<GateMaster> findByExample(GateMaster instance) {
		log.debug("finding GateMaster instance by example");
		try {
			List<GateMaster> results = (List<GateMaster>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.gatepass.GateMaster")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
