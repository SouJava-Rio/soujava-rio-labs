package br.org.soujava.persistence;

import org.jnosql.artemis.Repository;

import br.org.soujava.model.Person;

import java.util.List;

public interface PersonRepository extends Repository<Person, String> {

    List<Person> findAll();
}
