package pixel_tracer;

/**
 * Représente un rectangle dans un espace 2D.
 */
public class RectangleShape extends Shape {
    private Point origin;
    private int width;
    private int height;

    /**
     * Crée un rectangle avec le point d'origine, la largeur et la hauteur
     * spécifiés.
     * 
     * @param x      Coordonnée X du point d'origine
     * @param y      Coordonnée Y du point d'origine
     * @param width  Largeur du rectangle
     * @param height Hauteur du rectangle
     */
    public RectangleShape(int x, int y, int width, int height) {
        super(ShapeType.RECTANGLE);
        this.origin = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * @return Le point d'origine du rectangle
     */
    public Point getOrigin() {
        return origin;
    }

    /**
     * @param origin Nouveau point d'origine
     */
    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    /**
     * @return La largeur du rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width Nouvelle largeur
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return La hauteur du rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height Nouvelle hauteur
     */
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle: origin=" + origin.toString() +
                ", width=" + width + ", height=" + height;
    }
}