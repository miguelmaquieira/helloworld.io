package com.helloworldio.front.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.webflow.execution.RequestContext;

import com.helloworldio.common.LanguageUtils;
import com.helloworldio.front.web.domain.Language;


public abstract class BaseAction {

    @Resource(name = "messageSource")
    private MessageSource messageSource;
    
    public MessageSource getMessageSource() {
    	return messageSource;
    }
    
    public String validateFlowInitActions() {
    	return null;
    }
    
    public void onEntry(RequestContext requestContext) {
    	 
		// get locale
		Locale locale = LocaleContextHolder.getLocale();
		
		// Manage language
		manageLanguage(requestContext, locale);
	}
    
    public void manageLanguage(RequestContext context, Locale locale) {
    	// get language supported
    	List<Language> languages =  getLanguages();
    	context.getFlowScope().put("languages", languages);
    			
    	// current language
    	Language currentLang = LanguageUtils.getLanguageFromListByLocale(locale.toString(), languages, null);
    	context.getFlowScope().put("lang", currentLang);
    }
    
    protected List<Language> getLanguages() {
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language("English", "en_GB", "flag flag-gb"));
		languages.add(new Language("Spanish", "es_ES", "flag flag-es"));
		languages.add(new Language("French", "fr_FR", "flag flag-fr"));
		return languages;
	}
}
