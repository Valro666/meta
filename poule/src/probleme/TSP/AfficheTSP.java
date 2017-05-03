package probleme.TSP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import generic.AlgorithmeAbstract;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algo.Greedy;
import algo.RecuitSimule;


public class AfficheTSP extends JPanel {

	private static final int DECALAGE = 100;
	// le probleme à afficher
	TSP problemeAAfficher;
	// la solution
	SolutionTSP solutionCourante;

	// lien vers les algorithmes
	AlgorithmeAbstract greedy;
	RecuitSimule recuitSimule;
	AlgorithmeAbstract taboue;
	AlgorithmeAbstract taboueAttribut;

	public AfficheTSP(TSP probleme, SolutionTSP solutionInitiale) {
		this.problemeAAfficher = probleme;
		this.solutionCourante = solutionInitiale;

		// Jpanel
		JPanel contenu = new JPanel();
		contenu.setLayout(new BorderLayout());
		contenu.add(this, BorderLayout.CENTER);

		// JButton pour greedy
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new BorderLayout());
		JButton boutonGreedy = creerBoutonGreedy();
		panelBoutons.add(boutonGreedy, BorderLayout.NORTH);
		JButton boutonRecuit = creerBoutonRecuit();
		panelBoutons.add(boutonRecuit, BorderLayout.CENTER);
		contenu.add(panelBoutons, BorderLayout.SOUTH);

		// construction JFrame
		JFrame f = new JFrame();
		f.setContentPane(contenu);
		int tailleFenetre = problemeAAfficher.taillePlan + 2*DECALAGE;
		Dimension dimensions = new Dimension(tailleFenetre, tailleFenetre);
		this.setPreferredSize(dimensions);
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton creerBoutonGreedy() {
		// creation de l'algorithme
	    this.greedy = new Greedy(problemeAAfficher, solutionCourante, 10000);
		// creation du bouton
		JButton boutonGreedy = new JButton("greedy");
		boutonGreedy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				greedy.amelioreSolution();
				solutionCourante = (SolutionTSP) greedy.getSolutionEnCours();
				System.out.println(greedy.log());
				repaint();
			}
		});
		return boutonGreedy;
	}

	private JButton creerBoutonRecuit() {
		final int nbIteration = 100;
		String nombouton = "recuit simule (*" + nbIteration + ")";
		JButton boutonRecuit = new JButton(nombouton);
		this.recuitSimule = new RecuitSimule(problemeAAfficher,
						     solutionCourante, 10000, 10000);
		this.recuitSimule.DELTA_TEMPERATURE=0.999;
		boutonRecuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < nbIteration; i++) {
					recuitSimule.amelioreSolution();
				}
				solutionCourante = (SolutionTSP) recuitSimule
						.getSolutionEnCours();
				System.out.println(recuitSimule.log());
				repaint();
			}
		});
		return boutonRecuit;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		dessinChemins(g);
		dessinVilles(g);
		
	}

	private void dessinChemins(Graphics g) {
		g.setColor(Color.blue);
		ArrayList<Ville> villesSolution = solutionCourante.listeVilles;
		Ville depart=villesSolution.get(villesSolution.size()-1);
		for (int i=0;i<villesSolution.size();i++)
		{
			Ville arrivee=villesSolution.get(i);
			g.drawLine(depart.x+DECALAGE, depart.y+DECALAGE, arrivee.x+DECALAGE, arrivee.y+DECALAGE);
			depart=arrivee;
		}
	}

	private void dessinVilles(Graphics g) {
		g.setColor(Color.black);
		for (int i = 0; i < problemeAAfficher.nombreVilles; i++) {
			Ville v = problemeAAfficher.listeVilles.get(i);
			int TAILLEVILLE = 4;
			int DEMI = TAILLEVILLE / 2;
			g.fillOval(v.x - DEMI + DECALAGE, v.y - DEMI + DECALAGE,
					TAILLEVILLE, TAILLEVILLE);
		}
	}

}
