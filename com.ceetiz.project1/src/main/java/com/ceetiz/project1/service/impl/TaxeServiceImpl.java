package com.ceetiz.project1.service.impl;

import com.ceetiz.project1.exception.CompanyTypeException;
import com.ceetiz.project1.model.ICompany;
import com.ceetiz.project1.service.ITaxeService;

/**
 * 
 * This class is a service for the taxes.
 * It allows to calculate the taxes for different companies.
 *
 */
public class TaxeServiceImpl implements ITaxeService {
	
	@Override
	public double calculateTaxe(ICompany company, double turnover) throws CompanyTypeException {
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
