import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class Editeur extends JPanel implements MouseListener, MouseMotionListener {
	/**
	 * ATTRIBUTS
	 */
	public ArrayList<Figure> liste;
	public String chosenFigure;
	private Point movablePoint = new Point(0, 0);

	private Point basePoint = new Point(0, 0);
	private Segment S = new Segment(movablePoint, basePoint);
	private Cercle C = new Cercle(movablePoint, 0);
	private List<Point> listpoint = new ArrayList<Point>();
	private Polygone Poly = new Polygone(listpoint);
	private String typeSelected;

	/**
	 * CONSTRUCTEUR
	 */

	public Editeur() {
		super();
		liste = new ArrayList<Figure>();
		this.setBackground(Color.WHITE);
		liste = new ArrayList<Figure>();
		this.chosenFigure = null;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		// TEST
		// liste.add(new Point(150, 450));

	}

	public void paint(Graphics g) {

		super.paint(g);

		Figure f;
		for (int i = 0; i < liste.size(); i++) {
			f = liste.get(i);
			if (f.getisSelected()) {

				g.setColor(Color.RED);

			}
			f.paint(g);
			g.setColor(Color.BLACK);
			repaint();

		}
	}

	public void mouseClicked(MouseEvent e) {

		if (this.chosenFigure == "Point") {
			movablePoint = new Point(e.getX(), e.getY());
			liste.add(movablePoint);
			repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (this.chosenFigure == "Segment") {
			basePoint = new Point(e.getX(), e.getY());
			movablePoint = new Point(e.getX(), e.getY());
			S = new Segment(basePoint, movablePoint);

			liste.add(basePoint);
			liste.add(movablePoint);
			liste.add(S);
			repaint();

		}

		else if (this.chosenFigure == "Cercle") {
			basePoint = new Point(e.getX(), e.getY(), true);
			movablePoint = new Point(e.getX(), e.getY());
			C = new Cercle(basePoint, basePoint.distance(movablePoint));

			liste.add(basePoint);
			liste.add(C);

			repaint();

		}

		else if (this.chosenFigure == "Move" || this.chosenFigure == "Select") {
			Figure f;
			typeSelected = null;
			for (Figure figure : liste) {
				figure.setisSelected(false);
			}

			for (int i = 0; i < liste.size(); i++) {
				f = liste.get(i);

				if (f instanceof Point) {
					if (f.isAroundMouse(new Point(e.getX(), e.getY()))) {

						movablePoint = (Point) f;

						if (movablePoint.isCentre()) {

							typeSelected = "Cercle";

							(liste.get(i + 1)).setisSelected(true);
							f.setisSelected(true);
							repaint();
							break;
						}

						else {

							typeSelected = "Point";

							movablePoint.setisSelected(true);
							repaint();

							for (Figure figure : liste) {
								if (figure instanceof Segment) {
									S = (Segment) figure;
									if (S.getP1().equals(movablePoint) || S.getP2().equals(movablePoint)) {
										if (S.getP1().equals(movablePoint)) {
											movablePoint = (Point) S.getP1();
										} else {
											movablePoint = (Point) S.getP2();
										}

										typeSelected = "Segment";

										S.setisSelected(true);
										S.getP1().setisSelected(true);
										S.getP2().setisSelected(true);
										repaint();
										break;

									}
								}
							}
							for (Figure figure : liste) {

								if (figure instanceof Polygone) {
									Poly = (Polygone) figure;

									for (int k = 0; k < Poly.getlistepoints().size() - 1; k++) {
										if (Poly.getlistepoints().get(k).equals(movablePoint)) {

											movablePoint = (Point) Poly.getlistepoints().get(k);
											typeSelected = "Polygone";

											Poly.setisSelected(true);
											for (Point p : Poly.getlistepoints()) {
												p.setisSelected(true);
											}
											Poly.getlistepoints().get(Poly.getlistepoints().size() - 1)
													.setisSelected(true);
											repaint();
											break;
										}
									}
									if (typeSelected == "Polygone") {
										break;
									}

								}
							}

							break;

						}

					}
				}

			}

		} else if (this.chosenFigure == "Modif") {
			Figure f;
			typeSelected = null;
			for (Figure figure : liste) {
				figure.setisSelected(false);
			}

			for (int i = 0; i < liste.size(); i++) {
				f = liste.get(i);

				if (f instanceof Point) {

					if (f.isAroundMouse(new Point(e.getX(), e.getY()))) {
						movablePoint = (Point) f;
						if (movablePoint.isCentre()) {
							C = (Cercle) liste.get(i + 1);
							basePoint = movablePoint;
							typeSelected = "Cercle";
							(liste.get(i + 1)).afficher();
							(liste.get(i + 1)).setisSelected(true);
							f.setisSelected(true);
							repaint();
							break;
						} else {

							typeSelected = "Point";
							f.afficher();
							movablePoint.setisSelected(true);
							repaint();
							break;
						}

					}

				}

			}

		}

		else if (this.chosenFigure == "Polygone") {
			movablePoint = new Point(e.getX(), e.getY());
			if (listpoint.size() == 0) {
				listpoint = new ArrayList<Point>();
				listpoint.add(movablePoint);
				Poly = new Polygone(listpoint);
				liste.add(movablePoint);
				liste.add(Poly);

			} else if (movablePoint.isAroundMouse(listpoint.get(0))) {
				listpoint.add(listpoint.get(0));
				liste.add(listpoint.get(0));

				repaint();
				listpoint = new ArrayList<Point>();

			} else {
				listpoint.add(movablePoint);
				Poly.setlistepoints(listpoint);
				liste.add(movablePoint);

			}

			repaint();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (this.chosenFigure == "Segment") {
			movablePoint.setX(e.getX());
			movablePoint.setY(e.getY());
			repaint();

		} else if (this.chosenFigure == "Cercle") {
			movablePoint.setX(e.getX());
			movablePoint.setY(e.getY());
			C.setRayon(basePoint.distance(movablePoint));
			repaint();

		} else if (this.chosenFigure == "Move" && typeSelected != null) {
			if (typeSelected == "Point" || typeSelected == "Cercle") {

				movablePoint.setX(e.getX());
				movablePoint.setY(e.getY());
				repaint();

			} else if (typeSelected == "Segment") {

				double tranlsationX = e.getX() - movablePoint.getX();
				double tranlsationY = e.getY() - movablePoint.getY();
				S.translater(tranlsationX, tranlsationY);
				movablePoint.setX(e.getX());
				movablePoint.setY(e.getY());
				repaint();
			} else if (typeSelected == "Polygone") {

				double tranlsationX = e.getX() - movablePoint.getX();
				double tranlsationY = e.getY() - movablePoint.getY();

				Poly.translater(tranlsationX, tranlsationY);
				movablePoint.setX(e.getX());
				movablePoint.setY(e.getY());
				repaint();
			}

		}

		else if (this.chosenFigure == "Modif" && typeSelected != null) {
			if (typeSelected == "Point") {
				movablePoint.setX(e.getX());
				movablePoint.setY(e.getY());

				repaint();

			} else if (typeSelected == "Cercle") {

				C.afficher();
				C.setRayon(basePoint.distance(new Point(e.getX(), e.getY())));
				repaint();
			}

		}
	}

	public void supp() {
		if (this.chosenFigure == "Select" || this.chosenFigure == "Move") {
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getisSelected()) {
					liste.get(i).setisSelected(false);
					if (typeSelected == "Segment") {

						liste.remove(liste.indexOf(S.getP1()));
						liste.remove(liste.indexOf(S.getP2()));
						liste.remove(liste.indexOf(S));

					} else if (typeSelected == "Cercle") {
						C = (Cercle) liste.get(i + 1);

						liste.remove(liste.indexOf(C));
						liste.remove(liste.indexOf(C.getMilieu()));
					}

					else if (typeSelected == "Polygone") {

						for (int k = 0; k < Poly.getlistepoints().size(); k++) {

							System.out.println("HELLO");
							liste.remove(liste.indexOf(Poly.getlistepoints().get(k)));
						}

						liste.remove(Poly);

						repaint();

					}

					else {
						liste.remove(i);
					}

					repaint();

				}

			}
		}

	}

	public void cloned() {
		if (this.chosenFigure == "Select" || this.chosenFigure == "Move") {
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getisSelected()) {

					liste.get(i).setisSelected(false);
					try {

						if (liste.get(i) instanceof Cercle) {
							C = (Cercle) liste.get(i).clone();
							C.translater(10, 10);
							liste.add(C.getMilieu());
							liste.add(C);

						} else if (liste.get(i) instanceof Segment) {
							S = (Segment) liste.get(i).clone();
							S.translater(10, 10);
							liste.add(S.getP1());
							liste.add(S.getP2());
							liste.add(S);

						} else if (liste.get(i) instanceof Polygone) {

							Poly = (Polygone) liste.get(i).clone();

							Poly.translater(10, 0);

							Poly.getlistepoints().set(Poly.getlistepoints().size() - 1, Poly.getlistepoints().get(0));

							liste.add(Poly);
							for (int k = 0; k < Poly.getlistepoints().size(); k++) {
								liste.add(Poly.getlistepoints().get(k));

							}

						}

					} catch (CloneNotSupportedException e) {
						System.out.println("Clonage Impossible");
					}

					repaint();

				}

			}

		}
	}

}
