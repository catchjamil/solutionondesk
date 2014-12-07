package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Tariff.
 * @see com.sd.app.bean.masters.Tariff
 * @author Hibernate Tools
 */
public class TariffHome {

	private static final Log log = LogFactory.getLog(TariffHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tariff transientInstance) {
		log.debug("persisting Tariff instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tariff instance) {
		log.debug("attaching dirty Tariff instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tariff instance) {
		log.debug("attaching clean Tariff instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tariff persistentInstance) {
		log.debug("deleting Tariff instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tariff merge(Tariff detachedInstance) {
		log.debug("merging Tariff instance");
		try {
			Tariff result = (Tariff) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tariff findById(com.sd.app.bean.masters.TariffId id) {
		log.debug("getting Tariff instance with id: " + id);
		try {
			Tariff instance = (Tariff) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.Tariff", id);
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

	public List<Tariff> findByExample(Tariff instance) {
		log.debug("finding Tariff instance by example");
		try {
			List<Tariff> results = (List<Tariff>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.Tariff")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
