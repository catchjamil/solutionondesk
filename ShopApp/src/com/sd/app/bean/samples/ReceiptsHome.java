package com.sd.app.bean.samples;

// Generated Nov 22, 2014 1:18:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Receipts.
 * @see com.sd.app.bean.samples.Receipts
 * @author Hibernate Tools
 */
public class ReceiptsHome {

	private static final Log log = LogFactory.getLog(ReceiptsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Receipts transientInstance) {
		log.debug("persisting Receipts instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Receipts instance) {
		log.debug("attaching dirty Receipts instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Receipts instance) {
		log.debug("attaching clean Receipts instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Receipts persistentInstance) {
		log.debug("deleting Receipts instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Receipts merge(Receipts detachedInstance) {
		log.debug("merging Receipts instance");
		try {
			Receipts result = (Receipts) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Receipts findById(com.sd.app.bean.samples.ReceiptsId id) {
		log.debug("getting Receipts instance with id: " + id);
		try {
			Receipts instance = (Receipts) sessionFactory.getCurrentSession().get("com.sd.app.bean.samples.Receipts", id);
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

	public List<Receipts> findByExample(Receipts instance) {
		log.debug("finding Receipts instance by example");
		try {
			List<Receipts> results = (List<Receipts>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.samples.Receipts")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
