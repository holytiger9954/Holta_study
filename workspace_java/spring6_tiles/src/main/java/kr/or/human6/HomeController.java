package kr.or.human6;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "common/header";
	}
	
	@GetMapping("/class3")
	public String class3() {
		return "class3";
	}
	
	@GetMapping("/necro")
	public String necro() {
//		return "necro";
		return "네크로멘서.tiles";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
