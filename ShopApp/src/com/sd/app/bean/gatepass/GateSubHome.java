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
 * Home object for domain model class GateSub.
 * @see com.sd.app.bean.gatepass.GateSub
 * @author Hibernate Tools
 */
public class GateSubHome {

	private static final Log log = LogFactory.getLog(GateSubHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(GateSub transientInstance) {
		log.debug("persisting GateSub instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GateSub instance) {
		log.debug("attaching dirty GateSub instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GateSub instance) {
		log.debug("attaching clean GateSub instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GateSub persistentInstance) {
		log.debug("deleting GateSub instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GateSub merge(GateSub detachedInstance) {
		log.debug("merging GateSub instance");
		try {
			GateSub result = (GateSub) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GateSub findById(com.sd.app.bean.gatepass.GateSubId id) {
		log.debug("getting GateSub instance with id: " + id);
		try {
			GateSub instance = (GateSub) sessionFactory.getCurrentSession().get("com.sd.app.bean.gatepass.GateSub", id);
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

	public List<GateSub> findByExample(GateSub instance) {
		log.debug("finding GateSub instance by example");
		try {
			List<GateSub> results = (List<GateSub>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.gatepass.GateSub")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
