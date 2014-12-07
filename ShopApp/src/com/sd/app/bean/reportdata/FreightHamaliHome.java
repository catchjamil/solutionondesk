package com.sd.app.bean.reportdata;

// Generated Nov 22, 2014 1:17:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FreightHamali.
 * @see com.sd.app.bean.reportdata.FreightHamali
 * @author Hibernate Tools
 */
public class FreightHamaliHome {

	private static final Log log = LogFactory.getLog(FreightHamaliHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FreightHamali transientInstance) {
		log.debug("persisting FreightHamali instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FreightHamali instance) {
		log.debug("attaching dirty FreightHamali instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FreightHamali instance) {
		log.debug("attaching clean FreightHamali instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FreightHamali persistentInstance) {
		log.debug("deleting FreightHamali instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FreightHamali merge(FreightHamali detachedInstance) {
		log.debug("merging FreightHamali instance");
		try {
			FreightHamali result = (FreightHamali) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FreightHamali findById(com.sd.app.bean.reportdata.FreightHamaliId id) {
		log.debug("getting FreightHamali instance with id: " + id);
		try {
			FreightHamali instance = (FreightHamali) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.FreightHamali", id);
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

	public List<FreightHamali> findByExample(FreightHamali instance) {
		log.debug("finding FreightHamali instance by example");
		try {
			List<FreightHamali> results = (List<FreightHamali>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.FreightHamali").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
