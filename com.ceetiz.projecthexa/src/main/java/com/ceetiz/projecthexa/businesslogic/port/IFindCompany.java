package com.ceetiz.projecthexa.businesslogic.port;

import com.ceetiz.projecthexa.businesslogic.model.ICompany;

/**
 * 
 * This interface allows to find companies.
 *
 */
public interface IFindCompany {

	/**
	 * Finds a {@link ICompany} by its siret.
	 * 
	 * @param siret {@link String}
	 * @return {@link ICompany}
	 */
	public ICompany findBySiret(String siret);
}
