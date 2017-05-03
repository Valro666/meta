package sacADos;

import generic.Heuristique;
import generic.SolutionPartielle;

/**
 * une heuristique qui consiste à considerer qu'on peut mettre des objets en
 * quantité infinie avec la densite max
 * 
 */
public class HeuristiqueDensiteMax extends Heuristique {
	
	static int z = 0 ;

	@Override
	public double estimer(SolutionPartielle solutionAnalysee) {
		z++;
		
		//if(z%1000==0) System.out.println("ici "+z);

		SolutionSacADos s = (SolutionSacADos) solutionAnalysee;

		// si solution complete
		if (s.estComplete())
			// retourne 0
			return 0;
		
		// on recupere meilleuredensite
		double densite = s.problemeEnCours.getDensiteMax();
		int restant = s.problemeEnCours.contenance - s.volumeActuel;
		if (restant < 0)
			restant = 0;

		double max = restant * densite;
		return max;
	}

}
