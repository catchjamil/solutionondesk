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
 * Home object for domain model class TmpSticker.
 * @see com.sd.app.bean.reportdata.TmpSticker
 * @author Hibernate Tools
 */
public class TmpStickerHome {

	private static final Log log = LogFactory.getLog(TmpStickerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TmpSticker transientInstance) {
		log.debug("persisting TmpSticker instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpSticker instance) {
		log.debug("attaching dirty TmpSticker instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpSticker instance) {
		log.debug("attaching clean TmpSticker instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TmpSticker persistentInstance) {
		log.debug("deleting TmpSticker instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpSticker merge(TmpSticker detachedInstance) {
		log.debug("merging TmpSticker instance");
		try {
			TmpSticker result = (TmpSticker) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpSticker findById(com.sd.app.bean.reportdata.TmpStickerId id) {
		log.debug("getting TmpSticker instance with id: " + id);
		try {
			TmpSticker instance = (TmpSticker) sessionFactory.getCurrentSession().get("com.sd.app.bean.reportdata.TmpSticker", id);
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

	public List<TmpSticker> findByExample(TmpSticker instance) {
		log.debug("finding TmpSticker instance by example");
		try {
			List<TmpSticker> results = (List<TmpSticker>) sessionFactory.getCurrentSession().createCriteria("com.sd.app.bean.reportdata.TmpSticker")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
