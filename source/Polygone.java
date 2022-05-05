import java.util.*;
import java.awt.Graphics;

/**
 * Definition d'une classe Polygone mathematique dans un plan qui peut etre
 * considere dans un repere cartesien ou polaire. Un point peut etre dessine,
 * translate. Sa longueur peut etre obtenue.
 *
 * @version $Date$
 *
 */
@SuppressWarnings("serial")
public class Polygone extends Figure {

    // Representation interne d'un polygone
    // ---------------------------------
    private List<Point> listpoints;// centre du cercle
    // rayon du cercle

    /**
     * Construction d'un polygone à partir de son nom et des points extrêmes qui le
     * compose
     * 
     * @param Nom    Nom
     * @param npoint les N points que l'on souhaite avoir comme point extreme du
     *               polygone
     * 
     */

    public Polygone(String Nom, List<Point> npoint) {
        super(Nom);
        this.listpoints = npoint;
    }

    /**
     * Construction d'un polygone à partir d'une liste de points
     * 
     * @param ListePoints Une liste de points
     * 
     */

    public Polygone(List<Point> ListePoints) {
        super("P"); // Les polygones sans nom auront pour simple nom "POLY"
        this.listpoints = ListePoints;
    }

    /**
     * La liste de points
     * 
     * @return la liste de points
     */
    public List<Point> getlistepoints() {
        return listpoints;
    }

    /**
     * Modifie la liste de points
     * 
     * @return la liste de points modifiée
     */
    public void setlistepoints(List<Point> points) {
        this.listpoints = points;
    }

    /** Afficher le polygone */
    public void afficher() {
        System.out.println(getNom());
        for (int i = 0; i < listpoints.size(); i++) {
            listpoints.get(i).afficher();
        }
    }

    /**
     * Translater le polygone de dx_ suivant l'axe des X et de dy_ suivant les Y.
     *
     * @param dx_ deplacement suivant l'axe des X
     * @param dy_ deplacement suivant l'axe des Y
     */
    public void translater(double dx_, double dy_) {
        for (int i = 0; i < listpoints.size() - 1; i++) {
            listpoints.get(i).translater(dx_, dy_);

        }
    }

    /**
     * Verifie l'égalité entre deux polygones
     *
     * @param autre l'autre polygone à comparer
     */

    public boolean equals(Polygone autre) {
        return true;

    }

    /**
     * Clonage d'un polygone
     * 
     * 
     */
    public Polygone clone() {
        Polygone Poly = null;
        List<Point> listpoint = new ArrayList<Point>();
        try {
            Poly = (Polygone) super.clone();
            for(int k = 0; k<this.listpoints.size();k++) {
            	listpoint.add(this.listpoints.get(k).clone());
            }
            Poly.listpoints = listpoint;
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonage Impossible");
        }

        return Poly;
    }

    public boolean add(Point p) {
        listpoints.add(p);
        return true;
    }

    public void paint(Graphics g) {
        if (listpoints.size() > 1) {
            for (int i = 0; i < listpoints.size() - 1; i++) {
                g.drawLine((int) listpoints.get(i).getX() + 5, (int) listpoints.get(i).getY() + 5,
                        (int) listpoints.get(i + 1).getX() + 5, (int) listpoints.get(i + 1).getY() + 5);
            }

        }

    }

    public boolean isAroundMouse(Point mousePoint) {
        return true;
    }
}
