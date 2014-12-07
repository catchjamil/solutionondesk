package com.sd.app.bean.challan;

// Generated Nov 22, 2014 12:50:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ExciseChallanDetails.
 * @see com.sd.app.bean.challan.ExciseChallanDetails
 * @author Hibernate Tools
 */
public class ExciseChallanDetailsHome {

	private static final Log log = LogFactory.getLog(ExciseChallanDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExciseChallanDetails transientInstance) {
		log.debug("persisting ExciseChallanDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExciseChallanDetails instance) {
		log.debug("attaching dirty ExciseChallanDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExciseChallanDetails instance) {
		log.debug("attaching clean ExciseChallanDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExciseChallanDetails persistentInstance) {
		log.debug("deleting ExciseChallanDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExciseChallanDetails merge(ExciseChallanDetails detachedInstance) {
		log.debug("merging ExciseChallanDetails instance");
		try {
			ExciseChallanDetails result = (ExciseChallanDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExciseChallanDetails findById(com.sd.app.bean.challan.ExciseChallanDetailsId id) {
		log.debug("getting ExciseChallanDetails instance with id: " + id);
		try {
			ExciseChallanDetails instance = (ExciseChallanDetails) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.challan.ExciseChallanDetails", id);
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

	public List<ExciseChallanDetails> findByExample(ExciseChallanDetails instance) {
		log.debug("finding ExciseChallanDetails instance by example");
		try {
			List<ExciseChallanDetails> results = (List<ExciseChallanDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.challan.ExciseChallanDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
