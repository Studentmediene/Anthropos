package com.springapp.mvc;

/**
 * Created by adrianh on 12.02.14.
 */

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String membership;
    private int id;

    Person(String firstName, String lastName, String email, String membership, int id) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId(id);
        setMembership(membership);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }

    public String getMembership() {
        return this.membership;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) { this.id = id; }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
