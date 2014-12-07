package com.sd.app.bean.sfa;

// Generated Nov 22, 2014 1:19:44 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FollowUps.
 * @see com.sd.app.bean.sfa.FollowUps
 * @author Hibernate Tools
 */
public class FollowUpsHome {

	private static final Log log = LogFactory.getLog(FollowUpsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FollowUps transientInstance) {
		log.debug("persisting FollowUps instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FollowUps instance) {
		log.debug("attaching dirty FollowUps instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FollowUps instance) {
		log.debug("attaching clean FollowUps instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FollowUps persistentInstance) {
		log.debug("deleting FollowUps instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FollowUps merge(FollowUps detachedInstance) {
		log.debug("merging FollowUps instance");
		try {
			FollowUps result = (FollowUps) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FollowUps findById(com.sd.app.bean.sfa.FollowUpsId id) {
		log.debug("getting FollowUps instance with id: " + id);
		try {
			FollowUps instance = (FollowUps) sessionFactory.getCurrentSession().get("com.sd.app.bean.sfa.FollowUps", id);
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

	public List<FollowUps> findByExample(FollowUps instance) {
		log.debug("finding FollowUps instance by example");
		try {
			List<FollowUps> results = (List<FollowUps>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.sfa.FollowUps")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
