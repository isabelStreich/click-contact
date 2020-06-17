package com.example.click_contact.entities;
public class Operation {
    int id;
    int idClient;
    String typeOperation;
    String tarifPosition;
    String incoterms;
    String entiteBancaire;
    String Status;
    public Operation() {
    }
    public Operation(int id, int idClient, String typeOperation, String tarifPosition, String incoterms, String entiteBancaire, String status) {
        this.id = id;
        this.idClient = idClient;
        this.typeOperation = typeOperation;
        this.tarifPosition = tarifPosition;
        this.incoterms = incoterms;
        this.entiteBancaire = entiteBancaire;
        Status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getTypeOperation() {
        return typeOperation;
    }
    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }
    public String getTarifPosition() {
        return tarifPosition;
    }
    public void setTarifPosition(String tarifPosition) {
        this.tarifPosition = tarifPosition;
    }
    public String getIncoterms() {
        return incoterms;
    }
    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }
    public String getEntiteBancaire() {
        return entiteBancaire;
    }
    public void setEntiteBancaire(String entiteBancaire) {
        this.entiteBancaire = entiteBancaire;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
}
