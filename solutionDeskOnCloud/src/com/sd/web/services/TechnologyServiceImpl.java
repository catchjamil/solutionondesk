package com.sd.web.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sd.web.dao.BaseDAO;
import com.sd.web.dao.BaseDAOImpl;
import com.sd.web.dao.HibernateUtil;
import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.TechnologyDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.TechnologyBO;
import com.sd.web.security.Ticket;

public class TechnologyServiceImpl implements TechnologyService {
	private static BaseDAO baseDAO = new BaseDAOImpl();

	public List<TechnologyDTO> findAll(Ticket ticket, TechnologyDTO technologyDTO) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO", "BO");
		Criteria criteria = session.createCriteria("" + getClassName(technologyDTO));
		List<TechnologyBO> list = criteria.list();
		List<TechnologyDTO> techList = new ArrayList<TechnologyDTO>();

		for (TechnologyBO technologyBO : list) {
			technologyDTO = new TechnologyDTO();
			technologyDTO.setId(technologyBO.getId());
			technologyDTO.setTechName(technologyBO.getTechName());
			techList.add(technologyDTO);
		}
		session.close();
		return techList;
	}

	public List<TechnologyDTO> findBySpec(Ticket ticket, TechnologyDTO technologyDTO, String spec) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		// String className = baseDTO.getClass().getName().replace("DTO", "BO");
		Query createQuery = session.createQuery(" from " + TechnologyBO.class.getName() + " where " + spec);
		List<TechnologyBO> list = createQuery.list();

		List<TechnologyDTO> techList = new ArrayList<TechnologyDTO>();

		for (TechnologyBO technologyBO : list) {
			technologyDTO = new TechnologyDTO();
			technologyDTO.setTechName(technologyBO.getChapterName());
			technologyDTO.setTechName(technologyBO.getTopicName());
			techList.add(technologyDTO);
		}
		session.close();
		return techList;
	}

	private String getClassName(BaseDTO baseDTO) {
		return baseDTO.getClass().getName().replace("DTO", "BO").replace("dto", "bo").replace(".bo.", ".model.bo.");
	}

	public TechnologyDTO save(Ticket ticket, TechnologyDTO technologyDTO) throws DatabaseException {
		technologyDTO = (TechnologyDTO) baseDAO.save(ticket, technologyDTO);
		return technologyDTO;
	}
}
