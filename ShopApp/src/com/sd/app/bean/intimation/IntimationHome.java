package com.sd.app.bean.intimation;

// Generated Nov 22, 2014 12:59:41 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Intimation.
 * @see com.sd.app.bean.intimation.Intimation
 * @author Hibernate Tools
 */
public class IntimationHome {

	private static final Log log = LogFactory.getLog(IntimationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Intimation transientInstance) {
		log.debug("persisting Intimation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Intimation instance) {
		log.debug("attaching dirty Intimation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Intimation instance) {
		log.debug("attaching clean Intimation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Intimation persistentInstance) {
		log.debug("deleting Intimation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Intimation merge(Intimation detachedInstance) {
		log.debug("merging Intimation instance");
		try {
			Intimation result = (Intimation) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Intimation findById(com.sd.app.bean.intimation.IntimationId id) {
		log.debug("getting Intimation instance with id: " + id);
		try {
			Intimation instance = (Intimation) sessionFactory.getCurrentSession().get("com.sd.app.bean.intimation.Intimation", id);
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

	public List<Intimation> findByExample(Intimation instance) {
		log.debug("finding Intimation instance by example");
		try {
			List<Intimation> results = (List<Intimation>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.intimation.Intimation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
