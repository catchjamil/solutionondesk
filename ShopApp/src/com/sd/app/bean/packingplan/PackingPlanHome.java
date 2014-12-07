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
 * Home object for domain model class PackingPlan.
 * @see com.sd.app.bean.packingplan.PackingPlan
 * @author Hibernate Tools
 */
public class PackingPlanHome {

	private static final Log log = LogFactory.getLog(PackingPlanHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PackingPlan transientInstance) {
		log.debug("persisting PackingPlan instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PackingPlan instance) {
		log.debug("attaching dirty PackingPlan instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PackingPlan instance) {
		log.debug("attaching clean PackingPlan instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PackingPlan persistentInstance) {
		log.debug("deleting PackingPlan instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PackingPlan merge(PackingPlan detachedInstance) {
		log.debug("merging PackingPlan instance");
		try {
			PackingPlan result = (PackingPlan) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PackingPlan findById(com.sd.app.bean.packingplan.PackingPlanId id) {
		log.debug("getting PackingPlan instance with id: " + id);
		try {
			PackingPlan instance = (PackingPlan) sessionFactory.getCurrentSession().get("com.sd.app.bean.packingplan.PackingPlan", id);
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

	public List<PackingPlan> findByExample(PackingPlan instance) {
		log.debug("finding PackingPlan instance by example");
		try {
			List<PackingPlan> results = (List<PackingPlan>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.packingplan.PackingPlan").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
