package com.sd.app.bean.quotation;

// Generated Nov 22, 2014 1:14:29 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PlamDetails.
 * @see com.sd.app.bean.quotation.PlamDetails
 * @author Hibernate Tools
 */
public class PlamDetailsHome {

	private static final Log log = LogFactory.getLog(PlamDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PlamDetails transientInstance) {
		log.debug("persisting PlamDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlamDetails instance) {
		log.debug("attaching dirty PlamDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlamDetails instance) {
		log.debug("attaching clean PlamDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlamDetails persistentInstance) {
		log.debug("deleting PlamDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlamDetails merge(PlamDetails detachedInstance) {
		log.debug("merging PlamDetails instance");
		try {
			PlamDetails result = (PlamDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlamDetails findById(com.sd.app.bean.quotation.PlamDetailsId id) {
		log.debug("getting PlamDetails instance with id: " + id);
		try {
			PlamDetails instance = (PlamDetails) sessionFactory.getCurrentSession().get("com.sd.app.bean.quotation.PlamDetails", id);
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

	public List<PlamDetails> findByExample(PlamDetails instance) {
		log.debug("finding PlamDetails instance by example");
		try {
			List<PlamDetails> results = (List<PlamDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.quotation.PlamDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
