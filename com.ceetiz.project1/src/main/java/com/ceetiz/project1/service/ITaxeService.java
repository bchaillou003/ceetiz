package com.ceetiz.project1.service;

import com.ceetiz.project1.exception.CompanyTypeException;
import com.ceetiz.project1.model.CompanyType;
import com.ceetiz.project1.model.ICompany;

public interface ITaxeService {

	/**
	 * Calculates the taxes by {@link CompanyType}.
	 * 
	 * @param company {@link CompanyType}
	 * @param turnover {@link Double}
	 * @return {@link Double}
	 * @throws CompanyTypeException
	 */
	public double calculateTaxe(ICompany company, double turnover) throws CompanyTypeException;
}
