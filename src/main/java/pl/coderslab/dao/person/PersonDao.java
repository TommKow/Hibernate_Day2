package pl.coderslab.dao.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;
    public void savePerson(Person entity) {
        entityManager.persist(entity);
    }
    public void editPerson(Person entity) {
        entityManager.merge(entity);
    }
    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }
    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity)?entity : entityManager.merge(entity));
    }
}
