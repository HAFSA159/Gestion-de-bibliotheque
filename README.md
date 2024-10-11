**Évolution de l'Application de Gestion de Bibliothèque**

Suite à la réussite du premier brief, la direction souhaite faire évoluer l'application console de gestion de bibliothèque en ajoutant des fonctionnalités plus avancées et en intégrant la persistance des données. Votre mission consiste à améliorer l'application existante avec les éléments suivants :

- **Persistance des données** : Intégrer une base de données relationnelle pour stocker de manière durable les livres, magazines, emprunts, et utilisateurs.
- **Concepts Java avancés** : Utiliser des concepts tels que les DAO (Data Access Object), les interfaces, l'héritage, et les collections pour structurer le code de manière optimale.
- **Gestion des utilisateurs et des emprunts** : Mettre en place des fonctionnalités permettant d'ajouter, gérer, et suivre les utilisateurs (étudiants, professeurs, etc.) ainsi que leurs emprunts et réservations de documents.
- **Recherche et tri** : Améliorer les fonctionnalités de recherche et de tri des documents grâce à des algorithmes plus performants et des méthodes comme les Streams et lambda expressions.
- **Tests et validation** : Ajouter des tests unitaires pour garantir la robustesse de l'application et valider le bon fonctionnement des nouvelles fonctionnalités.

L'application évolue vers un système plus complet, capable de gérer efficacement l'inventaire et les opérations d'une bibliothèque tout en offrant une expérience utilisateur améliorée.

Objectifs d'apprentissage :

    Approfondir les concepts de POO en Java, notamment le polymorphisme et l'héritage
    Concevoir et implémenter une base de données relationnelle simple
    Appliquer les principes de conception logicielle
    Maîtriser la création et l'interprétation de différents types de diagrammes UML
    Utiliser des outils de gestion de projet

​

Structure de l'application (évolution du brief 1) :

    Couche de présentation :
        Interface console améliorée (ConsoleUI)
        Vous etes libre de concevoir le contenu du menu à afficher

    Couche de métier

    Nouvelle couche de persistance :
        DAO (Data Access Objects) pour l'accès aux données

    Couche utilitaire :
        Classe DateUtils pour la manipulation avancée des dates
        Classe InputValidator pour la validation améliorée des entrées utilisateur

​

Structure de classes étendue :

    Hiérarchie de documents (vous etes libre de choisir les attribut et méthodes) :

        Classe abstraite Document

        Sous-classes :

        • Livre

        • Magazine

        • JournalScientifique (exemple d'attributs : domaineRecherche)

        • ThèseUniversitaire (exemple d'attributs : université, domaine)

        Classe Bibliotheque pour la gestion des documents

        Interface Empruntable (avec méthodes emprunter() et retourner())

        Interface Réservable (avec méthodes réserver() et annulerRéservation())

​

    Nouvelle hiérarchie d'utilisateurs :

        Classe abstraite Utilisateur (ajout d'attribut ou de méthode de votre choix)

        Sous-classes :

        • Etudiant (ajout d'attribut ou de méthode de votre choix)

        • Professeur (ajout d'attribut ou de méthode de votre choix)

​

Fonctionnalités principales :

    Gestion des documents :
        CRUD pour tous les types de documents
        Recherche avancée

    Gestion des utilisateurs :
        CRUD pour tous les 2 types d'utilisateur
        Gestion des droits d'emprunt selon le type d'utilisateur

    Gestion des emprunts :
        Emprunter et retourner des documents

    Gestion des réservations :
        Réserver un document
        Annuler une réservation

​

Spécifications techniques :

    Java 8 :
        Utiliser les Reference Methods
        Implémenter des Optionals pour la gestion des valeurs nulles
        Intégrer Java Time API pour la gestion avancée des dates
        Utiliser l'API Stream pour le traitement des collections
        Implémenter des interfaces fonctionnelles et des expressions lambda

​

    Base de données :

Pour ce projet, l'utilisation de PostgreSQL comme SGBD est exigée, car il offre un meilleur support pour l'héritage de tables, ce qui facilitera la mise en œuvre de la structure de classes hiérarchique de notre application.

Pour cela il faut :

    Concevoir un schéma de base de données relationnel PostgreSQL
    Utiliser le pilote JDBC pour la connexion et les opérations sur la base de données
    Implémenter des requêtes SQL adaptées aux spécificités de PostgreSQL

​

    Collection API et Hashmaps :
        Optimiser la recherche de documents avec des Hashmaps

​

    Garbage Collection : Implémenter une gestion efficace de la mémoire en se concentrant sur le point relatif à le Gestion des ressources de la base de données :

    Utilisez le pattern "try-with-resources" pour les connexions à PostgreSQL.
    Fermez explicitement les connexions dans les méthodes DAO après chaque opération.

​

Contraintes :

    Utiliser le pattern DAO pour l'accès aux données
    il est obligatoire d'Implémenter le design pattern Singleton
    Utiliser le polymorphisme de manière efficace dans la hiérarchie de classes

​

Gestion de projet :

    Poursuivre l'utilisation de Git avec une gestion plus avancée des branches
    Améliorer la gestion des tâches dans JIRA (backlog, 1seul sprint, user stories)

​

Modélisation :

    Élaborer un diagramme de cas d'utilisation pour les principales fonctionnalités
    Mettre à jour le diagramme de classes UML pour refléter la nouvelle structure
