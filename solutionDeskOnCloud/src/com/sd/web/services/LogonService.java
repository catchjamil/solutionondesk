package com.sd.web.services;

import com.sd.web.dto.LogonDTO;
import com.sd.web.security.Ticket;

public interface LogonService extends BaseService {

	public Ticket authenticateUser(LogonDTO logonDTO) throws Exception;

}
