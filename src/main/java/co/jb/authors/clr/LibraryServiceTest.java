package co.jb.authors.clr;

import co.jb.authors.beans.Author;
import co.jb.authors.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class LibraryServiceTest implements CommandLineRunner {

    @Autowired
    private LibraryService libraryService;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("*********** ADD AUTHOR ***********");
        libraryService.addAuthor(Author.builder().name("Kobi").build());
        libraryService.getAllAuthors().forEach(System.out::println);
        System.out.println("*********** DELETE AUTHOR *********");
        libraryService.deleteAuthor(1);
        System.out.println("************ GET ALL AUTHORS **********");
        libraryService.getAllAuthors().forEach(System.out::println);
        System.out.println("**********  GET ONE AUTHOR ***********");
        System.out.println(libraryService.getSingleAuthor(2));
        System.out.println("********** GET AVG YEARS BOOK **********");
        System.out.println(libraryService.getAvgBooksYear());
        System.out.println("*********** GET AVG YEARS BOOKS BY AUTHOR ID **************");
        System.out.println(libraryService.getAvgBooksYearByAuthorId(2));
        System.out.println("********** GET BOOKS BY RANGE *********");
        libraryService.getBooksByYearRange(2000, 2022).forEach(System.out::println);

    }
}
