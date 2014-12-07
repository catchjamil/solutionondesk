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
 * Home object for domain model class ReturnableRack.
 * @see com.sd.app.bean.challan.ReturnableRack
 * @author Hibernate Tools
 */
public class ReturnableRackHome {

	private static final Log log = LogFactory.getLog(ReturnableRackHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ReturnableRack transientInstance) {
		log.debug("persisting ReturnableRack instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReturnableRack instance) {
		log.debug("attaching dirty ReturnableRack instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReturnableRack instance) {
		log.debug("attaching clean ReturnableRack instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReturnableRack persistentInstance) {
		log.debug("deleting ReturnableRack instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReturnableRack merge(ReturnableRack detachedInstance) {
		log.debug("merging ReturnableRack instance");
		try {
			ReturnableRack result = (ReturnableRack) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReturnableRack findById(com.sd.app.bean.challan.ReturnableRackId id) {
		log.debug("getting ReturnableRack instance with id: " + id);
		try {
			ReturnableRack instance = (ReturnableRack) sessionFactory.getCurrentSession().get("com.sd.app.bean.challan.ReturnableRack", id);
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

	public List<ReturnableRack> findByExample(ReturnableRack instance) {
		log.debug("finding ReturnableRack instance by example");
		try {
			List<ReturnableRack> results = (List<ReturnableRack>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.challan.ReturnableRack").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
