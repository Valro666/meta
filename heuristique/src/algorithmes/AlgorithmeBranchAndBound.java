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

	SolutionPartielle meilleur() {

		if (liste.size() == 1) {
			SolutionPartielle tmp = ouvert.get(0);
			ouvert.remove(tmp);
			return tmp;

		}

		SolutionPartielle tmp = ouvert.get(0);

		for (int i = 0; i < ouvert.size(); i++) {
			if (problemeAResoudre.evaluer(tmp) > problemeAResoudre.evaluer(ouvert.get(i))) {
				tmp = ouvert.get(i);
			}
		}
		ouvert.remove(tmp);
		return tmp;
	}

	boolean contien(SolutionPartielle a) {

		for (SolutionPartielle truc : liste) {
			if (problemeAResoudre.evaluer(truc) == problemeAResoudre.evaluer(a)) {
				return true;
			}
		}

		return false;
	}

	ArrayList<SolutionPartielle> ouvert = new ArrayList<SolutionPartielle>();

	void bidule(SolutionPartielle solutionInitiale) {

		ArrayList<SolutionPartielle> al = new ArrayList<SolutionPartielle>();
		// ArrayList<SolutionPartielle> fermer = new
		// ArrayList<SolutionPartielle>();

		ouvert.add(solutionInitiale);

		int tour = 0;
		while (ouvert.size() != 0) {
			this.compteur++;
			// System.out.println("gred");
			SolutionPartielle tmp = meilleur();
			liste.add(tmp);

			SolutionPartielle[] tab = tmp.solutionsVoisines();

			for (SolutionPartielle a : tab) {
				if (!liste.contains(a))
					if (problemeAResoudre.evaluer(a) >= problemeAResoudre.evaluer(tmp)) {
						ouvert.add(a);
					}
			}
			tour++;
		}
	}
}
