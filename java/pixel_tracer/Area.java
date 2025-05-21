package pixel_tracer;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une zone de dessin dans l'application Pixel Tracer.
 */
public class Area {
    private int id;
    private String name;
    private int width;
    private int height;
    private List<Layer> layers;
    private char emptyChar;
    private char fillChar;
    private char[][] grid;

    /**
     * Crée une nouvelle zone avec la largeur, hauteur, ID et nom spécifiés.
     * 
     * @param width  Largeur de la zone
     * @param height Hauteur de la zone
     * @param id     Identifiant unique de la zone
     * @param name   Nom de la zone
     */
    public Area(int width, int height, int id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fillChar = '@';

        // Initialisation de la grille
        this.grid = new char[height][width];
        clearGrid();
    }

    /**
     * Initialise la grille avec le caractère vide.
     */
    public void clearGrid() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = emptyChar;
            }
        }
    }

    /**
     * @return L'identifiant de la zone
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Nouvel identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Le nom de la zone
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Nouveau nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return La largeur de la zone
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return La hauteur de la zone
     */
    public int getHeight() {
        return height;
    }

    /**
     * Redimensionne la grille.
     * 
     * @param newWidth  Nouvelle largeur
     * @param newHeight Nouvelle hauteur
     */
    public void resize(int newWidth, int newHeight) {
        char[][] newGrid = new char[newHeight][newWidth];

        // Copie des données existantes
        for (int y = 0; y < Math.min(height, newHeight); y++) {
            for (int x = 0; x < Math.min(width, newWidth); x++) {
                newGrid[y][x] = grid[y][x];
            }
        }

        // Initialisation des nouvelles cellules
        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                if (y >= height || x >= width) {
                    newGrid[y][x] = emptyChar;
                }
            }
        }

        this.grid = newGrid;
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * @return Le caractère utilisé pour les cellules vides
     */
    public char getEmptyChar() {
        return emptyChar;
    }

    /**
     * @param emptyChar Nouveau caractère pour les cellules vides
     */
    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    /**
     * @return Le caractère utilisé pour les cellules remplies
     */
    public char getFillChar() {
        return fillChar;
    }

    /**
     * @param fillChar Nouveau caractère pour les cellules remplies
     */
    public void setFillChar(char fillChar) {
        this.fillChar = fillChar;
    }

    /**
     * @return La liste des couches de cette zone
     */
    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * Ajoute une couche à la zone.
     * 
     * @param layer La couche à ajouter
     */
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    /**
     * Supprime une couche de la zone.
     * 
     * @param layer La couche à supprimer
     * @return true si la couche a été trouvée et supprimée, false sinon
     */
    public boolean removeLayer(Layer layer) {
        return layers.remove(layer);
    }

    /**
     * Supprime une couche de la zone par son ID.
     * 
     * @param layerId L'ID de la couche à supprimer
     * @return true si une couche a été trouvée et supprimée, false sinon
     */
    public boolean removeLayerById(int layerId) {
        for (int i = 0; i < layers.size(); i++) {
            if (layers.get(i).getId() == layerId) {
                layers.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Recherche une couche par son ID.
     * 
     * @param layerId L'ID de la couche à trouver
     * @return La couche correspondant à l'ID, ou null si aucune ne correspond
     */
    public Layer findLayerById(int layerId) {
        for (Layer layer : layers) {
            if (layer.getId() == layerId) {
                return layer;
            }
        }
        return null;
    }

    /**
     * Accède à une cellule de la grille.
     * 
     * @param x Coordonnée X
     * @param y Coordonnée Y
     * @return Le caractère à la position (x, y)
     * @throws IndexOutOfBoundsException si les coordonnées sont hors limites
     */
    public char getCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Coordonnées hors limites: (" + x + ", " + y + ")");
        }
        return grid[y][x];
    }

    /**
     * Définit le caractère d'une cellule de la grille.
     * 
     * @param x     Coordonnée X
     * @param y     Coordonnée Y
     * @param value Le caractère à placer
     * @throws IndexOutOfBoundsException si les coordonnées sont hors limites
     */
    public void setCell(int x, int y, char value) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Coordonnées hors limites: (" + x + ", " + y + ")");
        }
        grid[y][x] = value;
    }

    /**
     * Affiche la grille dans la console.
     */
    public void draw() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Area[id=" + id + ", name=" + name +
                ", size=" + width + "x" + height +
                ", layers=" + layers.size() + "]";
    }
}