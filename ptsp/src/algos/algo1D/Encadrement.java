package algos.algo1D;

import java.util.ArrayList;

import fonctions.Fonction1D;

/**
 * permet de trouver le minimum d'une fonction à partir d'nu encadrement
 * 
 * appel à la methode chercher minimum en pasasnt les trois valeurs de depart
 * 
 */
public class Encadrement extends AbstractAlgo1D {

	/**
	 * les attributs qui permettent de faire la recherche
	 */
	private double a;
	private double b;
	private double c;

	/**
	 * constructeur prend en paremetre la fontion à minimiser
	 * 
	 * @param ap
	 *            parametre encadrant a gauche
	 * @param bp
	 *            parametre du centre
	 * @param cp
	 *            parametre encadrant a droite
	 * @param f
	 *            fonction à minimiser
	 */
	public Encadrement(Fonction1D f, double ap, double bp, double cp) {
		super(f);
		this.a = ap;
		this.b = bp;
		this.c = cp;

		// verification des valeurs de parametres
		if (!(ap < bp) || !(bp < cp))
			throw new IllegalArgumentException("ordre des parametres mauvais");

		if (!(f.evaluer(ap) > f.evaluer(bp)) || !(f.evaluer(cp) > f.evaluer(bp)))
			throw new IllegalArgumentException(
					"ordre des valeurs mauvais : " + f.evaluer(ap) + "," + f.evaluer(bp) + "," + f.evaluer(cp));
	}

	/**
	 * permet de trouver le min de la fonction
	 * 
	 * 
	 * @param nbIterations
	 *            nombre d'iterations à effectuer
	 * 
	 * @return les positions courantes au fur et a mesure (b dans ce cas)
	 */

	public Log minimiser(int nbIterations) {

		Log resultats = new Log();

		for (int i = 0; i < nbIterations; i++) {

			double x1 = (a + b) / 2;

			// if (i % 2 == 1) {

			if (this.fonction.evaluer(x1) < fonction.evaluer(b)) {
				b = x1;
			}

			else if (this.fonction.evaluer(x1) < fonction.evaluer(a)) {
				a = x1;
			}

			// } else {

			double x2 = (b + c) / 2;

			if (this.fonction.evaluer(x2) < fonction.evaluer(b)) {
				b = x2;
			}

			else if (this.fonction.evaluer(x2) < fonction.evaluer(c)) {
				c = x2;
			}

			// }

			resultats.ajoute(b, fonction.evaluer(b));
		}

		return resultats;
	}

	public void enc(double x, double a, double b) {

		if (this.fonction.evaluer(x) < fonction.evaluer(a)) {
			a = x;
		}

		if (this.fonction.evaluer(x) < fonction.evaluer(b)) {
			b = x;
		}

	}

	/**
	 * fait une iteration de algorithme
	 */
	void iteration() {
		// TODO ecrire une iteration de l'algorithme

	}

}
