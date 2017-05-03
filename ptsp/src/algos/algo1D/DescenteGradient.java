package algos.algo1D;

import java.util.ArrayList;

import fonctions.Fonction1D;

/**
 * 
 * permet de faire une descente de gradient
 * 
 * @author vthomas
 * 
 */
public class DescenteGradient extends AbstractAlgo1D {

	/**
	 * pas de la descente
	 */
	double alpha;

	/**
	 * point de départ de la recherche
	 */
	double depart;

	/**
	 * construit une descente de gradient à pas constant
	 * 
	 * @param f
	 *            fonction à minimiser
	 * @param alpha
	 *            pas de la descente
	 * @param depart
	 *            lieu de depart de la minimisation
	 */
	public DescenteGradient(Fonction1D f, double alpha, double depart) {
		super(f);
		this.alpha = alpha;
		this.depart = depart;
	}

	/**
	 * implementation de methode pour minimiser la fonction
	 */
	public Log minimiser(int nbIterations) {
		Log res = new Log();

		// TODO a completer

		return res;

	}

	/**
	 * méthode qui permet d'estimer la dérive en un point
	 * 
	 * @param x
	 *            endroit ou chercher la derivee
	 * @return estimation de la dérivée
	 */
	private double calculerDerivee(double x) {
		// TODO a completer etudiants
		return 0;
	}

}
