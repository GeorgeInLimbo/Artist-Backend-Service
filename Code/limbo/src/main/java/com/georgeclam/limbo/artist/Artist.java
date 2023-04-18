package com.georgeclam.limbo.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/****************************************************************************
 * <b>Title</b>: Artist.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Artist Model, which sets the parameters for the Artist table in the database.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank  // Must activate the validations in the controller for it to work (@Valid)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // Makes sure that password isn't exposed
    private String password;

    @NotBlank
    @Email
    private String email;

    /**
     * Constructor that doesn't set the value for the id attribute because it is automatically generated.
     *
     * @param name
     * @param password
     * @param email
     */
    public Artist(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
