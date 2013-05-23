package com.sd.web.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sd.web.dao.BaseDAO;
import com.sd.web.dao.BaseDAOImpl;
import com.sd.web.dao.HibernateUtil;
import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.ObjectiveQADTO;
import com.sd.web.dto.UserRegistrationDTO;
import com.sd.web.enums.Actions;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.ObjectiveQABO;
import com.sd.web.model.bo.UserRegistrationBO;
import com.sd.web.security.Ticket;

public class ObjectiveQAServiceImpl implements ObjectiveQAService {
	private final BaseDAO baseDAO = new BaseDAOImpl();

	public ObjectiveQADTO delete(Ticket ticket, ObjectiveQADTO ObjectiveQADTO, String[] ids) throws DatabaseException {
		ObjectiveQADTO = (ObjectiveQADTO) baseDAO.delete(ticket, ObjectiveQADTO, ids);
		return ObjectiveQADTO;
	}

	public List<ObjectiveQADTO> findAll(Ticket ticket, ObjectiveQADTO ObjectiveQADTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO", "BO");
		Criteria criteria = session.createCriteria("" + getClassName(ObjectiveQADTO)).add(Restrictions.ne("role", Actions.DELETED.toString()));
		List<ObjectiveQABO> list = criteria.list();
		List<ObjectiveQADTO> techList = new ArrayList<ObjectiveQADTO>();

		for (ObjectiveQABO objectiveQABO : list) {
			ObjectiveQADTO = new ObjectiveQADTO();
			ObjectiveQADTO.setId(objectiveQABO.getId());
			techList.add(ObjectiveQADTO);
		}
		session.close();
		return techList;
	}

	public ObjectiveQADTO findById(Ticket ticket, ObjectiveQADTO ObjectiveQADTO, String id) throws DatabaseException {
		ObjectiveQADTO = (ObjectiveQADTO) baseDAO.findById(ObjectiveQADTO, id);
		return ObjectiveQADTO;
	}

	public List<ObjectiveQADTO> findBySpec(Ticket ticket, ObjectiveQADTO ObjectiveQADTO, String spec) throws DatabaseException {
		List<ObjectiveQADTO> techList = new ArrayList<ObjectiveQADTO>();
		try {
			Session session = HibernateUtil.openSession();
System.out.println("Query : "+" from " + ObjectiveQABO.class.getName() + " where " + spec);
			Query createQuery = session.createQuery(" from " + ObjectiveQABO.class.getName() + " where " + spec);
			List<ObjectiveQABO> list = createQuery.list();

			for (ObjectiveQABO objectiveQABO : list) {
				ObjectiveQADTO = new ObjectiveQADTO();
				// BODTOFiller.getDto(ObjectiveQADTO, objectiveQABO);
				ObjectiveQADTO.setId(objectiveQABO.getId());
				ObjectiveQADTO.setQuestion(objectiveQABO.getQuestion());
				ObjectiveQADTO.setOption1(objectiveQABO.getOption1());
				ObjectiveQADTO.setOption2(objectiveQABO.getOption2());
				ObjectiveQADTO.setOption3(objectiveQABO.getOption3());
				ObjectiveQADTO.setOption4(objectiveQABO.getOption4());
				ObjectiveQADTO.setAnswer(objectiveQABO.getAnswer());
				ObjectiveQADTO.setTechnologyId(objectiveQABO.getTechnologyId());
				ObjectiveQADTO.setCreatedBy(objectiveQABO.getCreatedBy());
				techList.add(ObjectiveQADTO);
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return techList;
	}

	private String getClassName(BaseDTO baseDTO) {
		return baseDTO.getClass().getName().replace("DTO", "BO").replace("dto", "bo").replace(".bo.", ".model.bo.");
	}

	public ObjectiveQADTO save(Ticket ticket, ObjectiveQADTO ObjectiveQADTO) throws DatabaseException {

		ObjectiveQADTO = (ObjectiveQADTO) baseDAO.save(ticket, ObjectiveQADTO);
		return ObjectiveQADTO;
	}

	public ObjectiveQADTO update(Ticket ticket, ObjectiveQADTO objectiveQADTO) throws DatabaseException {

		
		Session session = HibernateUtil.openSession();
		ObjectiveQABO objectiveQABO = (ObjectiveQABO) session.load(ObjectiveQABO.class, objectiveQADTO.getId());
		objectiveQADTO.setTechnologyId(objectiveQABO.getTechnologyId());
		objectiveQADTO.setCreatedOn(objectiveQABO.getCreatedOn());
		objectiveQADTO.setCreatedBy(objectiveQABO.getCreatedBy());
		session.close();
		
		objectiveQADTO = (ObjectiveQADTO) baseDAO.update(ticket, objectiveQADTO, "");
		return objectiveQADTO;
	}
}
