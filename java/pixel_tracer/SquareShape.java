package pixel_tracer;

/**
 * Représente un carré dans un espace 2D.
 */
public class SquareShape extends Shape {
    private Point origin;
    private int length;

    /**
     * Crée un carré avec le point d'origine et la longueur spécifiés.
     * 
     * @param x      Coordonnée X du point d'origine
     * @param y      Coordonnée Y du point d'origine
     * @param length Longueur du côté du carré
     */
    public SquareShape(int x, int y, int length) {
        super(ShapeType.SQUARE);
        this.origin = new Point(x, y);
        this.length = length;
    }

    /**
     * @return Le point d'origine du carré
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
     * @return La longueur du côté du carré
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length Nouvelle longueur du côté
     */
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Square: origin=" + origin.toString() + ", length=" + length;
    }
}