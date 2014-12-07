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
 * Home object for domain model class ExtraRtables.
 * @see com.sd.app.bean.ratetables.ExtraRtables
 * @author Hibernate Tools
 */
public class ExtraRtablesHome {

	private static final Log log = LogFactory.getLog(ExtraRtablesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExtraRtables transientInstance) {
		log.debug("persisting ExtraRtables instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExtraRtables instance) {
		log.debug("attaching dirty ExtraRtables instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExtraRtables instance) {
		log.debug("attaching clean ExtraRtables instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExtraRtables persistentInstance) {
		log.debug("deleting ExtraRtables instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExtraRtables merge(ExtraRtables detachedInstance) {
		log.debug("merging ExtraRtables instance");
		try {
			ExtraRtables result = (ExtraRtables) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExtraRtables findById(com.sd.app.bean.ratetables.ExtraRtablesId id) {
		log.debug("getting ExtraRtables instance with id: " + id);
		try {
			ExtraRtables instance = (ExtraRtables) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.ExtraRtables", id);
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

	public List<ExtraRtables> findByExample(ExtraRtables instance) {
		log.debug("finding ExtraRtables instance by example");
		try {
			List<ExtraRtables> results = (List<ExtraRtables>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.ratetables.ExtraRtables").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
