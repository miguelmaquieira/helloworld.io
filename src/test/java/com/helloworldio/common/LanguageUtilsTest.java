package com.helloworldio.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.junit.Test;

public class LanguageUtilsTest {
	
	@Test
	public void getLocaleArrayShouldReturnAThreeElementArray() {
		// Arrange
 		Locale sourceLocale = LocaleUtils.toLocale("es_ES");
 		int expectedSize = 3; // es, es_ES, ca_ES
 		
		// Act
		Locale[] result = LanguageUtils.getLocaleArray(sourceLocale);
 		
		// Assert
		assertNotNull(result);
		assertEquals(expectedSize, result.length);
	}

}
