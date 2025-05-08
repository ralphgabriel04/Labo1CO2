/**
 * Classe représentant un capteur de CO2
 * Hérite de la classe abstraite Capteur
 */
public class CapteurCO2 extends Capteur {
    // Constructeur de la classe CapteurCO2
    public CapteurCO2() {
        super("CO2");
    }
    // Retourne l'unité de mesure de la concentration en CO2
    @Override
    public String getUnite() {
        return "ppm";
    }
} 