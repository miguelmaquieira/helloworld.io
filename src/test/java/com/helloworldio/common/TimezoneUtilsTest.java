package com.helloworldio.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.helloworldio.common.TimezoneUtils.TIMEZONE_PREFIX;

public class TimezoneUtilsTest {
	
	@Test
	public void getTimezonePrefixShouldReturnEightStringList() {
		// Arrange
		int timezonePrefixSize = 8;
		
		// Act
		List<String> prefixList = TimezoneUtils.getTimezonePrefixs();
		
		// Assert
		assertNotNull(prefixList);
		assertEquals(timezonePrefixSize, prefixList.size());
	}
	
	@Test
	public void getTimezonePrefixShouldContainEuropeAndAmericaPrefix() {
		// Arrange
		String europaPrefix = "Europe";
		String americaPrefix = "America";
		
		// Act
		List<String> prefixList = TimezoneUtils.getTimezonePrefixs();
		
		// Assert
		assertNotNull(prefixList);
		assertTrue(prefixList.contains(europaPrefix) && prefixList.contains(americaPrefix));
	}
	
	@Test
	public void getTimezonesAfrica() {
		// Arrange
		TIMEZONE_PREFIX timezonePrefix = TIMEZONE_PREFIX.AFRICA;
		
		// Act
		List<TimeZone> timezoneList = TimezoneUtils.getTimezone(timezonePrefix);
		Iterator<TimeZone> iterTimezone = timezoneList.iterator();
		StringBuilder sbTimezones = new StringBuilder();
		sbTimezones.append(timezonePrefix.value()).append("\n________________________\n");
		while(iterTimezone.hasNext()) {
			TimeZone timezone = iterTimezone.next();
			String timezoneName = timezone.getID().replaceAll(timezonePrefix.value() + "/", "");
			sbTimezones.append(timezoneName).append(":").append(timezone.getDisplayName()).append("\n");
		}
		
		System.out.println(sbTimezones.toString());
		
		// Assert
		assertNotNull(timezoneList);
		assertTrue(timezoneList.size() > 0);
	}

}
