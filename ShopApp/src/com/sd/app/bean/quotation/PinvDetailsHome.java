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
 * Home object for domain model class PinvDetails.
 * @see com.sd.app.bean.quotation.PinvDetails
 * @author Hibernate Tools
 */
public class PinvDetailsHome {

	private static final Log log = LogFactory.getLog(PinvDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PinvDetails transientInstance) {
		log.debug("persisting PinvDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PinvDetails instance) {
		log.debug("attaching dirty PinvDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PinvDetails instance) {
		log.debug("attaching clean PinvDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PinvDetails persistentInstance) {
		log.debug("deleting PinvDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PinvDetails merge(PinvDetails detachedInstance) {
		log.debug("merging PinvDetails instance");
		try {
			PinvDetails result = (PinvDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PinvDetails findById(com.sd.app.bean.quotation.PinvDetailsId id) {
		log.debug("getting PinvDetails instance with id: " + id);
		try {
			PinvDetails instance = (PinvDetails) sessionFactory.getCurrentSession().get("com.sd.app.bean.quotation.PinvDetails", id);
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

	public List<PinvDetails> findByExample(PinvDetails instance) {
		log.debug("finding PinvDetails instance by example");
		try {
			List<PinvDetails> results = (List<PinvDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.quotation.PinvDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
