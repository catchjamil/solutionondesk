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
 * Home object for domain model class StaxFormDue.
 * @see com.sd.app.bean.masters.StaxFormDue
 * @author Hibernate Tools
 */
public class StaxFormDueHome {

	private static final Log log = LogFactory.getLog(StaxFormDueHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StaxFormDue transientInstance) {
		log.debug("persisting StaxFormDue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StaxFormDue instance) {
		log.debug("attaching dirty StaxFormDue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StaxFormDue instance) {
		log.debug("attaching clean StaxFormDue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StaxFormDue persistentInstance) {
		log.debug("deleting StaxFormDue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StaxFormDue merge(StaxFormDue detachedInstance) {
		log.debug("merging StaxFormDue instance");
		try {
			StaxFormDue result = (StaxFormDue) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StaxFormDue findById(com.sd.app.bean.masters.StaxFormDueId id) {
		log.debug("getting StaxFormDue instance with id: " + id);
		try {
			StaxFormDue instance = (StaxFormDue) sessionFactory.getCurrentSession().get("com.sd.app.bean.masters.StaxFormDue", id);
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

	public List<StaxFormDue> findByExample(StaxFormDue instance) {
		log.debug("finding StaxFormDue instance by example");
		try {
			List<StaxFormDue> results = (List<StaxFormDue>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.masters.StaxFormDue")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
