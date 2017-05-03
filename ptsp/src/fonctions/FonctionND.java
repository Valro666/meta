package fonctions;

/**
 * permet de gérer des fonctions à n-dimensions classe abstraite
 * 
 * @author vthomas
 * 
 */
public abstract class FonctionND {

	/**
	 * nombre de dimensions de la fonction
	 */
	int n;

	/**
	 * construit une fonction nb dimensions
	 * 
	 * @param nb
	 *            nombre dimensions
	 */
	public FonctionND(int nb) {
		this.n = nb;
	}

	/**
	 * méthode qui doit évaluer la valeur de la fonction
	 * 
	 * @param x
	 *            les parametres passés à la fonction sous forme d'un tableau
	 *            taille doit etre egale à this.n
	 */
	public abstract double evaluer(double[] x);

	
	/**
	 * permet d'estimer la dérivée de la fonction
	 *  
	 * @param x point où évaluer la fonction
	 * @param dim dimension de la dérivée
	 */
	public double calculerDerivee(double[] x, int dim,double dx)
	{
		//TODO  a completer etudiant
	}
	
	/**
	 * retourne le gradient de la fonction
	 * @param x endroit ou evaluer gradient
	 * 
	 * @return gradient de la fonction en x
	 */
	public double[] calculerGradient(double[] x)
	{
		//TODO  a completer etudiant 
	}
}
