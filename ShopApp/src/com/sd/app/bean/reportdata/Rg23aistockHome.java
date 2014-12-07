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
 * Home object for domain model class Rg23aistock.
 * @see com.sd.app.bean.reportdata.Rg23aistock
 * @author Hibernate Tools
 */
public class Rg23aistockHome {

	private static final Log log = LogFactory.getLog(Rg23aistockHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Rg23aistock transientInstance) {
		log.debug("persisting Rg23aistock instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rg23aistock instance) {
		log.debug("attaching dirty Rg23aistock instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rg23aistock instance) {
		log.debug("attaching clean Rg23aistock instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rg23aistock persistentInstance) {
		log.debug("deleting Rg23aistock instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rg23aistock merge(Rg23aistock detachedInstance) {
		log.debug("merging Rg23aistock instance");
		try {
			Rg23aistock result = (Rg23aistock) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rg23aistock findById(com.sd.app.bean.reportdata.Rg23aistockId id) {
		log.debug("getting Rg23aistock instance with id: " + id);
		try {
			Rg23aistock instance = (Rg23aistock) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.Rg23aistock", id);
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

	public List<Rg23aistock> findByExample(Rg23aistock instance) {
		log.debug("finding Rg23aistock instance by example");
		try {
			List<Rg23aistock> results = (List<Rg23aistock>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.Rg23aistock").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
