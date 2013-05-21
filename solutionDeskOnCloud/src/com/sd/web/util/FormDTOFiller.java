package com.sd.web.util;

import java.lang.reflect.Method;

import com.sd.web.dto.BaseDTO;
import com.sd.web.form.BaseForm;

public class FormDTOFiller {

	public static BaseDTO getDTO(BaseForm form) {
		BaseDTO dto = getDTOInstance(form);
		Class formClass = form.getClass();
		Class dtoClass = dto.getClass();

		Method[] dtoMethods = dtoClass.getMethods();
		for (Method dtoMethod : dtoMethods) {
			String dtoMethodName = dtoMethod.getName();
			if (dtoMethodName.startsWith("set")) {
				String formMethodName = dtoMethodName.replaceFirst("^set", "get");
				Method formMethod = null;
				try {
					formMethod = formClass.getMethod(formMethodName, new Class[] {});
				} catch (NoSuchMethodException ignore) {
					formMethodName = dtoMethodName.replaceFirst("^set", "is");
					try {
						formMethod = formClass.getMethod(formMethodName, new Class[] {});
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				}
				try {
					if ((null != formMethod) && (null != dtoMethod)) {
						Object returnValue = formMethod.invoke(form, new Object[] {});

						dtoMethod.invoke(dto, new Object[] { returnValue });
					}
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		}
		return dto;
	}

	public static BaseDTO getDTO(BaseForm form, BaseDTO dto) {
		Class formClass = form.getClass();
		Class dtoClass = dto.getClass();

		Method[] dtoMethods = dtoClass.getMethods();
		for (Method dtoMethod : dtoMethods) {
			String dtoMethodName = dtoMethod.getName();
			if (dtoMethodName.startsWith("set")) {
				String formMethodName = dtoMethodName.replaceFirst("^set", "get");
				Method formMethod = null;
				try {
					formMethod = formClass.getMethod(formMethodName, new Class[] {});
				} catch (NoSuchMethodException ignore) {
					formMethodName = dtoMethodName.replaceFirst("^set", "is");
					try {
						formMethod = formClass.getMethod(formMethodName, new Class[] {});
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				}
				try {
					if ((null != formMethod) && (null != dtoMethod)) {
						Object returnValue = formMethod.invoke(form, new Object[] {});

						dtoMethod.invoke(dto, new Object[] { returnValue });
					}
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		}
		return dto;
	}

	private static BaseDTO getDTOInstance(BaseForm form) {
		String boClassName = form.getClass().getName().replace("Form", "DTO").replace("form", "dto");
		try {
			BaseDTO BaseDTO = (BaseDTO) Class.forName(boClassName).newInstance();

			return BaseDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static BaseForm getForm(BaseDTO dto) {
		BaseForm form = getFormInstance(dto);
		Class dtoClass = dto.getClass();
		Class formClass = form.getClass();

		Method[] formMethods = formClass.getMethods();
		for (Method formMethod : formMethods) {
			String formMethodName = formMethod.getName();
			if (formMethodName.startsWith("set")) {
				String dtoMethodName = formMethodName.replaceFirst("^set", "get");
				Method dtoMethod = null;
				try {
					dtoMethod = dtoClass.getMethod(dtoMethodName, new Class[] {});
				} catch (NoSuchMethodException ignore) {
					dtoMethodName = formMethodName.replaceFirst("^set", "is");
					try {
						dtoMethod = dtoClass.getMethod(dtoMethodName, new Class[] {});
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				}
				try {
					if ((null != dtoMethod) && (null != dtoMethod)) {
						Object returnValue = dtoMethod.invoke(dto, new Object[] {});

						formMethod.invoke(form, new Object[] { returnValue });
					}
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		}
		return form;
	}

	private static BaseForm getFormInstance(BaseDTO form) {
		String formClassName = form.getClass().getName().replace("DTO", "Form").replace("dto", "form");
		try {
			BaseForm baseForm = (BaseForm) Class.forName(formClassName).newInstance();

			return baseForm;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
