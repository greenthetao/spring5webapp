package guru.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController 
{
	@Autowired
	AuthorRepository authorRepository;
	
	@RequestMapping(value = "/authors", method=RequestMethod.GET)
	public String getAuthors(Model model) 
	{
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}
}
