package com.ceetiz.project1.exception;

import com.ceetiz.project1.model.CompanyType;
import com.ceetiz.project1.model.ICompany;

/**
 * 
 * This exception is for the type of a {@link ICompany}.
 *
 */
public class CompanyTypeException extends Exception {

	private static final long serialVersionUID = 2588064135496720800L;

	public CompanyTypeException(CompanyType type) {
		super(type + " company type is unknown.");
	}
}
