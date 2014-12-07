package com.sd.app.bean.insurance;

// Generated Nov 22, 2014 12:58:31 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class InsurancePolicies.
 * @see com.sd.app.bean.insurance.InsurancePolicies
 * @author Hibernate Tools
 */
public class InsurancePoliciesHome {

	private static final Log log = LogFactory.getLog(InsurancePoliciesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(InsurancePolicies transientInstance) {
		log.debug("persisting InsurancePolicies instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InsurancePolicies instance) {
		log.debug("attaching dirty InsurancePolicies instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InsurancePolicies instance) {
		log.debug("attaching clean InsurancePolicies instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InsurancePolicies persistentInstance) {
		log.debug("deleting InsurancePolicies instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InsurancePolicies merge(InsurancePolicies detachedInstance) {
		log.debug("merging InsurancePolicies instance");
		try {
			InsurancePolicies result = (InsurancePolicies) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InsurancePolicies findById(com.sd.app.bean.insurance.InsurancePoliciesId id) {
		log.debug("getting InsurancePolicies instance with id: " + id);
		try {
			InsurancePolicies instance = (InsurancePolicies) sessionFactory.getCurrentSession()
					.get("com.sd.app.bean.insurance.InsurancePolicies", id);
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

	public List<InsurancePolicies> findByExample(InsurancePolicies instance) {
		log.debug("finding InsurancePolicies instance by example");
		try {
			List<InsurancePolicies> results = (List<InsurancePolicies>) sessionFactory.getCurrentSession()
					.createCriteria("com.sd.app.bean.insurance.InsurancePolicies").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
