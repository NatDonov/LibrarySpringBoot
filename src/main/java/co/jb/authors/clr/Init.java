package co.jb.authors.clr;


import co.jb.authors.beans.Author;
import co.jb.authors.beans.Book;
import co.jb.authors.repos.AuthorRepository;
import co.jb.authors.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = Book.builder().name("Love to love").year(2000).build();
        Book b2 = Book.builder().name("Freedom").year(1980).build();
        Book b3 = Book.builder().name("Titanic").year(2002).build();
        Book b4 = Book.builder().name("Notebook").year(2022).build();

        Author a1 = Author.builder().name("Shaked").books(List.of(b1,b2)).build();
        Author a2 = Author.builder().name("Natali").books(List.of(b3,b4)).build();

        authorRepository.saveAll(List.of(a1,a2));

//
//        System.out.println(bookRepository.findByYearBetween(2000,2022));
//        System.out.println(bookRepository.findAvgBooksYear());
//        System.out.println(bookRepository.findAvgBooksYearByAuthorId(1));


    }
}
