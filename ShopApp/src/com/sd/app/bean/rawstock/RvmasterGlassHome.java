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
 * Home object for domain model class RvmasterGlass.
 * @see com.sd.app.bean.rawstock.RvmasterGlass
 * @author Hibernate Tools
 */
public class RvmasterGlassHome {

	private static final Log log = LogFactory.getLog(RvmasterGlassHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RvmasterGlass transientInstance) {
		log.debug("persisting RvmasterGlass instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RvmasterGlass instance) {
		log.debug("attaching dirty RvmasterGlass instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RvmasterGlass instance) {
		log.debug("attaching clean RvmasterGlass instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RvmasterGlass persistentInstance) {
		log.debug("deleting RvmasterGlass instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RvmasterGlass merge(RvmasterGlass detachedInstance) {
		log.debug("merging RvmasterGlass instance");
		try {
			RvmasterGlass result = (RvmasterGlass) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RvmasterGlass findById(com.sd.app.bean.rawstock.RvmasterGlassId id) {
		log.debug("getting RvmasterGlass instance with id: " + id);
		try {
			RvmasterGlass instance = (RvmasterGlass) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.RvmasterGlass", id);
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

	public List<RvmasterGlass> findByExample(RvmasterGlass instance) {
		log.debug("finding RvmasterGlass instance by example");
		try {
			List<RvmasterGlass> results = (List<RvmasterGlass>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.RvmasterGlass").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
