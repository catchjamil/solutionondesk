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
 * Home object for domain model class MachineOutPut.
 * @see com.sd.app.bean.wipfile.MachineOutPut
 * @author Hibernate Tools
 */
public class MachineOutPutHome {

	private static final Log log = LogFactory.getLog(MachineOutPutHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MachineOutPut transientInstance) {
		log.debug("persisting MachineOutPut instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MachineOutPut instance) {
		log.debug("attaching dirty MachineOutPut instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MachineOutPut instance) {
		log.debug("attaching clean MachineOutPut instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MachineOutPut persistentInstance) {
		log.debug("deleting MachineOutPut instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MachineOutPut merge(MachineOutPut detachedInstance) {
		log.debug("merging MachineOutPut instance");
		try {
			MachineOutPut result = (MachineOutPut) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MachineOutPut findById(com.sd.app.bean.wipfile.MachineOutPutId id) {
		log.debug("getting MachineOutPut instance with id: " + id);
		try {
			MachineOutPut instance = (MachineOutPut) sessionFactory.getCurrentSession().get("com.sd.app.bean.wipfile.MachineOutPut", id);
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

	public List<MachineOutPut> findByExample(MachineOutPut instance) {
		log.debug("finding MachineOutPut instance by example");
		try {
			List<MachineOutPut> results = (List<MachineOutPut>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.wipfile.MachineOutPut").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
