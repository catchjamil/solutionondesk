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
 * Home object for domain model class RawRates.
 * @see com.sd.app.bean.rawstock.RawRates
 * @author Hibernate Tools
 */
public class RawRatesHome {

	private static final Log log = LogFactory.getLog(RawRatesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawRates transientInstance) {
		log.debug("persisting RawRates instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawRates instance) {
		log.debug("attaching dirty RawRates instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawRates instance) {
		log.debug("attaching clean RawRates instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawRates persistentInstance) {
		log.debug("deleting RawRates instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawRates merge(RawRates detachedInstance) {
		log.debug("merging RawRates instance");
		try {
			RawRates result = (RawRates) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawRates findById(com.sd.app.bean.rawstock.RawRatesId id) {
		log.debug("getting RawRates instance with id: " + id);
		try {
			RawRates instance = (RawRates) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RawRates", id);
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

	public List<RawRates> findByExample(RawRates instance) {
		log.debug("finding RawRates instance by example");
		try {
			List<RawRates> results = (List<RawRates>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.rawstock.RawRates")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
