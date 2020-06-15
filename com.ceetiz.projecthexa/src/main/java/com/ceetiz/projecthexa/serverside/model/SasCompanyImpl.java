package com.ceetiz.projecthexa.serverside.model;

import com.ceetiz.projecthexa.businesslogic.exception.DenominationException;
import com.ceetiz.projecthexa.businesslogic.exception.HeadOfficeAddressException;
import com.ceetiz.projecthexa.businesslogic.exception.SiretException;
import com.ceetiz.projecthexa.businesslogic.model.CompanyType;
import com.ceetiz.projecthexa.businesslogic.model.ISasCompany;

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
