package br.edu.ifsp.lp2a4.iforum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;

@Controller
public class TopicosController {
	
	@GetMapping("topicos")
	public ModelAndView list(TopicosRepository repository) {
		
		ModelAndView mv = new ModelAndView("topicos/list");
		
		mv.addObject("topicos", repository.findAll());
		
		return mv;
	}

}
