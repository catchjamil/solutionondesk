package com.sd.app.bean.sfa;

// Generated Nov 22, 2014 1:19:44 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Sfasummary.
 * @see com.sd.app.bean.sfa.Sfasummary
 * @author Hibernate Tools
 */
public class SfasummaryHome {

	private static final Log log = LogFactory.getLog(SfasummaryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Sfasummary transientInstance) {
		log.debug("persisting Sfasummary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Sfasummary instance) {
		log.debug("attaching dirty Sfasummary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sfasummary instance) {
		log.debug("attaching clean Sfasummary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Sfasummary persistentInstance) {
		log.debug("deleting Sfasummary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sfasummary merge(Sfasummary detachedInstance) {
		log.debug("merging Sfasummary instance");
		try {
			Sfasummary result = (Sfasummary) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sfasummary findById(com.sd.app.bean.sfa.SfasummaryId id) {
		log.debug("getting Sfasummary instance with id: " + id);
		try {
			Sfasummary instance = (Sfasummary) sessionFactory.getCurrentSession().get("com.sd.app.bean.sfa.Sfasummary", id);
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

	public List<Sfasummary> findByExample(Sfasummary instance) {
		log.debug("finding Sfasummary instance by example");
		try {
			List<Sfasummary> results = (List<Sfasummary>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.sfa.Sfasummary")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
