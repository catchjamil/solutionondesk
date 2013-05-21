package com.sd.web.util;

import java.lang.reflect.Method;

import com.sd.web.dto.BaseDTO;
import com.sd.web.model.bo.BaseBO;

public class BODTOFiller {

	public static BaseBO getBO(BaseDTO dto) {
		BaseBO bo = getBOInstance(dto);
		Class boClass = bo.getClass();
		Class dtoClass = dto.getClass();

		Method[] boMethods = boClass.getMethods();
		for (Method boMethod : boMethods) {
			String boMethodName = boMethod.getName();
			if (boMethodName.startsWith("set")) {
				String dtoMethodName = boMethodName.replaceFirst("^set", "get");
				Method dtoMethod = null;
				try {
					dtoMethod = dtoClass.getMethod(dtoMethodName, new Class[] {});
				} catch (NoSuchMethodException ignore) {
					dtoMethodName = boMethodName.replaceFirst("^set", "is");
					try {
						dtoMethod = dtoClass.getMethod(boMethodName, new Class[] {});
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				}
				try {
					if ((null != dtoMethod) && (null != boMethod)) {
						Object returnValue = dtoMethod.invoke(dto, new Object[] {});
						boMethod.invoke(bo, new Object[] { returnValue });
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return bo;
	}

	private static BaseBO getBOInstance(BaseDTO dto) {
		String boClassName = dto.getClass().getName().replace("DTO", "BO").replace("dto", "model.bo");
		try {
			BaseBO BaseBO = (BaseBO) Class.forName(boClassName).newInstance();

			return BaseBO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static BaseDTO getDto(BaseDTO dto, BaseBO bo) {
		Class boClass = bo.getClass();
		Class dtoClass = dto.getClass();

		Method[] dtoMethods = dtoClass.getMethods();
		for (Method dtoMethod : dtoMethods) {
			String dtoMethodName = dtoMethod.getName();
			if (dtoMethodName.startsWith("set")) {
				String boMethodName = dtoMethodName.replaceFirst("^set", "get");
				Method boMethod = null;
				try {
					boMethod = boClass.getMethod(boMethodName, new Class[] {});
				} catch (NoSuchMethodException ignore) {
					boMethodName = dtoMethodName.replaceFirst("^set", "is");
					try {
						boMethod = boClass.getMethod(boMethodName, new Class[] {});
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {

					Object returnValue = boMethod.invoke(bo, new Object[] {});

					dtoMethod.invoke(dto, new Object[] { returnValue });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return dto;
	}

}
