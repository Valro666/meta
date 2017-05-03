package algos.algo1D;

import fonctions.Fonction1D;


/**
 * factory pour génerer des algorithmes particuliers
 * 
 */
public class FactoryAlgo1D {

	public static AbstractAlgo1D getAlgo(Fonction1D f,String s,double depart)
	{
		if (s.equals("descenteGradient"))
			return(new DescenteGradient(f, 0.1, depart));
		if (s.equals("descenteGradientAlphaGrand"))
			return(new DescenteGradient(f, 10., depart));
		if (s.equals("encadrement"))
			return(new Encadrement(f, -Math.PI, depart,0.5));
		throw new IllegalArgumentException("erreur algo non connu");
		
	}
	
}
