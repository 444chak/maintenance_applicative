package pixel_tracer;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale de l'application Pixel Tracer.
 */
public class PixelTracerApp {
    private List<Area> areas;
    private Area currentArea;
    private Layer currentLayer;
    private Shape currentShape;

    /**
     * Crée une nouvelle instance de l'application Pixel Tracer.
     */
    public PixelTracerApp() {
        this.areas = new ArrayList<>();
        initApp();
    }

    /**
     * Initialise l'application avec une zone et une couche par défaut.
     */
    public void initApp() {
        // Chargement de l'ID à partir du fichier ou initialisation à 0
        IdGenerator.loadId();

        // Création d'une zone par défaut
        Area defaultArea = new Area(80, 40, (int) IdGenerator.getNextId(), "Area1");
        areas.add(defaultArea);
        currentArea = defaultArea;

        // Création d'une couche par défaut dans la zone
        Layer defaultLayer = new Layer((int) IdGenerator.getNextId(), "Layer 1");
        defaultArea.addLayer(defaultLayer);
        currentLayer = defaultLayer;

        currentShape = null;
    }

    /**
     * Nettoie les ressources avant de quitter l'application.
     */
    public void destroy() {
        // Sauvegarde de l'ID actuel
        IdGenerator.saveId();

        // Libération des ressources (pas nécessaire en Java, mais pour respecter le
        // modèle C)
        areas.clear();
        currentArea = null;
        currentLayer = null;
        currentShape = null;
    }

    /**
     * @return La liste des zones
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * @return La zone active
     */
    public Area getCurrentArea() {
        return currentArea;
    }

    /**
     * @param area La nouvelle zone active
     */
    public void setCurrentArea(Area area) {
        if (areas.contains(area)) {
            currentArea = area;
            if (!area.getLayers().isEmpty()) {
                currentLayer = area.getLayers().get(0);
            } else {
                currentLayer = null;
            }
            currentShape = null;
        }
    }

    /**
     * @return La couche active
     */
    public Layer getCurrentLayer() {
        return currentLayer;
    }

    /**
     * @param layer La nouvelle couche active
     */
    public void setCurrentLayer(Layer layer) {
        if (currentArea != null && currentArea.getLayers().contains(layer)) {
            currentLayer = layer;
            currentShape = null;
        }
    }

    /**
     * @return La forme active
     */
    public Shape getCurrentShape() {
        return currentShape;
    }

    /**
     * @param shape La nouvelle forme active
     */
    public void setCurrentShape(Shape shape) {
        if (currentLayer != null && currentLayer.getShapes().contains(shape)) {
            currentShape = shape;
        }
    }

    /**
     * Ajoute une nouvelle zone à l'application.
     * 
     * @param area La zone à ajouter
     */
    public void addArea(Area area) {
        areas.add(area);
    }

    /**
     * Crée et ajoute une nouvelle zone avec les dimensions spécifiées.
     * 
     * @param width  Largeur de la zone
     * @param height Hauteur de la zone
     * @param name   Nom de la zone
     * @return La zone créée
     */
    public Area createArea(int width, int height, String name) {
        Area newArea = new Area(width, height, (int) IdGenerator.getNextId(), name);
        areas.add(newArea);
        return newArea;
    }

    /**
     * Supprime une zone de l'application.
     * 
     * @param area La zone à supprimer
     * @return true si la zone a été trouvée et supprimée, false sinon
     */
    public boolean removeArea(Area area) {
        if (currentArea == area) {
            if (!areas.isEmpty() && areas.get(0) != area) {
                currentArea = areas.get(0);
            } else if (areas.size() > 1) {
                currentArea = areas.get(1);
            } else {
                currentArea = null;
            }
            currentLayer = currentArea != null && !currentArea.getLayers().isEmpty() ? currentArea.getLayers().get(0)
                    : null;
            currentShape = null;
        }
        return areas.remove(area);
    }

    /**
     * Point d'entrée principal de l'application.
     * 
     * @param args Arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        PixelTracerApp app = new PixelTracerApp();

        // Créer le processeur de commandes
        CommandProcessor cmdProcessor = new CommandProcessor(app);

        // Démarrer l'application en mode interactif
        cmdProcessor.startInteractive();

        // Nettoyer avant de quitter
        app.destroy();
    }

    /**
     * Effectue le rendu de la zone courante en dessinant toutes les formes
     * de toutes les couches visibles.
     */
    public void renderCurrentArea() {
        if (currentArea == null)
            return;

        // Nettoie la grille
        currentArea.clearGrid();

        // Pour chaque couche visible, dessine ses formes
        for (Layer layer : currentArea.getLayers()) {
            if (layer.isVisible()) {
                renderLayer(layer);
            }
        }
    }

