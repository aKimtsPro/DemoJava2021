package POO.exo.heritage.production;

public class Usine extends Propriete {

    private Produit produit;
    private int qtt;

    public Usine(Proprietaire proprietaire, int salaire, int nbrEmploye, Produit produit) {
        super(proprietaire, salaire, nbrEmploye);
        this.setProduit(produit);
    }

    @Override
    public void produire() {
        int nbrProduit = 8 / (int)produit.getTempsProd();
        double benefice = nbrProduit * produit.getPrix();
        double salaire = this.getNbrEmploye() * this.getSalaire();
        double coutProdTotal = nbrProduit * produit.getCoutProd();

        double gain = benefice - salaire - coutProdTotal;
        this.qtt += nbrProduit;

        System.out.println("Suite à une journée de travail dans une usine de "+ produit.getNom()+" " +
                this.getProprietaire().getPrenom() +" "+ getProprietaire().getNom() +" a gagné " +gain+ "euro(s).");
        getProprietaire().gain(gain);
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        if(produit != null){
            this.produit = produit;
            this.qtt = 0;
        }
    }

    public int getQtt() {
        return qtt;
    }

    private void setQtt(int qtt) {
        this.qtt = qtt;
    }
}
