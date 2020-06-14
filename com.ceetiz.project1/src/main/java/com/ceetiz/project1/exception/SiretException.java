package com.ceetiz.project1.exception;

import com.ceetiz.project1.model.ICompany;

/**
 * 
 * This exception is for the siret of a {@link ICompany}.
 *
 */
public class SiretException extends Exception {

	private static final long serialVersionUID = -3269568172853383577L;

	public SiretException(String message)  {
		super(message);
	}
}
