import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface {
	public static void main(String args[]) {

		// DEFINTION DE LA FENETRE
		JFrame fen = new JFrame();
		fen.setSize(800, 600);
		fen.setTitle("FIGURES");

		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// CONTENU DE LA FENETRE
		Container contenu = fen.getContentPane();

		// PANEAU OUEST
		JPanel wPanel = new JPanel();
		wPanel.setBackground(Color.orange);
		wPanel.setPreferredSize(new Dimension(50, 0));
		contenu.add(wPanel, BorderLayout.WEST);

		// PANNEAU CENTRAL

		Editeur edit = new Editeur();

		contenu.add(edit, BorderLayout.CENTER);

		// CREATION BOUTTON
		Icon pointIcon = new ImageIcon("../assets/img/pointIcon.png");
		JButton btPoint = new JButton(pointIcon);
		btPoint.setBackground(Color.white);
		btPoint.setForeground(Color.cyan);
		btPoint.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btPoint);

		Icon segmentIcon = new ImageIcon("../assets/img/segmentIcon.png");
		JButton btSegment = new JButton(segmentIcon);
		btSegment.setBackground(Color.white);
		btSegment.setForeground(Color.cyan);
		btSegment.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btSegment);

		Icon cercleIcon = new ImageIcon("../assets/img/cercleIcon.png");
		JButton btCercle = new JButton(cercleIcon);
		btCercle.setBackground(Color.white);
		btCercle.setForeground(Color.cyan);
		btCercle.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btCercle);

		Icon polygoneIcon = new ImageIcon("../assets/img/polygoneIcon.png");
		JButton btPolygone = new JButton(polygoneIcon);
		btPolygone.setBackground(Color.white);
		btPolygone.setForeground(Color.cyan);
		btPolygone.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btPolygone);

		Icon cursorIcon = new ImageIcon("../assets/img/cursorIcon.png");
		JButton btSelect = new JButton(cursorIcon);
		btSelect.setBackground(Color.white);
		btSelect.setForeground(Color.cyan);
		btSelect.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btSelect);

		Icon modifIcon = new ImageIcon("../assets/img/modifIcon.png");
		JButton btModif = new JButton(modifIcon);
		btModif.setBackground(Color.white);
		btModif.setForeground(Color.cyan);
		btModif.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btModif);

		Icon moveIcon = new ImageIcon("../assets/img/moveIcon.png");
		JButton btMove = new JButton(moveIcon);
		btMove.setBackground(Color.white);
		btMove.setForeground(Color.cyan);
		btMove.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btMove);

		Icon cloneIcon = new ImageIcon("../assets/img/cloneIcon.png");
		JButton btClone = new JButton(cloneIcon);
		btClone.setBackground(Color.white);
		btClone.setForeground(Color.cyan);
		btClone.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btClone);
		btClone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clone Clique !");

				edit.cloned();

			}
		});

		Icon suppIcon = new ImageIcon("../assets/img/suppIcon.png");
		JButton btSupp = new JButton(suppIcon);
		btSupp.setBackground(Color.white);
		btSupp.setForeground(Color.cyan);
		btSupp.setBorder(BorderFactory.createEtchedBorder());
		wPanel.add(btSupp);
		btSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Supprimer Clique !");

				edit.supp();

			}

		});

		btPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Point Clique !");
				edit.chosenFigure = "Point";
				btPoint.setBackground(Color.lightGray);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.white);
			}
		});

		btSegment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Segment Clique !");
				edit.chosenFigure = "Segment";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.lightGray);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.white);

			}
		});

		btCercle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Cercle Clique !");
				edit.chosenFigure = "Cercle";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.lightGray);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.white);

			}
		});

		btPolygone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Polygone Clique !");
				edit.chosenFigure = "Polygone";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.lightGray);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.white);

			}
		});

		btSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Select Clique !");
				edit.chosenFigure = "Select";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.lightGray);

			}
		});

		btModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Modif Clique !");
				edit.chosenFigure = "Modif";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.lightGray);
				btMove.setBackground(Color.white);
				btSelect.setBackground(Color.white);

			}
		});

		btMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Move Clique !");
				edit.chosenFigure = "Move";
				btPoint.setBackground(Color.white);
				btSegment.setBackground(Color.white);
				btCercle.setBackground(Color.white);
				btPolygone.setBackground(Color.white);
				btModif.setBackground(Color.white);
				btMove.setBackground(Color.lightGray);
				btSelect.setBackground(Color.white);

			}
		});

		// EDITEUR

		fen.setVisible(true);

	}
}
