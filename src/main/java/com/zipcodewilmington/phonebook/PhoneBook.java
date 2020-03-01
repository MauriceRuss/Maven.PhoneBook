package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook  {

    //giving field of a map for getter method for constructor test
    //final for immutability
    private final Map<String, List<String>> phoneBook;

    //making the map in parameter the named map in field
    //passed reference of map Copy constructor cloned original map
    //added private method for null point exception in constuctor
    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = new LinkedHashMap<>((map));
    }

//    private Map<String, List<String>> validateMap(Map<String, List<String>> map) {
//        for (Map.Entry<String,List<String>> numbers : phoneBook.entrySet()) {
//            map.put(numbers.getKey(),numbers.getValue()==null? new ArrayList<>() : numbers.getValue());
//        }
//        return map;
//    }

    //changing to LinkedHashMap for sorting issue to happen latter
    public PhoneBook() {
        this.phoneBook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers;
        if (phoneBook.containsKey(name)) {
            phoneNumbers = phoneBook.get(name);
        }
        else {
            phoneNumbers = new ArrayList<String>();
            phoneBook.put(name,phoneNumbers);
        }
        phoneNumbers.add(phoneNumber);
    }
         
    public void addAll(String name, String... phoneNumbers) {
        this.phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
       this.phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {

        if(this.phoneBook.containsKey(name)) {
            return true;
        }
        else {
            for (Map.Entry<String,List<String>> numbers : phoneBook.entrySet()) {
                if (numbers.getValue().contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }
     //Needed for addAll test BE SURE TO LOOK AT TEST CAREFULLY
    public List<String> lookup(String name) {
        return this.phoneBook.get(name);
    }
     //For each loop iterator Map.Entry
    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String,List<String>> entry : phoneBook.entrySet()){
            if(entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
         return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<String>(phoneBook.keySet());
    }

    public Map<String, List<String>> getPhoneBook() {
        return phoneBook;
    }
}
