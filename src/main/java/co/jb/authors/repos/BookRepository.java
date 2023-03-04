package co.jb.authors.repos;

import co.jb.authors.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByYearBetween(int start, int end);

    @Query(value = "select avg (book_year) from books", nativeQuery = true)
    double findAvgBooksYear();

    @Query(value = "select avg (book_year) from books join authors_books on books.id = authors_books.books_id where author_id=? ", nativeQuery = true)
    double findAvgBooksYearByAuthorId(int id);


}