    /**
     * Effectue le rendu d'une couche en dessinant toutes ses formes.
     * 
     * @param layer La couche à rendre
     */
    private void renderLayer(Layer layer) {
        if (currentArea == null || layer == null)
            return;

        // Pour chaque forme, dessine ses pixels dans la grille
        for (Shape shape : layer.getShapes()) {
            renderShape(shape);
        }
    }

    /**
     * Effectue le rendu d'une forme en définissant les cellules de la grille.
     * Ceci est une implémentation simplifiée qui n'utilise que des caractères.
     * 
     * @param shape La forme à rendre
     */
    private void renderShape(Shape shape) {
        if (currentArea == null || shape == null)
            return;

        int width = currentArea.getWidth();
        int height = currentArea.getHeight();

        switch (shape.getShapeType()) {
            case POINT:
                renderPoint((PointShape) shape);
                break;
            case LINE:
                renderLine((LineShape) shape);
                break;
            case SQUARE:
                renderSquare((SquareShape) shape);
                break;
            case RECTANGLE:
                renderRectangle((RectangleShape) shape);
                break;
            case CIRCLE:
                renderCircle((CircleShape) shape);
                break;
            case POLYGON:
                renderPolygon((PolygonShape) shape);
                break;
            case CURVE:
                renderCurve((CurveShape) shape);
                break;
        }
    }

    /**
     * Dessine un point sur la grille.
     * 
     * @param point La forme point à dessiner
     */
    private void renderPoint(PointShape point) {
        int x = point.getPoint().getPosX();
        int y = point.getPoint().getPosY();

        if (x >= 0 && x < currentArea.getWidth() &&
                y >= 0 && y < currentArea.getHeight()) {
            currentArea.setCell(x, y, currentArea.getFillChar());
        }
    }

    /**
     * Dessine une ligne sur la grille en utilisant l'algorithme de Bresenham.
     * 
     * @param line La forme ligne à dessiner
     */
    private void renderLine(LineShape line) {
        int x0 = line.getP1().getPosX();
        int y0 = line.getP1().getPosY();
        int x1 = line.getP2().getPosX();
        int y1 = line.getP2().getPosY();

        // Algorithme de Bresenham pour tracer une ligne
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (x0 >= 0 && x0 < currentArea.getWidth() &&
                    y0 >= 0 && y0 < currentArea.getHeight()) {
                currentArea.setCell(x0, y0, currentArea.getFillChar());
            }

            if (x0 == x1 && y0 == y1)
                break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    /**
     * Dessine un carré sur la grille.
     * 
     * @param square La forme carré à dessiner
     */
    private void renderSquare(SquareShape square) {
        int x = square.getOrigin().getPosX();
        int y = square.getOrigin().getPosY();
        int length = square.getLength();

        // Dessine les quatre côtés du carré
        for (int i = 0; i < length; i++) {
            // Ligne horizontale supérieure
            if (x + i >= 0 && x + i < currentArea.getWidth() && y >= 0 && y < currentArea.getHeight()) {
                currentArea.setCell(x + i, y, currentArea.getFillChar());
            }

            // Ligne horizontale inférieure
            if (x + i >= 0 && x + i < currentArea.getWidth() && y + length - 1 >= 0
                    && y + length - 1 < currentArea.getHeight()) {
                currentArea.setCell(x + i, y + length - 1, currentArea.getFillChar());
            }

            // Ligne verticale gauche
            if (x >= 0 && x < currentArea.getWidth() && y + i >= 0 && y + i < currentArea.getHeight()) {
                currentArea.setCell(x, y + i, currentArea.getFillChar());
            }

            // Ligne verticale droite
            if (x + length - 1 >= 0 && x + length - 1 < currentArea.getWidth() && y + i >= 0
                    && y + i < currentArea.getHeight()) {
                currentArea.setCell(x + length - 1, y + i, currentArea.getFillChar());
            }
        }
    }

    /**
     * Dessine un rectangle sur la grille.
     * 
     * @param rectangle La forme rectangle à dessiner
     */
    private void renderRectangle(RectangleShape rectangle) {
        int x = rectangle.getOrigin().getPosX();
        int y = rectangle.getOrigin().getPosY();
        int width = rectangle.getWidth();
        int height = rectangle.getHeight();

        // Dessine les quatre côtés du rectangle
        for (int i = 0; i < width; i++) {
            // Ligne horizontale supérieure
            if (x + i >= 0 && x + i < currentArea.getWidth() && y >= 0 && y < currentArea.getHeight()) {
                currentArea.setCell(x + i, y, currentArea.getFillChar());
            }

            // Ligne horizontale inférieure
            if (x + i >= 0 && x + i < currentArea.getWidth() && y + height - 1 >= 0
                    && y + height - 1 < currentArea.getHeight()) {
                currentArea.setCell(x + i, y + height - 1, currentArea.getFillChar());
            }
        }

        for (int i = 0; i < height; i++) {
            // Ligne verticale gauche
            if (x >= 0 && x < currentArea.getWidth() && y + i >= 0 && y + i < currentArea.getHeight()) {
                currentArea.setCell(x, y + i, currentArea.getFillChar());
            }

            // Ligne verticale droite
            if (x + width - 1 >= 0 && x + width - 1 < currentArea.getWidth() && y + i >= 0
                    && y + i < currentArea.getHeight()) {
                currentArea.setCell(x + width - 1, y + i, currentArea.getFillChar());
            }
        }
    }

    /**
     * Dessine un cercle sur la grille en utilisant l'algorithme de Bresenham.
     * 
     * @param circle La forme cercle à dessiner
     */
    private void renderCircle(CircleShape circle) {
        int xc = circle.getCenter().getPosX();
        int yc = circle.getCenter().getPosY();
        int r = circle.getRadius();

        int x = 0;
        int y = r;
        int d = 3 - 2 * r;

        drawCirclePoints(xc, yc, x, y);

        while (y >= x) {
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            drawCirclePoints(xc, yc, x, y);
        }
    }

    /**
     * Dessine les huit points symétriques d'un cercle.
     */
    private void drawCirclePoints(int xc, int yc, int x, int y) {
        setPixel(xc + x, yc + y);
        setPixel(xc - x, yc + y);
        setPixel(xc + x, yc - y);
        setPixel(xc - x, yc - y);
        setPixel(xc + y, yc + x);
        setPixel(xc - y, yc + x);
        setPixel(xc + y, yc - x);
        setPixel(xc - y, yc - x);
    }

    /**
     * Définit un pixel sur la grille s'il est dans les limites.
     */
    private void setPixel(int x, int y) {
        if (x >= 0 && x < currentArea.getWidth() && y >= 0 && y < currentArea.getHeight()) {
            currentArea.setCell(x, y, currentArea.getFillChar());
        }
    }

    /**
     * Dessine un polygone sur la grille.
     * 
     * @param polygon La forme polygone à dessiner
     */
    private void renderPolygon(PolygonShape polygon) {
        List<Point> points = polygon.getPoints();
        int size = points.size();

        if (size < 2)
            return;

        // Dessine les segments entre les points consécutifs
        for (int i = 0; i < size; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % size); // Connecte le dernier point au premier

            // Utilise l'algorithme de ligne pour tracer chaque segment
            LineShape line = new LineShape(p1.getPosX(), p1.getPosY(), p2.getPosX(), p2.getPosY());
            renderLine(line);
        }
    }

