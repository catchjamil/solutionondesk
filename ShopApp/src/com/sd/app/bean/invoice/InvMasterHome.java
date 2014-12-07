package com.sd.app.bean.invoice;

// Generated Nov 22, 2014 1:01:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class InvMaster.
 * @see com.sd.app.bean.invoice.InvMaster
 * @author Hibernate Tools
 */
public class InvMasterHome {

	private static final Log log = LogFactory.getLog(InvMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(InvMaster transientInstance) {
		log.debug("persisting InvMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InvMaster instance) {
		log.debug("attaching dirty InvMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvMaster instance) {
		log.debug("attaching clean InvMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InvMaster persistentInstance) {
		log.debug("deleting InvMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvMaster merge(InvMaster detachedInstance) {
		log.debug("merging InvMaster instance");
		try {
			InvMaster result = (InvMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InvMaster findById(com.sd.app.bean.invoice.InvMasterId id) {
		log.debug("getting InvMaster instance with id: " + id);
		try {
			InvMaster instance = (InvMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.invoice.InvMaster", id);
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

	public List<InvMaster> findByExample(InvMaster instance) {
		log.debug("finding InvMaster instance by example");
		try {
			List<InvMaster> results = (List<InvMaster>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.invoice.InvMaster")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
