package POO.exo.exceptions;

import java.util.UUID;

public class DemoBanque {

    public static void main(String[] args) {

        Compte courant = new Courant(UUID.randomUUID(), "BE85-1234-4587-7854-1335", 1000, 500);
        Compte courant1 = new Courant(UUID.randomUUID(), "BE85-1234-4587-7854-1335", 2000, 500);
        Compte epargne = new Epargne(UUID.randomUUID(), "BE86-9874-4458-7145-3256", 2500);


        ActionClient courantClient = courant;
        ActionBanquier courantBanquier = courant;
        epargne.consulter();

        try {
            courant.retrait(800);
            courant.retrait(650);
            courantClient.retrait(200);


        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }

        try {
            epargne.retrait(2400);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }

        courantClient.depot(1000);
        courantBanquier.appliquerTauxInteret(2.5);
        courant.consulter();
        courant.afficherHistorique();
        epargne.afficherHistorique();

        System.out.println(courant.compareTo(courant1));
    }
}
