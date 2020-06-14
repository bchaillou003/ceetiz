package com.ceetiz.project1.model.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ceetiz.project1.exception.DenominationException;
import com.ceetiz.project1.exception.HeadOfficeAddressException;
import com.ceetiz.project1.exception.SiretException;
import com.ceetiz.project1.model.ISasCompany;
import com.ceetiz.project1.model.impl.SasCompanyImpl;

public class SasCompanyTest {
	
	private static final String SIRET = "01234567890123";
	private static final String DENOMINATION = "Denomination";
	private static final String HEAD_OFFICE_ADDRESS = "headOfficeAddress";

	@Test
	public void testSasCompanyObject() throws SiretException, DenominationException, HeadOfficeAddressException {
		assertThrows(HeadOfficeAddressException.class, () -> new SasCompanyImpl(SIRET, DENOMINATION, ""));
		
		ISasCompany sasCompany = new SasCompanyImpl(SIRET, DENOMINATION, HEAD_OFFICE_ADDRESS);
		assertEquals(SIRET, sasCompany.getSiret());
		assertEquals(DENOMINATION, sasCompany.getDenomination());
		assertEquals(HEAD_OFFICE_ADDRESS, sasCompany.getHeadOfficeAddress());
	}

}
