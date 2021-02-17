package POO.demo.services.models;

import java.util.Arrays;

public class Personne {

    private String firstName;
    private String lastName;
    private String companyName;
    private Adresse address;
    private String[] phones;
    private String email;
    private String web;

    public Personne(String firstName, String lastName, String companyName, Adresse address, String[] phones, String email, String web) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.phones = phones;
        this.email = email;
        this.web = web;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s\n%s %s\n%s\n%s - %s",
                this.lastName,
                this.firstName,
                this.companyName,
                this.phones[0],
                this.phones[1],
                this.address,
                this.email,
                this.web);
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Adresse getAddress() {
        return address;
    }

    public void setAddress(Adresse address) {
        this.address = address;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
