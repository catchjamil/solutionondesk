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
 * Home object for domain model class OrderSub.
 * @see com.sd.app.bean.orders.OrderSub
 * @author Hibernate Tools
 */
public class OrderSubHome {

	private static final Log log = LogFactory.getLog(OrderSubHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OrderSub transientInstance) {
		log.debug("persisting OrderSub instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderSub instance) {
		log.debug("attaching dirty OrderSub instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderSub instance) {
		log.debug("attaching clean OrderSub instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrderSub persistentInstance) {
		log.debug("deleting OrderSub instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderSub merge(OrderSub detachedInstance) {
		log.debug("merging OrderSub instance");
		try {
			OrderSub result = (OrderSub) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderSub findById(com.sd.app.bean.orders.OrderSubId id) {
		log.debug("getting OrderSub instance with id: " + id);
		try {
			OrderSub instance = (OrderSub) sessionFactory.getCurrentSession().get("com.sd.app.bean.orders.OrderSub", id);
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

	public List<OrderSub> findByExample(OrderSub instance) {
		log.debug("finding OrderSub instance by example");
		try {
			List<OrderSub> results = (List<OrderSub>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.orders.OrderSub")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
