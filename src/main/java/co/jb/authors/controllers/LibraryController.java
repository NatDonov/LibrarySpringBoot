package co.jb.authors.controllers;

import co.jb.authors.beans.Author;
import co.jb.authors.beans.Book;
import co.jb.authors.exceptions.LibraryCustomException;
import co.jb.authors.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author){
        libraryService.addAuthor(author);
    };


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws LibraryCustomException{
        libraryService.deleteAuthor(id);
    };


    @GetMapping("authors")
    public List<Author> getAllAuthors(){
        return libraryService.getAllAuthors();
    };


    @GetMapping("authors/{id}")
    public Author getSingleAuthor(@PathVariable int id) throws LibraryCustomException{
        return libraryService.getSingleAuthor(id);
    };


    @GetMapping("books/year/btw")
    public List<Book> getBooksByYearRange(@RequestParam int start, @RequestParam int end) throws LibraryCustomException{
        return libraryService.getBooksByYearRange(start, end);
    };


    @GetMapping("books/year/avg")
    public double getAvgBooksYear(){
        return libraryService.getAvgBooksYear();
    };


    @GetMapping("books/avg/{id}")
    public double getAvgBooksYearByAuthorId(@PathVariable int id) throws LibraryCustomException{
        return libraryService.getAvgBooksYearByAuthorId(id);
    };

    @PutMapping("authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@PathVariable int id, @RequestBody Author author){
        libraryService.updateAuthor(id, author);
    }


}
