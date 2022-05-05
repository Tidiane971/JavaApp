import java.util.ArrayList;
import java.util.List;

/**
 * Tester la classe Point
 *
 * @author Grandchamp Enguerran
 * @version $Date$
 */

public class test {

    /** Methode principale */
    public static void main(String args[]) {
        testPoly();
    }

    public static void testPoint() {

        // Creer et afficher un point p1
        Point p1 = new Point("p1", 3, 4);
   
        Point p2 = p1.clone();
   
        p2.translater(1,1);
        p1.afficher();
        p2.afficher();
        
    }

    public static void testSegment() {
        Segment S1 = new Segment("S1", 1.0, 2.3, 7.2, 8.2);
        Segment S2 = new Segment("S2", 0.0, 2.3, 7.2, 8.2);
        System.out.println(S1.equals(S2));
        S2.getP1().setX(1.0);
        System.out.println(S1.equals(S2));
        S1.afficher();

        S1.getMilieu().afficher();
        System.out.println("Longueur :" + S1.getLongueur());
        S1.translater(1.0, 2.0);
        S1.afficher();

        Segment S3 = S1.clone();
        S3.afficher();

    }

    public static void testCercle() {
        Cercle C1 = new Cercle("C1", 1.0, 2.0, 4.0);
        Cercle C2 = new Cercle("C2", 0.0, 2.0, 4.0);
        System.out.println(C1.equals(C2));
        C2.getMilieu().setX(1.0);
        System.out.println(C1.equals(C2));
        C1.afficher();
        C1.translater(1.0, 2.0);
        C1.afficher();
        C1.getMilieu().setX(5.0);
        C1.afficher();
        Cercle C3 = C2.clone();
        C3.afficher();
    }

    public static void testStructures() {
        Figure[] L1 = new Figure[3];
        L1[0] = new Point("P1", 10, 10);
        L1[1] = new Segment("S1", 5, 5, 8, 9);
        L1[2] = new Cercle("C1", (Point) L1[0], 5);

        for (int i = 0; i < L1.length; i++) {
            if (L1[i].getClass().getName() == "Point") {
                L1[i].afficher();
            }
        }

    }

    public static void testPoly() {
        List<Point> listpoint = new ArrayList<Point>();
        listpoint.add(new Point("P1", 1, 1));
        listpoint.add(new Point("P2", 3, 4));
        listpoint.add(new Point("P3", 5, 8));

        Polygone Poly1 = new Polygone("Poly1", listpoint);
        Polygone Poly2 = Poly1.clone();
        Poly2.translater(10, 10);
        Poly1.afficher();
        Poly2.afficher();
      
        

    }

}
