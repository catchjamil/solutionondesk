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
 * Home object for domain model class TmpInvDetails.
 * @see com.sd.app.bean.reportdata.TmpInvDetails
 * @author Hibernate Tools
 */
public class TmpInvDetailsHome {

	private static final Log log = LogFactory.getLog(TmpInvDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TmpInvDetails transientInstance) {
		log.debug("persisting TmpInvDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpInvDetails instance) {
		log.debug("attaching dirty TmpInvDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpInvDetails instance) {
		log.debug("attaching clean TmpInvDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TmpInvDetails persistentInstance) {
		log.debug("deleting TmpInvDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpInvDetails merge(TmpInvDetails detachedInstance) {
		log.debug("merging TmpInvDetails instance");
		try {
			TmpInvDetails result = (TmpInvDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpInvDetails findById(com.sd.app.bean.reportdata.TmpInvDetailsId id) {
		log.debug("getting TmpInvDetails instance with id: " + id);
		try {
			TmpInvDetails instance = (TmpInvDetails) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.TmpInvDetails", id);
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

	public List<TmpInvDetails> findByExample(TmpInvDetails instance) {
		log.debug("finding TmpInvDetails instance by example");
		try {
			List<TmpInvDetails> results = (List<TmpInvDetails>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.TmpInvDetails").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
