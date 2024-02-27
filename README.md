# TP-Tournoi-Foot

## Contexte

Cette application s'inscrit dans le cursus M2i 2iTech
, pour l'obtention du titre de Concepteur et Développeur d'Application (CDA).

Le but étant de pouvoir évaluer nos compétences de conception et développement dans une API Rest
, pour le langage Java Spring boot.

---

### Technologies :
- JDK 21
- Java 17
- Spring boot : 3.2.3
- MySQL

### Git :
- https://github.com/AntoineValenduc/TP-Tournoi-Foot

### Docker :

- Pour lancer le conteneur, inscrivez dans la console `docker compose up -d`.
- Pour fermer le controller avec ses volumes, inscrivez dans la console `docker compose down -v`.

---

## Présentation

Il s'agit d'une application de gestion de match de foot.

Elle permet de générer des matchs de composition d'équipe aléatoire.
Avec un système de réservation de tickets pour les matchs, ainsi que de paris.

---

## Fonctionnalités principales

- Réserver un ou plusieurs ticket(s) pour un supporter.
- Réserver un ticket à partir du match
- Faire un pari sur la réussite d'une équipe lors d'un match
- Système de quotation des équipes pour définir la valeur du pari
