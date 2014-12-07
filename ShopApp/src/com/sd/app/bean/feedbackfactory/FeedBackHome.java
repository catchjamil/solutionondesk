package com.sd.app.bean.feedbackfactory;

// Generated Nov 22, 2014 12:53:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FeedBack.
 * @see com.sd.app.bean.feedbackfactory.FeedBack
 * @author Hibernate Tools
 */
public class FeedBackHome {

	private static final Log log = LogFactory.getLog(FeedBackHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FeedBack transientInstance) {
		log.debug("persisting FeedBack instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FeedBack instance) {
		log.debug("attaching dirty FeedBack instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FeedBack instance) {
		log.debug("attaching clean FeedBack instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FeedBack persistentInstance) {
		log.debug("deleting FeedBack instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FeedBack merge(FeedBack detachedInstance) {
		log.debug("merging FeedBack instance");
		try {
			FeedBack result = (FeedBack) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FeedBack findById(com.sd.app.bean.feedbackfactory.FeedBackId id) {
		log.debug("getting FeedBack instance with id: " + id);
		try {
			FeedBack instance = (FeedBack) sessionFactory.getCurrentSession().get("com.sd.app.bean.feedbackfactory.FeedBack", id);
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

	public List<FeedBack> findByExample(FeedBack instance) {
		log.debug("finding FeedBack instance by example");
		try {
			List<FeedBack> results = (List<FeedBack>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.feedbackfactory.FeedBack")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
