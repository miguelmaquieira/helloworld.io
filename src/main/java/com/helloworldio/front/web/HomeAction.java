package com.helloworldio.front.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.helloworldio.front.web.domain.HomeCarousel;

@Component("homeAction")
public class HomeAction extends BaseAction {
	
	
	@Override
	public String validateFlowInitActions() {
		RequestContext requestContext = RequestContextHolder.getRequestContext();
		String flowActionCase = requestContext.getExternalContext().getSessionMap().getString("flowToken");
		if (flowActionCase != null) {
			requestContext.getExternalContext().getSessionMap().remove("flowToken");
		}
		return flowActionCase;
	}
	
	public List<HomeCarousel> getCarouselData() {
		// get locale
		Locale locale = LocaleContextHolder.getLocale();
		
		List<HomeCarousel> carousel = new ArrayList<HomeCarousel>();
		String image1 = getMessageSource().getMessage("home.carouselItemImage1", null, locale);
		String caption1 = getMessageSource().getMessage("home.carouselItemCaption1", null, locale);
		carousel.add(new HomeCarousel(0, true, image1, caption1));
		String image2 = getMessageSource().getMessage("home.carouselItemImage2", null, locale);
		String caption2 = getMessageSource().getMessage("home.carouselItemCaption2", null, locale);
		carousel.add(new HomeCarousel(1, false, image2, caption2));
		String image3 = getMessageSource().getMessage("home.carouselItemImage3", null, locale);
		String caption3 = getMessageSource().getMessage("home.carouselItemCaption3", null, locale);
		carousel.add(new HomeCarousel(2, false, image3, caption3));
		String image4 = getMessageSource().getMessage("home.carouselItemImage4", null, locale);
		String caption4 = getMessageSource().getMessage("home.carouselItemCaption4", null, locale);
		carousel.add(new HomeCarousel(3, false, image4, caption4));
		String image5 = getMessageSource().getMessage("home.carouselItemImage5", null, locale);
		String caption5 = getMessageSource().getMessage("home.carouselItemCaption5", null, locale);
		carousel.add(new HomeCarousel(4, false, image5, caption5));
		String image6 = getMessageSource().getMessage("home.carouselItemImage6", null, locale);
		String caption6 = getMessageSource().getMessage("home.carouselItemCaption6", null, locale);
		carousel.add(new HomeCarousel(5, false, image6, caption6));
		return carousel;
	}

	
}
