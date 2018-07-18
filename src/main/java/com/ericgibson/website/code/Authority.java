package com.ericgibson.website.code;

import javax.persistence.*;

@Entity
@Table(schema = "eric_gibson", name = "Authorities")
class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String authority;

    void setId(Integer id) {
        this.id = id;
    }

    Integer getId() {
        return id;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getUsername() {
        return username;
    }

    void setAuthority(String authority) {
        this.authority = authority;
    }

    String getAuthority() {
        return authority;
    }
}