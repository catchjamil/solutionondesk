package com.sd.app.bean.wipfile;

// Generated Nov 22, 2014 1:20:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BrokenMaster.
 * @see com.sd.app.bean.wipfile.BrokenMaster
 * @author Hibernate Tools
 */
public class BrokenMasterHome {

	private static final Log log = LogFactory.getLog(BrokenMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BrokenMaster transientInstance) {
		log.debug("persisting BrokenMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BrokenMaster instance) {
		log.debug("attaching dirty BrokenMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BrokenMaster instance) {
		log.debug("attaching clean BrokenMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BrokenMaster persistentInstance) {
		log.debug("deleting BrokenMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BrokenMaster merge(BrokenMaster detachedInstance) {
		log.debug("merging BrokenMaster instance");
		try {
			BrokenMaster result = (BrokenMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BrokenMaster findById(com.sd.app.bean.wipfile.BrokenMasterId id) {
		log.debug("getting BrokenMaster instance with id: " + id);
		try {
			BrokenMaster instance = (BrokenMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.wipfile.BrokenMaster", id);
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

	public List<BrokenMaster> findByExample(BrokenMaster instance) {
		log.debug("finding BrokenMaster instance by example");
		try {
			List<BrokenMaster> results = (List<BrokenMaster>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.wipfile.BrokenMaster").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
