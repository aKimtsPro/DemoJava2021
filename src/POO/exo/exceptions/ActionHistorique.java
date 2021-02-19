package POO.exo.exceptions;

public interface ActionHistorique {
    void afficherHistorique();
    void ajouter(Compte.Historique element);
    void retirer(Compte.Historique element);
}
