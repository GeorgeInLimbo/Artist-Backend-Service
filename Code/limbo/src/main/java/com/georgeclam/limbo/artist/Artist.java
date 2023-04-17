package com.georgeclam.limbo.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public Artist(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
