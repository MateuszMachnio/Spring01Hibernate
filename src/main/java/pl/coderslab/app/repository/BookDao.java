package pl.coderslab.app.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public Book findByIdWithAuthors(long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }
    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
//        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating", Book.class);
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getBooksWhichHavePublisher() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher", Book.class);
        return query.getResultList();
    }

    public List<Book> getBooksWithPublisher(Publisher publisher) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher", Book.class);
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBooksWithAuthor(Author author) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE :author member of b.authors", Book.class);
        return query.getResultList();
    }

}
