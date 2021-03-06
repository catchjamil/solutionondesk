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
 * Home object for domain model class PrintGatePass.
 * @see com.sd.app.bean.reportdata.PrintGatePass
 * @author Hibernate Tools
 */
public class PrintGatePassHome {

	private static final Log log = LogFactory.getLog(PrintGatePassHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PrintGatePass transientInstance) {
		log.debug("persisting PrintGatePass instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PrintGatePass instance) {
		log.debug("attaching dirty PrintGatePass instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PrintGatePass instance) {
		log.debug("attaching clean PrintGatePass instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PrintGatePass persistentInstance) {
		log.debug("deleting PrintGatePass instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PrintGatePass merge(PrintGatePass detachedInstance) {
		log.debug("merging PrintGatePass instance");
		try {
			PrintGatePass result = (PrintGatePass) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PrintGatePass findById(com.sd.app.bean.reportdata.PrintGatePassId id) {
		log.debug("getting PrintGatePass instance with id: " + id);
		try {
			PrintGatePass instance = (PrintGatePass) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.PrintGatePass", id);
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

	public List<PrintGatePass> findByExample(PrintGatePass instance) {
		log.debug("finding PrintGatePass instance by example");
		try {
			List<PrintGatePass> results = (List<PrintGatePass>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.PrintGatePass").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
