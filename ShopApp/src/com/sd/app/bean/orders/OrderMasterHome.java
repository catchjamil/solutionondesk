package com.sd.app.bean.orders;

// Generated Nov 22, 2014 1:10:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class OrderMaster.
 * @see com.sd.app.bean.orders.OrderMaster
 * @author Hibernate Tools
 */
public class OrderMasterHome {

	private static final Log log = LogFactory.getLog(OrderMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OrderMaster transientInstance) {
		log.debug("persisting OrderMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderMaster instance) {
		log.debug("attaching dirty OrderMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderMaster instance) {
		log.debug("attaching clean OrderMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrderMaster persistentInstance) {
		log.debug("deleting OrderMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderMaster merge(OrderMaster detachedInstance) {
		log.debug("merging OrderMaster instance");
		try {
			OrderMaster result = (OrderMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderMaster findById(com.sd.app.bean.orders.OrderMasterId id) {
		log.debug("getting OrderMaster instance with id: " + id);
		try {
			OrderMaster instance = (OrderMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.orders.OrderMaster", id);
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

	public List<OrderMaster> findByExample(OrderMaster instance) {
		log.debug("finding OrderMaster instance by example");
		try {
			List<OrderMaster> results = (List<OrderMaster>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.orders.OrderMaster")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
