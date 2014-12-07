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
 * Home object for domain model class FreightAc.
 * @see com.sd.app.bean.masters.FreightAc
 * @author Hibernate Tools
 */
public class FreightAcHome {

	private static final Log log = LogFactory.getLog(FreightAcHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FreightAc transientInstance) {
		log.debug("persisting FreightAc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FreightAc instance) {
		log.debug("attaching dirty FreightAc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FreightAc instance) {
		log.debug("attaching clean FreightAc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FreightAc persistentInstance) {
		log.debug("deleting FreightAc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FreightAc merge(FreightAc detachedInstance) {
		log.debug("merging FreightAc instance");
		try {
			FreightAc result = (FreightAc) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FreightAc findById(com.sd.app.bean.masters.FreightAcId id) {
		log.debug("getting FreightAc instance with id: " + id);
		try {
			FreightAc instance = (FreightAc) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.FreightAc", id);
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

	public List<FreightAc> findByExample(FreightAc instance) {
		log.debug("finding FreightAc instance by example");
		try {
			List<FreightAc> results = (List<FreightAc>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.FreightAc")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
