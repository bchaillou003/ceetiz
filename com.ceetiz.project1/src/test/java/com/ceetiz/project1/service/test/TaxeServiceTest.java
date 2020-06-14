package com.ceetiz.project1.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceetiz.project1.exception.CompanyTypeException;
import com.ceetiz.project1.exception.DenominationException;
import com.ceetiz.project1.exception.HeadOfficeAddressException;
import com.ceetiz.project1.exception.SiretException;
import com.ceetiz.project1.model.CompanyType;
import com.ceetiz.project1.model.ICompany;
import com.ceetiz.project1.model.impl.AbstractCompanyImpl;
import com.ceetiz.project1.model.impl.SasCompanyImpl;
import com.ceetiz.project1.model.impl.SelfEmployedCompanyImpl;
import com.ceetiz.project1.service.ITaxeService;
import com.ceetiz.project1.service.impl.TaxeServiceImpl;

public class TaxeServiceTest {
	
	private static final String SIRET = "01234567890123";
	private static final String DENOMINATION = "Denomination";
	private static final String HEAD_OFFICE_ADDRESS = "headOfficeAddress";
	
	private ITaxeService taxeService;
	
	public TaxeServiceTest() {
		taxeService = new TaxeServiceImpl();
	}

	@Test
	public void testCalculateTaxe() throws CompanyTypeException, SiretException, DenominationException, HeadOfficeAddressException {
		ICompany selftEmployedCompany = new SelfEmployedCompanyImpl(SIRET, DENOMINATION);
		double taxe1 = taxeService.calculateTaxe(selftEmployedCompany, 0);
		assertEquals(-1, taxe1);
		double taxe2 = taxeService.calculateTaxe(selftEmployedCompany, 100);
		assertEquals(25, taxe2);
		
		ICompany sasCompany = new SasCompanyImpl(SIRET, DENOMINATION, HEAD_OFFICE_ADDRESS);
		double taxe3 = taxeService.calculateTaxe(sasCompany, 0);
		assertEquals(-1, taxe3);
		double taxe4= taxeService.calculateTaxe(sasCompany, 100);
		assertEquals(33, taxe4);
		
		ICompany company = createCompany(SIRET, DENOMINATION);
		assertThrows(CompanyTypeException.class, () -> taxeService.calculateTaxe(company, 100));
	}

	private ICompany createCompany(String siret, String denomination) throws SiretException, DenominationException {
		return new AbstractCompanyImpl(siret, denomination) {
			@Override
			public CompanyType getType() {
				return CompanyType.SASU;
			}
		};
	}
}
