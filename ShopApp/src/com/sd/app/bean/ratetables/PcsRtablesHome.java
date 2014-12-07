package com.sd.app.bean.ratetables;

// Generated Nov 22, 2014 1:15:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PcsRtables.
 * @see com.sd.app.bean.ratetables.PcsRtables
 * @author Hibernate Tools
 */
public class PcsRtablesHome {

	private static final Log log = LogFactory.getLog(PcsRtablesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PcsRtables transientInstance) {
		log.debug("persisting PcsRtables instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcsRtables instance) {
		log.debug("attaching dirty PcsRtables instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcsRtables instance) {
		log.debug("attaching clean PcsRtables instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcsRtables persistentInstance) {
		log.debug("deleting PcsRtables instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcsRtables merge(PcsRtables detachedInstance) {
		log.debug("merging PcsRtables instance");
		try {
			PcsRtables result = (PcsRtables) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcsRtables findById(com.sd.app.bean.ratetables.PcsRtablesId id) {
		log.debug("getting PcsRtables instance with id: " + id);
		try {
			PcsRtables instance = (PcsRtables) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.PcsRtables", id);
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

	public List<PcsRtables> findByExample(PcsRtables instance) {
		log.debug("finding PcsRtables instance by example");
		try {
			List<PcsRtables> results = (List<PcsRtables>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.ratetables.PcsRtables")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
