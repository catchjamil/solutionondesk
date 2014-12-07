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
 * Home object for domain model class OrderStatus.
 * @see com.sd.app.bean.misreport.OrderStatus
 * @author Hibernate Tools
 */
public class OrderStatusHome {

	private static final Log log = LogFactory.getLog(OrderStatusHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OrderStatus transientInstance) {
		log.debug("persisting OrderStatus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderStatus instance) {
		log.debug("attaching dirty OrderStatus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderStatus instance) {
		log.debug("attaching clean OrderStatus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrderStatus persistentInstance) {
		log.debug("deleting OrderStatus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderStatus merge(OrderStatus detachedInstance) {
		log.debug("merging OrderStatus instance");
		try {
			OrderStatus result = (OrderStatus) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderStatus findById(com.sd.app.bean.misreport.OrderStatusId id) {
		log.debug("getting OrderStatus instance with id: " + id);
		try {
			OrderStatus instance = (OrderStatus) sessionFactory.getCurrentSession().get("com.sd.app.bean.misreport.OrderStatus", id);
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

	public List<OrderStatus> findByExample(OrderStatus instance) {
		log.debug("finding OrderStatus instance by example");
		try {
			List<OrderStatus> results = (List<OrderStatus>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.misreport.OrderStatus").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
