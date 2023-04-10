package com.georgeclam.limbo.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
// @Table(name = "artist") optional given the class name matches the table name in the db
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the primary key should be generated automatically.
    private Long id;

    @Column(length = 70, nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank  // Must activate the validations in the controller for it to work (@Valid)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // Makes sure that password isn't exposed
    private String password;

    @Column(nullable = false)
    @NotBlank
    @Email // Performs email validation automatically
    private String email;

    public Artist() {
    }

    public Artist(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
