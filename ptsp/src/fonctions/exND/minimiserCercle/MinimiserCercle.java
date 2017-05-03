package fonctions.exND.minimiserCercle;

import java.util.ArrayList;

import fonctions.FonctionND;

/**
 * classe pour le probleme de fitting de pointd on dispose de points, il faut
 * trouver le cercle qui minimise l'erreur.
 * 
 * @author vthomas
 * 
 */

public class MinimiserCercle extends FonctionND {

	ArrayList<Point> liste;

	/**
	 * fonction de dimension 3 (xcentre,ycentre,rayon) trouver le point etre le
	 * plus prés des points donnés
	 */
	public MinimiserCercle() {
		// fonction de dimension 3
		super(3);

		// les points à approcher
		liste = new ArrayList<Point>();
		liste.add(new Point(1, 1));
		liste.add(new Point(1, -1));
		liste.add(new Point(-1, -1));
		liste.add(new Point(-1, 1));
	}

	/**
	 * décrit le probleme consistant à évaluer les erreurs entre les points et
	 * le cercle
	 */
	public double evaluer(double[] x) {
		//on récupere les variables (facilité ecriture)
		double xcentre=x[0];
		double ycentre=x[1];
		double rayon=x[2];
		
		//calcul erreur
		double erreur = 0;
		// pour chaque point, on ajoute erreur
		for (int i = 0; i < liste.size(); i++) {
			// distance au centre
			double d = (xcentre - liste.get(i).x) * (xcentre - liste.get(i).x);
			d += (ycentre - liste.get(i).y) * (ycentre - liste.get(i).y);

			// on retire le rayon
			d = d - rayon * rayon;
			// on ajoute la différence
			erreur += Math.abs(d);
		}
		return (erreur);
	}

}
