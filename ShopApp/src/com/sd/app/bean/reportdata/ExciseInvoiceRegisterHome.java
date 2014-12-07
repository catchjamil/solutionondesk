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
 * Home object for domain model class ExciseInvoiceRegister.
 * @see com.sd.app.bean.reportdata.ExciseInvoiceRegister
 * @author Hibernate Tools
 */
public class ExciseInvoiceRegisterHome {

	private static final Log log = LogFactory.getLog(ExciseInvoiceRegisterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseInvoiceRegister transientInstance) {
		log.debug("persisting ExciseInvoiceRegister instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseInvoiceRegister instance) {
		log.debug("attaching dirty ExciseInvoiceRegister instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseInvoiceRegister instance) {
		log.debug("attaching clean ExciseInvoiceRegister instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseInvoiceRegister persistentInstance) {
		log.debug("deleting ExciseInvoiceRegister instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseInvoiceRegister merge(ExciseInvoiceRegister detachedInstance) {
		log.debug("merging ExciseInvoiceRegister instance");
		try {
			ExciseInvoiceRegister result = (ExciseInvoiceRegister) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseInvoiceRegister findById(com.sd.app.bean.reportdata.ExciseInvoiceRegisterId id) {
		log.debug("getting ExciseInvoiceRegister instance with id: " + id);
		try {
			ExciseInvoiceRegister instance = (ExciseInvoiceRegister) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.reportdata.ExciseInvoiceRegister", id);
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

	public List<ExciseInvoiceRegister> findByExample(ExciseInvoiceRegister instance) {
		log.debug("finding ExciseInvoiceRegister instance by example");
		try {
			List<ExciseInvoiceRegister> results = (List<ExciseInvoiceRegister>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.ExciseInvoiceRegister").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
