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
 * Home object for domain model class SqmRtables.
 * @see com.sd.app.bean.ratetables.SqmRtables
 * @author Hibernate Tools
 */
public class SqmRtablesHome {

	private static final Log log = LogFactory.getLog(SqmRtablesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SqmRtables transientInstance) {
		log.debug("persisting SqmRtables instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SqmRtables instance) {
		log.debug("attaching dirty SqmRtables instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SqmRtables instance) {
		log.debug("attaching clean SqmRtables instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SqmRtables persistentInstance) {
		log.debug("deleting SqmRtables instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SqmRtables merge(SqmRtables detachedInstance) {
		log.debug("merging SqmRtables instance");
		try {
			SqmRtables result = (SqmRtables) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SqmRtables findById(com.sd.app.bean.ratetables.SqmRtablesId id) {
		log.debug("getting SqmRtables instance with id: " + id);
		try {
			SqmRtables instance = (SqmRtables) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.SqmRtables", id);
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

	public List<SqmRtables> findByExample(SqmRtables instance) {
		log.debug("finding SqmRtables instance by example");
		try {
			List<SqmRtables> results = (List<SqmRtables>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.ratetables.SqmRtables")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
