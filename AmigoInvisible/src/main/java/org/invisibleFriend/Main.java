package org.invisibleFriend;

import org.invisibleFriend.users.Person;
import org.invisibleFriend.users.PersonCollector;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        PersonCollector people = new PersonCollector();
        EmailSender emailSender = new EmailSender();

        System.out.println("Bienvenido a la aplicación de amigo invisible.\n");
        while (true) {
            System.out.print("Introduce un nombre (Enter vacío para salir): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                break;
            } else {
                String name = input;
                System.out.println("Ahora introduce su correo: ");
                String email = emailCheck();
                Person user = new Person(name, email);
                people.addPerson(user);
                System.out.println("Ahora introduce la persona que le tocó el año pasado al usuario (Enter vacío para salir)");
                String lastYearGifted = sc.nextLine().trim();
                user.setLastYearGifted(new Person(lastYearGifted));
            }
        }
        System.out.println(people);

        people.assignNextGift();
        for(Person p : people.getPersonCollector()) {
            emailSender.sendEmail(p);
        }
    }

    private static String emailCheck() {
        while (true) {
            String email = sc.nextLine().trim();
            // Si es válido, lo devolvemos
            if (email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
                return email;
            } else {
                System.out.println("Introduce una dirección de correo válida (Enter vacío para salir): ");
            }
        }
    }
}