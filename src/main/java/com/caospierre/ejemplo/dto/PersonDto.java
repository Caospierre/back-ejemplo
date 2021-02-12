package com.caospierre.ejemplo.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDto {

    @NotBlank
    private String name;

    @NotBlank
    private String dni;

    @NotBlank
    private String age;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String city;

    public PersonDto(@NotBlank String name, @NotBlank String dni, @NotBlank String age, @NotBlank String username, @NotBlank String password, String city) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.username = username;
        this.password = password;
        this.city = city;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
