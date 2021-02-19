package POO.exo.exceptions;

import java.util.UUID;

public class Epargne extends Compte {

    public Epargne(UUID numeroUnique, String iban, double solde) {
        super(numeroUnique, iban, solde);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Epargne{");
        sb.append("numeroUnique=").append(numeroUnique);
        sb.append(", iban='").append(iban).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }
}
