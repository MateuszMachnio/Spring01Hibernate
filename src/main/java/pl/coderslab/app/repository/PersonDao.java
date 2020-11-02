package pl.coderslab.app.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;


    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }


    public List<Person> getAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }
}
