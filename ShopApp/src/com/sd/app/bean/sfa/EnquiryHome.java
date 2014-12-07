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
 * Home object for domain model class Enquiry.
 * @see com.sd.app.bean.sfa.Enquiry
 * @author Hibernate Tools
 */
public class EnquiryHome {

	private static final Log log = LogFactory.getLog(EnquiryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Enquiry transientInstance) {
		log.debug("persisting Enquiry instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Enquiry instance) {
		log.debug("attaching dirty Enquiry instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Enquiry instance) {
		log.debug("attaching clean Enquiry instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Enquiry persistentInstance) {
		log.debug("deleting Enquiry instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Enquiry merge(Enquiry detachedInstance) {
		log.debug("merging Enquiry instance");
		try {
			Enquiry result = (Enquiry) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Enquiry findById(com.sd.app.bean.sfa.EnquiryId id) {
		log.debug("getting Enquiry instance with id: " + id);
		try {
			Enquiry instance = (Enquiry) sessionFactory.getCurrentSession().get("com.sd.app.bean.sfa.Enquiry", id);
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

	public List<Enquiry> findByExample(Enquiry instance) {
		log.debug("finding Enquiry instance by example");
		try {
			List<Enquiry> results = (List<Enquiry>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.sfa.Enquiry")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
