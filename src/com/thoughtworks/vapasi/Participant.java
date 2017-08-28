package com.thoughtworks.vapasi;

public class Participant {
    String firstName;
    String lastName;
    Address address;
    Session session;

    public String getFullName()
    {
        return firstName + " " + lastName;
    }


}
