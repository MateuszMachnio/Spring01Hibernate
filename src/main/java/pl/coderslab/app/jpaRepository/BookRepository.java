package pl.coderslab.app.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Category;
import pl.coderslab.app.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long id);

    List<Book> findByAuthorsContains(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(int rating);

    Book findFirstByCategoryOrderByTitleAsc(Category category);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findBooksByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> findBooksByCategory(@Param("category") Category category);

    @Query("SELECT b FROM Book b WHERE b.rating between ?1 and ?2")
    List<Book> findBooksByRatingBetween(int start, int end);

    @Query("SELECT b FROM Book b WHERE b.publisher = ?1")
    List<Book> findBooksByPublisher(Publisher publisher);

    @Query(value = "SELECT * FROM books WHERE category_id = ?1 ORDER BY title LIMIT 1", nativeQuery = true)
    Book findFirstBookByCategoryIdOrderByTitle(long id);

}
