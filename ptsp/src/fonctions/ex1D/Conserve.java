package fonctions.ex1D;

import fonctions.Fonction1D;

/**
 * probleme conserve
 * 
 * @author vthomas
 *
 */
public class Conserve extends Fonction1D {

	/**
	 * volume de la conserve à construire
	 */
	double volume;

	/**
	 * constructeur de probleme de conserve
	 * 
	 * @param pVolume
	 *            volume de la conserve
	 */
	public Conserve(double pVolume) {
		this.volume = pVolume;
	}

	@Override
	public double evaluer(double x) {

		// TODO a ecrire

		double r = (((volume * 2) / x) + (2 * Math.PI * x * x));

		// h pi r^2 = vol

		return r;
	}

}
