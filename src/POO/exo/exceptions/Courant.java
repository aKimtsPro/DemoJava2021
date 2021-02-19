package POO.exo.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Courant extends Compte  {

    private double ligneDeCredit;

    public Courant(UUID numeroUnique, String iban, double solde, double ligneDeCredit) {
        super(numeroUnique, iban, solde);
        this.ligneDeCredit = ligneDeCredit;
    }

    @Override
    public void retrait(double retrait) throws SoldeInsuffisantException {
        if (retrait > 0 && (solde - retrait) > -ligneDeCredit) {
            this.solde = this.solde - retrait;
            System.out.println("Retrait de " + retrait + " du compte " + iban + " >> Nouveau solde de " + solde);
            this.historique.ajouter(new Historique(retrait, LocalDateTime.now()));

        } else {
            throw new SoldeInsuffisantException();
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Courant{");
        sb.append("ligneDeCredit=").append(ligneDeCredit);
        sb.append(", numeroUnique=").append(numeroUnique);
        sb.append(", iban='").append(iban).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }
}
