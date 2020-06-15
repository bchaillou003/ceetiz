package com.ceetiz.projecthexa.businesslogic.exception;

import com.ceetiz.projecthexa.businesslogic.model.ICompany;

/**
 * 
 * This exception is for the Denomination of a {@link ICompany}.
 *
 */
public class DenominationException extends Exception {

	private static final long serialVersionUID = 337666871781293669L;

	public DenominationException(String message) {
		super(message);
	}
}
