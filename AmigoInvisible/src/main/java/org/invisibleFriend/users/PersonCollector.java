package org.invisibleFriend.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PersonCollector {

    private List<Person> people;

    public PersonCollector(List<Person> people) {
        this.people = people;
    }

    public PersonCollector() {
        people = new ArrayList<>();
    }

    public PersonCollector addPerson(Person person) {
        people.add(person);
        return this;
    }

    public void removePerson(Person person) {
        people.remove(person);
    }

    public Person getPerson(Person person) {
        Person finalPerson = new Person();
        for(Person p : people) {
            if(p.getPersonName().equals(person.getPersonName())) {
                finalPerson = p;
            }
        }
        return finalPerson;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Su lista de personas (usuarios/administradores) es: \n");
        for(Person p : this.people) {
            sb.append(p.toString()).append("\n");
        }

        return sb.toString();
    }

    public List<Person> getPersonCollector() {
        return people;
    }

    //Metodo para asignar a cada usuario su proximo regalo.
    public void assignNextGift() {
        List<Person> givers = new ArrayList<>(people);
        List<Person> receivers = new ArrayList<>(people);
        Random random = new Random();

        boolean validAssignment = false;

        while (!validAssignment) {
            Collections.shuffle(receivers, random);
            validAssignment = true;

            for (int i = 0; i < givers.size(); i++) {
                Person giver = givers.get(i);
                Person receiver = receivers.get(i);

                // Restricciones: no se puede regalar a sí mismo ni al del año pasado
                if (receiver.getPersonName().equals(giver.getPersonName()) ||
                        receiver.getPersonName().equals(giver.getLastYearGifted().getPersonName())) {
                    validAssignment = false;
                    break;
                }
            }
        }

        // Cuando llega aquí, el emparejamiento es válido
        for (int i = 0; i < givers.size(); i++) {
            givers.get(i).setNextGiftPerson(receivers.get(i));
        }
    }

}
