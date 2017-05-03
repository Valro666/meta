package algorithmes;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import generic.Heuristique;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeBranchAndBound extends AlgorithmeParcoursLargeurFiltre {

	Heuristique heuristique;

	public AlgorithmeBranchAndBound(Problem p, Heuristique h) {
		super(p);
		this.heuristique = h;
	}

	// on retire les solutions dominee
	@Override
	protected void filtrerGlobal(ArrayList<SolutionPartielle> nouvelles) {
		// System.out.println("vyi");
		super.filtrerGlobal(nouvelles);

		int nombreSupprimee = 0;

		double meilleureValeur = -1;
		for (SolutionPartielle s : nouvelles) {
			double evaluation = problemeAResoudre.evaluer(s);
			if (evaluation > meilleureValeur)
				meilleureValeur = evaluation;
		}

		// si l'esperance d'une solution est <0 que la meilleure valeur
		for (int i = 0; i < nouvelles.size(); i++) {
			SolutionPartielle s = nouvelles.get(i);
			double valeur = problemeAResoudre.evaluer(s);
			double estimation = heuristique.estimer(s);
			double attenteMax = valeur + estimation;

			if (attenteMax < meilleureValeur) {
				nombreSupprimee++;
				nouvelles.remove(i);
				// pour revenir avant
				i--;
			}

		}
		// System.out.println("-> supprimes : "+nombreSupprimee);

	}

	void bidule(SolutionPartielle solutionInitiale) {

		ArrayList<SolutionPartielle> al = new ArrayList<SolutionPartielle>();

		for (SolutionPartielle a : (solutionInitiale.solutionsVoisines())) {
			// if (!a.invalide()) {
			al.add(a);
			// }
		}

		this.filtrerGlobal(al);

		for (SolutionPartielle a : al) {
			// if (!a.invalide()) {
			liste.add(a);
			bidule(a);
			this.compteur++;
			// }
		}
	}

}
