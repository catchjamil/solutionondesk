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
 * Home object for domain model class InvMaster1.
 * @see com.sd.app.bean.reportdata.InvMaster1
 * @author Hibernate Tools
 */
public class InvMaster1Home {

	private static final Log log = LogFactory.getLog(InvMaster1Home.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(InvMaster1 transientInstance) {
		log.debug("persisting InvMaster1 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InvMaster1 instance) {
		log.debug("attaching dirty InvMaster1 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvMaster1 instance) {
		log.debug("attaching clean InvMaster1 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InvMaster1 persistentInstance) {
		log.debug("deleting InvMaster1 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvMaster1 merge(InvMaster1 detachedInstance) {
		log.debug("merging InvMaster1 instance");
		try {
			InvMaster1 result = (InvMaster1) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InvMaster1 findById(com.sd.app.bean.reportdata.InvMaster1Id id) {
		log.debug("getting InvMaster1 instance with id: " + id);
		try {
			InvMaster1 instance = (InvMaster1) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.InvMaster1", id);
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

	public List<InvMaster1> findByExample(InvMaster1 instance) {
		log.debug("finding InvMaster1 instance by example");
		try {
			List<InvMaster1> results = (List<InvMaster1>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.reportdata.InvMaster1")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
