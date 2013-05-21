package com.sd.web.services;

import java.util.List;

import com.sd.web.dto.ArticleDTO;
import com.sd.web.dto.BaseDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.security.Ticket;

public interface ArticleService extends BaseService {
	public List<ArticleDTO> findBySpec(Ticket ticket, ArticleDTO articleDTO, String spec) throws DatabaseException;

	public Long findTechnologyId(String Spec) throws DatabaseException;

	public BaseDTO save(Ticket ticket, BaseDTO baseDTO) throws DatabaseException;

}
