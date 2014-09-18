package com.helloworldio.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class TimezoneUtils {
	
	public enum TIMEZONE_PREFIX {
		AFRICA("Africa"), AMERICA("America"), ASIA("Asia"), ATLANTIC("Atlantic"), AUSTRALIA("Autralia"), EUROPE("Europe"), INDIAN("Indian"), PACIFIC("Pacific");
        private String value;
        
        private TIMEZONE_PREFIX(String value) {
            this.value = value;
        }
        
        public String value() {
        	return this.value;
        }
        
        public String pattern() {
        	return "^(" + value + ")/.*";
        }
    }
	
	private static final String TIMEZONE_PREFIXES_PATTERN =
			"^("
			+ TIMEZONE_PREFIX.AFRICA.value() + "|"
			+ TIMEZONE_PREFIX.AMERICA.value() + "|"
			+ TIMEZONE_PREFIX.ASIA.value() + "|"
			+ TIMEZONE_PREFIX.ATLANTIC.value() + "|"
			+ TIMEZONE_PREFIX.AUSTRALIA.value() + "|"
			+ TIMEZONE_PREFIX.EUROPE.value() + "|"
			+ TIMEZONE_PREFIX.INDIAN.value() + "|"
			+ TIMEZONE_PREFIX.PACIFIC.value()
			+ ")/.*";
	
	private static String[] timezonePrefixs;
	private static List<TimeZone> timezones;
	
	static {
		timezonePrefixs = new String[TIMEZONE_PREFIX.values().length];
		TIMEZONE_PREFIX[] timezonePrefixArray = TIMEZONE_PREFIX.values();
		for (int i = 0; i < timezonePrefixArray.length; i++) {
			timezonePrefixs[i] = timezonePrefixArray[i].value();
		}
		
		timezones = new ArrayList<TimeZone>();
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		for (String id : timeZoneIds) {
			if (id.matches(TIMEZONE_PREFIXES_PATTERN)) {
				timezones.add(TimeZone.getTimeZone(id));
			}
		}
		Collections.sort(timezones, new Comparator<TimeZone>() {
			public int compare(final TimeZone a, final TimeZone b) {
				return a.getID().compareTo(b.getID());
			}
		});
	}
	
	public static List<String> getTimezonePrefixs() {
		return Arrays.asList(timezonePrefixs);
	}
	
	public static List<TimeZone> getTimezone(TIMEZONE_PREFIX prefix) {
		List<TimeZone> timezoneLst = new ArrayList<TimeZone>();
		Iterator<TimeZone> iterTimezone = timezones.iterator();
		while(iterTimezone.hasNext()) {
			TimeZone timezone = iterTimezone.next();
			if (timezone.getID().matches(prefix.pattern())) {
				timezoneLst.add(timezone);
			}
		}
		return timezoneLst;
	}

}
