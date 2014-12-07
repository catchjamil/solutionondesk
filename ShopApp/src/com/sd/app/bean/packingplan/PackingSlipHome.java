package com.sd.app.bean.packingplan;

// Generated Nov 22, 2014 1:11:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PackingSlip.
 * @see com.sd.app.bean.packingplan.PackingSlip
 * @author Hibernate Tools
 */
public class PackingSlipHome {

	private static final Log log = LogFactory.getLog(PackingSlipHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PackingSlip transientInstance) {
		log.debug("persisting PackingSlip instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PackingSlip instance) {
		log.debug("attaching dirty PackingSlip instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PackingSlip instance) {
		log.debug("attaching clean PackingSlip instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PackingSlip persistentInstance) {
		log.debug("deleting PackingSlip instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PackingSlip merge(PackingSlip detachedInstance) {
		log.debug("merging PackingSlip instance");
		try {
			PackingSlip result = (PackingSlip) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PackingSlip findById(com.sd.app.bean.packingplan.PackingSlipId id) {
		log.debug("getting PackingSlip instance with id: " + id);
		try {
			PackingSlip instance = (PackingSlip) sessionFactory.getCurrentSession().get("com.sd.app.bean.packingplan.PackingSlip", id);
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

	public List<PackingSlip> findByExample(PackingSlip instance) {
		log.debug("finding PackingSlip instance by example");
		try {
			List<PackingSlip> results = (List<PackingSlip>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.packingplan.PackingSlip").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
