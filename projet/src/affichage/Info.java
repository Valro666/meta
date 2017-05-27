package affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import projet.Monochro;
import projet.Single;

public class Info extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	Monochro mono;
	JLabel nombre;
	LayoutManager mana;

	JPanel graph = new JPanel();

	public Info() {
		this.setPreferredSize(new Dimension(100, 100));
		mana = new GridLayout(2, 1);
		// mana.preferredLayoutSize(this);

		this.setLayout(mana);
		mono = Single.getInstance().mono;
		Single.getInstance().mono.addObserver(this);
		nombre = new JLabel(mono.valeur() + " ");
		this.add(nombre);
		this.add(graph);
		// this.setSize(400, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		graph.paintComponents(g);

		ArrayList<Integer> histo = Single.getInstance().historique;

		int pos = 50;
		for (Integer i : histo) {
			// g.drawLine(0, 0, pos, i);
			// pos += 50;
			// graph.paint(g);
			// g.drawLine(pos, 0, pos, i);
		}

		pos = 50;

		for (int i = 0; i < histo.size() - 1; i++) {
			g.setColor(Color.RED);
			g.drawLine(pos * i, histo.get(i), pos * i + 50, histo.get(i + 1));
			// g.drawString(histo.get(i) + " ", pos * i, histo.get(i));
			g.setColor(Color.BLACK);
			g.drawString(histo.get(i + 1) + " ", pos * i + 50, histo.get(i + 1));
		}

		repaint();
		revalidate();

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

		// this.setPreferredSize(new Dimension(500, 500));
		nombre.setText(mono.valeur() + " ");
	}

}