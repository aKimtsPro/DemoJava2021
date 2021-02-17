### Exercice récupitulatif
## Gestion de Stock

Grâce au site mockaroo.com, générez 1000 objects dans un fichier CSV contenant les propriétés suivantes :
- id
- typeProduit
- prix
- quantité
- Producteur
- emailProducteur

Créer le générateur.
Créer une application de gestion de stock:
Cette app doit pouvoir via un menu :
- Afficher tous les produits en choisissant le nombre à afficher (10, 50, 100);
- Faire une recherche complète multi-critères
- Pouvoir créer des commandes sur ces produits en impactant le stock;
- Afficher les commandes en cours

Une commande est définie avec
- id
- nom
- date
- List<Produits>
- prix total

#### Ecriture de fichier

Faites en sorte que les commandes réalisées par l'utilisateur de l'application soit
enregistrées de façon pérenne(dans un fichier). Les commandes devront être chargées 
au lancement de l'application.

Ajouter une fonctionnalité permettant d'annuler des commandes.