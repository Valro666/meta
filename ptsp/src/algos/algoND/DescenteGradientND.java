package algos.algoND;

import algos.algo1D.Log;
import fonctions.FonctionND;
import fonctions.exND.minimiserCercle.MinimiserCercle;

/**
 * permet d'optimiser une fonction en deux dimensions
 * 
 * @author vthomas
 * 
 */

public class DescenteGradientND {

	/**
	 * fonction à optimiser
	 */
	FonctionND fonction;

	/**
	 * pas constant
	 */
	double alpha;

	/**
	 * point de départ
	 */
	double[] depart;

	/**
	 * permet de construire une descente de gradient à plusieurs dimensions
	 * 
	 * @param f
	 *            fonction à optimiser
	 * @param dep
	 *            point de depart (vecteur double)
	 * @param pas
	 *            pas de la descente
	 */
	public DescenteGradientND(FonctionND f, double[] dep, double pas) {
		super();
		this.fonction = f;
		this.alpha = pas;
		this.depart = dep;
	}

	/**
	 * methode qui retourne la liste des points suivis
	 * 
	 * @param nbIterations
	 *            nombre d'iterations
	 * @return liste des points suivis au cours de l'algorithme
	 */
	public Log minimiser(int nbIterations) {
		//TODO  a completer par etudiants

	}

}
