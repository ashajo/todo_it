package se.lexicon.asha.data;

import se.lexicon.asha.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] personArray = {};

    public int size(){
        return personArray.length;
    }

    public static Person[] findAll() {
        return personArray;
    }

    public Person findById(int personId){
        for(int i = 0; i < size(); i++){
            if(personArray[i].getPersonId() == personId){
                return personArray[i];
            }
        }
        return null;
    }

    public Person addPerson(String firstName, String lastName){
        Person newPerson = new Person(PersonSequencer.nextPersonId(), firstName, lastName);
        personArray = Arrays.copyOf(personArray,size()+1);
        personArray[size()-1] = newPerson;
        return newPerson;
    }
    public void clear(){
        personArray = new Person [0];
        PersonSequencer.reset();
    }
}
