# Pixel Tracer (Version Java)

Cette application est une conversion en Java du projet original Pixel Tracer écrit en C. Elle permet de créer et manipuler des formes géométriques dans un espace 2D en utilisant du texte ASCII.

## Fonctionnalités

* Création de formes : points, lignes, carrés, rectangles, cercles, polygones et courbes de Bézier
* Système de couches avec visibilité configurable
* Zones de dessin multiples
* Interface en ligne de commande intuitive
* Rendu ASCII pour visualisation dans le terminal

## Prérequis

* Java Development Kit (JDK) 8 ou supérieur

## Compilation et exécution

### Méthode simple (avec script)

Pour compiler et exécuter l'application, il suffit d'utiliser le script `run.bat` :

```bash
# À la racine du projet Java
run.bat
```

Le script va :

1. Créer le dossier `build` s'il n'existe pas
2. Compiler tous les fichiers Java
3. Exécuter l'application

### Méthode manuelle

Vous pouvez également compiler et exécuter manuellement :

```bash
# Création du répertoire de compilation
mkdir -p build

# Compilation
javac -d build pixel_tracer/*.java

# Exécution
java -cp build pixel_tracer.PixelTracerApp
```

## Commandes disponibles

| Commande | Description |
|---------|-------------|
| `help` | Affiche l'aide |
| `exit` | Quitte l'application |
| `clear` | Efface l'écran |
| `plot` | Redessine l'écran |
| `point x y` | Crée un point aux coordonnées (x,y) |
| `line x1 y1 x2 y2` | Trace une ligne de (x1,y1) à (x2,y2) |
| `square x y l` | Dessine un carré de côté l à partir de (x,y) |
| `rectangle x y w h` | Dessine un rectangle de largeur w et hauteur h à partir de (x,y) |
| `circle x y r` | Dessine un cercle de centre (x,y) et de rayon r |
| `polygon x1 y1 x2 y2...` | Dessine un polygone avec les points spécifiés |
| `curve x1 y1 x2 y2 x3 y3 x4 y4` | Dessine une courbe de Bézier avec les points de contrôle spécifiés |
| `list areas` | Liste toutes les zones |
| `list layers` | Liste toutes les couches de la zone courante |
| `list shapes` | Liste toutes les formes de la couche courante |
| `select area id` | Sélectionne une zone |
| `select layer id` | Sélectionne une couche |
| `select shape id` | Sélectionne une forme |
| `new area [name]` | Crée une nouvelle zone |
| `new layer [name]` | Crée une nouvelle couche |
| `delete area id` | Supprime une zone |
| `delete layer id` | Supprime une couche |
| `delete shape id` | Supprime une forme |
| `set char border code` | Change le caractère de bordure |
| `set char background code` | Change le caractère d'arrière-plan |
| `set layer visible id` | Rend une couche visible |
| `set layer invisible id` | Rend une couche invisible |

## Différences avec la version C

Cette version Java a été conçue pour être fidèle à l'original tout en tirant parti des fonctionnalités du langage Java :

* Utilisation des collections Java (ArrayList, List) au lieu des listes chaînées personnalisées
* Approche orientée objet avec héritage pour les formes
* Gestion automatique de la mémoire (garbage collector)
* Gestion d'erreurs avec exceptions
* Code plus modulaire et extensible

## Perspectives d'évolution

* Interface graphique (Swing ou JavaFX)
* Import/export vers d'autres formats (SVG, PNG)
* Support de la couleur (ANSI pour le terminal)
* Opérations sur les formes (rotation, mise à l'échelle)
* Annulation/rétablissement des actions

## Auteur

Ce projet est une conversion Java du projet Pixel Tracer original.
