# 🌡️ Capteur Température & CO₂ – Simulation

## 📝 Description

Ce projet Java simule le fonctionnement d’un système de contrôle de température et de CO₂ dans une pièce, à l’aide du **patron de conception Observateur**.  
Lorsqu’un capteur détecte un changement, il **notifie automatiquement un contrôleur**, qui décide ensuite d’activer ou de désactiver le chauffage, la climatisation ou la ventilation.

Le projet est orienté objet, simple, éducatif et conçu pour illustrer l’utilisation du **patron Observateur**, de l’**héritage**, et des **interfaces** en Java.

---

## 🧠 Fonctionnement

- L’utilisateur entre manuellement la **température (°C)** et le **taux de CO₂ (ppm)** dans la console.
- Les capteurs (température et CO₂) envoient ces valeurs au **contrôleur**, qui réagit selon des limites prédéfinis :
  - 🌡️ **Température cible : 22 °C**
  - 🏭 **CO₂ maximal : 1000 ppm**
- Le contrôleur déclenche les actions nécessaires :
  - Chauffage
  - Climatisation
  - Ventilation
---

## 🔄 Règles d'activation des systèmes

| Système        | Démarre si…                       | S’arrête si…                   |
|----------------|------------------------------------|--------------------------------|
| Chauffage      | Température **< 22°C**             | Température **≥ 22°C**         |
| Climatisation  | Température **> 22°C**             | Température **≤ 22°C**         |
| Ventilation    | CO₂ **> 1000 ppm**                 | CO₂ **≤ 1000 ppm**             |

---

## 🛠️ Technologies

- Java 17+
- Programmation orientée objet
- Patron de conception : **Observateur**

---

## 📂 Structure du projet

```
UML/
└── Labo1-DiagrammeUML.png
├── Capteur.java
├── CapteurCO2.java
├── CapteurTemperature.java
├── Controleur.java
├── Observateur.java
├── Simulation.java
├── Sujet.java
```

---

## ✨ Fonctions clés

- ✅ Application du **patron Observateur**
- ✅ Système modulaire basé sur des **interfaces**
- ✅ Simulation en console avec saisie utilisateur
- ✅ Faible couplage et bonne séparation des responsabilités

---

## 💡 Améliorations possibles(Pour la prochaine fois)

- Ajouter une **interface graphique (JavaFX, Swing)**
- Enregistrer les données des capteurs dans un fichier ou une base de données
- Support pour d’autres types de capteurs (humidité, luminosité…)
- Ajout de logs ou historique des actions déclenchées

---

## 👤 Auteur

**Ralph Christian Gabriel**  
Étudiant passionné par le développement Java, les concepts orientés objet et la conception logicielle claire et maintenable à L'École de Technologie Supérieure.

---

## 📜 Licence

Projet open-source disponible sous la licence **MIT**.
