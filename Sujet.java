/**
 * Interface Sujet du patron Observateur
 * Représente un objet qui peut être observé(Permet à d'autre objet de s'inscrire )
 */
public interface Sujet {
    void enregistrerObservateur(Observateur o); // Pour ajouter un observateur à la liste des observateurs
    void supprimerObservateur(Observateur o); // Pour retirer un observateur à la liste des observateurs
    void notifierObservateurs(); // Pour avertir quand quelque chose change
} 