package pixel_tracer;

/**
 * Représente un point dans un espace 2D.
 */
public class Point {
    private int posX;
    private int posY;

    /**
     * Crée un point avec les coordonnées spécifiées.
     * 
     * @param posX La coordonnée X
     * @param posY La coordonnée Y
     */
    public Point(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * @return La coordonnée X du point
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX La nouvelle coordonnée X
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return La coordonnée Y du point
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY La nouvelle coordonnée Y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Convertit le point en chaîne de caractères.
     * 
     * @return Une représentation texte du point
     */
    @Override
    public String toString() {
        return posX + " " + posY;
    }
}