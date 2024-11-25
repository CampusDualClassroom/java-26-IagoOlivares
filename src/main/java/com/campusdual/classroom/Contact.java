package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames); // Generamos el código automáticamente.
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    private String generateCode(String name, String lastName) {
        String normalizedLastName = Normalizer.normalize(lastName.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String[] lastNameParts = normalizedLastName.split(" ");

        if (lastNameParts.length == 1) {
            return name.toLowerCase().charAt(0) + lastNameParts[0];
        } else {

            String firstPart = lastNameParts[0];
            StringBuilder secondPart = new StringBuilder();

            for (int i = 1; i < lastNameParts.length; i++) {
                secondPart.append(lastNameParts[i]);
            }

            return name.toLowerCase().charAt(0) + String.valueOf(firstPart.charAt(0)) + secondPart.toString();
        }
    }

    @Override
    public void callMyNumber() {
        System.out.println("Llamando al propio número: " + this.name + " " + this.surnames + ", " + this.phone);
    }

    @Override
    public void callOtherNumber(String phone) {
        System.out.println("Llamando desde " + this.name + " " + this.surnames + " al número " + phone);
    }


    @Override
    public void showContactDetails() {
        System.out.println("Detalles del contacto:");
        System.out.println("Nombre: " + name + " " + surnames);
        System.out.println("Número de teléfono: " + phone);
        System.out.println("Código: " + code);
    }


}
