package com.ceetiz.project1.model;

/**
 * 
 * This interface defines a Company.
 *
 */
public interface ICompany {

	/**
	 * Gets the siret.
	 * 
	 * @return {@link String}
	 */
	public String getSiret();
	
	/**
	 * Gets the denomination.
	 * 
	 * @return {@link String}
	 */
	public String getDenomination();
	
	/**
	 * Gets the type.
	 * 
	 * @return {@link CompanyType}
	 */
	public CompanyType getType();
}
