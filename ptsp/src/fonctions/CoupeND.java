package fonctions;

/**
 * permet de calculer une coupe d'une fonction à nD
 * 
 * @author vthomas
 * 
 */
public class CoupeND extends Fonction1D {

	/**
	 * la fonction dont on calcule la coupeND
	 */
	FonctionND fonction;

	/**
	 * l'endroit ou effectuer la coupe
	 */
	double[] x;

	/**
	 * le gradient en x estimé une seule fois
	 */
	public double[] gradient;

	/**
	 * construit une coupe en 1D d'une fonction à plusieurs dimensions en
	 * suivant le gradient
	 * 
	 * @param f
	 *            la fonction dont on veut la coupe
	 * 
	 * @param px
	 *            l'endroit ou faire la coupe
	 */
	public CoupeND(FonctionND f, double[] px) {
		
		//TODO  a completer
	}

	/**
	 * evalue la valeur de la coupe en se daplacant de t
	 * selon cet axe
	 */
	public double evaluer(double t) {
		//TODO  a completer
	}

}
