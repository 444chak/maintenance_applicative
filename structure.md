# Pixel Tracer Architecture

## :flag_us: Pixel Tracer Architecture

## Core Data Structures

### Area (`struct area`)

- Represents a 2D space with width and height
- Contains a 2D character array (`char**`) for rendering
- Holds a name and ID for identification (name as `char*`, id as `int`)
- Maintains a list of layers (`LayersList`) that can be stacked and composited
- Defines character styles for empty spaces (`empty_char`) and filled spaces (`filled_char`)
- Provides methods for resizing, clearing, and exporting to different formats
- Supports viewport management for large areas with scrolling capabilities

### Layer (`struct layer`)

- Represents a single layer within an area
- Contains its own 2D grid representation for independent manipulation
- Supports transparency/opacity settings (0-100%)
- Has visibility toggle for showing/hiding in composite rendering
- Maintains Z-index for layering order during compositing
- Tracks dirty regions for optimized rendering
- Supports blending modes for interaction with other layers
- Contains metadata like creation timestamp and last modification

### Point (`struct point`)

- Fundamental structure representing a position in 2D space (x, y coordinates)
- Supports floating-point precision for anti-aliasing and smooth transformations
- Contains optional color and style attributes
- Provides utility methods for distance calculation, interpolation, and snapping
- Used for coordinates in shapes, paths, and drawing operations

### Command (`struct command`)

- Represents user operations/instructions with command type and parameters
- Implements command pattern for operation execution
- Supports undo/redo functionality with state tracking
- Contains validation logic to ensure operation validity
- Provides detailed error reporting for failed commands
- Supports command batching for complex operations
- Includes timing information for performance monitoring

### List Implementation (`lnode_`)

- Generic linked list implementation with dynamic memory management
- Used for managing collections of objects (areas, layers, points, etc.)
- Supports typical list operations (add, remove, iterate, sort, filter)
- Implements custom memory allocation strategies for performance
- Provides thread-safety options for concurrent access
- Includes traversal helpers and functional-style iterators
- Supports serialization for persistence

## Main Component

### Pixel Tracer (`struct pixel_tracer`)

- Central controller structure for the application
- Manages areas, layers, and command processing through dedicated managers
- Implements event system for UI updates and inter-component communication
- Coordinates the rendering pipeline with configurable refresh rates
- Handles file I/O for project saving/loading
- Provides plugin system for extensibility
- Manages configuration and user preferences
- Implements logging and diagnostics for debugging

## Rendering Pipeline

1. **Layer Preparation**: Each layer is prepared for rendering
2. **Composition**: Layers are composited based on z-index and opacity
3. **Viewport Transformation**: The visible portion is extracted
4. **Character Mapping**: Pixel values are mapped to characters
5. **Buffer Creation**: The final character buffer is assembled
6. **Display**: The buffer is sent to the output device

## Relationships

- **Pixel Tracer** contains and manages multiple **Areas** through an area manager
- Each **Area** contains multiple **Layers** in a z-ordered stack
- **Layers** are composed of **Points** and shapes with style attributes
- User interaction happens through **Commands** that modify the data structures
- **Lists** are used throughout to manage collections of objects with efficient traversal
- The rendering pipeline transforms these structures into viewable output
- Event system connects components for reactive updates

This architecture follows a layered approach where rendering happens through a stack of layers, contained within defined areas, all orchestrated by the main pixel tracer component. The design emphasizes flexibility, extensibility, and performance for real-time character-based graphics.

## :flag_fr: Architecture de Pixel Tracer

## Structures de Données Principales

### Zone (`struct area`)

- Représente un espace 2D avec largeur et hauteur
- Contient un tableau 2D de caractères (`char**`) pour le rendu
- Possède un nom et un ID pour l'identification (nom en `char*`, id en `int`)
- Maintient une liste de calques (`LayersList`) pouvant être empilés et composés
- Définit des styles de caractères pour les espaces vides (`empty_char`) et remplis (`filled_char`)
- Fournit des méthodes pour redimensionner, nettoyer et exporter vers différents formats
- Supporte la gestion de la fenêtre d'affichage pour les grandes zones avec des capacités de défilement

