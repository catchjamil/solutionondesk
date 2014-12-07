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
 * Home object for domain model class OffCutReceipts.
 * @see com.sd.app.bean.reportdata.OffCutReceipts
 * @author Hibernate Tools
 */
public class OffCutReceiptsHome {

	private static final Log log = LogFactory.getLog(OffCutReceiptsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(OffCutReceipts transientInstance) {
		log.debug("persisting OffCutReceipts instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OffCutReceipts instance) {
		log.debug("attaching dirty OffCutReceipts instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OffCutReceipts instance) {
		log.debug("attaching clean OffCutReceipts instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OffCutReceipts persistentInstance) {
		log.debug("deleting OffCutReceipts instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OffCutReceipts merge(OffCutReceipts detachedInstance) {
		log.debug("merging OffCutReceipts instance");
		try {
			OffCutReceipts result = (OffCutReceipts) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OffCutReceipts findById(com.sd.app.bean.reportdata.OffCutReceiptsId id) {
		log.debug("getting OffCutReceipts instance with id: " + id);
		try {
			OffCutReceipts instance = (OffCutReceipts) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.OffCutReceipts", id);
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

	public List<OffCutReceipts> findByExample(OffCutReceipts instance) {
		log.debug("finding OffCutReceipts instance by example");
		try {
			List<OffCutReceipts> results = (List<OffCutReceipts>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.OffCutReceipts").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
