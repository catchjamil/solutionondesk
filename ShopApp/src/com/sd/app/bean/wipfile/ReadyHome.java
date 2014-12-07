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
 * Home object for domain model class Ready.
 * @see com.sd.app.bean.wipfile.Ready
 * @author Hibernate Tools
 */
public class ReadyHome {

	private static final Log log = LogFactory.getLog(ReadyHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Ready transientInstance) {
		log.debug("persisting Ready instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ready instance) {
		log.debug("attaching dirty Ready instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ready instance) {
		log.debug("attaching clean Ready instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ready persistentInstance) {
		log.debug("deleting Ready instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ready merge(Ready detachedInstance) {
		log.debug("merging Ready instance");
		try {
			Ready result = (Ready) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ready findById(com.sd.app.bean.wipfile.ReadyId id) {
		log.debug("getting Ready instance with id: " + id);
		try {
			Ready instance = (Ready) sessionFactory.getCurrentSession().get("com.sd.app.bean.wipfile.Ready", id);
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

	public List<Ready> findByExample(Ready instance) {
		log.debug("finding Ready instance by example");
		try {
			List<Ready> results = (List<Ready>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.wipfile.Ready")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
