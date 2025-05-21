package pixel_tracer;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un polygone dans un espace 2D.
 */
public class PolygonShape extends Shape {
    private List<Point> points;

    /**
     * Crée un polygone vide.
     */
    public PolygonShape() {
        super(ShapeType.POLYGON);
        this.points = new ArrayList<>();
    }

    /**
     * Crée un polygone à partir d'un tableau de coordonnées.
     * Le tableau doit contenir des paires (x,y) et donc être de longueur paire.
     * 
     * @param coordinates Tableau de coordonnées [x1,y1,x2,y2,...]
     * @throws IllegalArgumentException si le nombre de coordonnées est impair
     */
    public PolygonShape(int[] coordinates) {
        super(ShapeType.POLYGON);

        if (coordinates.length % 2 != 0) {
            throw new IllegalArgumentException("Le tableau de coordonnées doit contenir des paires (x,y)");
        }

        this.points = new ArrayList<>();
        for (int i = 0; i < coordinates.length; i += 2) {
            addPoint(coordinates[i], coordinates[i + 1]);
        }
    }

    /**
     * Ajoute un point au polygone.
     * 
     * @param x Coordonnée X du point
     * @param y Coordonnée Y du point
     */
    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    /**
     * @return La liste des points du polygone
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * @param points Nouvelle liste de points
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * @return Le nombre de points dans le polygone
     */
    public int getPointCount() {
        return points.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon: points=[");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}