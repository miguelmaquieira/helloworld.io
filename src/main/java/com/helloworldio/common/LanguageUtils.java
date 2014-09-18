package com.helloworldio.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;

import com.helloworldio.front.web.domain.Language;

public class LanguageUtils {
	
	public static Language getLanguageFromListByLocale(String locale, List<Language> languages, String defaultLocale) {
		Language language =  getLanguageByLocale(locale, languages);
		if (language == null && defaultLocale != null) {
			language = getLanguageByLocale(defaultLocale, languages);
		}
		return language;
	}
	
	private static Language getLanguageByLocale(String locale, List<Language> languages) {
		Language language =  null;
		for (Language lang: languages) {
			String langLocale = lang.getLocale();
			if (langLocale.equals(locale)) {
				language = lang;
				break;
			}
		}
		return language;
	}
	
	@SuppressWarnings("unchecked")
	public static Locale[] getLocaleArray(Locale locale) {
		List<Locale> localeList = new ArrayList<Locale>();
		
		if (locale.getLanguage() != null) {
			localeList.add(new Locale(locale.getLanguage()));
		}
		if (locale.getCountry() != null) {
			localeList.addAll(LocaleUtils.languagesByCountry(locale.getCountry()));
		}
		
		return localeList.toArray(new Locale[localeList.size()]);
	}
}
