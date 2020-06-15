package com.ceetiz.projecthexa.serverside.adapter;

import java.util.HashMap;
import java.util.Map;

import com.ceetiz.projecthexa.businesslogic.exception.DenominationException;
import com.ceetiz.projecthexa.businesslogic.exception.HeadOfficeAddressException;
import com.ceetiz.projecthexa.businesslogic.exception.SiretException;
import com.ceetiz.projecthexa.businesslogic.model.ICompany;
import com.ceetiz.projecthexa.businesslogic.port.IFindCompany;
import com.ceetiz.projecthexa.serverside.model.SasCompanyImpl;
import com.ceetiz.projecthexa.serverside.model.SelfEmployedCompanyImpl;

public class CompanyMemoryAdapter implements IFindCompany {

	public static final String SIRET_SELFEMPLOYED = "01234567890123";
	public static final String SIRET_SAS = "01234567890124";
	public static final String DENOMINATION = "Denomination";
	public static final String HEAD_OFFICE_ADDRESS = "headOfficeAddress";
	
	private Map<String, ICompany> companiesMap;
	
	public CompanyMemoryAdapter() throws SiretException, DenominationException, HeadOfficeAddressException {
		companiesMap = buildCompaniesMap();
	}
	
	@Override
	public ICompany findBySiret(String siret) {
		return companiesMap.get(siret);
	}

	private Map<String, ICompany> buildCompaniesMap() throws SiretException, DenominationException, HeadOfficeAddressException {
		Map<String, ICompany> map = new HashMap<>();
		map.put(SIRET_SELFEMPLOYED, new SelfEmployedCompanyImpl(SIRET_SELFEMPLOYED, DENOMINATION));
		map.put(SIRET_SAS, new SasCompanyImpl(SIRET_SAS, DENOMINATION, HEAD_OFFICE_ADDRESS));
		return map;
	}
}
