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
 * Home object for domain model class RawPurOrders.
 * @see com.sd.app.bean.rawstock.RawPurOrders
 * @author Hibernate Tools
 */
public class RawPurOrdersHome {

	private static final Log log = LogFactory.getLog(RawPurOrdersHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RawPurOrders transientInstance) {
		log.debug("persisting RawPurOrders instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RawPurOrders instance) {
		log.debug("attaching dirty RawPurOrders instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RawPurOrders instance) {
		log.debug("attaching clean RawPurOrders instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RawPurOrders persistentInstance) {
		log.debug("deleting RawPurOrders instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RawPurOrders merge(RawPurOrders detachedInstance) {
		log.debug("merging RawPurOrders instance");
		try {
			RawPurOrders result = (RawPurOrders) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawPurOrders findById(java.lang.Integer id) {
		log.debug("getting RawPurOrders instance with id: " + id);
		try {
			RawPurOrders instance = (RawPurOrders) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RawPurOrders", id);
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

	public List<RawPurOrders> findByExample(RawPurOrders instance) {
		log.debug("finding RawPurOrders instance by example");
		try {
			List<RawPurOrders> results = (List<RawPurOrders>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.RawPurOrders").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
