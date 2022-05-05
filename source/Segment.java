import java.awt.Graphics;

// import java.util.function.Supplier;

/**
 * Definition d'une classe segment mathematique dans un plan qui peut etre
 * considere dans un repere cartesien ou polaire. Un point peut etre dessine,
 * translate. Sa longueur peut etre obtenue.
 *
 * @author Grandchamp Enguerran
 * @version $Date$
 *
 */
@SuppressWarnings("serial")
public class Segment extends Figure {

    // Representation interne d'un segment
    // ---------------------------------
    private Point p1; // point extrême 1
    private Point p2; // point extrême 2

    /**
     * Construction d'un segment à partir de son nom et des coordonnées des points
     * extrêmes
     * 
     * @param Nom Nom
     * @param x1  abscisse de p1
     * @param y1  ordonnee de p1
     * @param x2  abscisse de p2
     * @param x2  ordonnee de p2
     */
    public Segment(String Nom, double x1, double y1, double x2, double y2) {
        super(Nom);
        this.p1 = new Point("P1", x1, y1);
        this.p2 = new Point("P2", x2, y2);
    }

    /**
     * Construction d'un segment à partir de ses points extrêmes
     * 
     * @param p1 Point 1
     * @param p2 Point 2
     */
    public Segment(Point p1, Point p2) {
        super("S"); // Les segments sans nom auront pour simple nom "S"
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Construction d'un segment à partir des coordonnées des points
     * extrêmes
     * 
     * @param x1 abscisse de p1
     * @param y1 ordonnee de p1
     * @param x2 abscisse de p2
     * @param x2 ordonnee de p2
     */
    public Segment(double x1, double y1, double x2, double y2) {
        super("S");
        this.p1 = new Point("P1", x1, y1);
        this.p2 = new Point("P2", x2, y2);
    }

    /**
     * Construction d'un segment à partir de ses points extrêmes
     * 
     * @param Nom Nom du Segment
     * @param p1  Point 1
     * @param p2  Point 2
     */
    public Segment(String Nom, Point p1, Point p2) {
        super(Nom);
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Point p1
     * 
     * @return P1 le premier point extrême
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Point p2
     * 
     * @return P2 le second point extrême
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Changer le point 1 du segment
     * 
     * @param p1 le nouveau point 1
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Changer le point 2 du segment
     * 
     * @param p2 le nouveau point 2
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Retourner le centre du segment
     * 
     */
    public Point getMilieu() {
        return new Point("Millieu", (p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    /** Afficher le segment */
    public void afficher() {
        System.out.println(getNom() + " : ");
        p1.afficher();
        p2.afficher();
    }

    /** Retourner la longueur du segment */
    public double getLongueur() {
        return p1.distance(p2);
    }

    /**
     * Translater le point de dx_ suivant l'axe des X et de dy_ suivant les Y.
     *
     * @param dx_ deplacement suivant l'axe des X
     * @param dy_ deplacement suivant l'axe des Y
     */
    public void translater(double dx_, double dy_) {
        p1.translater(dx_, dy_);
        p2.translater(dx_, dy_);
    }

    /**
     * Verifier l'égalité entre deux segments
     *
     * @param autre le segment avec lequel on veut comparer notre segment
     */

    public boolean equals(Segment autre) {
        if (p1.equals(autre.getP1()) && p2.equals(autre.getP2())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clonage d'un segment
     *
     */

    public Segment clone() {
        Segment S = null;
        try {
            S = (Segment) super.clone();
            S.p1 = (Point) p1.clone();
            S.p2 = (Point) p2.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonage Impossible");
        }

        return S;
    }

    public void paint(Graphics g) {
        g.drawLine((int) p1.getX() + 5, (int) p1.getY() + 5, (int) p2.getX() + 5, (int) p2.getY() + 5);

    }

    public boolean isAroundMouse(Point mousePoint) {
        if ((mousePoint.getX() > getMilieu().getX() - 10 && mousePoint.getX() < getMilieu().getX() + 20)
                && (mousePoint.getY() > getMilieu().getY() - 10 && mousePoint.getY() < getMilieu().getY() + 20)) {
            return true;
        }
        return false;
    }

}
