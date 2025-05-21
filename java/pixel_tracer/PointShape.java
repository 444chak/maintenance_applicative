package pixel_tracer;

/**
 * Représente un point comme forme.
 */
public class PointShape extends Shape {
    private Point point;

    /**
     * Crée un point aux coordonnées spécifiées.
     * 
     * @param x La coordonnée X du point
     * @param y La coordonnée Y du point
     */
    public PointShape(int x, int y) {
        super(ShapeType.POINT);
        this.point = new Point(x, y);
    }

    /**
     * @return Le point représenté par cette forme
     */
    public Point getPoint() {
        return point;
    }

    /**
     * @param point Le nouveau point
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Point: " + point.toString();
    }
}