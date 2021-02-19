package POO.design_pattern.builder;

import java.time.LocalDate;

public class EmployeBuilder { // inconvéniant : si les constructeurs sont en private

    private String nom;
    private String prenom;
    private String surnom;
    private String numTel;
    private LocalDate dateNaiss;

    public EmployeBuilder nom(String nom){
        this.nom = nom;
        return this;
    }

    public EmployeBuilder prenom(String prenom){
        this.prenom = prenom;
        return this;
    }

    public EmployeBuilder surnom(String surnom){
        this.surnom = surnom;
        return this;
    }

    public EmployeBuilder numTel(String numTel){
        this.numTel = numTel;
        return this;
    }

    public EmployeBuilder dateNaiss(LocalDate dateNaiss){
        this.dateNaiss = dateNaiss;
        return this;
    }

    public Employe build(){
        return new Employe(nom, prenom, surnom, numTel, dateNaiss);
    }
}
