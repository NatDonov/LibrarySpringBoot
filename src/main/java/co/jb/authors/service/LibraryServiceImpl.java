package co.jb.authors.service;


import co.jb.authors.beans.Author;
import co.jb.authors.beans.Book;
import co.jb.authors.exceptions.LibraryCustomException;
import co.jb.authors.repos.AuthorRepository;
import co.jb.authors.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) throws LibraryCustomException {
        if(!authorRepository.existsById(id)){
            throw new LibraryCustomException("Author not exists");
        }
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getSingleAuthor(int id) throws LibraryCustomException {
        return authorRepository.findById(id).orElseThrow(()-> new LibraryCustomException("Author not exists"));
    }

    @Override
    public List<Book> getBooksByYearRange(int start, int end) throws LibraryCustomException {
        if(start>end){
            throw new LibraryCustomException("Invalid value, start year bigger end year");
        }
        return bookRepository.findByYearBetween(start, end);
    }

    @Override
    public double getAvgBooksYear() {
        return bookRepository.findAvgBooksYear();
    }

    @Override
    public double getAvgBooksYearByAuthorId(int id) throws LibraryCustomException {
        if(!authorRepository.existsById(id)){
            throw new LibraryCustomException("Author not exists");
        }
        return bookRepository.findAvgBooksYearByAuthorId(id);
    }

    @Override
    public void updateAuthor(int id, Author author) {
        authorRepository.saveAndFlush(author);
    }

}
