package com.sd.app.bean.menumaster;

// Generated Nov 22, 2014 1:04:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MenuMaster.
 * @see com.sd.app.bean.menumaster.MenuMaster
 * @author Hibernate Tools
 */
public class MenuMasterHome {

	private static final Log log = LogFactory.getLog(MenuMasterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MenuMaster transientInstance) {
		log.debug("persisting MenuMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MenuMaster instance) {
		log.debug("attaching dirty MenuMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MenuMaster instance) {
		log.debug("attaching clean MenuMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MenuMaster persistentInstance) {
		log.debug("deleting MenuMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MenuMaster merge(MenuMaster detachedInstance) {
		log.debug("merging MenuMaster instance");
		try {
			MenuMaster result = (MenuMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MenuMaster findById(com.sd.app.bean.menumaster.MenuMasterId id) {
		log.debug("getting MenuMaster instance with id: " + id);
		try {
			MenuMaster instance = (MenuMaster) sessionFactory.getCurrentSession().get("com.sd.app.bean.menumaster.MenuMaster", id);
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

	public List<MenuMaster> findByExample(MenuMaster instance) {
		log.debug("finding MenuMaster instance by example");
		try {
			List<MenuMaster> results = (List<MenuMaster>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.menumaster.MenuMaster")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
