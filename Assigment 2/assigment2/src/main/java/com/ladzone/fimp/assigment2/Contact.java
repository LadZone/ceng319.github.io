package com.ladzone.fimp.assigment2;

/**
 * Created by Alay on 10/30/2016.
 */
public class Contact {
    private  String _firstName, _lastName, _department;

    public Contact (String firstName, String lastName ){

        _firstName = firstName;
        _lastName = lastName;


    }

    public String getFirstName(){
        return _firstName;
    }

    public String getLastName(){
        return _lastName;
    }

}
