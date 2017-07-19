package com.onetechone.model;

import javax.persistence.*;

/**
 * Created by rasoul on 7/18/2017.
 */
@Entity
@Table(name = "mytable")
@Access(value = AccessType.FIELD)
public class User {

    @Column(name = "id")
    @Id
    public int Id;

    public User(int id, String name) {
        Id = id;
        Name = name;
    }

    public User() {
    }

    @Column(name = "name")
    public String Name;

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
