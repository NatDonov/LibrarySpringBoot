package co.jb.authors.service;

import co.jb.authors.beans.Author;
import co.jb.authors.beans.Book;
import co.jb.authors.exceptions.LibraryCustomException;

import java.util.List;


public interface LibraryService {

    void addAuthor(Author author);
    void deleteAuthor(int id) throws LibraryCustomException;
    List<Author> getAllAuthors();
    Author getSingleAuthor(int id) throws LibraryCustomException;
    List<Book> getBooksByYearRange(int start, int end) throws LibraryCustomException;
    double getAvgBooksYear();
    double getAvgBooksYearByAuthorId(int id) throws LibraryCustomException;


    void updateAuthor(int id, Author author);


}


