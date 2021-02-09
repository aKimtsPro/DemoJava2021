package POO.exo.heritage.production;

public abstract class Propriete {

    private Proprietaire proprietaire;
    private int salaire = 100;
    private int nbrEmploye;

    public Propriete(Proprietaire proprietaire, int salaire, int nbrEmploye) {
        this.setProprietaire(proprietaire);
        this.setSalaire(salaire);
        this.setNbrEmploye(nbrEmploye);
    }

    public abstract void produire();

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        if(salaire > 0)
            this.salaire = salaire;
    }

    public int getNbrEmploye() {
        return nbrEmploye;
    }

    public void setNbrEmploye(int nbrEmploye) {
        if(nbrEmploye >= 0)
            this.nbrEmploye = nbrEmploye;
    }
}
