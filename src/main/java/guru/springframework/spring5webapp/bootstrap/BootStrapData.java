package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.repositories.*;
import guru.springframework.spring5webapp.model.*;

@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
	{
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Started in Bootstrap");
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St. Petersburg");
		publisher.setState("FL");
		
		publisherRepository.save(publisher);
		
		System.out.println("Publisher count: " + publisherRepository.count());
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development Without EJB", "3939459459");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
//		Publisher addisonWesley = new Publisher("Addison-Wesley","501 Boylston St","Boston","MA","02116");
//		publisherRepository.save(addisonWesley);
//		Publisher wiley = new Publisher("Wiley","111 River Street Hoboken","Hoboken","NJ","07030");
//		publisherRepository.save(wiley);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Authors: " + authorRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
		
		System.out.println("Publisher number of books " + publisher.getBooks().size());
	}

}
