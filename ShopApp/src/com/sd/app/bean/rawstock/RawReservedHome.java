package com.sd.app.bean.rawstock;

// Generated Nov 22, 2014 1:16:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RawReserved.
 * @see com.sd.app.bean.rawstock.RawReserved
 * @author Hibernate Tools
 */
public class RawReservedHome {

	private static final Log log = LogFactory.getLog(RawReservedHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawReserved transientInstance) {
		log.debug("persisting RawReserved instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawReserved instance) {
		log.debug("attaching dirty RawReserved instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawReserved instance) {
		log.debug("attaching clean RawReserved instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawReserved persistentInstance) {
		log.debug("deleting RawReserved instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawReserved merge(RawReserved detachedInstance) {
		log.debug("merging RawReserved instance");
		try {
			RawReserved result = (RawReserved) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawReserved findById(com.sd.app.bean.rawstock.RawReservedId id) {
		log.debug("getting RawReserved instance with id: " + id);
		try {
			RawReserved instance = (RawReserved) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RawReserved", id);
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

	public List<RawReserved> findByExample(RawReserved instance) {
		log.debug("finding RawReserved instance by example");
		try {
			List<RawReserved> results = (List<RawReserved>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.rawstock.RawReserved")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
