package pixel_tracer;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une couche dans l'application Pixel Tracer.
 */
public class Layer {
    private int id;
    private String name;
    private boolean visible;
    private List<Shape> shapes;

    /**
     * Crée une nouvelle couche avec l'ID et le nom spécifiés.
     * 
     * @param id   Identifiant unique de la couche
     * @param name Nom de la couche
     */
    public Layer(int id, String name) {
        this.id = id;
        this.name = name;
        this.visible = true;
        this.shapes = new ArrayList<>();
    }

    /**
     * @return L'identifiant de la couche
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
     * @return Le nom de la couche
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
     * @return true si la couche est visible, false sinon
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible Nouvelle visibilité
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return La liste des formes dans cette couche
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Ajoute une forme à la couche.
     * 
     * @param shape La forme à ajouter
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Supprime une forme de la couche.
     * 
     * @param shape La forme à supprimer
     * @return true si la forme a été trouvée et supprimée, false sinon
     */
    public boolean removeShape(Shape shape) {
        return shapes.remove(shape);
    }

    /**
     * Supprime une forme de la couche par son ID.
     * 
     * @param shapeId L'ID de la forme à supprimer
     * @return true si une forme a été trouvée et supprimée, false sinon
     */
    public boolean removeShapeById(long shapeId) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getId() == shapeId) {
                shapes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Recherche une forme par son ID.
     * 
     * @param shapeId L'ID de la forme à trouver
     * @return La forme correspondant à l'ID, ou null si aucune ne correspond
     */
    public Shape findShapeById(long shapeId) {
        for (Shape shape : shapes) {
            if (shape.getId() == shapeId) {
                return shape;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Layer[id=").append(id)
                .append(", name=").append(name)
                .append(", visible=").append(visible ? "V" : "H")
                .append(", shapes=").append(shapes.size())
                .append("]");
        return sb.toString();
    }
}