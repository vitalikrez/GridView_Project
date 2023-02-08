package com.example.myapplicationgridviewproject;

import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable {
    UUID id;
    String name;
    String dateOfName;
    String description;

    Person( String name, String dateOfName, String description)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.dateOfName = dateOfName;
        this.description = description;
    }

    public String getName() {
        return name;
    }
}
