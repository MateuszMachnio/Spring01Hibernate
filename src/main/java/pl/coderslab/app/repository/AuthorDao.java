package pl.coderslab.app.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

//    public Author findByIdWithBooks(long id) {
//        Author author = findById(id);
//        Hibernate.initialize(author.getBooks());
//        return author;
//    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }


    public List<Author> getAll() {
        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }
}
