package com.caospierre.ejemplo.repository;
import com.caospierre.ejemplo.exceptions.EtAuthException;
import com.caospierre.ejemplo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>{
    Optional<Person> findByUsername(String username);
    boolean existsByUsername(String username);
    Person findByUsernameAndPassword(String username, String password) throws EtAuthException;

}