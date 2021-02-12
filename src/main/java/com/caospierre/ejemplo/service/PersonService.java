package com.caospierre.ejemplo.service;
import com.caospierre.ejemplo.exceptions.EtAuthException;
import com.caospierre.ejemplo.model.Person;
import com.caospierre.ejemplo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personaRepository;

    public Person create (Person person) {
        return personaRepository.save(person);
    }





    public List<Person> getAllPersonas (){
        return personaRepository.findAll();
    }

    public void delete (Person persona) {
        personaRepository.delete(persona);
    }

    public Optional<Person> findById (Long id) {
        return personaRepository.findById(id);
    }
    public Person validateUser(String username, String password) throws EtAuthException {
        return personaRepository.findByUsernameAndPassword(username, password);
    }

}