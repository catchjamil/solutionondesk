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
 * Home object for domain model class NonReturnableChallan.
 * @see com.sd.app.bean.challan.NonReturnableChallan
 * @author Hibernate Tools
 */
public class NonReturnableChallanHome {

	private static final Log log = LogFactory.getLog(NonReturnableChallanHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(NonReturnableChallan transientInstance) {
		log.debug("persisting NonReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(NonReturnableChallan instance) {
		log.debug("attaching dirty NonReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NonReturnableChallan instance) {
		log.debug("attaching clean NonReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NonReturnableChallan persistentInstance) {
		log.debug("deleting NonReturnableChallan instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NonReturnableChallan merge(NonReturnableChallan detachedInstance) {
		log.debug("merging NonReturnableChallan instance");
		try {
			NonReturnableChallan result = (NonReturnableChallan) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NonReturnableChallan findById(com.sd.app.bean.challan.NonReturnableChallanId id) {
		log.debug("getting NonReturnableChallan instance with id: " + id);
		try {
			NonReturnableChallan instance = (NonReturnableChallan) sessionFactory.getCurrentSession().get(
					"com.sd.app.bean.challan.NonReturnableChallan", id);
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

	public List<NonReturnableChallan> findByExample(NonReturnableChallan instance) {
		log.debug("finding NonReturnableChallan instance by example");
		try {
			List<NonReturnableChallan> results = (List<NonReturnableChallan>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.challan.NonReturnableChallan").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
