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
 * Home object for domain model class TransferRates.
 * @see com.sd.app.bean.ratetables.TransferRates
 * @author Hibernate Tools
 */
public class TransferRatesHome {

	private static final Log log = LogFactory.getLog(TransferRatesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TransferRates transientInstance) {
		log.debug("persisting TransferRates instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TransferRates instance) {
		log.debug("attaching dirty TransferRates instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TransferRates instance) {
		log.debug("attaching clean TransferRates instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TransferRates persistentInstance) {
		log.debug("deleting TransferRates instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TransferRates merge(TransferRates detachedInstance) {
		log.debug("merging TransferRates instance");
		try {
			TransferRates result = (TransferRates) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TransferRates findById(com.sd.app.bean.ratetables.TransferRatesId id) {
		log.debug("getting TransferRates instance with id: " + id);
		try {
			TransferRates instance = (TransferRates) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.TransferRates", id);
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

	public List<TransferRates> findByExample(TransferRates instance) {
		log.debug("finding TransferRates instance by example");
		try {
			List<TransferRates> results = (List<TransferRates>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.ratetables.TransferRates").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
