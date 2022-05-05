import java.awt.Graphics;

// import java.util.function.Supplier;

/**
 * Definition d'une classe point mathematique dans un plan qui peut etre
 * considere dans un repere cartesien ou polaire. Un point peut etre dessine,
 * translate. Sa distance par rapport a un autre point peut etre obtenue.
 *
 * @version $Date$
 *
 */
@SuppressWarnings("serial")
public class Point extends Figure {

    // Representation interne d'un point
    // ---------------------------------
    private double x; // abscisse
    private double y; // ordonnee
    private boolean isCenter =false; // si le point est le centre d'un cercle


    /**
     * Construction d'un point
     * 
     */
    public Point(Point p) {
        super(p.getNom());
        this.x = p.getX();
        this.y = p.getY();

    }

    /**
     * Construction d'un point a partir de son abscisse et de son ordonnnee
     * 
     * @param x abscisse
     * @param y ordonnee
     */
    public Point(double x, double y) {
        super("P"); // Les points sans nom auront pour simple nom "P"
        this.x = x;
        this.y = y;
    }
    
    /**
     * Construction d'un point a partir de son abscisse, de son ordonnnee et de son appartenance a un cercle
     * 
     * @param x abscisse
     * @param y ordonnee
     * @param isCenter si le point est le centre d'un cercle
     */
    public Point(double x, double y, boolean isCenter) {
        super("P"); // Les points sans nom auront pour simple nom "P"
        this.x = x;
        this.y = y;
        this.isCenter = isCenter;
    }
    
    
    

    /**
     * Construction d'un point a partir de son abscisse et de son ordonnnee et de
     * son nom
     * 
     * @param x   abscisse
     * @param y   ordonnee
     * @param Nom Nom
     */

    public Point(String Nom, double x, double y) {

        super(Nom);
        this.x = x;
        this.y = y;
    }
    
    /**
     * Construction d'un point a partir de son nom, de son abscisse, de son ordonnnee et de son appartenance a un cercle
     * @param Nom om
     * @param x abscisse
     * @param y ordonnee
     * @param isCenter si le point est le centre d'un cercle
     */
    public Point(String Nom, double x, double y, boolean isCenter) {
        super(Nom); 
        this.x = x;
        this.y = y;
        this.isCenter = isCenter;
    }
    
    

    /**
     * Abscisse du point
     * 
     * @return x l'abscisse du point
     */
    public double getX() {
        return x;
    }

    /**
     * Ordonnee du point
     * 
     * @return y l'ordonnee du point
     */
    public double getY() {
        return y;
    }

    /**
     * Changer l'abscisse du point
     * 
     * @param x la nouvelle abscisse
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Changer l'ordonnee du point
     * 
     * @param y la nouvelle ordonnee
     */
    public void setY(double y) {
        this.y = y;

    }

    /**
     * Retourner le centre du point
     * 
     * @param p le point
     */
    public Point getMilieu(Point p) {
        return p;
    }
    
    /**
     * Retourner si le centre est le milieu d'un cercle
     * 
     * @param p le point
     */
    public boolean isCentre() {
        return isCenter;
    }

    /** Afficher le point */
    public void afficher() {
        System.out.print(getNom() + " : (" + x + "," + y + ")!\n");
    }

    /**
     * Distance par rapport a un autre point
     */
    public double distance(Point autre) {
        double resultat = Math.sqrt(Math.pow(autre.getX() - getX(), 2)
                + Math.pow(autre.getY() - getY(), 2));
        return resultat;
    }

    /**
     * Translater le point de dx_ suivant l'axe des X et de dy_ suivant les Y.
     *
     * @param dx_ deplacement suivant l'axe des X
     * @param dy_ deplacement suivant l'axe des Y
     */
    public void translater(double dx_, double dy_) {
        x += dx_;
        y += dy_;
    }

    /**
     * Verifie l'égalité entre deux points
     *
     * @param autre l'autre point à comparer
     */
    public boolean equals(Point autre) {
        if (x == autre.getX() && y == autre.getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clonage d'un point
     * 
     * 
     */
    public Point clone() {
        Point P = null;
        try {
        	P = (Point) super.clone();
            P.x = x;
            P.y = y;
        }catch(CloneNotSupportedException e) {
        	System.out.println("Clonage Impossible");
        }
        
        return P;
    }

    public void paint(Graphics g) {
        g.fillOval((int) x, (int) y, 10, 10);
    }

    public boolean isAroundMouse(Point mousePoint) {
        if ((mousePoint.getX() > this.getX() - 10 && mousePoint.getX() < this.getX() + 20)
                && (mousePoint.getY() > this.getY() - 10 && mousePoint.getY() < this.getY() + 20)) {
            return true;
        }
        return false;
    }

}
