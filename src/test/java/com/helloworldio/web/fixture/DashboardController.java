package com.helloworldio.web.fixture;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworldio.front.web.DashboardAction;
import com.helloworldio.front.web.domain.DashboardAlert;
import com.helloworldio.front.web.domain.DashboardMessage;
import com.helloworldio.front.web.domain.DashboardTask;



@Controller
public class DashboardController extends BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private DashboardAction dashboardAction; 
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String handleDashboardTilesRequest(Model model, Locale locale) {
		LOG.debug("Handling dashboard url");
		
		// get dashboard messages
//		List<DashboardMessage> messages = dashboardAction.getMessages();
//		model.addAttribute("messages", messages);
//		
//		// get dashboard task
//		List<DashboardTask> tasks = dashboardAction.getTasks();
//		model.addAttribute("tasks", tasks);
//		
//		// language support
//		manageLanguage(model, locale);
//		
//		// Alerts
//		List<DashboardAlert> alerts =  dashboardAction.getAlerts();
//		model.addAttribute("alerts", alerts);
		
		return "dashboard";
	}
}
