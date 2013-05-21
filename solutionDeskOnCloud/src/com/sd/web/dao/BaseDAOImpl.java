package com.sd.web.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.web.dto.BaseDTO;
import com.sd.web.enums.Actions;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.BaseBO;
import com.sd.web.security.Ticket;
import com.sd.web.util.BODTOFiller;

public class BaseDAOImpl implements BaseDAO {

	public BaseDTO delete(Ticket ticket, BaseDTO baseDTO, String[] ids) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		BaseBO baseBo = BODTOFiller.getBO(baseDTO);
		for (String id : ids) {
			baseBo.setId(Long.parseLong(id));
			baseBo.setModifiedBy(ticket.getId());
			baseBo.setCreatedOn(new Date());
			baseBo.setAction(Actions.DELETED.toString());
			session.delete(baseBo);
		}
		t.commit();
		session.close();

		return baseDTO;
	}

	public List<BaseDTO> findAll(BaseDTO baseDTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO", "BO");
		Criteria criteria = session.createCriteria("" + getClassName(baseDTO));
		List<BaseDTO> list = criteria.list();
		session.close();
		return list;
	}

	public BaseDTO findById(BaseDTO baseDTO, String id) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		BaseBO baseBO = null;
		try {
			// baseB0 = (BaseBO)
			// session.load(Class.forName(getClassName(baseDTO)),
			// Long.parseLong(id));
			Query createQuery = session.createQuery(" from " + getClassName(baseDTO) + " where id=" + id);
			baseBO = (BaseBO) createQuery.list().get(0);
			BODTOFiller.getDto(baseDTO, baseBO);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
		return baseDTO;
	}

	public List<BaseDTO> findBySpec(BaseDTO baseDTO, String spec) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO",
		// "BO").replace("dto", "bo").replace(".bo.", ".model.bo.");
		Query createQuery = session.createQuery(" from " + getClassName(baseDTO) + " where " + spec);
		List<BaseDTO> list = createQuery.list();
		session.close();

		return null;
	}

	private String getClassName(BaseDTO baseDTO) {
		return baseDTO.getClass().getName().replace("DTO", "BO").replace("dto", "bo").replace(".bo.", ".model.bo.");
	}

	public BaseDTO save(Ticket ticket, BaseDTO baseDTO) throws DatabaseException {
		try {
			Session session = HibernateUtil.openSession();
			Transaction t = session.beginTransaction();
			BaseBO baseBo = BODTOFiller.getBO(baseDTO);
			baseBo.setCreatedBy(ticket.getId());
			// baseBo.setId(2000l);
			baseBo.setCreatedOn(new Date());
			baseBo.setAction(Actions.CREATED.toString());
			session.save(baseBo);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BaseDTO update(Ticket ticket, BaseDTO baseDTO, String Spec) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		BaseBO baseBo = BODTOFiller.getBO(baseDTO);
		baseBo.setModifiedBy(ticket.getId());
		baseBo.setModifiedOn(new Date());
		baseBo.setAction(Actions.UPDATED.toString());
		session.update(baseBo);
		t.commit();
		session.close();
		return null;
	}

}
