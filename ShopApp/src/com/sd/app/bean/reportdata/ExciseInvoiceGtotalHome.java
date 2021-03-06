package com.sd.app.bean.reportdata;

// Generated Nov 22, 2014 1:17:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ExciseInvoiceGtotal.
 * @see com.sd.app.bean.reportdata.ExciseInvoiceGtotal
 * @author Hibernate Tools
 */
public class ExciseInvoiceGtotalHome {

	private static final Log log = LogFactory.getLog(ExciseInvoiceGtotalHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseInvoiceGtotal transientInstance) {
		log.debug("persisting ExciseInvoiceGtotal instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseInvoiceGtotal instance) {
		log.debug("attaching dirty ExciseInvoiceGtotal instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseInvoiceGtotal instance) {
		log.debug("attaching clean ExciseInvoiceGtotal instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseInvoiceGtotal persistentInstance) {
		log.debug("deleting ExciseInvoiceGtotal instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseInvoiceGtotal merge(ExciseInvoiceGtotal detachedInstance) {
		log.debug("merging ExciseInvoiceGtotal instance");
		try {
			ExciseInvoiceGtotal result = (ExciseInvoiceGtotal) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseInvoiceGtotal findById(com.sd.app.bean.reportdata.ExciseInvoiceGtotalId id) {
		log.debug("getting ExciseInvoiceGtotal instance with id: " + id);
		try {
			ExciseInvoiceGtotal instance = (ExciseInvoiceGtotal) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.reportdata.ExciseInvoiceGtotal", id);
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

	public List<ExciseInvoiceGtotal> findByExample(ExciseInvoiceGtotal instance) {
		log.debug("finding ExciseInvoiceGtotal instance by example");
		try {
			List<ExciseInvoiceGtotal> results = (List<ExciseInvoiceGtotal>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.ExciseInvoiceGtotal").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
