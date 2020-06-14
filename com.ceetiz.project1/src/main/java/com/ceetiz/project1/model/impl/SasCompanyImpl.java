package com.ceetiz.project1.model.impl;

import com.ceetiz.project1.exception.DenominationException;
import com.ceetiz.project1.exception.HeadOfficeAddressException;
import com.ceetiz.project1.exception.SiretException;
import com.ceetiz.project1.model.CompanyType;
import com.ceetiz.project1.model.ISasCompany;

/**
 * 
 * This abstract class implements the {@link ISasCompany} interface.
 * It checks if the head office address is correct.
 *
 */
public class SasCompanyImpl extends AbstractCompanyImpl implements ISasCompany {
	
	private String headOfficeAddress;

	public SasCompanyImpl(String siret, String denomination, String headOfficeAddress) throws SiretException, DenominationException, HeadOfficeAddressException {
		super(siret, denomination);
		
		checkHeadOfficeAddress(headOfficeAddress);
		
		this.headOfficeAddress = headOfficeAddress;
	}

	@Override
	public String getHeadOfficeAddress() {
		return headOfficeAddress;
	}
	
	@Override
	public CompanyType getType() {
		return CompanyType.SAS;
	}
	
	private void checkHeadOfficeAddress(String headOfficeAddress) throws HeadOfficeAddressException {
		if (headOfficeAddress == null || "".equals(headOfficeAddress.trim())) {
			throw new HeadOfficeAddressException("Head Office Address can't not be null or empty.");
		}
	}
}
