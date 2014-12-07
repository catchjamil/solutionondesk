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
 * Home object for domain model class UserGroups.
 * @see com.sd.app.bean.masters.UserGroups
 * @author Hibernate Tools
 */
public class UserGroupsHome {

	private static final Log log = LogFactory.getLog(UserGroupsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(UserGroups transientInstance) {
		log.debug("persisting UserGroups instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserGroups instance) {
		log.debug("attaching dirty UserGroups instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserGroups instance) {
		log.debug("attaching clean UserGroups instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserGroups persistentInstance) {
		log.debug("deleting UserGroups instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserGroups merge(UserGroups detachedInstance) {
		log.debug("merging UserGroups instance");
		try {
			UserGroups result = (UserGroups) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserGroups findById(com.sd.app.bean.masters.UserGroupsId id) {
		log.debug("getting UserGroups instance with id: " + id);
		try {
			UserGroups instance = (UserGroups) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.UserGroups", id);
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

	public List<UserGroups> findByExample(UserGroups instance) {
		log.debug("finding UserGroups instance by example");
		try {
			List<UserGroups> results = (List<UserGroups>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.UserGroups")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
