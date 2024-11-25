package com.campusdual.classroom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }

    public Map<String, Contact> getData() {
        return this.contacts;
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getCode())) {
            System.out.println("El contacto ya existe.");
        } else {
            contacts.put(contact.getCode(), contact);
            System.out.println("Contacto añadido correctamente.");
        }
    }

    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("Aun no tienes contactos.");
        } else {
            System.out.println("Contactos:");
            for (Contact contact : contacts.values()) {
                System.out.println(contact.getCode() + " - " + contact.getPhone());
            }
        }
    }

    public void deleteContact(String code) {
        if (contacts.containsKey(code)) {
            contacts.remove(code);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("El contacto no existe.");
        }
    }

    public void selectContact(String code) {
        Contact contact = contacts.get(code);
        if (contact != null) {
            contactMenu(contact);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private void contactMenu(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nMenú de acciones para " + contact.getCode());
            System.out.println("1. Llamar a mi número");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Mostrar detalles del contacto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1:
                    contact.callMyNumber();
                    break;
                case 2:
                    System.out.print("Introduce el número al que quieres llamar: ");
                    String number = scanner.nextLine();
                    contact.callOtherNumber(number);
                    break;
                case 3:
                    contact.showContactDetails();
                    break;
                case 0:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nMenú del listín telefónico");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Número de teléfono: ");
                    String phoneNumber = scanner.nextLine();
                    addContact(new Contact(name, lastName, phoneNumber));
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    System.out.print("Introduce el código del contacto: ");
                    String code = scanner.nextLine();
                    selectContact(code);
                    break;
                case 4:
                    System.out.print("Introduce el código del contacto a eliminar: ");
                    String removeCode = scanner.nextLine();
                    deleteContact(removeCode);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }
}
