package fonctions.ex1D;

import fonctions.Fonction1D;

/**
 * redefinition pour la méthode sinus
 * 
 *
 */
public class Sinus extends Fonction1D{

	@Override
	public double evaluer(double x) {
		return Math.sin(x);
	}
	

}
