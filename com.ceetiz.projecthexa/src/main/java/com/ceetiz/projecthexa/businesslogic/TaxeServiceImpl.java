package com.ceetiz.projecthexa.businesslogic;

import com.ceetiz.projecthexa.businesslogic.exception.CompanyTypeException;
import com.ceetiz.projecthexa.businesslogic.model.ICompany;
import com.ceetiz.projecthexa.businesslogic.port.IFindCompany;
import com.ceetiz.projecthexa.businesslogic.port.ITaxeService;

public class TaxeServiceImpl implements ITaxeService {
	
	private IFindCompany obtainCompany;
	
	public TaxeServiceImpl(IFindCompany obtainCompany) {
		this.obtainCompany = obtainCompany;
	}

	@Override
	public double calculateTaxes(String siret, double turnover) throws CompanyTypeException {
		ICompany company = obtainCompany.findBySiret(siret);
		if (company != null && turnover > 0) {
			switch (company.getType()) {
			case SELF_EMPLOYED:
				return turnover * 0.25;
			case SAS:
				return turnover * 0.33;
			default:
				throw new CompanyTypeException(company.getType());
			}
		}
		return -1;
	}

}
