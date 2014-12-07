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
 * Home object for domain model class ExciseInvoiceRegDetails.
 * @see com.sd.app.bean.reportdata.ExciseInvoiceRegDetails
 * @author Hibernate Tools
 */
public class ExciseInvoiceRegDetailsHome {

	private static final Log log = LogFactory.getLog(ExciseInvoiceRegDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseInvoiceRegDetails transientInstance) {
		log.debug("persisting ExciseInvoiceRegDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseInvoiceRegDetails instance) {
		log.debug("attaching dirty ExciseInvoiceRegDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseInvoiceRegDetails instance) {
		log.debug("attaching clean ExciseInvoiceRegDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseInvoiceRegDetails persistentInstance) {
		log.debug("deleting ExciseInvoiceRegDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseInvoiceRegDetails merge(ExciseInvoiceRegDetails detachedInstance) {
		log.debug("merging ExciseInvoiceRegDetails instance");
		try {
			ExciseInvoiceRegDetails result = (ExciseInvoiceRegDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseInvoiceRegDetails findById(com.sd.app.bean.reportdata.ExciseInvoiceRegDetailsId id) {
		log.debug("getting ExciseInvoiceRegDetails instance with id: " + id);
		try {
			ExciseInvoiceRegDetails instance = (ExciseInvoiceRegDetails) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.reportdata.ExciseInvoiceRegDetails", id);
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

	public List<ExciseInvoiceRegDetails> findByExample(ExciseInvoiceRegDetails instance) {
		log.debug("finding ExciseInvoiceRegDetails instance by example");
		try {
			List<ExciseInvoiceRegDetails> results = (List<ExciseInvoiceRegDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.ExciseInvoiceRegDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
