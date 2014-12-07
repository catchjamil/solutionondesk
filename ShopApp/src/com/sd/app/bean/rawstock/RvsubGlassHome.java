package com.sd.app.bean.rawstock;

// Generated Nov 22, 2014 1:16:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RvsubGlass.
 * @see com.sd.app.bean.rawstock.RvsubGlass
 * @author Hibernate Tools
 */
public class RvsubGlassHome {

	private static final Log log = LogFactory.getLog(RvsubGlassHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RvsubGlass transientInstance) {
		log.debug("persisting RvsubGlass instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RvsubGlass instance) {
		log.debug("attaching dirty RvsubGlass instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RvsubGlass instance) {
		log.debug("attaching clean RvsubGlass instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RvsubGlass persistentInstance) {
		log.debug("deleting RvsubGlass instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RvsubGlass merge(RvsubGlass detachedInstance) {
		log.debug("merging RvsubGlass instance");
		try {
			RvsubGlass result = (RvsubGlass) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RvsubGlass findById(com.sd.app.bean.rawstock.RvsubGlassId id) {
		log.debug("getting RvsubGlass instance with id: " + id);
		try {
			RvsubGlass instance = (RvsubGlass) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RvsubGlass", id);
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

	public List<RvsubGlass> findByExample(RvsubGlass instance) {
		log.debug("finding RvsubGlass instance by example");
		try {
			List<RvsubGlass> results = (List<RvsubGlass>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.rawstock.RvsubGlass")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
