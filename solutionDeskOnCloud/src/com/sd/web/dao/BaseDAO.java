/**
 * 
 */
package com.sd.web.dao;

import java.util.List;

import com.sd.web.dto.BaseDTO;
import com.sd.web.exception.DatabaseException;
import com.sd.web.security.Ticket;

/*******************************************************************************
 * *
 * 
 * @author Jamil
 */

public interface BaseDAO {

	/**
	 * @param logonDTO
	 * @param baseBo
	 * @param Spec
	 * @return
	 * @throws DatabaseException
	 */
	public BaseDTO delete(Ticket ticket, BaseDTO baseDTO, String[] ids) throws DatabaseException;

	/**
	 * @param baseBo
	 * @return
	 * @throws DatabaseException
	 */
	public List<BaseDTO> findAll(BaseDTO baseDTO) throws DatabaseException;

	/**
	 * @param baseBo
	 * @param id
	 * @return
	 * @throws DatabaseException
	 */
	public BaseDTO findById(BaseDTO baseDTO, String id) throws DatabaseException;

	/**
	 * @param baseBo
	 * @param Spec
	 * @return
	 * @throws DatabaseException
	 */
	public List<BaseDTO> findBySpec(BaseDTO baseDTO, String Spec) throws DatabaseException;

	/**
	 * @param logonDTO
	 * @param baseBo
	 * @param Spec
	 * @return
	 * @throws DatabaseException
	 */
	public BaseDTO save(Ticket ticket, BaseDTO baseDTO) throws DatabaseException;

	/**
	 * @param logonDTO
	 * @param baseBo
	 * @param Spec
	 * @return
	 * @throws DatabaseException
	 */
	public BaseDTO update(Ticket ticket, BaseDTO baseDTO, String Spec) throws DatabaseException;

}
