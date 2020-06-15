package com.ceetiz.projecthexa.businesslogic.port;

import com.ceetiz.projecthexa.businesslogic.exception.CompanyTypeException;
import com.ceetiz.projecthexa.businesslogic.model.CompanyType;

/**
 * 
 * This interface allows to calculate taxes of a company.
 *
 */
public interface ITaxeService {
	
	/**
	 * Calculates the taxes by {@link CompanyType}.
	 * 
	 * @param siret {@link String}
	 * @param turnover {@link Double}
	 * @return {@link Double}
	 * @throws CompanyTypeException
	 */
	public double calculateTaxes(String siret, double turnover) throws CompanyTypeException;
}
