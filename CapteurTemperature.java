/**
 * Classe représentant un capteur de température
 * Hérite de la classe abstraite Capteur
 */
public class CapteurTemperature extends Capteur {
    // Constructeur de la classe CapteurTemperature
    public CapteurTemperature() {
        super("Température");
    }
    // Retourne l'unité de mesure de la température
    @Override
    public String getUnite() {
        return "°C";
    }
} 