### Calque (`struct layer`)

- Représente un calque unique dans une zone
- Contient sa propre représentation en grille 2D pour une manipulation indépendante
- Supporte les réglages de transparence/opacité (0-100 %)
- Possède une option de visibilité pour afficher/masquer dans le rendu composite
- Maintient un Z-index pour l'ordre des calques lors de la composition
- Suit les régions modifiées pour un rendu optimisé
- Supporte les modes de fusion pour interagir avec d'autres calques
- Contient des métadonnées comme la date de création et la dernière modification

### Point (`struct point`)

- Structure fondamentale représentant une position dans un espace 2D (coordonnées x, y)
- Supporte la précision en virgule flottante pour l'anti-aliasing et les transformations fluides
- Contient des attributs optionnels de couleur et de style
- Fournit des méthodes utilitaires pour le calcul de distance, l'interpolation et l'alignement
- Utilisé pour les coordonnées dans les formes, chemins et opérations de dessin

### Commande (`struct command`)

- Représente les opérations/instructions utilisateur avec un type de commande et des paramètres
- Implémente le modèle de commande pour l'exécution des opérations
- Supporte les fonctionnalités d'annulation/rétablissement avec suivi d'état
- Contient une logique de validation pour garantir la validité des opérations
- Fournit des rapports d'erreur détaillés pour les commandes échouées
- Supporte le regroupement de commandes pour des opérations complexes
- Inclut des informations de chronométrage pour le suivi des performances

### Implémentation de Liste (`lnode_`)

- Implémentation générique de liste chaînée avec gestion dynamique de la mémoire
- Utilisée pour gérer des collections d'objets (zones, calques, points, etc.)
- Supporte les opérations typiques de liste (ajouter, supprimer, itérer, trier, filtrer)
- Implémente des stratégies personnalisées d'allocation mémoire pour la performance
- Fournit des options de sécurité pour l'accès concurrent
- Inclut des aides pour le parcours et des itérateurs de style fonctionnel
- Supporte la sérialisation pour la persistance

## Composant Principal

### Pixel Tracer (`struct pixel_tracer`)

- Structure centrale contrôlant l'application
- Gère les zones, calques et le traitement des commandes via des gestionnaires dédiés
- Implémente un système d'événements pour les mises à jour de l'interface utilisateur et la communication entre composants
- Coordonne le pipeline de rendu avec des taux de rafraîchissement configurables
- Gère les entrées/sorties de fichiers pour la sauvegarde/chargement de projets
- Fournit un système de plugins pour l'extensibilité
- Gère la configuration et les préférences utilisateur
- Implémente la journalisation et le diagnostic pour le débogage

## Pipeline de Rendu

1. **Préparation des Calques** : Chaque calque est préparé pour le rendu
2. **Composition** : Les calques sont composés en fonction du Z-index et de l'opacité
3. **Transformation de la Fenêtre d'Affichage** : La portion visible est extraite
4. **Mappage des Caractères** : Les valeurs des pixels sont mappées à des caractères
5. **Création du Buffer** : Le buffer final de caractères est assemblé
6. **Affichage** : Le buffer est envoyé au périphérique de sortie

## Relations

- **Pixel Tracer** contient et gère plusieurs **Zones** via un gestionnaire de zones
- Chaque **Zone** contient plusieurs **Calques** empilés selon un ordre Z
- Les **Calques** sont composés de **Points** et de formes avec des attributs de style
- L'interaction utilisateur se fait via des **Commandes** qui modifient les structures de données
- Les **Listes** sont utilisées partout pour gérer des collections d'objets avec un parcours efficace
- Le pipeline de rendu transforme ces structures en une sortie visualisable
- Le système d'événements connecte les composants pour des mises à jour réactives

Cette architecture suit une approche en couches où le rendu se fait via une pile de calques, contenus dans des zones définies, le tout orchestré par le composant principal Pixel Tracer. La conception met l'accent sur la flexibilité, l'extensibilité et la performance pour des graphiques en temps réel basés sur des caractères.
