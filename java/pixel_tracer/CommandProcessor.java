package pixel_tracer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Processeur de commandes pour l'application Pixel Tracer.
 * Gère l'interprétation des commandes textuelles entrées par l'utilisateur.
 */
public class CommandProcessor {
    private PixelTracerApp app;
    private boolean running;

    // Messages d'erreur
    private static final String[] ERROR_MESSAGES = {
            "Commande exécutée avec succès",
            "Commande inconnue",
            "Commande vide",
            "Nombre de paramètres incorrect",
            "Quitter l'application",
            "Effacer l'écran",
            "Tracer la zone courante",
            "Aide affichée",
            "Information affichée",
            "Élément non trouvé"
    };

    /**
     * Crée un nouveau processeur de commandes.
     * 
     * @param app L'application Pixel Tracer
     */
    public CommandProcessor(PixelTracerApp app) {
        this.app = app;
        this.running = true;
    }

    /**
     * Démarre le traitement des commandes en mode interactif.
     */
    public void startInteractive() {
        Scanner scanner = new Scanner(System.in);

        clearScreen();
        app.renderCurrentArea();
        app.getCurrentArea().draw();

        while (running) {
            System.out.print("pixel_tracer> ");
            String input = scanner.nextLine().trim();

            int errorCode = processCommand(input);
            System.out.println(ERROR_MESSAGES[errorCode]);

            if (errorCode == 4) { // Quitter
                running = false;
            } else if (errorCode == 0 || errorCode == 6) { // Succès ou traçage
                clearScreen();
                app.renderCurrentArea();
                app.getCurrentArea().draw();
            } else if (errorCode == 5) { // Effacer écran
                clearScreen();
            }
        }
    }

    /**
     * Traite une commande textuelle.
     * 
     * @param commandLine La ligne de commande à traiter
     * @return Un code d'erreur
     */
    public int processCommand(String commandLine) {
        if (commandLine == null || commandLine.isEmpty()) {
            return 2; // Commande vide
        }

        String[] tokens = commandLine.split("\\s+");
        String cmdName = tokens[0].toLowerCase();
        List<String> strParams = new ArrayList<>();
        List<Integer> intParams = new ArrayList<>();
        List<Float> floatParams = new ArrayList<>();

        // Analyser les paramètres
        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];

