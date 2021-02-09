package POO.exo.encaps;

public class Exo3 {
    public static void main(String[] args) {
        Article article = new Article("polopopo", "pullover", 20);
        System.out.println("Article:" +
                "\n- marque: " + article.getMarque() +
                "\n- nom: " + article.getNom() +
                "\n- prix: " + article.getPrix() +
                "\n- reduction: " + article.getReduction());

        Client client = new Client("pol","jen");
        client.recharger(100);
        client.acheter(article);
        client.acheter(article, 1);

        System.out.println("--------------------");
        System.out.println(Client.generateNumero());
    }
}
