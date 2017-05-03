package algorithmes;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeParcoursLargeurFiltre extends AlgorithmeParcoursLargeur {

	public AlgorithmeParcoursLargeurFiltre(Problem p) {
		super(p);
	}

	protected boolean doitEtreFiltre(SolutionPartielle fille, ArrayList<SolutionPartielle> nouvelles) {

		this.compteur++;
		for (SolutionPartielle a : fille.solutionsVoisines()) {
			if (!a.invalide()) {
				liste.add(a);
				bidule(a);
				return true;
			}
		}
		return false;
	}

	void bidule(SolutionPartielle solutionInitiale) {
		this.compteur++;
		for (SolutionPartielle a : solutionInitiale.solutionsVoisines()) {
			if (!a.invalide()) {
				liste.add(a);
				bidule(a);
			}
		}
	}
}
