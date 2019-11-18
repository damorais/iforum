package br.edu.ifsp.lp2a4.iforum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifsp.lp2a4.iforum.entidades.Topico;
import br.edu.ifsp.lp2a4.iforum.entidades.TopicosRepository;

@Controller
public class TopicosController {
	
	private TopicosRepository repository;

	public TopicosController(TopicosRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("topicos")
	public ModelAndView list() {
		
		ModelAndView mv = new ModelAndView("topicos/list");
		
		Iterable<Topico> topico = repository.findAll();
		
		mv.addObject("topicos", topico);
		
		return mv;
	}

	@GetMapping("topicos/create")
	public ModelAndView create() {
		
		ModelAndView mv = new ModelAndView("topicos/create");
		
		return mv;
	}
	
	@PostMapping("topicos/create")
	public ModelAndView create(Topico topico, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect: /topicos");
		
		redirectAttributes.addFlashAttribute("sucesso", "Tópico criado");
		
		return mv;
	}
}
