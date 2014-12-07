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
 * Home object for domain model class CheapterWiseSales.
 * @see com.sd.app.bean.reportdata.CheapterWiseSales
 * @author Hibernate Tools
 */
public class CheapterWiseSalesHome {

	private static final Log log = LogFactory.getLog(CheapterWiseSalesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CheapterWiseSales transientInstance) {
		log.debug("persisting CheapterWiseSales instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CheapterWiseSales instance) {
		log.debug("attaching dirty CheapterWiseSales instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CheapterWiseSales instance) {
		log.debug("attaching clean CheapterWiseSales instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CheapterWiseSales persistentInstance) {
		log.debug("deleting CheapterWiseSales instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CheapterWiseSales merge(CheapterWiseSales detachedInstance) {
		log.debug("merging CheapterWiseSales instance");
		try {
			CheapterWiseSales result = (CheapterWiseSales) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CheapterWiseSales findById(com.sd.app.bean.reportdata.CheapterWiseSalesId id) {
		log.debug("getting CheapterWiseSales instance with id: " + id);
		try {
			CheapterWiseSales instance = (CheapterWiseSales) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.CheapterWiseSales",
					id);
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

	public List<CheapterWiseSales> findByExample(CheapterWiseSales instance) {
		log.debug("finding CheapterWiseSales instance by example");
		try {
			List<CheapterWiseSales> results = (List<CheapterWiseSales>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.CheapterWiseSales").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
