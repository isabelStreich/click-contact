package com.example.click_contact.entities;
public class Contact {
    int id;
    String name;
    String adresse;
    String telephone;
    String email;
    String rol;
    String entiteFinanciereUtilise;
    public Contact() {
    }
    public Contact(int id, String name, String adresse, String telephone, String email, String rol, String entiteFinanciereUtilise) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.rol = rol;
        this.entiteFinanciereUtilise = entiteFinanciereUtilise;
    }
    public Contact(String nom, String adresse, String telephone, String email, String entiteFinanciereUtilise) {
        this.name = name;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.entiteFinanciereUtilise = entiteFinanciereUtilise;
    }
    public Contact(String name, String adresse, String telephone, String email, String rol, String entiteFinanciereUtilise) {
        this.name = name;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.rol = rol;
        this.entiteFinanciereUtilise = entiteFinanciereUtilise;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getEntiteFinanciereUtilise() {
        return entiteFinanciereUtilise;
    }
    public void setEntiteFinanciereUtilise(String entiteFinanciereUtilise) {
        this.entiteFinanciereUtilise = entiteFinanciereUtilise;
    }
}
