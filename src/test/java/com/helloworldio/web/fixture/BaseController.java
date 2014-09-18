package com.helloworldio.web.fixture;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.helloworldio.common.LanguageUtils;
import com.helloworldio.front.web.domain.Language;

@Controller
public class BaseController {

    @Resource(name = "messageSource")
    private MessageSource messageSource;
    
    public MessageSource getMessageSource() {
    	return messageSource;
    }
    
    protected void manageLanguage(Model model, Locale locale) {
    	// get language supported
    	List<Language> languages =  getLanguages();
    	model.addAttribute("languages", languages);
    			
    	// current language
    	Language currentLang = LanguageUtils.getLanguageFromListByLocale(locale.toString(), languages, null);
    	model.addAttribute("lang", currentLang);
    }
    
    
    protected List<Language> getLanguages() {
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language("English", "en_GB", "flag flag-gb"));
		languages.add(new Language("Spanish", "es_ES", "flag flag-es"));
		languages.add(new Language("French", "fr_FR", "flag flag-fr"));
		return languages;
	}
}
