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
 * Home object for domain model class PinvMaster.
 * @see com.sd.app.bean.quotation.PinvMaster
 * @author Hibernate Tools
 */
public class PinvMasterHome {

	private static final Log log = LogFactory.getLog(PinvMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PinvMaster transientInstance) {
		log.debug("persisting PinvMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PinvMaster instance) {
		log.debug("attaching dirty PinvMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PinvMaster instance) {
		log.debug("attaching clean PinvMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PinvMaster persistentInstance) {
		log.debug("deleting PinvMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PinvMaster merge(PinvMaster detachedInstance) {
		log.debug("merging PinvMaster instance");
		try {
			PinvMaster result = (PinvMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PinvMaster findById(com.sd.app.bean.quotation.PinvMasterId id) {
		log.debug("getting PinvMaster instance with id: " + id);
		try {
			PinvMaster instance = (PinvMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.quotation.PinvMaster", id);
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

	public List<PinvMaster> findByExample(PinvMaster instance) {
		log.debug("finding PinvMaster instance by example");
		try {
			List<PinvMaster> results = (List<PinvMaster>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.quotation.PinvMaster")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
