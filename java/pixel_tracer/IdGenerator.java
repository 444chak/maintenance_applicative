package pixel_tracer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Générateur d'identifiants uniques pour les objets.
 */
public class IdGenerator {
    private static long currentId = 0;
    private static final String ID_FILE = "id.txt";

    /**
     * Obtient le prochain identifiant disponible
     * 
     * @return Un nouvel identifiant unique
     */
    public static synchronized long getNextId() {
        return ++currentId;
    }

    /**
     * Définit l'identifiant courant
     * 
     * @param id La valeur à utiliser comme prochain id
     */
    public static synchronized void setId(long id) {
        currentId = id;
    }

    /**
     * Sauvegarde l'identifiant courant dans un fichier
     */
    public static void saveId() {
        try (FileWriter writer = new FileWriter(ID_FILE)) {
            writer.write(Long.toString(currentId));
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de l'ID: " + e.getMessage());
        }
    }

    /**
     * Charge l'identifiant depuis un fichier
     */
    public static void loadId() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(ID_FILE)));
            currentId = Long.parseLong(content.trim());
        } catch (IOException | NumberFormatException e) {
            // Si le fichier n'existe pas ou est invalide, on commence à 0
            currentId = 0;
        }
    }
}