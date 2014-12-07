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
 * Home object for domain model class SizeTables.
 * @see com.sd.app.bean.ratetables.SizeTables
 * @author Hibernate Tools
 */
public class SizeTablesHome {

	private static final Log log = LogFactory.getLog(SizeTablesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SizeTables transientInstance) {
		log.debug("persisting SizeTables instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SizeTables instance) {
		log.debug("attaching dirty SizeTables instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SizeTables instance) {
		log.debug("attaching clean SizeTables instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SizeTables persistentInstance) {
		log.debug("deleting SizeTables instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SizeTables merge(SizeTables detachedInstance) {
		log.debug("merging SizeTables instance");
		try {
			SizeTables result = (SizeTables) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SizeTables findById(com.sd.app.bean.ratetables.SizeTablesId id) {
		log.debug("getting SizeTables instance with id: " + id);
		try {
			SizeTables instance = (SizeTables) sessionFactory.getCurrentSession().get("com.sd.app.bean.ratetables.SizeTables", id);
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

	public List<SizeTables> findByExample(SizeTables instance) {
		log.debug("finding SizeTables instance by example");
		try {
			List<SizeTables> results = (List<SizeTables>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.ratetables.SizeTables")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
