package com.helloworldio.front.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.helloworldio.front.web.domain.DashboardAlert;
import com.helloworldio.front.web.domain.DashboardMessage;
import com.helloworldio.front.web.domain.DashboardTask;

@Component("dashboardAction")
public class DashboardAction extends BaseAction {
	
	public List<DashboardMessage> getMessages() {
		List<DashboardMessage> messages = new ArrayList<DashboardMessage>();
		messages.add(new DashboardMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...", 
											"John Smith", 
											"Yesterday"));
		messages.add(new DashboardMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...", 
											"John Smith", 
											"Yesterday"));
		messages.add(new DashboardMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...", 
											"John Smith", 
											"Yesterday"));
		messages.add(new DashboardMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...", 
											"Miguelito", 
											"08/08/2014"));
		return messages;
	}
	
	public List<DashboardTask> getTasks() {
		List<DashboardTask> tasks = new ArrayList<DashboardTask>();
		tasks.add(new DashboardTask("Task 1", 40, "success"));
		tasks.add(new DashboardTask("Task 2", 20, "info"));
		tasks.add(new DashboardTask("Task 3", 60, "warning"));
		tasks.add(new DashboardTask("Task 4", 80, "danger"));
		return tasks;
	}
	
	public List<DashboardAlert> getAlerts() {
		// Locale
		Locale locale = LocaleContextHolder.getLocale();
		
		List<DashboardAlert> alerts = new ArrayList<DashboardAlert>();
		Date now = new Date();
		PrettyTime pretty = new PrettyTime(now, locale);
		String alertMessage1 = pretty.format(new Date(now.getTime()	 - 25 * 60 * 60 * 1000));
		alerts.add(new DashboardAlert("New Comment", alertMessage1, "fa fa-comment fa-fw"));
		String alertMessage2 = pretty.format(new Date(now.getTime()	 - 35 * 60 * 60 * 1000));
		alerts.add(new DashboardAlert("3 New Followers", alertMessage2, "fa fa-twitter fa-fw"));
		String alertMessage3 = pretty.format(new Date(now.getTime()	 - 15 * 60 * 60 * 1000));
		alerts.add(new DashboardAlert("Message Sent", alertMessage3, "fa fa-envelope fa-fw"));
		String alertMessage4 = pretty.format(new Date(now.getTime()	 - 5 * 60 * 60 * 1000));
		alerts.add(new DashboardAlert("New Task", alertMessage4, "fa fa-tasks fa-fw"));
		return alerts;
	}
}
