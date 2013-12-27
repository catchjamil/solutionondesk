package com.sd.web.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sd.web.dao.BaseDAO;
import com.sd.web.dao.BaseDAOImpl;
import com.sd.web.dao.HibernateUtil;
import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.UserRegistrationDTO;
import com.sd.web.enums.Actions;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.UserRegistrationBO;
import com.sd.web.security.Ticket;

public class UserRegistrationServiceImpl implements UserRegistrationService {
	private final BaseDAO baseDAO = new BaseDAOImpl();

	public UserRegistrationDTO delete(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String[] ids) throws DatabaseException {
		baseDAO.delete(ticket, userRegistrationDTO, ids);
		return null;
	}

	public List<UserRegistrationDTO> findAll(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO", "BO");
		//Criteria criteria = session.createCriteria("" + getClassName(userRegistrationDTO)).add(Restrictions.ne("role", Actions.DELETED.toString()));
		Criteria criteria = session.createCriteria("" + getClassName(userRegistrationDTO));
		List<UserRegistrationBO> list = criteria.list();
		List<UserRegistrationDTO> techList = new ArrayList<UserRegistrationDTO>();

		for (UserRegistrationBO userRegistrationBO : list) {
			userRegistrationDTO = new UserRegistrationDTO();
			userRegistrationDTO.setId(userRegistrationBO.getId());
			userRegistrationDTO.setUserName(userRegistrationBO.getUserName());
			userRegistrationDTO.setFirstName(userRegistrationBO.getFirstName());
			userRegistrationDTO.setLastName(userRegistrationBO.getLastName());
			userRegistrationDTO.setRole(userRegistrationBO.getRole());
			techList.add(userRegistrationDTO);
		}
		session.close();
		return techList;
	}

	public UserRegistrationDTO findById(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String id) throws DatabaseException {
		userRegistrationDTO = (UserRegistrationDTO) baseDAO.findById(userRegistrationDTO, id);
		return userRegistrationDTO;
	}

	public List<UserRegistrationDTO> findBySpec(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String spec) throws DatabaseException {
		List<UserRegistrationDTO> techList = new ArrayList<UserRegistrationDTO>();
		try {
			Session session = HibernateUtil.openSession();

			// String className = baseDTO.getClass().getName().replace("DTO",
			// "BO");
			Query createQuery = session.createQuery(" from " + UserRegistrationBO.class.getName() + " where " + spec);
			List<UserRegistrationBO> list = createQuery.list();

			for (UserRegistrationBO userRegistrationBO : list) {
				userRegistrationDTO = new UserRegistrationDTO();
				userRegistrationDTO.setId(userRegistrationBO.getId());
				userRegistrationDTO.setUserName(userRegistrationBO.getUserName());
				userRegistrationDTO.setFirstName(userRegistrationBO.getFirstName());
				userRegistrationDTO.setLastName(userRegistrationBO.getLastName());
				userRegistrationDTO.setRole(userRegistrationBO.getRole());
				userRegistrationDTO.setPassword(userRegistrationBO.getPassword());
				userRegistrationDTO.setEmail(userRegistrationBO.getEmail());
				techList.add(userRegistrationDTO);
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

	public UserRegistrationDTO resetPwd(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		UserRegistrationBO userRegistrationBO = (UserRegistrationBO) session.load(UserRegistrationBO.class, userRegistrationDTO.getId());
		userRegistrationBO.setModifiedOn(new Date());
		userRegistrationBO.setAction(Actions.UPDATED.toString());
		userRegistrationBO.setPassword(userRegistrationDTO.getPassword());
		session.update(userRegistrationBO);
		t.commit();
		session.close();
		return null;
	}

	public UserRegistrationDTO save(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException {

		System.out.println("password : "+userRegistrationDTO.getPassword());
		userRegistrationDTO = (UserRegistrationDTO) baseDAO.save(ticket, userRegistrationDTO);
		return userRegistrationDTO;
	}

	public UserRegistrationDTO update(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		UserRegistrationBO userRegistrationBO = (UserRegistrationBO) session.load(UserRegistrationBO.class, userRegistrationDTO.getId());
		userRegistrationDTO.setPassword(userRegistrationBO.getPassword());
		userRegistrationDTO = (UserRegistrationDTO) baseDAO.update(ticket, userRegistrationDTO, "");
		session.close();
		return userRegistrationDTO;
	}

}
