package com.sd.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sd.web.form.LogonForm;

public class UserRegistrationFormValidator implements Validator {

	public boolean supports(Class clazz) {
		return clazz.equals(LogonForm.class);
	}

	public void validate(Object obj, Errors errors) {
		LogonForm logonForm = (LogonForm) obj;
		if (logonForm == null) {
			errors.rejectValue("username", "error.login.not-specified", null,
					"Value required.");
		} else {

			if ((logonForm.getUserName() == null)
					|| (logonForm.getUserName().trim().length() <= 0)) {
				System.out.println("user name null value");
				errors.rejectValue("userName", "error.login.invalid-user",
						null, "Username is Required.");
			} else {
				if ((logonForm.getPassword() == null)
						|| (logonForm.getPassword().trim().length() <= 0)) {
					errors.rejectValue("password", "error.login.invalid-pass",
							null, "Password is Required.");
				}
			}

		}
	}
}
