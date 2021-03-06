package algo;

import java.util.List;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

/**
 * classe representant un algorithme de type greedy
 * 
 * @author vthomas
 *
 */
public class Greedy extends AlgorithmeAbstract {

	public Greedy(ProblemeAbstract probleme, SolutionAbstract solutionInitiale, int maxEvaluations) {
		super(probleme, solutionInitiale, maxEvaluations);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur d'un algorithme greedy
	 * 
	 * @param probleme
	 *            le probleme a resoudre
	 * @param initiale
	 *            la solution initiale a modifier
	 */
	// public Greedy(ProblemeAbstract probleme, SolutionAbstract initiale) {
	// super(probleme, initiale);
	// }

	/**
	 * permet d'améliorer la solution selon une approche gloutonne
	 */
	public boolean ameliorerSolution() {

		// System.out.println(problemeATraiter.evaluation(solutionEnCours));

		List<SolutionAbstract> voisin = solutionEnCours.retourneVoisinage();
		SolutionAbstract res = null;
		double s = problemeATraiter.evaluation(solutionEnCours);

		for (SolutionAbstract sol : voisin) {

			double ss = problemeATraiter.evaluation(sol);
			if (s > ss) {
				res = sol;
			}
		}

		solutionEnCours = res;

		if (res == null)
			return false;

		return true;

		// on s'arrete si la solution ne s'ameliore plus
	}

	@Override
	public boolean amelioreSolution() {
		// TODO Auto-generated method stub

		List<SolutionAbstract> voisin = solutionEnCours.retourneVoisinage();
		SolutionAbstract res = null;
		double s = this.valeur();

		for (SolutionAbstract sol : voisin) {

			double ss = problemeATraiter.evaluation(sol);
			if (s > ss) {
				res = sol;
			}
		}

		solutionEnCours = res;

		if (res == null)
			return false;

		return true;
	}

}
