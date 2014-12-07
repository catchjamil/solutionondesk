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
 * Home object for domain model class ToughPlant.
 * @see com.sd.app.bean.wipfile.ToughPlant
 * @author Hibernate Tools
 */
public class ToughPlantHome {

	private static final Log log = LogFactory.getLog(ToughPlantHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ToughPlant transientInstance) {
		log.debug("persisting ToughPlant instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ToughPlant instance) {
		log.debug("attaching dirty ToughPlant instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ToughPlant instance) {
		log.debug("attaching clean ToughPlant instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ToughPlant persistentInstance) {
		log.debug("deleting ToughPlant instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ToughPlant merge(ToughPlant detachedInstance) {
		log.debug("merging ToughPlant instance");
		try {
			ToughPlant result = (ToughPlant) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ToughPlant findById(com.sd.app.bean.wipfile.ToughPlantId id) {
		log.debug("getting ToughPlant instance with id: " + id);
		try {
			ToughPlant instance = (ToughPlant) sessionFactory.getCurrentSession().get("com.sd.app.bean.wipfile.ToughPlant", id);
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

	public List<ToughPlant> findByExample(ToughPlant instance) {
		log.debug("finding ToughPlant instance by example");
		try {
			List<ToughPlant> results = (List<ToughPlant>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.wipfile.ToughPlant")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
