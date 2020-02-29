package com.zipcodewilmington.phonebook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook  {
    private String name;
    private String phoneNumber;
    private String phoneNumbers;
    private Map phoneBook = new HashMap();



    public PhoneBook(Map<String, List<String>> map) {
        Map phoneBook = this.phoneBook;
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        phoneBook.put(this.name,this.phoneNumber);

    }

    public void addAll(String name, String... phoneNumbers) {
        phoneBook.put(this.name, this.phoneNumbers);
    }

    public void remove(String name) {
    }

    public Boolean hasEntry(String name) {
        return null;
    }

    public List<String> lookup(String name) {
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {

        return phoneBook;
    }
}
