package gestiondechets;

import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.time.LocalDate;

import java.util.Scanner;


public class MainTest {

    public static void main(String[] args) {

        System.out.println("Bienvenue dans le système de gestion des déchets !");
    
        // Créer des utilisateurs
        Utilisateur utilisateur1 = new Utilisateur("user1", "John Doe", "johndoe@example.com", "password");
        Utilisateur utilisateur2 = new Utilisateur("user2", "Jane Doe", "janedoe@example.com", "password");
    
        // Créer les ménages
        Menage menage1 = new Menage("1234", utilisateur1);
        Menage menage2 = new Menage("5678", utilisateur2);
    
        // Créer les catégories pour chaque type de poubelle
        List<String> categoriesVerte = List.of("verre");
        List<String> categoriesJaune = List.of("carton", "plastique", "canette", "converse");
        List<String> categoriesBleue = List.of("papier");
        List<String> categoriesClassique = List.of("autres");
    
        // Créez les poubelles intelligentes correspondantes
        PoubelleIntelligente poubelleVerte = new PoubelleIntelligente("1", 100, categoriesVerte, "Emplacement 1", "Poubelle Verte", "Quartier 1");
        PoubelleIntelligente poubelleJaune = new PoubelleIntelligente("2", 100, categoriesJaune, "Emplacement 2", "Poubelle Jaune", "Quartier 1");
        PoubelleIntelligente poubelleBleue = new PoubelleIntelligente("3", 100, categoriesBleue, "Emplacement 3", "Poubelle Bleue", "Quartier 2");
        PoubelleIntelligente poubelleClassique = new PoubelleIntelligente("4", 100, categoriesClassique, "Emplacement 4", "Poubelle Classique", "Quartier 2");
    
        // Créer un centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre de Tri 1", "Adresse du centre de tri 1");
    
        // Ajoutez les poubelles au centre de tri
        centreDeTri.ajouterPoubelle(poubelleVerte);
        centreDeTri.ajouterPoubelle(poubelleJaune);
        centreDeTri.ajouterPoubelle(poubelleBleue);
        centreDeTri.ajouterPoubelle(poubelleClassique);
    
        // Créez des déchets conformes aux nouvelles poubelles
        LocalDate date = LocalDate.now();
        Dechet dechet1 = new Dechet("Plastique", 5, "plastique", 0.1, date);
        Dechet dechet2 = new Dechet("Papier", 2, "papier", 0.05, date);
        Dechet dechet3 = new Dechet("Verre", 3, "verre", 0.1, date);
        Dechet dechet4 = new Dechet("Autres", 1, "autres", 0.05, date);
    
        // Créez des déchets non conformes aux nouvelles poubelles
        Dechet dechetNonConforme = new Dechet("Plastique non conforme", 3, "plastique non conforme", 0.1, date);
    
        // Créer un bon d'achat
        BonDachat bonDachat1 = new BonDachat(500, 5, "Produits alimentaires");
    
        String categorieProduit = "Alimentation";
        int pointsAConvertir = 100;
        double pourcentageReduction = 0; // Vous pouvez définir un pourcentage de réduction ici
        BonDachat nouveauBonDachat = menage1.convertirPointsEnBonDachat(pointsAConvertir, pourcentageReduction, categorieProduit);
        if (nouveauBonDachat != null) {
            menage1.ajouterBonDachat(utilisateur1, nouveauBonDachat);
        }
    
        // Utiliser le bon d'achat
        menage1.utiliserBonDachat(bonDachat1, 3);
    
        // Vérifier le solde du bon d'achat après utilisation
        System.out.println("Solde restant sur le bon d'achat 1 : " + bonDachat1.getValeur() + " points");
    
        // Essayer d'utiliser plus de points que le solde du bon d'achat
        menage1.utiliserBonDachat(bonDachat1, 600);
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Ajout des utilisateurs autorisés
        poubelleVerte.ajouterUtilisateurAutorise(utilisateur1);
        poubelleJaune.ajouterUtilisateurAutorise(utilisateur1);
        poubelleBleue.ajouterUtilisateurAutorise(utilisateur1);
        poubelleClassique.ajouterUtilisateurAutorise(utilisateur1);
    
        // Ajoutez les déchets dans les poubelles appropriées
        poubelleJaune.ajouterDechet(dechet1, utilisateur1, centreDeTri);
        poubelleBleue.ajouterDechet(dechet2, utilisateur2, centreDeTri);
        poubelleVerte.ajouterDechet(dechet3, utilisateur1, centreDeTri);
        poubelleClassique.ajouterDechet(dechet4, utilisateur2, centreDeTri);
    
        // Identification de l'utilisateur
        if (poubelleVerte.identifierUtilisateur(utilisateur1)) {
            System.out.println("L'utilisateur 1 est autorisé à utiliser la poubelle verte.");
        } else {
            System.out.println("L'utilisateur 1 n'est pas autorisé à utiliser la poubelle verte.");
        }
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Essayez d'ajouter un déchet non conforme dans la poubelle verte
        try {
            poubelleVerte.ajouterDechet(dechetNonConforme, utilisateur1, centreDeTri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Essayez d'ajouter un déchet non conforme dans la poubelle verte
        Dechet dechetNonConforme2 = new Dechet("Plastique non conforme", 3, "plastique non conforme", 0.1, date);
        try {
            poubelleVerte.ajouterDechet(dechetNonConforme2, utilisateur1, centreDeTri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("+-----------------------------------------------------------+");

        // Collecte des déchets par le centre de tri
        centreDeTri.collecterDechets();
        
        // Afficher les points de fidélité des utilisateurs
        System.out.println("Points de fidélité de l'utilisateur1: " + utilisateur1.getPointsFidelite());
        System.out.println("Points de fidélité de l'utilisateur2: " + utilisateur2.getPointsFidelite());
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Afficher les déchets restants dans les poubelles après la collecte desdéchets
        System.out.println("Déchets restants dans la poubelle verte après la collecte des déchets: " + poubelleVerte.getDechets().size());
        System.out.println("Déchets restants dans la poubelle jaune après la collecte des déchets: " + poubelleJaune.getDechets().size());
        System.out.println("Déchets restants dans la poubelle bleue après la collecte des déchets: " + poubelleBleue.getDechets().size());
        System.out.println("Déchets restants dans la poubelle classique après la collecte des déchets: " + poubelleClassique.getDechets().size());
        System.out.println("+-----------------------------------------------------------+");
        // Afficher les membres du ménage
        System.out.println("Membres du ménage 1:");
        for (Utilisateur membre : menage1.getMembres()) {
            System.out.println("  - " + membre.getNom());
        }
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Retirer un membre du ménage
        menage1.retirerMembre(utilisateur2);
    
        // Afficher les membres restants du ménage
        System.out.println("Membres restants du ménage 1:");
        for (Utilisateur membre : menage1.getMembres()) {
            System.out.println("  - " + membre.getNom());
        }
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Afficher les bons d'achat du ménage
        System.out.println("Bons d'achat du ménage 1:");
        for (BonDachat bon : menage1.getBonsDachat()) {
            System.out.println("  - Bon d'achat avec solde: " + bon.getValeur() + " points");
        }
    
        System.out.println("+-----------------------------------------------------------+");
    
        // Afficher les points de fidélité des utilisateurs après utilisation des bons d'achat
        System.out.println("Points de fidélité de l'utilisateur1 après utilisation des bons d'achat: " + utilisateur1.getPointsFidelite());
        System.out.println("Points de fidélité de l'utilisateur2 après utilisation des bons d'achat: " + utilisateur2.getPointsFidelite());
    
        System.out.println("+-----------------------------------------------------------+");
    }
    
    
    
}
