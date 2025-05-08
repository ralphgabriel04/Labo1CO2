import java.util.Scanner;

/**
 * Classe principale contenant la méthode main
 * Permet de simuler le contrôle de température et CO2 d'un endroit
 */
public class Simulation {
    
    public static void main(String[] args) {
        // Création des capteurs
        CapteurTemperature capteurTemperature = new CapteurTemperature();
        CapteurCO2 capteurCO2 = new CapteurCO2();
        
        // Création du contrôleur
        Controleur controleur = new Controleur();
        
        // Enregistrement du contrôleur comme observateur des capteurs
        capteurTemperature.enregistrerObservateur(controleur);
        capteurCO2.enregistrerObservateur(controleur);

        // Prendre l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        
        // Afficher les informations de la simulation 
        System.out.println("Simulation de contrôle de température et CO2");
        System.out.println("Température cible: 22°C");
        System.out.println("Niveau de CO2 cible: inférieur à 1000 ppm");
        System.out.println("Entrez 'q' pour quitter\n");

        while (continuer) {
            // Demande des nouvelles valeurs
            System.out.print("Entrez la température (°C): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                continuer = false;
                continue;
            }
            // Try catch pour gérer les erreurs de format ex se n'est pas un nombre
            try {
                double temperature = Double.parseDouble(input);
                capteurTemperature.setValeur(temperature);
                System.out.printf("Contrôleur : nouvelle valeur reçue du capteur de %s : %.1f %s\n", 
                  capteurTemperature.getNom(), 
                  capteurTemperature.getValeur(), 
                  capteurTemperature.getUnite());
                
                System.out.print("Entrez le niveau de CO2 (ppm): ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("q")) {
                    continuer = false;
                    continue;
                }
                
                double co2 = Double.parseDouble(input);
                capteurCO2.setValeur(co2);
                System.out.printf("Contrôleur : nouvelle valeur reçue du capteur de %s : %.1f %s\n", 
                  capteurCO2.getNom(), 
                  capteurCO2.getValeur(), 
                  capteurCO2.getUnite()); // Affiche les nouvelles valeurs des capteurs selon leur format
                 
                System.out.println("Entrez 'q' pour quitter");
                
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }
        // Affichage des valeurs à la fin de la simulation
        System.out.println("\nValeurs à la fin de la simulation:");
        System.out.printf("%s: %.1f %s\n", capteurTemperature.getNom(), 
                         capteurTemperature.getValeur(), capteurTemperature.getUnite());
        System.out.printf("%s: %.1f %s\n", capteurCO2.getNom(), 
                         capteurCO2.getValeur(), capteurCO2.getUnite());
        
        // Affichage de l'état des systèmes
        controleur.afficherEtat();
        System.out.println("Fin de la simulation.");
        scanner.close();
    }
} 