package com.caospierre.ejemplo.dto;

import javax.validation.constraints.NotBlank;

public class LoginPerson {
    @NotBlank
    private String username;
    @NotBlank
    private String token;
    private boolean signed;

    public LoginPerson(@NotBlank String username, @NotBlank String token, boolean signed) {
        this.username = username;
        this.token = token;
        this.signed = signed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
