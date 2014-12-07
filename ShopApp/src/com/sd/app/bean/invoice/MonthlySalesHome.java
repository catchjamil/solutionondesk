package com.sd.app.bean.invoice;

// Generated Nov 22, 2014 1:01:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MonthlySales.
 * @see com.sd.app.bean.invoice.MonthlySales
 * @author Hibernate Tools
 */
public class MonthlySalesHome {

	private static final Log log = LogFactory.getLog(MonthlySalesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MonthlySales transientInstance) {
		log.debug("persisting MonthlySales instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MonthlySales instance) {
		log.debug("attaching dirty MonthlySales instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MonthlySales instance) {
		log.debug("attaching clean MonthlySales instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MonthlySales persistentInstance) {
		log.debug("deleting MonthlySales instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MonthlySales merge(MonthlySales detachedInstance) {
		log.debug("merging MonthlySales instance");
		try {
			MonthlySales result = (MonthlySales) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MonthlySales findById(com.sd.app.bean.invoice.MonthlySalesId id) {
		log.debug("getting MonthlySales instance with id: " + id);
		try {
			MonthlySales instance = (MonthlySales) sessionFactory.getCurrentSession().get("com.sd.app.bean.invoice.MonthlySales", id);
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

	public List<MonthlySales> findByExample(MonthlySales instance) {
		log.debug("finding MonthlySales instance by example");
		try {
			List<MonthlySales> results = (List<MonthlySales>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.invoice.MonthlySales").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