            try {
                // Essayer de convertir en entier
                int intValue = Integer.parseInt(token);
                intParams.add(intValue);
            } catch (NumberFormatException e1) {
                try {
                    // Essayer de convertir en flottant
                    float floatValue = Float.parseFloat(token);
                    floatParams.add(floatValue);
                } catch (NumberFormatException e2) {
                    // Considérer comme une chaîne
                    strParams.add(token);
                }
            }
        }

        // Traiter la commande
        switch (cmdName) {
            case "exit":
                return 4; // Quitter

            case "clear":
                return 5; // Effacer écran

            case "plot":
                return 6; // Tracer

            case "help":
                printHelp();
                return 7; // Aide affichée

            case "point":
                if (intParams.size() < 2)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    PointShape point = new PointShape(intParams.get(0), intParams.get(1));
                    app.getCurrentLayer().addShape(point);
                    return 0;
                }
                return 9; // Aucune couche active

            case "line":
                if (intParams.size() < 4)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    LineShape line = new LineShape(
                            intParams.get(0), intParams.get(1),
                            intParams.get(2), intParams.get(3));
                    app.getCurrentLayer().addShape(line);
                    return 0;
                }
                return 9; // Aucune couche active

            case "square":
                if (intParams.size() < 3)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    SquareShape square = new SquareShape(
                            intParams.get(0), intParams.get(1),
                            intParams.get(2));
                    app.getCurrentLayer().addShape(square);
                    return 0;
                }
                return 9; // Aucune couche active

            case "rectangle":
                if (intParams.size() < 4)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    RectangleShape rectangle = new RectangleShape(
                            intParams.get(0), intParams.get(1),
                            intParams.get(2), intParams.get(3));
                    app.getCurrentLayer().addShape(rectangle);
                    return 0;
                }
                return 9; // Aucune couche active

            case "circle":
                if (intParams.size() < 3)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    CircleShape circle = new CircleShape(
                            intParams.get(0), intParams.get(1),
                            intParams.get(2));
                    app.getCurrentLayer().addShape(circle);
                    return 0;
                }
                return 9; // Aucune couche active

            case "polygon":
                if (intParams.size() < 4 || intParams.size() % 2 != 0)
                    return 3; // Paramètres insuffisants ou nombre impair

                if (app.getCurrentLayer() != null) {
                    int[] coordinates = new int[intParams.size()];
                    for (int i = 0; i < intParams.size(); i++) {
                        coordinates[i] = intParams.get(i);
                    }
                    PolygonShape polygon = new PolygonShape(coordinates);
                    app.getCurrentLayer().addShape(polygon);
                    return 0;
                }
                return 9; // Aucune couche active

            case "curve":
                if (intParams.size() < 8)
                    return 3; // Paramètres insuffisants

                if (app.getCurrentLayer() != null) {
                    CurveShape curve = new CurveShape(
                            intParams.get(0), intParams.get(1),
                            intParams.get(2), intParams.get(3),
                            intParams.get(4), intParams.get(5),
                            intParams.get(6), intParams.get(7));
                    app.getCurrentLayer().addShape(curve);
                    return 0;
                }
                return 9; // Aucune couche active

            case "list":
                if (strParams.size() < 1)
                    return 3; // Paramètres insuffisants

                switch (strParams.get(0).toLowerCase()) {
                    case "areas":
                        listAreas();
                        return 8;

                    case "layers":
                        if (app.getCurrentArea() != null) {
                            listLayers();
                            return 8;
                        }
                        return 9; // Aucune zone active

                    case "shapes":
                        if (app.getCurrentLayer() != null) {
                            listShapes();
                            return 8;
                        }
                        return 9; // Aucune couche active

                    default:
                        return 3; // Paramètres incorrects
                }

            case "select":
                if (strParams.size() < 1 || intParams.size() < 1)
                    return 3; // Paramètres insuffisants

                switch (strParams.get(0).toLowerCase()) {
                    case "area":
                        for (Area area : app.getAreas()) {
                            if (area.getId() == intParams.get(0)) {
                                app.setCurrentArea(area);
                                return 0;
                            }
                        }
                        return 9; // Zone non trouvée

                    case "layer":
                        if (app.getCurrentArea() != null) {
                            Layer layer = app.getCurrentArea().findLayerById(intParams.get(0));
                            if (layer != null) {
                                app.setCurrentLayer(layer);
                                return 0;
                            }
                        }
                        return 9; // Couche non trouvée

                    case "shape":
                        if (app.getCurrentLayer() != null) {
                            Shape shape = app.getCurrentLayer().findShapeById(intParams.get(0));
                            if (shape != null) {
                                app.setCurrentShape(shape);
                                return 0;
                            }
                        }
                        return 9; // Forme non trouvée

                    default:
                        return 3; // Paramètres incorrects
                }

            case "new":
                if (strParams.size() < 1)
                    return 3; // Paramètres insuffisants

                switch (strParams.get(0).toLowerCase()) {
                    case "area":
                        String areaName = strParams.size() > 1 ? strParams.get(1) : "New Area";
                        Area area = app.createArea(80, 40, areaName);
                        app.setCurrentArea(area);

                        // Ajouter une couche par défaut
                        Layer layer = new Layer((int) IdGenerator.getNextId(), "Layer 1");
                        area.addLayer(layer);
                        app.setCurrentLayer(layer);
                        return 0;

                    case "layer":
                        if (app.getCurrentArea() != null) {
                            String layerName = strParams.size() > 1 ? strParams.get(1) : "New Layer";
                            Layer newLayer = new Layer((int) IdGenerator.getNextId(), layerName);
                            app.getCurrentArea().addLayer(newLayer);
                            app.setCurrentLayer(newLayer);
                            return 0;
                        }
                        return 9; // Aucune zone active

                    default:
                        return 3; // Paramètres incorrects
                }

            case "delete":
                if (strParams.size() < 1 || intParams.size() < 1)
                    return 3; // Paramètres insuffisants

                switch (strParams.get(0).toLowerCase()) {
                    case "area":
                        for (Area area : new ArrayList<>(app.getAreas())) {
                            if (area.getId() == intParams.get(0)) {
                                app.removeArea(area);
                                return 0;
                            }
                        }
                        return 9; // Zone non trouvée

                    case "layer":
                        if (app.getCurrentArea() != null) {
                            boolean removed = app.getCurrentArea().removeLayerById(intParams.get(0));
                            if (removed) {
                                // Si la couche supprimée était la couche active, sélectionner la première
                                // couche
                                if (!app.getCurrentArea().getLayers().isEmpty()) {
                                    app.setCurrentLayer(app.getCurrentArea().getLayers().get(0));
                                } else {
                                    app.setCurrentLayer(null);
                                }
                                return 0;
                            }
                        }
                        return 9; // Couche non trouvée ou aucune zone active

                    case "shape":
                        if (app.getCurrentLayer() != null) {
                            boolean removed = app.getCurrentLayer().removeShapeById(intParams.get(0));
                            if (removed) {
                                app.setCurrentShape(null);
                                return 0;
                            }
                        }
                        return 9; // Forme non trouvée ou aucune couche active

                    default:
                        return 3; // Paramètres incorrects
                }

            case "set":
                if (strParams.size() < 2)
                    return 3; // Paramètres insuffisants

                if (strParams.get(0).equals("char")) {
                    if (intParams.isEmpty())
                        return 3; // Paramètres insuffisants

                    if (app.getCurrentArea() != null) {
                        char charValue = (char) intParams.get(0).intValue();

                        if (strParams.get(1).equals("border")) {
                            app.getCurrentArea().setFillChar(charValue);
                            return 0;
                        } else if (strParams.get(1).equals("background")) {
                            app.getCurrentArea().setEmptyChar(charValue);
                            return 0;
                        }
                    }
                } else if (strParams.get(0).equals("layer")) {
                    if (intParams.isEmpty())
                        return 3; // Paramètres insuffisants

                    if (app.getCurrentArea() != null) {
                        Layer layer = app.getCurrentArea().findLayerById(intParams.get(0));

                        if (layer != null) {
                            if (strParams.get(1).equals("visible")) {
                                layer.setVisible(true);
                                return 0;
                            } else if (strParams.get(1).equals("invisible") || strParams.get(1).equals("hidden")) {
                                layer.setVisible(false);
                                return 0;
                            }
                        }
                        return 9; // Couche non trouvée
                    }
                }
                return 3; // Paramètres incorrects

            default:
                return 1; // Commande inconnue
        }
    }

    /**
     * Affiche la liste des zones.
     */
    private void listAreas() {
        List<Area> areas = app.getAreas();

        System.out.println("Liste des zones :");
        for (Area area : areas) {
            if (area == app.getCurrentArea()) {
                System.out.print(" * ");
            } else {
                System.out.print(" - ");
            }
            System.out.printf("%3d %s %n", area.getId(), area.getName());
        }
    }

    /**
     * Affiche la liste des couches de la zone active.
     */
    private void listLayers() {
        Area area = app.getCurrentArea();
        if (area == null)
            return;

        List<Layer> layers = area.getLayers();

        System.out.println("Liste des couches de la zone " + area.getId() + " :");
        for (Layer layer : layers) {
            if (layer == app.getCurrentLayer()) {
                System.out.print(" * ");
            } else {
                System.out.print(" - ");
            }
            char visibility = layer.isVisible() ? 'V' : 'H';
            System.out.printf("%3d (%c) %s %n", layer.getId(), visibility, layer.getName());
        }
    }

    /**
     * Affiche la liste des formes de la couche active.
     */
    private void listShapes() {
        Layer layer = app.getCurrentLayer();
        if (layer == null)
            return;

        List<Shape> shapes = layer.getShapes();

        String[] shapeTypes = { "POINT", "LINE", "SQUARE", "RECTANGLE", "CIRCLE", "POLYGON", "CURVE" };

        System.out.println("Liste des formes de la couche " + layer.getId() + " :");
        for (Shape shape : shapes) {
            if (shape == app.getCurrentShape()) {
                System.out.print(" * ");
            } else {
                System.out.print(" - ");
            }
            System.out.printf("%3d : %s %s%n",
                    shape.getId(),
                    shapeTypes[shape.getShapeType().ordinal()],
                    shape.toString());
        }
    }

    /**
     * Affiche l'aide de l'application.
     */
    private void printHelp() {
        System.out.println("\t**************************************************");
        System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t**************************************************");

        System.out.println("\t==== Contrôles ====");
        System.out.println("\tclear : efface l'écran");
        System.out.println("\texit : quitte l'application");
        System.out.println("\thelp : affiche cette aide");
        System.out.println("\tplot : dessine l'écran");

        System.out.println("\t==== Dessiner des formes ====");
        System.out.println("\tpoint px py : crée un point à la position (px, py)");
        System.out.println("\tline x1 y1 x2 y2 : trace une ligne de (x1, y1) à (x2, y2)");
        System.out.println("\tsquare x1 y1 l : dessine un carré à (x1, y1) de longueur l");
        System.out.println("\trectangle x1 y1 w h : dessine un rectangle à (x1, y1) de largeur w et hauteur h");
        System.out.println("\tcircle x y r : dessine un cercle de centre (x, y) et de rayon r");
        System.out.println("\tpolygon x1 y1 x2 y2 ... : dessine un polygone");
        System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4 : dessine une courbe de Bézier");

        System.out.println("\t==== Gestion des éléments ====");
        System.out.println("\tlist {areas, layers, shapes} : liste les éléments");
        System.out.println("\tselect {area, layer, shape} {id} : sélectionne un élément par son id");
        System.out.println("\tdelete {area, layer, shape} {id} : supprime un élément par son id");
        System.out.println("\tnew {area, layer} : crée un nouvel élément");

        System.out.println("\t==== Configuration ====");
        System.out.println("\tset char {border, background} ascii_code : change le caractère utilisé");
        System.out.println("\tset layer {visible, invisible} {id} : change la visibilité d'une couche");
    }

    /**
     * Efface l'écran de la console.
     */
    private void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Pour Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Pour Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback si la commande échoue
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}