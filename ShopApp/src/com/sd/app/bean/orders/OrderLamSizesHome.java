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
 * Home object for domain model class OrderLamSizes.
 * @see com.sd.app.bean.orders.OrderLamSizes
 * @author Hibernate Tools
 */
public class OrderLamSizesHome {

	private static final Log log = LogFactory.getLog(OrderLamSizesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OrderLamSizes transientInstance) {
		log.debug("persisting OrderLamSizes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderLamSizes instance) {
		log.debug("attaching dirty OrderLamSizes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderLamSizes instance) {
		log.debug("attaching clean OrderLamSizes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrderLamSizes persistentInstance) {
		log.debug("deleting OrderLamSizes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderLamSizes merge(OrderLamSizes detachedInstance) {
		log.debug("merging OrderLamSizes instance");
		try {
			OrderLamSizes result = (OrderLamSizes) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderLamSizes findById(com.sd.app.bean.orders.OrderLamSizesId id) {
		log.debug("getting OrderLamSizes instance with id: " + id);
		try {
			OrderLamSizes instance = (OrderLamSizes) sessionFactory.getCurrentSession().get("com.sd.app.bean.orders.OrderLamSizes", id);
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

	public List<OrderLamSizes> findByExample(OrderLamSizes instance) {
		log.debug("finding OrderLamSizes instance by example");
		try {
			List<OrderLamSizes> results = (List<OrderLamSizes>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.orders.OrderLamSizes").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
