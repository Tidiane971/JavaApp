
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Classe Figure. Represente une figure geometrique.
 * Possede un centre et fournit un methode de translation
 * 
 */

@SuppressWarnings("serial")
public abstract class Figure implements Cloneable, Serializable {

    private String Nom;
    private boolean isSelected;

    /**
     * Construction d'une figure à partir de son nom
     * 
     * @param Nom        Nom
     * @param isSelected Si la figure est sélectionnée ou non
     */

    public Figure(String Nom) {
        this.Nom = Nom;
        this.isSelected = false;
    }

    public boolean getisSelected() {
        return this.isSelected;
    }

    public void setisSelected(boolean selec) {
        this.isSelected = selec;
    }

    /**
     * Clonage d'une figure
     * 
     * 
     */
    public Figure clone() throws CloneNotSupportedException {
        Figure F = null;
        F = (Figure) super.clone();
        return F;
    }

    /**
     * Centre de la figure geometrique
     * 
     * @see Point
     */
    protected Point centre;

    /**
     * Fonction renvoyant le centre de la Figure
     * 
     */

    public Point getMilieu() {
        return centre;
    };

    /**
     * Fonction renvoyant lle nom de la figure
     * 
     */

    public String getNom() {
        return Nom;
    };

    public void setNom(String Nom) {
        this.Nom = Nom;
    };

    /**
     * Fonction de translation de la figure geometrique
     * 
     * @param dx valeur de la translation en X
     * @param dy valeur de la translation en Y
     */
    public abstract void translater(double dx, double dy);

    /**
     * Fonction d'affichage de la figure geometrique.
     * A l'avenir, devrait etre une fonction graphique
     * ici juste un System.out.println()
     */
    public abstract void afficher();

    /**
     * Fonction de dessin dans une interface graphique
     */
    public abstract void paint(Graphics g);

    public abstract boolean isAroundMouse(Point mousePoint);
}
