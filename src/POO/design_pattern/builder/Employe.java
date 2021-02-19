package POO.design_pattern.builder;

import java.time.LocalDate;

public class Employe {

    private String nom;
    private String prenom;
    private String surnom;
    private String numTel;
    private LocalDate dateNaiss;

    public Employe() {
    }

    public Employe(String nom, String prenom, String surnom, String numTel, LocalDate dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.numTel = numTel;
        this.dateNaiss = dateNaiss;
    }

    public static Builder builder(String nom, String prenom){ // on veut que soit donné obligatoirement le nom et le prenom
        return new Builder(nom, prenom);
    }

    public static class Builder{ // avantage : si les constructeurs sont en private

        private final String nom; // dubois
        private final String prenom; // luc
        private String surnom; // null
        private String numTel; // null
        private LocalDate dateNaiss; // LocalDate.now()

        public Builder(String nom, String prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }

        public Builder surnom(String surnom){
            this.surnom = surnom;
            return this;
        }

        public Builder numTel(String numTel){
            this.numTel = numTel;
            return this;
        }

        public Builder dateNaiss(LocalDate dateNaiss){
            this.dateNaiss = dateNaiss;
            return this;
        }

        public Employe build(){
            return new Employe(nom, prenom, surnom, numTel, dateNaiss);
        }
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
}
