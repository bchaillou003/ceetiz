package com.ceetiz.project1.model.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ceetiz.project1.exception.DenominationException;
import com.ceetiz.project1.exception.SiretException;
import com.ceetiz.project1.model.ISelfEmployedCompany;
import com.ceetiz.project1.model.impl.SelfEmployedCompanyImpl;

public class SelfEmployedCompanyTest {

	private static final String SIRET = "01234567890123";
	private static final String DENOMINATION = "Denomination";
	
	@Test
	public void testSelfEmployedCompanyObject() throws SiretException, DenominationException {
		assertThrows(SiretException.class, () -> new SelfEmployedCompanyImpl("", ""));
		assertThrows(SiretException.class, () -> new SelfEmployedCompanyImpl("0123456789", ""));
		assertThrows(SiretException.class, () -> new SelfEmployedCompanyImpl("0123456789abcd", ""));
		assertThrows(DenominationException.class, () -> new SelfEmployedCompanyImpl(SIRET, ""));
		
		ISelfEmployedCompany selftEmployedCompany = new SelfEmployedCompanyImpl(SIRET, DENOMINATION);
		assertEquals(SIRET, selftEmployedCompany.getSiret());
		assertEquals(DENOMINATION, selftEmployedCompany.getDenomination());
	}

}
