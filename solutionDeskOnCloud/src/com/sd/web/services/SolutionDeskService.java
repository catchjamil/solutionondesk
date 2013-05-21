/**
 * 
 */
package com.sd.web.services;

/**
 * @author Jamil
 * 
 */
public abstract class SolutionDeskService {

	public static BaseService getService(String serviceName) {
		try {
			Class clazz = Class.forName(serviceName);
			BaseService baseService = (BaseService) clazz.newInstance();
			return baseService;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
