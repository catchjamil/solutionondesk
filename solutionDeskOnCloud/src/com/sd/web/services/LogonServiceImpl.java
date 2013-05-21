package com.sd.web.services;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.web.dao.HibernateUtil;
import com.sd.web.dto.LogonDTO;
import com.sd.web.enums.Roles;
import com.sd.web.exception.AuthenticationException;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.UserRegistrationBO;
import com.sd.web.security.Ticket;

public class LogonServiceImpl implements LogonService {

	public Ticket authenticateUser(LogonDTO logonDTO) throws Exception {
		LogonDTO LogonDTODB = getUserDetails(logonDTO);
		Ticket ticket = null;
		if (LogonDTODB.getPassword().equals(logonDTO.getPassword())) {
			ticket = getTicket(LogonDTODB);
			return ticket;
		} else {
			throw new AuthenticationException("Invalid User.");
		}

	}

	public UserRegistrationBO findBySpec(String Spec) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		Query createQuery = session.createQuery(" from " + UserRegistrationBO.class.getName() + " where userName = '" + Spec + "'");
		List<UserRegistrationBO> list = createQuery.list();
		UserRegistrationBO userRegistrationBO = null;
		if ((list != null) && (list.size() == 1)) {
			userRegistrationBO = list.get(0);
		}else{
			createQuery = session.createQuery(" from " + UserRegistrationBO.class.getName());	
			if ((list != null) && (list.size() == 0)) {
				userRegistrationBO  = new UserRegistrationBO();
				userRegistrationBO.setId(1l);
				userRegistrationBO.setUserName("admin");
				userRegistrationBO.setPassword("12345678");
				userRegistrationBO.setRole(Roles.ADMIN.name());
				userRegistrationBO.setEmail("jamil2049@gmail.com");
				Transaction beginTransaction = session.beginTransaction();
				session.save(userRegistrationBO);
				beginTransaction.commit();
			}
		}
		session.close();

		return userRegistrationBO;
	}

	private Ticket getTicket(LogonDTO logonDTO) {
		Ticket ticket = new Ticket();
		ticket.setId(logonDTO.getId());
		ticket.setUserName(logonDTO.getUserName());
		ticket.setRole(logonDTO.getRole());
		ticket.setEmail(logonDTO.getEmail());
		return ticket;

	}

	private LogonDTO getUserDetails(LogonDTO logonDTO) throws AuthenticationException {
		LogonDTO LogonDTODB = new LogonDTO();
		try {
			UserRegistrationBO userRegistrationBO = findBySpec(logonDTO.getUserName());
			if (null != userRegistrationBO) {
				LogonDTODB.setId(userRegistrationBO.getId());
				LogonDTODB.setUserName(userRegistrationBO.getUserName());
				LogonDTODB.setPassword(userRegistrationBO.getPassword());
				LogonDTODB.setRole(userRegistrationBO.getRole());
			} else {
				throw new AuthenticationException("Invalid User.");
			}
		} catch (DatabaseException db) {
			db.printStackTrace();
		}
		return LogonDTODB;
	}

}
