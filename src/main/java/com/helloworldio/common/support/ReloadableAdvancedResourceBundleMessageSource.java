package com.helloworldio.common.support;

import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class ReloadableAdvancedResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {
	
	public Iterator<String> getKeys(String prefix, Locale locale) {
		PropertiesHolder prop = getMergedProperties(locale);
		if (prop == null) {
			resolveCodeWithoutArguments(prefix, locale);
			prop = getMergedProperties(locale);
		}
		if (prop != null) {
			Properties properties = prop.getProperties(); 
			return properties.stringPropertyNames().iterator();
		}
		return null;
		
	}

}
