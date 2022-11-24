package se.lexicon.model.dao;

import se.lexicon.model.Person;

import java.util.Optional;

public interface PersonDao extends BaseDao<Person> {
    Optional<Person>findByUserName(String userName);
}
