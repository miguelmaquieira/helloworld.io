package com.helloworldio.common.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.helloworldio.common.LanguageUtils;


public class AdvancedResourceBundleMessageSource extends ResourceBundleMessageSource {
	
	private List<String> baseNameSet;
	
	public ResourceBundle getBundle(String basename, Locale locale) {
		ResourceBundle bundle = null;
		String basenamePath = getConfigBasename(basename);
		if (basenamePath != null) {
			basename = basenamePath;
		}
		Locale[] localeArray = LanguageUtils.getLocaleArray(locale);
		for (Locale localeTmp: localeArray) {
			bundle = getResourceBundle(basename, localeTmp);
			if (bundle != null) {
				break;
			}
		}
        return bundle;
    }
	
	public void setBasenames(String... basenames) {
		super.setBasenames(basenames);
		baseNameSet = new ArrayList<String>();
		for (String basename: basenames) {
			if (basename.contains(":")) {
				basename = basename.substring(basename.indexOf(":") + 1, basename.length());
			}
			baseNameSet.add(basename);
		}
	}
	
	protected String getConfigBasename(String basename) {
		Iterator<String> basenamesIter = baseNameSet.iterator();
		String basenamePath = null;
		while (basenamesIter.hasNext()) {
			String basenameValue = basenamesIter.next();
			if (basenameValue.contains(basename)) {
				basenamePath = basenameValue;
				break;
			}
		}
		return basenamePath;
	}
}
