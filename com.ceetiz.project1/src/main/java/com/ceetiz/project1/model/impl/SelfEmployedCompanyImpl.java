package com.ceetiz.project1.model.impl;

import com.ceetiz.project1.exception.DenominationException;
import com.ceetiz.project1.exception.SiretException;
import com.ceetiz.project1.model.CompanyType;
import com.ceetiz.project1.model.ISelfEmployedCompany;

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
