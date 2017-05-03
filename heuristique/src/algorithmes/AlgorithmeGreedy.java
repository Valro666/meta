package algorithmes;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeGreedy extends AlgorithmeAbstract {

	public AlgorithmeGreedy(Problem p) {
		super(p);
	}

	@Override
	public SolutionPartielle construireMeilleur() {

		SolutionPartielle enCours = this.problemeAResoudre.solutionInitiale();

		SolutionPartielle sol = loop(enCours);

		return sol;

	}

	SolutionPartielle loop(SolutionPartielle loop) {

		SolutionPartielle tmp = loop.solutionsVoisines()[0];

		for (SolutionPartielle a : loop.solutionsVoisines()) {
			if ((this.problemeAResoudre.evaluer(tmp)) <= (this.problemeAResoudre.evaluer(a))) {
				tmp = a;
			}
		}
		
		if (tmp.solutionsVoisines().length == 0) {
			return tmp;
		} else {
			return loop(tmp);
		}
	}
}
