package com.helloworldio.front.web;

import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

@Component("languageAction")
public class GlobalLanguageAction extends BaseAction {

	public void updateLocale(RequestContext context) {
		onEntry(context);
	}
}
