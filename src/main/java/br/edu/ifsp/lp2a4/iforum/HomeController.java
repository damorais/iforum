package br.edu.ifsp.lp2a4.iforum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/teste")
	public String index() {
		return "home/index";
	}

}
