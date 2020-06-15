package com.ceetiz.projecthexa.userside;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.ceetiz.projecthexa.businesslogic.TaxeServiceImpl;
import com.ceetiz.projecthexa.businesslogic.exception.CompanyTypeException;
import com.ceetiz.projecthexa.businesslogic.exception.DenominationException;
import com.ceetiz.projecthexa.businesslogic.exception.HeadOfficeAddressException;
import com.ceetiz.projecthexa.businesslogic.exception.SiretException;
import com.ceetiz.projecthexa.businesslogic.model.CompanyType;
import com.ceetiz.projecthexa.businesslogic.model.ICompany;
import com.ceetiz.projecthexa.businesslogic.port.IFindCompany;
import com.ceetiz.projecthexa.businesslogic.port.ITaxeService;
import com.ceetiz.projecthexa.serverside.adapter.CompanyMemoryAdapter;

class TaxeServiceTest {

	public static final String SIRET_SELFEMPLOYED = "SIRET_SELFEMPLOYED";
	public static final String SIRET_SAS = "SIRET_SAS";
	
	@Test
	void testUnit() throws CompanyTypeException {
		// 1. Instantiate user-side adapter.
		IFindCompany mockAdapter = createMockAdapter();
		
		// 2. Instantiate business logic.
		ITaxeService taxeService = new TaxeServiceImpl(mockAdapter);
		
		// 3. Instantiate the server-side adapter (here, it's assert methods).
		double taxe1 = taxeService.calculateTaxes(SIRET_SELFEMPLOYED, 0);
		assertEquals(-1, taxe1);
		double taxe2 = taxeService.calculateTaxes(SIRET_SELFEMPLOYED, 100);
		assertEquals(25, taxe2);
		double taxe3 = taxeService.calculateTaxes(SIRET_SAS, 0);
		assertEquals(-1, taxe3);
		double taxe4= taxeService.calculateTaxes(SIRET_SAS, 100);
		assertEquals(33, taxe4);
	}
	
	@Test
	void testIntegration() throws SiretException, DenominationException, HeadOfficeAddressException, CompanyTypeException {
		// 1. Instantiate user-side adapter.
		IFindCompany memoryAdapter = new CompanyMemoryAdapter();
		
		// 2. Instantiate business logic.
		ITaxeService taxeService = new TaxeServiceImpl(memoryAdapter);
		
		// 3. Instantiate the server-side adapter (here, it's assert methods).
		double taxe1 = taxeService.calculateTaxes(CompanyMemoryAdapter.SIRET_SELFEMPLOYED, 0);
		assertEquals(-1, taxe1);
		double taxe2 = taxeService.calculateTaxes(CompanyMemoryAdapter.SIRET_SELFEMPLOYED, 100);
		assertEquals(25, taxe2);
		double taxe3 = taxeService.calculateTaxes(CompanyMemoryAdapter.SIRET_SAS, 0);
		assertEquals(-1, taxe3);
		double taxe4= taxeService.calculateTaxes(CompanyMemoryAdapter.SIRET_SAS, 100);
		assertEquals(33, taxe4);
	}
	
	private IFindCompany createMockAdapter() {
		IFindCompany mockAdapter = mock(IFindCompany.class);
		ICompany selfEmployedCompany = createMockCompany(CompanyType.SELF_EMPLOYED);
		ICompany sasCompany = createMockCompany(CompanyType.SAS);

		when(mockAdapter.findBySiret(SIRET_SELFEMPLOYED)).thenReturn(selfEmployedCompany);
		when(mockAdapter.findBySiret(SIRET_SAS)).thenReturn(sasCompany);
		return mockAdapter;
	}
	
	private ICompany createMockCompany(CompanyType type) {
		ICompany mockCompany = mock(ICompany.class);
		when(mockCompany.getType()).thenReturn(type);
		return mockCompany;
	}
}
