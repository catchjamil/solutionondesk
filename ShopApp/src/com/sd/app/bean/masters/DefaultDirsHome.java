package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DefaultDirs.
 * @see com.sd.app.bean.masters.DefaultDirs
 * @author Hibernate Tools
 */
public class DefaultDirsHome {

	private static final Log log = LogFactory.getLog(DefaultDirsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DefaultDirs transientInstance) {
		log.debug("persisting DefaultDirs instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DefaultDirs instance) {
		log.debug("attaching dirty DefaultDirs instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DefaultDirs instance) {
		log.debug("attaching clean DefaultDirs instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DefaultDirs persistentInstance) {
		log.debug("deleting DefaultDirs instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DefaultDirs merge(DefaultDirs detachedInstance) {
		log.debug("merging DefaultDirs instance");
		try {
			DefaultDirs result = (DefaultDirs) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DefaultDirs findById(com.sd.app.bean.masters.DefaultDirsId id) {
		log.debug("getting DefaultDirs instance with id: " + id);
		try {
			DefaultDirs instance = (DefaultDirs) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.DefaultDirs", id);
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

	public List<DefaultDirs> findByExample(DefaultDirs instance) {
		log.debug("finding DefaultDirs instance by example");
		try {
			List<DefaultDirs> results = (List<DefaultDirs>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.DefaultDirs")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
