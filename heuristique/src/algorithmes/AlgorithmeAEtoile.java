package algorithmes;

import java.util.ArrayList;
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
	ArrayList<ValeurAEtoile> liste = new ArrayList<ValeurAEtoile>();
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
			liste.add(valEtoile);

			meilleureTrouvee = solutionEnCours;
		}

		bidule2();

		return liste.get(0).solutionStockee;

	}

	int test = 0;

	private void bidule2() {
		// TODO Auto-generated method stub

		if (liste.size() > 0)
		// if (test < 65)s
		{

			ValeurAEtoile val = liste.get(0);
			System.out.println(test + " " + val);
			liste.remove(0);

			boolean first = true;
			for (SolutionPartielle voi : val.solutionStockee.solutionsVoisines()) {
				double valeur = this.problemeAResoudre.evaluer(voi);
				double heuristique = this.heuristique.estimer(voi);
				ValeurAEtoile valVoisin = new ValeurAEtoile(voi, valeur, heuristique);
				// liste.add(valVoisin);
				// System.out.println();

				if (liste.size() == 0) {
					liste.add(valVoisin);
					continue;
				}

				if ((liste.get(0).heuristiqueEstimee) >= (valVoisin.heuristiqueEstimee)) {
					liste.add(0, valVoisin);
				} else {
					// liste.add(valVoisin);
				}
			}
			test++;
			// for (ValeurAEtoile a : liste) {
			// System.out.print(a.heuristiqueEstimee + " ");

			// System.out.println();
			bidule2();
			// }

			// System.out.println(liste.get(0));
			// meilleureTrouvee = liste.get(0).solutionStockee;
		}
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

					for (ValeurAEtoile b : atraiter) {
						if (b.heuristiqueEstimee < val.heuristiqueEstimee) {
							// atraiter.
							val = b;
							meilleureTrouvee = a;
						}
					}
				}
			}
		}
	}
}
