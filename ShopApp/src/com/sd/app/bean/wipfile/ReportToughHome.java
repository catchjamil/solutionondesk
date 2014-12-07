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
 * Home object for domain model class ReportTough.
 * @see com.sd.app.bean.wipfile.ReportTough
 * @author Hibernate Tools
 */
public class ReportToughHome {

	private static final Log log = LogFactory.getLog(ReportToughHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ReportTough transientInstance) {
		log.debug("persisting ReportTough instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReportTough instance) {
		log.debug("attaching dirty ReportTough instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReportTough instance) {
		log.debug("attaching clean ReportTough instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReportTough persistentInstance) {
		log.debug("deleting ReportTough instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReportTough merge(ReportTough detachedInstance) {
		log.debug("merging ReportTough instance");
		try {
			ReportTough result = (ReportTough) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReportTough findById(com.sd.app.bean.wipfile.ReportToughId id) {
		log.debug("getting ReportTough instance with id: " + id);
		try {
			ReportTough instance = (ReportTough) sessionFactory.getCurrentSession().get("com.sd.app.bean.wipfile.ReportTough", id);
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

	public List<ReportTough> findByExample(ReportTough instance) {
		log.debug("finding ReportTough instance by example");
		try {
			List<ReportTough> results = (List<ReportTough>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.wipfile.ReportTough")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
