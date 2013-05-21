package com.sd.web.services;

import java.util.List;

import com.sd.web.dto.TechnologyDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.security.Ticket;

public interface TechnologyService extends BaseService {
	public List<TechnologyDTO> findAll(Ticket ticket, TechnologyDTO technologyDTO) throws DatabaseException;

	public List<TechnologyDTO> findBySpec(Ticket ticket, TechnologyDTO technologyDTO, String spec) throws DatabaseException;

	public TechnologyDTO save(Ticket ticket, TechnologyDTO technologyDTO) throws DatabaseException;

}
