package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook  {
    private String name;
    private String phoneNumber;
    private String[] phoneNumbers;
    //giving field of a map for getter method for constructor test
    private Map<String, List<String>> phoneBook;


    //making the map in parameter the named map in field
    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map;
    }
    //changing to LinkedHashMap for sorting issue to happen latter
    public PhoneBook() {
        this.phoneBook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> actualPhoneNumbers = new ArrayList();
        actualPhoneNumbers.add(phoneNumber);
        this.phoneBook.put(name, actualPhoneNumbers);
    }
         
    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> actualPhoneNumbers = new ArrayList();
        for(String num : phoneNumbers){
            actualPhoneNumbers.add(num);
        }
        this.phoneBook.put(name, actualPhoneNumbers);
    }

    public void remove(String name) {
       this.phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
           if(phoneBook.containsKey(name) || phoneBook.containsValue(phoneNumber)){
               return true;
           }
         return false;
    }
     //Needed for addAll test BE SURE TO LOOK AT TEST CAREFULLY
    public List<String> lookup(String name) {
        return this.phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String,List<String>> entry : phoneBook.entrySet()){
            if(entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> contactNames = new ArrayList<String>(phoneBook.keySet());
        
        return contactNames;
    }

    public Map<String, List<String>> getPhoneBook() {

        return phoneBook;
    }
}
