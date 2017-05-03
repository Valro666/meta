package algorithmes;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

import generic.AlgorithmeAbstract;
import generic.Heuristique;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeAEtoile extends AlgorithmeAbstract {

	Heuristique heuristique;

	public AlgorithmeAEtoile(Problem p, Heuristique h) {
		super(p);
		this.heuristique = h;
	}

	PriorityQueue<ValeurAEtoile> atraiter = new PriorityQueue<ValeurAEtoile>();
	SolutionPartielle meilleureTrouvee = null;

	@Override
	public SolutionPartielle construireMeilleur() {

		SolutionPartielle solutionEnCours = this.problemeAResoudre.solutionInitiale();

		// initilisation
		{
			ValeurAEtoile valEtoile;
			double valeur = this.problemeAResoudre.evaluer(solutionEnCours);
			double heuristique = this.heuristique.estimer(solutionEnCours);
			valEtoile = new ValeurAEtoile(solutionEnCours, valeur, heuristique);
			atraiter.add(valEtoile);
			meilleureTrouvee = solutionEnCours;
		}

		// throw new Error("TODO"); //TODO a completer etudiants

		bidule();

		return null;

	}

	private void bidule() {
		// TODO Auto-generated method stub
		if (!atraiter.isEmpty()) {
			ValeurAEtoile vae = atraiter.poll();

			SolutionPartielle[] voisin = vae.solutionStockee.solutionsVoisines();

			for (SolutionPartielle a : voisin) {
				if (atraiter.isEmpty())
					atraiter.add(new ValeurAEtoile(a, this.problemeAResoudre.evaluer(a), this.heuristique.estimer(a)));
				else {
					ValeurAEtoile val;
					double valeur = this.problemeAResoudre.evaluer(a);
					double heuristique = this.heuristique.estimer(a);
					val = new ValeurAEtoile(a, valeur, heuristique);
					
					for(ValeurAEtoile b : atraiter){
						if(b.heuristiqueEstimee<val.heuristiqueEstimee){
							//atraiter.
						}
						
					}
				}

			}

		}
	}

}
