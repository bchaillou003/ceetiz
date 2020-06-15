package com.ceetiz.projecthexa.serverside.model;

import com.ceetiz.projecthexa.businesslogic.exception.DenominationException;
import com.ceetiz.projecthexa.businesslogic.exception.SiretException;
import com.ceetiz.projecthexa.businesslogic.model.CompanyType;
import com.ceetiz.projecthexa.businesslogic.model.ISelfEmployedCompany;

/**
 * 
 * This class implements the {@link ISelfEmployedCompany} interface.
 *
 */
public class SelfEmployedCompanyImpl extends AbstractCompanyImpl implements ISelfEmployedCompany {

	public SelfEmployedCompanyImpl(String siret, String denomination) throws SiretException, DenominationException {
		super(siret, denomination);
	}

	@Override
	public CompanyType getType() {
		return CompanyType.SELF_EMPLOYED;
	}
}
