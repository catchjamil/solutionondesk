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
 * Home object for domain model class ReturnableChallan.
 * @see com.sd.app.bean.challan.ReturnableChallan
 * @author Hibernate Tools
 */
public class ReturnableChallanHome {

	private static final Log log = LogFactory.getLog(ReturnableChallanHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ReturnableChallan transientInstance) {
		log.debug("persisting ReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReturnableChallan instance) {
		log.debug("attaching dirty ReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReturnableChallan instance) {
		log.debug("attaching clean ReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReturnableChallan persistentInstance) {
		log.debug("deleting ReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReturnableChallan merge(ReturnableChallan detachedInstance) {
		log.debug("merging ReturnableChallan instance");
		try {
			ReturnableChallan result = (ReturnableChallan) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReturnableChallan findById(com.sd.app.bean.challan.ReturnableChallanId id) {
		log.debug("getting ReturnableChallan instance with id: " + id);
		try {
			ReturnableChallan instance = (ReturnableChallan) sessionFactory.getCurrentSession().get("com.sd.app.bean.challan.ReturnableChallan", id);
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

	public List<ReturnableChallan> findByExample(ReturnableChallan instance) {
		log.debug("finding ReturnableChallan instance by example");
		try {
			List<ReturnableChallan> results = (List<ReturnableChallan>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.challan.ReturnableChallan").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
