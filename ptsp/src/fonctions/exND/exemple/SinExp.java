package fonctions.exND.exemple;

import fonctions.FonctionND;

public class SinExp extends FonctionND{

	//trouver min entre -2 et 2
	
	/**
	 * fonction à deux dimensions
	 */
	public SinExp() {
		super(2);
	}

	@Override
	public double evaluer(double[] val) {
		double x=val[0];
		double y=val[1];
		return(100*Math.sin(x)*Math.sin(y)*Math.exp(-x*x + x*y - y*y));

	}

}
