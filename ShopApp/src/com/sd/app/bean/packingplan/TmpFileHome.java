package com.sd.app.bean.packingplan;

// Generated Nov 22, 2014 1:11:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TmpFile.
 * @see com.sd.app.bean.packingplan.TmpFile
 * @author Hibernate Tools
 */
public class TmpFileHome {

	private static final Log log = LogFactory.getLog(TmpFileHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TmpFile transientInstance) {
		log.debug("persisting TmpFile instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpFile instance) {
		log.debug("attaching dirty TmpFile instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpFile instance) {
		log.debug("attaching clean TmpFile instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TmpFile persistentInstance) {
		log.debug("deleting TmpFile instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpFile merge(TmpFile detachedInstance) {
		log.debug("merging TmpFile instance");
		try {
			TmpFile result = (TmpFile) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpFile findById(com.sd.app.bean.packingplan.TmpFileId id) {
		log.debug("getting TmpFile instance with id: " + id);
		try {
			TmpFile instance = (TmpFile) sessionFactory.getCurrentSession().get("com.sd.app.bean.packingplan.TmpFile", id);
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

	public List<TmpFile> findByExample(TmpFile instance) {
		log.debug("finding TmpFile instance by example");
		try {
			List<TmpFile> results = (List<TmpFile>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.packingplan.TmpFile")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
