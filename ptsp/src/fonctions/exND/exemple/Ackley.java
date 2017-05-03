package fonctions.exND.exemple;

import fonctions.FonctionND;

//minimum en 0,0 avec pour valeur 0
public class Ackley extends FonctionND {

	/**
	 * fonction à deux dimensions
	 */
	public Ackley() {
		super(2);
	}

	/**
	 * définit la maniere d'évaluler la fonction
	 */
	public double evaluer(double[] val) {
		double x=val[0];
		double y=val[1];
		
		double res=-20*Math.exp(-0.2*Math.sqrt((1./2)*(x*x+y*y)));
		res+= -Math.exp(1./2*(Math.cos(x*Math.PI*2)+Math.cos(y*Math.PI*2)));
		res+=20+Math.exp(1);
		
		return(res);
	}

}
