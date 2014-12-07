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
 * Home object for domain model class ExcRawMaterial.
 * @see com.sd.app.bean.reportdata.ExcRawMaterial
 * @author Hibernate Tools
 */
public class ExcRawMaterialHome {

	private static final Log log = LogFactory.getLog(ExcRawMaterialHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExcRawMaterial transientInstance) {
		log.debug("persisting ExcRawMaterial instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExcRawMaterial instance) {
		log.debug("attaching dirty ExcRawMaterial instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExcRawMaterial instance) {
		log.debug("attaching clean ExcRawMaterial instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExcRawMaterial persistentInstance) {
		log.debug("deleting ExcRawMaterial instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExcRawMaterial merge(ExcRawMaterial detachedInstance) {
		log.debug("merging ExcRawMaterial instance");
		try {
			ExcRawMaterial result = (ExcRawMaterial) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExcRawMaterial findById(com.sd.app.bean.reportdata.ExcRawMaterialId id) {
		log.debug("getting ExcRawMaterial instance with id: " + id);
		try {
			ExcRawMaterial instance = (ExcRawMaterial) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.ExcRawMaterial", id);
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

	public List<ExcRawMaterial> findByExample(ExcRawMaterial instance) {
		log.debug("finding ExcRawMaterial instance by example");
		try {
			List<ExcRawMaterial> results = (List<ExcRawMaterial>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.reportdata.ExcRawMaterial").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
