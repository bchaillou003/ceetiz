package com.ceetiz.project1.model;

/**
 * 
 * This interface defines a Company of SAS type (see {@link CompanyType}).
 *
 */
public interface ISasCompany extends ICompany {

	/**
	 * Gets the head office address.
	 * 
	 * @return {@link String}
	 */
	public String getHeadOfficeAddress();
}
