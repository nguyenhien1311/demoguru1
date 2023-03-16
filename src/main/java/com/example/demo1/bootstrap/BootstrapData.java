package com.example.demo1.bootstrap;

import com.example.demo1.domain.Author;
import com.example.demo1.domain.Book;
import com.example.demo1.domain.Publisher;
import com.example.demo1.repositories.AuthorRepository;
import com.example.demo1.repositories.BookRepository;
import com.example.demo1.repositories.PublisherRepository;
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
        Author lili = new Author();
        lili.setFirstName("Lili");
        lili.setLastName("Lala");

        Book wonder = new Book();
        wonder.setTitle("Lili wonder book");
        wonder.setIsbn("1234asdf");

        Author lili1 = authorRepository.save(lili);
        Book wonder1 = bookRepository.save(wonder);

        Author lolo = new Author();
        lolo.setFirstName("Lolo");
        lolo.setLastName("Lala");

        Book danger = new Book();
        danger.setTitle("Lolo danger book");
        danger.setIsbn("1234asdf");

        Author lolo1 = authorRepository.save(lolo);
        Book danger1 = bookRepository.save(danger);

        lili1.getBooks().add(wonder1);
        lolo1.getBooks().add(danger1);
        wonder1.getAuthors().add(lili1);
        danger1.getAuthors().add(lolo1);

        authorRepository.save(lili1);
        authorRepository.save(lolo1);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Hanoi publisher");
        publisher1.setCity("Ha Noi");
        publisher1.setAddress("Middle of Hoan Kiem Lake");
        publisher1.setState("Hoan Kiem");
        publisher1.setZipCode("100000");

        Publisher publisher = publisherRepository.save(publisher1);

        wonder1.setPublisher(publisher);
        danger1.setPublisher(publisher);

        bookRepository.save(wonder1);
        bookRepository.save(danger1);

        System.out.println("In bootstrap");
        System.out.println("Author count : " + authorRepository.count());
        System.out.println("Book count : " + bookRepository.count());
        System.out.println("Publisher count : " + publisherRepository.count());

    }
}
