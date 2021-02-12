package com.caospierre.ejemplo.controller;
import java.net.URI;
import java.util.*;


import com.caospierre.ejemplo.dto.LoginPerson;
import com.caospierre.ejemplo.exceptions.EtAuthException;
import com.caospierre.ejemplo.model.Person;
import com.caospierre.ejemplo.service.PersonService;
import com.caospierre.ejemplo.utils.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//Controller 
@RestController
@RequestMapping ("/api/person")
public class PersonController {

    @Autowired
    private PersonService personaService;

    @CrossOrigin
    @PostMapping("/create")

    private ResponseEntity<Person> save (@RequestBody Person person){

        Person temporal = personaService.create(person);
        try {

            return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/list-all")
    private ResponseEntity<List<Person>> listPerson (){
        return ResponseEntity.ok(personaService.getAllPersonas());
    }

    @DeleteMapping("delete")
    private ResponseEntity<Void> deletePerson (@RequestBody Person person){
        personaService.delete(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Person>> listPersonById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(personaService.findById(id));
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoginPerson> loginUser(@RequestBody Person person) {
        String username = (String) person.getUsername();
        String password = (String) person.getPassword();
        Person user = personaService.validateUser(username, password);
        return new ResponseEntity<>(new LoginPerson(user.getUsername(),generateJWTToken(user),true), HttpStatus.OK);
    }



    private String generateJWTToken(Person user) throws EtAuthException {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("name", user.getName())
                .claim("password", user.getPassword())
                .compact();

        return token;
    }


}