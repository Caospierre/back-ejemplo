package com.caospierre.ejemplo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "dni")
    private String dni;

    @NotNull
    @Column(name = "age")
    private int age;



    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    public Person() {

    }

    public Person( @NotNull String name, @NotNull String dni, @NotNull int age, @NotNull String username, @NotNull String password, String city) {

        this.name = name;
        this.dni = dni;
        this.age = age;
        this.username = username;
        this.password = password;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}