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
 * Home object for domain model class PendingRates.
 * @see com.sd.app.bean.misreport.PendingRates
 * @author Hibernate Tools
 */
public class PendingRatesHome {

	private static final Log log = LogFactory.getLog(PendingRatesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PendingRates transientInstance) {
		log.debug("persisting PendingRates instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingRates instance) {
		log.debug("attaching dirty PendingRates instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingRates instance) {
		log.debug("attaching clean PendingRates instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingRates persistentInstance) {
		log.debug("deleting PendingRates instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingRates merge(PendingRates detachedInstance) {
		log.debug("merging PendingRates instance");
		try {
			PendingRates result = (PendingRates) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingRates findById(com.sd.app.bean.misreport.PendingRatesId id) {
		log.debug("getting PendingRates instance with id: " + id);
		try {
			PendingRates instance = (PendingRates) sessionFactory.getCurrentSession().get("com.sd.app.bean.misreport.PendingRates", id);
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

	public List<PendingRates> findByExample(PendingRates instance) {
		log.debug("finding PendingRates instance by example");
		try {
			List<PendingRates> results = (List<PendingRates>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.misreport.PendingRates").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
