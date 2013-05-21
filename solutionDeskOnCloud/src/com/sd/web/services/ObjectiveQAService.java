package com.sd.web.services;

import java.util.List;

import com.sd.web.dto.ObjectiveQADTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.security.Ticket;

public interface ObjectiveQAService extends BaseService {
	public ObjectiveQADTO delete(Ticket ticket, ObjectiveQADTO objectiveQADTO, String[] ids) throws DatabaseException;

	public ObjectiveQADTO findById(Ticket ticket, ObjectiveQADTO objectiveQADTO, String id) throws DatabaseException;

	public List<ObjectiveQADTO> findBySpec(Ticket ticket, ObjectiveQADTO objectiveQADTO, String spec) throws DatabaseException;

	public ObjectiveQADTO save(Ticket ticket, ObjectiveQADTO objectiveQADTO) throws DatabaseException;

	public ObjectiveQADTO update(Ticket ticket, ObjectiveQADTO objectiveQADTO) throws DatabaseException;

}
