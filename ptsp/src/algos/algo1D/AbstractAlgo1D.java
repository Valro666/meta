package algos.algo1D;

import java.util.ArrayList;

import fonctions.Fonction1D;


/**
 * permet d'abstraire les classes de minimisation 1D
 * 
 * 
 */
public abstract class AbstractAlgo1D {

	/**
	 * la fonction à minimiser
	 */
	protected Fonction1D fonction;

	/**
	 * constructeur vide, ne fait rien
	 */
	public AbstractAlgo1D(Fonction1D f) {
		super();
		this.fonction=f;
	}

	/**
	 * methode abstraite qui retourne la liste des 
	 * points suivis
	 * 
	 * @param nbIterations nombre d'iterations 
	 * @return liste des points suivis au cours de l'algorithme
	 */
	public abstract Log minimiser(int nbIterations);

}