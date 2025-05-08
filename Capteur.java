import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un capteur générique
 * Implémente l'interface Sujet du patron Observateur
 */
public abstract class Capteur implements Sujet {
    // Encapsulation des variables pour pas que les autres classes puissent les modifier
    protected List<Observateur> observateurs;
    protected String nom;
    protected double valeur;
    
    // Constructeur de la classe Capteur
    public Capteur(String nom) {
        this.nom = nom;
        this.observateurs = new ArrayList<>();
        this.valeur = 0.0;
    }
    
    @Override
    public void enregistrerObservateur(Observateur o) {
        if (!observateurs.contains(o)) {
            observateurs.add(o);
        }
    }
    
    @Override
    public void supprimerObservateur(Observateur o) {
        observateurs.remove(o);
    }

    
    @Override
    public void notifierObservateurs() {
        for (Observateur o : observateurs) {
            o.actualiser(this);
        }
    }
    
    /**
     * Modifie la valeur du capteur
     * @param nouvelleValeur La nouvelle valeur du capteur
     */
    public void setValeur(double nouvelleValeur) {
        this.valeur = nouvelleValeur;
        notifierObservateurs();
    }
    
    /**
     * Retourne la valeur actuelle du capteur
     * @return La valeur actuelle du capteur
     */
    public double getValeur() {
        return valeur;
    }
    
    /**
     * Retourne le nom du capteur
     * @return Le nom du capteur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Retourne l'unité de mesure du capteur
     * @return L'unité de mesure
     */
    public abstract String getUnite();
} 