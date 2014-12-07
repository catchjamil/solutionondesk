package com.sd.app.bean.ratetables;

// Generated Nov 22, 2014 1:15:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class StandType.
 * @see com.sd.app.bean.ratetables.StandType
 * @author Hibernate Tools
 */
public class StandTypeHome {

	private static final Log log = LogFactory.getLog(StandTypeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StandType transientInstance) {
		log.debug("persisting StandType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StandType instance) {
		log.debug("attaching dirty StandType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StandType instance) {
		log.debug("attaching clean StandType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StandType persistentInstance) {
		log.debug("deleting StandType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StandType merge(StandType detachedInstance) {
		log.debug("merging StandType instance");
		try {
			StandType result = (StandType) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StandType findById(com.sd.app.bean.ratetables.StandTypeId id) {
		log.debug("getting StandType instance with id: " + id);
		try {
			StandType instance = (StandType) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.StandType", id);
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

	public List<StandType> findByExample(StandType instance) {
		log.debug("finding StandType instance by example");
		try {
			List<StandType> results = (List<StandType>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.ratetables.StandType")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
