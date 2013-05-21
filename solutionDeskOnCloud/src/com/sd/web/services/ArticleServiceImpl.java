package com.sd.web.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sd.web.dao.BaseDAO;
import com.sd.web.dao.BaseDAOImpl;
import com.sd.web.dao.HibernateUtil;
import com.sd.web.dto.ArticleDTO;
import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.TechnologyDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.model.bo.ArticleBO;
import com.sd.web.security.Ticket;

public class ArticleServiceImpl implements ArticleService {
	private final BaseDAO baseDAO = new BaseDAOImpl();

	public List<ArticleDTO> findBySpec(Ticket ticket, ArticleDTO articleDTO, String spec) throws DatabaseException {
		Session session = HibernateUtil.openSession();
		Query createQuery = session.createQuery(" from " + ArticleBO.class.getName());
		List<ArticleBO> list = createQuery.list();
		List<ArticleDTO> dtoList = new ArrayList<ArticleDTO>();
		for (ArticleBO articleBO : list) {
			articleDTO = new ArticleDTO();
			articleDTO.setDescription(articleBO.getDescription());
			dtoList.add(articleDTO);
		}
		return dtoList;
	}

	public Long findTechnologyId(String Spec) throws DatabaseException {
		List<BaseDTO> list = baseDAO.findBySpec(new TechnologyDTO(), Spec);
		if (null != list) {
			BaseDTO baseDTO = list.get(0) != null ? list.get(0) : new BaseDTO();
			return baseDTO.getId();
		}
		return 0l;
	}

	public BaseDTO save(Ticket ticket, BaseDTO baseDTO) throws DatabaseException {
		baseDTO = (ArticleDTO) baseDAO.save(ticket, baseDTO);
		return baseDTO;

	}

}
