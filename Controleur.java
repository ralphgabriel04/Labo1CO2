/**
 * Classe Contrôleur qui gère le chauffage, la climatisation et la ventilation
 * Implémente l'interface Observateur du patron Observateur
 */
public class Controleur implements Observateur {
    private static final double TEMPERATURE_CIBLE = 22.0;
    private static final double CO2_CIBLE = 1000.0;
    
    private boolean chauffageActif;
    private boolean climatisationActive;
    private boolean ventilationActive;
    
    public Controleur() {
        this.chauffageActif = false;
        this.climatisationActive = false;
        this.ventilationActive = false;
    }
    
    @Override
    public void actualiser(Sujet sujet) {
        if (sujet instanceof Capteur) { // Vérifie si le sujet est une instance de Capteur parce que c'est un interface
            Capteur capteur = (Capteur) sujet;
            
            if (capteur instanceof CapteurTemperature) {
                gererTemperature(capteur.getValeur());
            } else if (capteur instanceof CapteurCO2) {
                gererCO2(capteur.getValeur());
            }
        }
    }
    
    /**
     * Gère le chauffage et la climatisation en fonction de la température
     * @param temperature La température actuelle
     */
    private void gererTemperature(double temperature) {
        if (temperature < TEMPERATURE_CIBLE && !chauffageActif) {
            demarrerChauffage();
            arreterClimatisation();
        } else if (temperature > TEMPERATURE_CIBLE && !climatisationActive) {
            arreterChauffage();
            demarrerClimatisation();
        } else if (temperature == TEMPERATURE_CIBLE) {
            arreterChauffage();
            arreterClimatisation();
        }
    }
    
    /**
     * Gère la ventilation en fonction du niveau de CO2
     * @param co2 Le niveau de CO2 actuel
     */
    private void gererCO2(double co2) {
        if (co2 > CO2_CIBLE && !ventilationActive) {
            demarrerVentilation();
        } else if (co2 <= CO2_CIBLE && ventilationActive) {
            arreterVentilation();
        }
    }
    
    /**
     * Démarre le chauffage
     */
    private void demarrerChauffage() {
        chauffageActif = true;
        System.out.println("Démarrage du chauffage.");
    }
    
    /**
     * Arrête le chauffage
     */
    private void arreterChauffage() {
        if (chauffageActif) {
            chauffageActif = false;
            System.out.println("Arrêt du chauffage.");
        }
    }
    
    /**
     * Démarre la climatisation
     */
    private void demarrerClimatisation() {
        climatisationActive = true;
        System.out.println("Démarrage de la climatisation.");
    }
    
    /**
     * Arrête la climatisation
     */
    private void arreterClimatisation() {
        if (climatisationActive) {
            climatisationActive = false;
            System.out.println("Arrêt de la climatisation.");
        }
    }
    
    /**
     * Démarre la ventilation
     */
    private void demarrerVentilation() {
        ventilationActive = true;
        System.out.println("Démarrage de la ventilation.");
    }
    
    /**
     * Arrête la ventilation
     */
    private void arreterVentilation() {
        if (ventilationActive) {
            ventilationActive = false;
            System.out.println("Arrêt de la ventilation.");
        }
    }
    
    /**
     * Affiche l'état des systèmes
     */
    public void afficherEtat() {
        System.out.println("\nÉtat des systèmes:");
        System.out.println("Chauffage: " + (chauffageActif ? "Actif" : "Inactif"));
        System.out.println("Climatisation: " + (climatisationActive ? "Active" : "Inactive"));
        System.out.println("Ventilation: " + (ventilationActive ? "Active" : "Inactive"));
        System.out.println();
    }
} 