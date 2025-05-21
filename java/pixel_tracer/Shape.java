package pixel_tracer;

/**
 * Classe abstraite représentant une forme dans un espace 2D.
 */
public abstract class Shape {
    private long id;
    private ShapeType shapeType;
    private Color color;
    private float thickness;
    private double rotation;
    private boolean fill;

    /**
     * Types de formes disponibles.
     */
    public enum ShapeType {
        POINT,
        LINE,
        SQUARE,
        RECTANGLE,
        CIRCLE,
        POLYGON,
        CURVE
    }

    /**
     * Couleurs disponibles pour les formes.
     */
    public enum Color {
        BLACK,
        WHITE,
        RED,
        GREEN
    }

    /**
     * Crée une nouvelle forme avec le type spécifié.
     * 
     * @param shapeType Type de la forme
     */
    public Shape(ShapeType shapeType) {
        this.id = IdGenerator.getNextId();
        this.shapeType = shapeType;
        this.color = Color.BLACK;
        this.thickness = 1.0f;
        this.rotation = 0.0;
        this.fill = false;
    }

    /**
     * @return L'identifiant unique de la forme
     */
    public long getId() {
        return id;
    }

    /**
     * @param id Nouvel identifiant unique
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Le type de la forme
     */
    public ShapeType getShapeType() {
        return shapeType;
    }

    /**
     * @return La couleur de la forme
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color Nouvelle couleur
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return L'épaisseur du trait
     */
    public float getThickness() {
        return thickness;
    }

    /**
     * @param thickness Nouvelle épaisseur
     */
    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    /**
     * @return L'angle de rotation en degrés
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * @param rotation Nouvel angle de rotation
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /**
     * @return Si la forme est remplie ou non
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * @param fill Indique si la forme doit être remplie
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    /**
     * Convertit les informations de la forme en chaîne.
     * 
     * @return Une représentation textuelle de la forme
     */
    @Override
    public abstract String toString();
}