package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private Date birthday;
    private ArrayList<MovieList> userLists;

    public User(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(){
        userLists = new ArrayList<>();
    }

    public void AddToList(MovieList newlist){
        if (!userLists.contains(newlist)){
            userLists.add(newlist);
        }
    }

    public void RemoveFromList(MovieList removeList){
        if (!userLists.contains(removeList)){
            userLists.remove(removeList);
        }
    }




}
