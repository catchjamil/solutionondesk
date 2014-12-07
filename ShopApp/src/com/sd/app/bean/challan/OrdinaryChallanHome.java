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
 * Home object for domain model class OrdinaryChallan.
 * @see com.sd.app.bean.challan.OrdinaryChallan
 * @author Hibernate Tools
 */
public class OrdinaryChallanHome {

	private static final Log log = LogFactory.getLog(OrdinaryChallanHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OrdinaryChallan transientInstance) {
		log.debug("persisting OrdinaryChallan instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrdinaryChallan instance) {
		log.debug("attaching dirty OrdinaryChallan instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrdinaryChallan instance) {
		log.debug("attaching clean OrdinaryChallan instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrdinaryChallan persistentInstance) {
		log.debug("deleting OrdinaryChallan instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrdinaryChallan merge(OrdinaryChallan detachedInstance) {
		log.debug("merging OrdinaryChallan instance");
		try {
			OrdinaryChallan result = (OrdinaryChallan) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrdinaryChallan findById(com.sd.app.bean.challan.OrdinaryChallanId id) {
		log.debug("getting OrdinaryChallan instance with id: " + id);
		try {
			OrdinaryChallan instance = (OrdinaryChallan) sessionFactory.getCurrentSession().get("com.sd.app.bean.challan.OrdinaryChallan", id);
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

	public List<OrdinaryChallan> findByExample(OrdinaryChallan instance) {
		log.debug("finding OrdinaryChallan instance by example");
		try {
			List<OrdinaryChallan> results = (List<OrdinaryChallan>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.challan.OrdinaryChallan").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
