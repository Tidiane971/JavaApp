
// import java.util.function.Supplier;
import java.awt.Graphics;

/**
 * Definition d'une classe Cercle mathematique dans un plan qui peut etre
 * considere dans un repere cartesien ou polaire. Un point peut etre dessine,
 * translate. Sa longueur peut etre obtenue.
 *
 * @version $Date$
 *
 */
@SuppressWarnings("serial")
public class Cercle extends Figure {

    // Representation interne d'un cercle
    // ---------------------------------
    private Point centre; // centre du cercle
    private double rayon; // rayon du cercle

    /**
     * Construction d'un cercle à partir de son nom, des coordonnées des points de
     * son centre et de son rayon
     * 
     * @param Nom   Nom
     * @param x     abscisse du centre
     * @param y     ordonnee du centre
     * @param rayon rayon du cercle
     * 
     */

    public Cercle(String Nom, double x, double y, double rayon) {
        super(Nom);
        this.centre = new Point("Centre", x, y, true);
        this.rayon = rayon;
    }

    /**
     * Construction d'un cercle à partir de son nom de son centre et de son rayon
     * 
     * @param Nom    Nom
     * @param centre Point du centre
     * @param rayon  rayon du cercle
     * 
     */
    public Cercle(String Nom, Point centre, double rayon) {
        super(Nom);
        this.centre = centre;
        this.rayon = rayon;
    }

    /**
     * Construction d'un cercle à partir de son centre et de son rayon
     * 
     * @param centre Point du centre
     * @param rayon  rayon du cercle
     * 
     */
    public Cercle(Point centre, double rayon) {
        super("C");// Les cercles sans nom auront pour simple nom "C"
        this.centre = centre;
        this.rayon = rayon;
    }

    /**
     * Construction d'un cercle à partir de 2 points
     * 
     * @param p1 Premier point qui sert de centre
     * @param p2 Second Point
     * 
     */
    public Cercle(Point p1, Point p2) {
        super("C");
        this.centre = p1;
        this.rayon = p1.distance(p2);
    }

    /**
     * Centre du cercle
     * 
     * @return le centre du cercle
     */
    public Point getMilieu() {
        return centre;
    }

    /**
     * Rayon du cercle
     * 
     * @return le rayon du cercle
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Changer le rayon
     * 
     * @param rayon le nouveau rayon
     */
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    /** Afficher le cercle */
    public void afficher() {
        System.out.println(getNom() + " : rayon = " + rayon);
        centre.afficher();
    }

    /**
     * Translater le cercle de dx_ suivant l'axe des X et de dy_ suivant les Y.
     *
     * @param dx_ deplacement suivant l'axe des X
     * @param dy_ deplacement suivant l'axe des Y
     */
    public void translater(double dx_, double dy_) {
        centre.translater(dx_, dy_);
    }

    /**
     * Verifie l'égalité entre deux cercles
     *
     * @param autre l'autre cercle à comparer
     */

    public boolean equals(Cercle autre) {
        if (centre.equals(autre.getMilieu()) && rayon == autre.getRayon()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clonage d'un cercle
     * 
     * 
     */
    public Cercle clone() {
        Cercle C = null;
        try {
        	 C = (Cercle) super.clone();
             C.centre = centre.clone();
             C.rayon = rayon;
        }catch(CloneNotSupportedException e) {
        	System.out.println("Clonage Impossible");
        }
       
        return C;
    }

    public void paint(Graphics g) {
        g.drawOval((int) (centre.getX() - rayon) + 5, (int) (centre.getY() - rayon) + 5, (int) rayon * 2,
                (int) rayon * 2);
    }

    public boolean isAroundMouse(Point mousePoint) {
        return true;
    }
}
