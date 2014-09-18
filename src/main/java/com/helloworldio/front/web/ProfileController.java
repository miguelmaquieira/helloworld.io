package com.helloworldio.front.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helloworldio.common.support.ReloadableAdvancedResourceBundleMessageSource;
import com.helloworldio.front.model.service.UserManager;

@RestController
public class ProfileController {

	private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

	Logger log = LoggerFactory.getLogger("HelloWorld.io");

	@Autowired
	private ReloadableAdvancedResourceBundleMessageSource messageResource;

	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = { "/profile/update/picture/crop" }, method = RequestMethod.POST)
	public void handleUpdatePictureCropRequest(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
	}
	
	@RequestMapping(value = { "/profile/update/picture/upload" }, method = RequestMethod.POST)
	public String handleUpdatePictureUploadRequest() {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		jsonArrayBuilder.add(Json.createObjectBuilder().add("status", "success")
														.add("url", "/img/migue.png")
														.add("width", 200)
														.add("height", 200));
		return jsonArrayBuilder.build().toString();
	}
	
	@RequestMapping(value = { "/profile/update/" }, method = RequestMethod.POST)
	public void handleUpdateFormRequest(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
	}
	

	@RequestMapping(value = { "/profile/update" }, method = RequestMethod.POST)
	public void handleUpdateFormDataRequest(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String varName = request.getParameter("name");
		String varValue = request.getParameter("value");
		Object value = null;
		if (varName != null && varName.length() > 0) {
			if (isDateVar(varName)) {
				try {
					value = DATE_FORMATTER.parse(varValue);
					userManager.updateProfileUserProperty(username, varName, value);
				} catch (ParseException pe) {
					log.warn(
							"Exception updating user profile, userId: {0}, varName: {1}, varValue: {2}\nException:",
							username,
							varName,
							value,
							pe);
				}
			} else {
				userManager.updateProfileUserProperty(username, varName, varValue);
			}
		} else {
			log.warn("The user profile, userId: {0}, have not been updated", username);
		}
	}

	@RequestMapping(value = { "/profile/data/gender*" }, headers = "Accept=application/json", method = RequestMethod.POST)
	public String getGenderData() {
		// get locale
		Locale locale = LocaleContextHolder.getLocale();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		Iterator<String> iterKeys = messageResource.getKeys("gender", locale);
		if (iterKeys != null) {
			while (iterKeys.hasNext()) {
				String key = iterKeys.next();
				String value = messageResource.getMessage(key, null, locale);
				jsonArrayBuilder.add(Json.createObjectBuilder().add("id", key).add("value", value));
			}
		}
		return jsonArrayBuilder.build().toString();
	}

	private boolean isDateVar(String varName) {
		boolean dateVar = false;
		if (varName.equals("birthdate")) {
			dateVar = true;
		}
		return dateVar;
	}
}
