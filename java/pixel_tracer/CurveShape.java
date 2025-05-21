package pixel_tracer;

/**
 * Représente une courbe de Bézier dans un espace 2D.
 */
public class CurveShape extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    /**
     * Crée une courbe de Bézier avec les quatre points de contrôle spécifiés.
     * 
     * @param x1 Coordonnée X du premier point
     * @param y1 Coordonnée Y du premier point
     * @param x2 Coordonnée X du deuxième point
     * @param y2 Coordonnée Y du deuxième point
     * @param x3 Coordonnée X du troisième point
     * @param y3 Coordonnée Y du troisième point
     * @param x4 Coordonnée X du quatrième point
     * @param y4 Coordonnée Y du quatrième point
     */
    public CurveShape(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(ShapeType.CURVE);
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
        this.p3 = new Point(x3, y3);
        this.p4 = new Point(x4, y4);
    }

    /**
     * @return Le premier point de contrôle
     */
    public Point getP1() {
        return p1;
    }

    /**
     * @param p1 Nouveau premier point de contrôle
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * @return Le deuxième point de contrôle
     */
    public Point getP2() {
        return p2;
    }

    /**
     * @param p2 Nouveau deuxième point de contrôle
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * @return Le troisième point de contrôle
     */
    public Point getP3() {
        return p3;
    }

    /**
     * @param p3 Nouveau troisième point de contrôle
     */
    public void setP3(Point p3) {
        this.p3 = p3;
    }

    /**
     * @return Le quatrième point de contrôle
     */
    public Point getP4() {
        return p4;
    }

    /**
     * @param p4 Nouveau quatrième point de contrôle
     */
    public void setP4(Point p4) {
        this.p4 = p4;
    }

    @Override
    public String toString() {
        return "Curve: p1=" + p1.toString() + ", p2=" + p2.toString() +
                ", p3=" + p3.toString() + ", p4=" + p4.toString();
    }
}