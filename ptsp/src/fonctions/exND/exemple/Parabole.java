package fonctions.exND.exemple;

import fonctions.FonctionND;

public class Parabole extends FonctionND {

	public Parabole() {
		super(2);
	}

	@Override
	public double evaluer(double[]val) {
		return(val[0]*val[0]+val[1]*val[1]);
	}

}