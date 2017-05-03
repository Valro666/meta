package algos.algoND;

import algos.algo1D.DescenteGradient;
import algos.algo1D.Encadrement;
import algos.algo1D.Log;
import fonctions.CoupeND;
import fonctions.Fonction1D;
import fonctions.FonctionND;
import fonctions.exND.minimiserCercle.MinimiserCercle;

/**
 * permet d'optimiser une fonction en deux dimensions
 * @author vthomas
 *
 */

public class GradientNDPasOptimal {

	/**
	 * fonction à optimiser
	 */
	FonctionND f;
	
	/**
	 * pas constant
	 */
	double alpha;
	
	/**
	 * point de départ
	 */
	double[] dep;
	

	public GradientNDPasOptimal(FonctionND f,double[] val, double a) {
		super();
		this.f = f;
		alpha=a;
		this.dep=val;
	}
	
	/**
	 * methode abstraite qui retourne la liste des 
	 * points suivis
	 * 
	 * @param nbIterations nombre d'iterations 
	 * @return liste des points suivis au cours de l'algorithme
	 */
	public Log minimiser(int nbIterations){
		//TODO  a completer
	}
	
}
