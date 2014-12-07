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
 * Home object for domain model class PrintOrderStatus.
 * @see com.sd.app.bean.reportdata.PrintOrderStatus
 * @author Hibernate Tools
 */
public class PrintOrderStatusHome {

	private static final Log log = LogFactory.getLog(PrintOrderStatusHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PrintOrderStatus transientInstance) {
		log.debug("persisting PrintOrderStatus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PrintOrderStatus instance) {
		log.debug("attaching dirty PrintOrderStatus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PrintOrderStatus instance) {
		log.debug("attaching clean PrintOrderStatus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PrintOrderStatus persistentInstance) {
		log.debug("deleting PrintOrderStatus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PrintOrderStatus merge(PrintOrderStatus detachedInstance) {
		log.debug("merging PrintOrderStatus instance");
		try {
			PrintOrderStatus result = (PrintOrderStatus) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PrintOrderStatus findById(com.sd.app.bean.reportdata.PrintOrderStatusId id) {
		log.debug("getting PrintOrderStatus instance with id: " + id);
		try {
			PrintOrderStatus instance = (PrintOrderStatus) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.PrintOrderStatus", id);
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

	public List<PrintOrderStatus> findByExample(PrintOrderStatus instance) {
		log.debug("finding PrintOrderStatus instance by example");
		try {
			List<PrintOrderStatus> results = (List<PrintOrderStatus>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.PrintOrderStatus").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
