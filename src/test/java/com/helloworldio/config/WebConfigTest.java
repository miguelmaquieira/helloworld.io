package com.helloworldio.config;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfigMixture.class })
public class WebConfigTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Test(expected = NoSuchMessageException.class)
	public void throwAnExceptionWhenWeAskForAnNotDefinedCode() {
		// Arrange
		String keyText = "keyNotDefined";
		Locale locale = Locale.ENGLISH;
		
		// Act
		webApplicationContext.getMessage(keyText, null, locale);
	}
	
	@Test
	public void returnTheRightTextforEnglishLocale() throws Exception {
		// Arrange
		String keyText = "webconfigtest.messageTest1";
		String expected = "test message 1. Check, check, check.";
		Locale locale = Locale.ENGLISH;
		
		// Act
		String text = webApplicationContext.getMessage(keyText, null, locale);
		
		// Assert
		assertEquals(expected, text);
	}
	
	@Test
	public void returnTheRightTextforFrenchLocale() throws Exception {
		// Arrange
		String keyText = "webconfigtest.messageTest1";
		String expected = "message de test 1. Un-deux-trois, Un-deux-trois";
		Locale locale = Locale.FRENCH;
		
		// Act
		String text = webApplicationContext.getMessage(keyText, null, locale);
		
		// Assert
		assertEquals(expected, text);
	}
	
	@Test
	public void returnTheTextFromTheDefaultFileSpanishLocaleAndText2() throws Exception {
		// Arrange
		String keyText = "webconfigtest.messageTest2";
		String expected = "test message 2. Bla bla bla bla...";
		Locale locale = new Locale("es","ES");
		
		// Act
		String text = webApplicationContext.getMessage(keyText, null, locale);
		
		// Assert
		assertEquals(expected, text);
	}
	
	@Test
	public void returnTheTextFromTheMessageFileInFolderMessages() throws Exception {
		// Arrange
		String keyText = "messageTest1";
		String expected = "test message 1. Check, check, check.";
		Locale locale = Locale.ENGLISH;
		
		// Act
		String text = webApplicationContext.getMessage(keyText, null, locale);
		
		// Assert
		assertEquals(expected, text);
	}
	
	@Test
	public void returnTheTextFromTheMessageDefaultFileInFolderMessages() throws Exception {
		// Arrange
		String keyText = "messageTest1";
		String expected = "test message 1. Check, check, check.";
		Locale locale = Locale.GERMAN;
		
		// Act
		String text = webApplicationContext.getMessage(keyText, null, locale);
		
		// Assert
		assertEquals(expected, text);
	}
}
