# API de Gestion de Garage Mécanique

Cette API Spring Boot a été développée pour répondre aux besoins spécifiques d'un garage mécanique selon le cahier des charges fourni.

## Structure du Projet

### Modèles

- **Garage** : Représente l'entité principale du garage avec ses informations de base.
- **Service** : Représente les différents services proposés par le garage (lustrage, pneumatique, diagnostic, etc.).
- **Client** : Gère les informations des clients du garage.
- **RendezVous** : Permet la gestion des rendez-vous entre clients et mécaniciens.
- **Employe** : Représente les différents employés du garage (mécaniciens, réceptionnistes, administrateurs).
- **Stock** : Gère l'inventaire des pièces et fournitures du garage.
- **Facture** : Gère la facturation des services et pièces.

### Repositories

Chaque modèle dispose d'un repository correspondant qui étend JpaRepository pour fournir les opérations CRUD de base ainsi que des méthodes de recherche personnalisées.

## Fonctionnalités Implémentées

### Services Proposés

L'API permet de gérer les différents services du garage :
- Lustrage & Lavage Auto
- Pneumatique
- Diagnostique & Electricité
- Gestion des sinistres automobile
- Carrosserie & Peinture
- Mécanique Générale

### Gestion des Rendez-vous

L'API permet de :
- Créer, modifier et annuler des rendez-vous
- Assigner des mécaniciens aux rendez-vous
- Suivre le statut des rendez-vous
- Associer des services à un rendez-vous

### Gestion des Stocks

L'API permet de :
- Suivre l'inventaire des pièces détachées
- Gérer les fournisseurs
- Définir des seuils d'alerte pour le réapprovisionnement

### Gestion des Factures

L'API permet de :
- Émettre des factures liées aux rendez-vous
- Suivre le statut des paiements
- Calculer les montants (HT, TVA, TTC)
- Gérer différents modes de paiement

### Gestion de la Clientèle

L'API permet de :
- Enregistrer et mettre à jour les informations des clients
- Suivre l'historique des rendez-vous et factures par client

### Ressources Humaines

L'API permet de gérer les différents types d'employés :
- Mécaniciens
- Réceptionnistes
- Administrateurs

## Prochaines Étapes

- Implémentation des services métier pour chaque entité
- Création des contrôleurs REST pour exposer les fonctionnalités
- Mise en place de la validation des données
- Implémentation de la sécurité et de l'authentification
- Développement d'une interface utilisateur

## Prerequisites

Before you begin, ensure you have met the following requirements:

*   Java Development Kit (JDK) 17 or later installed.
*   Apache Maven 3.6.x or later installed.
*   An IDE that supports Spring Boot development (e.g., IntelliJ IDEA, Eclipse, VSCode with Java extensions).
*   Access to a relational database (the project is configured for H2 by default, but can be adapted for MySQL, PostgreSQL, etc.).

## Getting Started

To get a local copy up and running, follow these simple steps.

### Installation

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd springboot_garage
    ```
2.  **Build the project and install dependencies:**
    The project uses Maven to manage dependencies. Navigate to the project's root directory (where `pom.xml` is located) and run:
    ```bash
    mvn clean install
    ```
    This command will download all necessary dependencies and compile the project.

### Running the Application

Once the build is successful, you can run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, you can run the packaged JAR file (after building with `mvn package`):

```bash
java -jar target/springboot_garage-0.0.1-SNAPSHOT.jar 
```
(Replace `springboot_garage-0.0.1-SNAPSHOT.jar` with the actual name of your generated JAR file if it differs).

The application will start, and by default, it should be accessible at `http://localhost:8080` (or the port configured in `application.properties`).

## Technologies Utilisées

- Spring Boot
- Spring Data JPA
- Lombok
- Base de données relationnelle (H2, MySQL, PostgreSQL)