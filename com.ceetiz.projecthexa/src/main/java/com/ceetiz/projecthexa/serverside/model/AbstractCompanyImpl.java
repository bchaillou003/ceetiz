package com.ceetiz.projecthexa.serverside.model;

import com.ceetiz.projecthexa.businesslogic.exception.DenominationException;
import com.ceetiz.projecthexa.businesslogic.exception.SiretException;
import com.ceetiz.projecthexa.businesslogic.model.ICompany;

/**
 * 
 * This abstract class implements the {@link ICompany} interface.
 * It checks if the siret and denomination are correct.
 *
 */
public abstract class AbstractCompanyImpl implements ICompany {
	
	private static final String SIRET_REGEX = "\\d{14}";
	
	protected String siret;
	protected String denomination;

	public AbstractCompanyImpl(String siret, String denomination) throws SiretException, DenominationException {
		checkSiret(siret);
		checkDenomination(denomination);
		
		this.siret = siret;
		this.denomination = denomination;
	}

	@Override
	public String getSiret() {
		return siret;
	}
	
	@Override
	public String getDenomination() {
		return denomination;
	}
	
	private void checkSiret(String siret) throws SiretException {
		if (siret == null || "".equals(siret.trim())) {
			throw new SiretException("Siret can't not be null or empty.");
		} else if(!siret.matches(SIRET_REGEX)) {
			throw new SiretException("Siret should only be made up of numbers and must be 14 digits.");
		}
	}
	
	private void checkDenomination(String denomination) throws DenominationException {
		if (denomination == null || "".equals(denomination.trim())) {
			throw new DenominationException("Denomination can't not be null or empty.");
		}
	}
}
