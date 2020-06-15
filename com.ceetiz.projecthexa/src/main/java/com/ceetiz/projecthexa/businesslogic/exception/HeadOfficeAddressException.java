package com.ceetiz.projecthexa.businesslogic.exception;

import com.ceetiz.projecthexa.businesslogic.model.ISasCompany;

/**
 * 
 * This exception is for the head office address of a {@link ISasCompany}.
 *
 */
public class HeadOfficeAddressException extends Exception {
	
	private static final long serialVersionUID = 8315806298689955837L;

	public HeadOfficeAddressException(String message) {
		super(message);
	}
}
