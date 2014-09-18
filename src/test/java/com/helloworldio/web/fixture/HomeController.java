package com.helloworldio.web.fixture;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworldio.front.web.domain.HomeCarousel;



@Controller
public class HomeController extends BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String handleHomeAndRootRequest(Model model, Locale locale) {
		LOG.debug("Handling home url");
		
//		// language support
//		manageLanguage(model, locale);
//		
//		// Add carousel data
//		List<HomeCarousel> carousel =  getCarouselData(locale);
//    	model.addAttribute("carousel", carousel);
		
		return "/home";
	}
	
	
	private List<HomeCarousel> getCarouselData(Locale locale) {
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
