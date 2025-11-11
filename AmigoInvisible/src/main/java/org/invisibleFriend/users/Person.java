package org.invisibleFriend.users;

public class Person {

    protected String personName;
    protected String personEmail;
    protected String personPassword;
    protected String role;
    protected Person lastYearGifted;
    protected Person nextGiftPerson;

    public Person(String personName, String personEmail, String personPassword) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPassword = personPassword;
    }

    public Person(String personName, String personEmail) {
        this.personName = personName;
        this.personEmail = personEmail;
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public Person() {

    }

    // ========== Getter and setters ==========
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public String getRole() {
        return role;
    }

    public Person getLastYearGifted() {
        return lastYearGifted;
    }

    public void setLastYearGifted(Person lastYearGifted) {
        this.lastYearGifted = lastYearGifted;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getNextGiftPerson() {
        return nextGiftPerson;
    }

    public void setNextGiftPerson(Person nextGiftPerson) {
        this.nextGiftPerson = nextGiftPerson;
    }

    // ========== toString ==========
    public String toString() {
        return "Persona: " + this.getPersonName()
                + " con email: " + this.getPersonEmail()
                + " con regalo para: " + this.getNextGiftPerson();
    }
}
