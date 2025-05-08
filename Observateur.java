/**
 * Interface Observateur du patron Observateur
 * Représente un objet qui observe un sujet
 */
public interface Observateur {
    void actualiser(Sujet sujet); // recevoir une notification de changement
} 