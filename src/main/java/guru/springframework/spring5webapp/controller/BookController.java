package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController
{
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(value = "/books", method=RequestMethod.GET)
	public String getBooks(Model model)
	{
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}
}