    /**
     * Dessine une courbe de Bézier sur la grille.
     * Cette méthode utilise une approximation simple.
     * 
     * @param curve La courbe à dessiner
     */
    private void renderCurve(CurveShape curve) {
        // Pour une courbe de Bézier cubique, on peut utiliser une approximation
        // en traçant plusieurs petits segments de ligne
        Point p1 = curve.getP1();
        Point p2 = curve.getP2();
        Point p3 = curve.getP3();
        Point p4 = curve.getP4();

        // Nombre de segments pour l'approximation
        int steps = 30;

        for (int i = 0; i < steps; i++) {
            float t1 = (float) i / steps;
            float t2 = (float) (i + 1) / steps;

            // Calcul des points sur la courbe
            int x1 = bezierPoint(p1.getPosX(), p2.getPosX(), p3.getPosX(), p4.getPosX(), t1);
            int y1 = bezierPoint(p1.getPosY(), p2.getPosY(), p3.getPosY(), p4.getPosY(), t1);
            int x2 = bezierPoint(p1.getPosX(), p2.getPosX(), p3.getPosX(), p4.getPosX(), t2);
            int y2 = bezierPoint(p1.getPosY(), p2.getPosY(), p3.getPosY(), p4.getPosY(), t2);

            // Trace un segment entre les deux points
            LineShape line = new LineShape(x1, y1, x2, y2);
            renderLine(line);
        }
    }

    /**
     * Calcule un point sur une courbe de Bézier.
     * 
     * @param a Premier point de contrôle
     * @param b Deuxième point de contrôle
     * @param c Troisième point de contrôle
     * @param d Quatrième point de contrôle
     * @param t Paramètre de la courbe (entre 0 et 1)
     * @return Valeur du point à la position t
     */
    private int bezierPoint(int a, int b, int c, int d, float t) {
        float t1 = 1.0f - t;
        return (int) (a * t1 * t1 * t1 +
                3 * b * t * t1 * t1 +
                3 * c * t * t * t1 +
                d * t * t * t);
    }

    /**
     * Redimensionne la zone courante.
     * 
     * @param newWidth  Nouvelle largeur
     * @param newHeight Nouvelle hauteur
     * @return true si le redimensionnement a réussi, false sinon
     */
    public boolean resizeCurrentArea(int newWidth, int newHeight) {
        if (currentArea == null || newWidth <= 0 || newHeight <= 0) {
            return false;
        }
        currentArea.resize(newWidth, newHeight);
        return true;
    }
}