package pixel_tracer;

/**
 * Représente une ligne dans un espace 2D.
 */
public class LineShape extends Shape {
    private Point p1;
    private Point p2;

    /**
     * Crée une ligne entre deux points.
     * 
     * @param x1 Coordonnée X du premier point
     * @param y1 Coordonnée Y du premier point
     * @param x2 Coordonnée X du second point
     * @param y2 Coordonnée Y du second point
     */
    public LineShape(int x1, int y1, int x2, int y2) {
        super(ShapeType.LINE);
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    /**
     * @return Le premier point de la ligne
     */
    public Point getP1() {
        return p1;
    }

    /**
     * @param p1 Nouveau premier point
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * @return Le second point de la ligne
     */
    public Point getP2() {
        return p2;
    }

    /**
     * @param p2 Nouveau second point
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Line: " + p1.toString() + " to " + p2.toString();
    }
}