package com.skiamakhos.spring6webapp.bootstrap;

import com.skiamakhos.spring6webapp.domain.Author;
import com.skiamakhos.spring6webapp.domain.Book;
import com.skiamakhos.spring6webapp.domain.Publisher;
import com.skiamakhos.spring6webapp.repositories.AuthorRepository;
import com.skiamakhos.spring6webapp.repositories.BookRepository;
import com.skiamakhos.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development Without EJB");
        noEJB.setIsbn("891011");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book dddSaved = bookRepository.save(ddd);
        Book noEjbSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEjbSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher gollancz = new Publisher();
        gollancz.setPublisherName("Gollancz");
        gollancz.setAddress("Carmelite House, Victoria Embankment");
        gollancz.setState("England");
        gollancz.setZip("EC4Y 0DZ");
        Publisher gollanczSaved = publisherRepository.save(gollancz);

        System.out.println("In Bootstrap:");
        System.out.println("Author Count: "+authorRepository.count());
        System.out.println("Book Count: "+bookRepository.count());
        System.out.println("Publisher Count: "+publisherRepository.count());
    }
}
