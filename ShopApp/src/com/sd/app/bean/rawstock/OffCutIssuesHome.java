package com.sd.app.bean.rawstock;

// Generated Nov 22, 2014 1:16:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class OffCutIssues.
 * @see com.sd.app.bean.rawstock.OffCutIssues
 * @author Hibernate Tools
 */
public class OffCutIssuesHome {

	private static final Log log = LogFactory.getLog(OffCutIssuesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OffCutIssues transientInstance) {
		log.debug("persisting OffCutIssues instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OffCutIssues instance) {
		log.debug("attaching dirty OffCutIssues instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OffCutIssues instance) {
		log.debug("attaching clean OffCutIssues instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OffCutIssues persistentInstance) {
		log.debug("deleting OffCutIssues instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OffCutIssues merge(OffCutIssues detachedInstance) {
		log.debug("merging OffCutIssues instance");
		try {
			OffCutIssues result = (OffCutIssues) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OffCutIssues findById(com.sd.app.bean.rawstock.OffCutIssuesId id) {
		log.debug("getting OffCutIssues instance with id: " + id);
		try {
			OffCutIssues instance = (OffCutIssues) sessionFactory.getCurrentSession().get("com.sd.app.bean.rawstock.OffCutIssues", id);
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

	public List<OffCutIssues> findByExample(OffCutIssues instance) {
		log.debug("finding OffCutIssues instance by example");
		try {
			List<OffCutIssues> results = (List<OffCutIssues>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.rawstock.OffCutIssues").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
