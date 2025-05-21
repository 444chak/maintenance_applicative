package pixel_tracer;

/**
 * Représente un cercle dans un espace 2D.
 */
public class CircleShape extends Shape {
    private Point center;
    private int radius;

    /**
     * Crée un cercle avec le centre et le rayon spécifiés.
     * 
     * @param x      Coordonnée X du centre
     * @param y      Coordonnée Y du centre
     * @param radius Rayon du cercle
     */
    public CircleShape(int x, int y, int radius) {
        super(ShapeType.CIRCLE);
        this.center = new Point(x, y);
        this.radius = radius;
    }

    /**
     * @return Le centre du cercle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @param center Nouveau centre
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * @return Le rayon du cercle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius Nouveau rayon
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle: center=" + center.toString() + ", radius=" + radius;
    }
}