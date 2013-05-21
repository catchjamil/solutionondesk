package com.sd.web.services;

import java.util.List;

import com.sd.web.dto.UserRegistrationDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.security.Ticket;

public interface UserRegistrationService extends BaseService {
	public UserRegistrationDTO delete(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String[] ids) throws DatabaseException;

	public List<UserRegistrationDTO> findAll(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException;

	public UserRegistrationDTO findById(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String id) throws DatabaseException;

	public List<UserRegistrationDTO> findBySpec(Ticket ticket, UserRegistrationDTO userRegistrationDTO, String spec) throws DatabaseException;

	public UserRegistrationDTO resetPwd(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException;

	public UserRegistrationDTO save(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException;

	public UserRegistrationDTO update(Ticket ticket, UserRegistrationDTO userRegistrationDTO) throws DatabaseException;

}
