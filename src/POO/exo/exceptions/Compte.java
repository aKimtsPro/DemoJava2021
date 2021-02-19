package POO.exo.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public abstract class Compte implements ActionClient, ActionBanquier, Comparable<Compte>{

    protected UUID numeroUnique;
    protected String iban;
    protected double solde;
    protected Historique historique;

    public Compte(UUID numeroUnique, String iban, double solde) {
        this.numeroUnique = numeroUnique;
        this.iban = iban;
        this.solde = solde;
        this.historique = new Historique(this.solde, LocalDateTime.now());
   }

    public void afficherHistorique() {
        System.out.println("Historique du compte " + iban);
        for (Historique h: historique.historiqueList) {
            System.out.println(h);
        }
    }

    @Override
    public int compareTo(Compte o) {

        /**
         * Classes locales
         */
//        class CompteComparator implements Comparator<Compte> {
//
//            @Override
//            public int compare(Compte o1, Compte o2) {
//                int order = o1.iban.compareTo(o2.iban);
//                return order != 0 ?  order : o1.numeroUnique.compareTo(o2.numeroUnique);
//            }
//        }
//
//        return new CompteComparator().compare(this, o);

        /**
         * Classe anonymes
         */

        Comparator<Compte> comparator = new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                int order = o1.iban.compareTo(o2.iban);
                return order != 0 ?  order : o1.numeroUnique.compareTo(o2.numeroUnique);
            }
        };

        return comparator.compare(this, o);
    }

    class Historique {

        protected List<Historique> historiqueList = new ArrayList<>();

        protected double soldeTransaction;
        protected LocalDateTime dateTransaction;

        public Historique(double soldeTransaction, LocalDateTime dateTransaction) {
            this.soldeTransaction = soldeTransaction;
            this.dateTransaction = dateTransaction;
        }

        public void ajouter(Historique element) {
            this.historiqueList.add(element);
        }

        public void retirer(Historique element) {
            this.historiqueList.remove(element);
        }


        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Historique{");
            sb.append("soldeTransaction=").append(soldeTransaction);
            sb.append(", dateTransaction=").append(dateTransaction);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public void appliquerTauxInteret(double taux) {
        this.solde = this.solde + (this.solde * taux/100);
        System.out.println("Application du taux d'intérêt de " + taux + "% au compte " + iban);
    }

    @Override
    public void depot(double depot) {
        this.solde += depot;
        this.historique.ajouter(new Historique(depot, LocalDateTime.now()));
        System.out.println("Nouveau dépot de " + depot + " sur le compte " + iban + " >> Nouveau solde de " + solde);
    }

    @Override
    public void retrait(double retrait) throws SoldeInsuffisantException {
        if (retrait > 0 && solde - retrait < 0) {
            throw new SoldeInsuffisantException();
        } else {
            if (retrait > 0) {
                this.solde = this.solde - retrait;
                System.out.println("Retrait de " + retrait + " du compte " + iban + " >> Nouveau solde de " + solde);
                this.historique.ajouter(new Historique(retrait, LocalDateTime.now()));

            }
        }
    }

    @Override
    public void consulter() {
        System.out.println(this);
    }
}
