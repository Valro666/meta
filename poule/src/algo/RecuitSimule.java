package algo;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

import java.util.List;

/**
 * classe recuit simulé
 * <p>
 * herite de Algrotihme, à redefinir
 * <p>
 * attribut temperature
 * <p>
 * iteration doit - recuperer le voisinage - choisir au hasard un point - tirer
 * un nombre aleatoire - faire évoluer la temperature
 * 
 * 
 * @author vthomas
 * 
 */
public class RecuitSimule extends AlgorithmeAbstract {

	public RecuitSimule(ProblemeAbstract probleme, SolutionAbstract solutionInitiale, int maxEvaluations) {
		super(probleme, solutionInitiale, maxEvaluations);
		// TODO Auto-generated constructor stub
	}

	/**
	 * variation de temperature par iteration
	 */
	public double DELTA_TEMPERATURE = 0.99;

	/**
	 * la temperature qui décroit au cours du temps;
	 */
	double temperature;

	/**
	 * valeur de la solution en cours
	 */
	double valeurActuelleSolution = 0;

	/**
	 * constructeur
	 * 
	 * @param probleme
	 *            probleme à resoudre
	 * @param solutionInitiale
	 *            solution initiale fournie
	 * @param temperatuer
	 *            temperature initiale
	 */
	// public RecuitSimule(ProblemeAbstract probleme, SolutionAbstract
	// solutionInitiale, double temperature) {
	// super(probleme, solutionInitiale);
	// this.temperature = temperature;
	// }

	/**
	 * lance une iteration.
	 * <p>
	 * A completer en utilisant les méthodes
	 * <ul>
	 * <li>choisirHasard
	 * <li>estAccepte
	 * </ul>
	 */
	boolean ameliorerSolution() {
		boolean truc = false;

		for (int i = 0; i < 1000; i++) {
			// System.out.println(i);
			SolutionAbstract sol = choisirHasard(solutionEnCours.retourneVoisinage());

			double evalSol = problemeATraiter.evaluation(sol);
			double actu = problemeATraiter.evaluation(solutionEnCours);

			if (evalSol < actu) {
				solutionEnCours = sol;
				this.miseAJourTemperature();
				truc = true;
				break;
			} else {
				if (estAcceptee(sol)) {
					solutionEnCours = sol;
					this.miseAJourTemperature();
					truc = true;
					break;
				}
			}
		}

		return truc;
	}

	public SolutionAbstract choisirHasard() {

		List<SolutionAbstract> voisin = solutionEnCours.retourneVoisinage();
		int p = (int) Math.random() * voisin.size();
		return voisin.get(p);
	}

	public SolutionAbstract choisirHasard(List<SolutionAbstract> voisin) {
		return voisin.get((int) Math.random() * voisin.size());
	}

	private void miseAJourTemperature() {
		this.temperature = this.temperature * DELTA_TEMPERATURE;
	}

	/**
	 * méthode stochastique pour savoir si une solution est validée
	 * 
	 * @param solutionAbstract
	 *            solution à comparer à la solution actuelle
	 * @return booleen qui valide ou non
	 */
	private boolean estAcceptee(SolutionAbstract solution) {

		double r = Math.random();

		double vsol, vactu;

		vsol = problemeATraiter.evaluation(solution);

		vactu = problemeATraiter.evaluation(solutionEnCours);

		if (r < probaMetropolis(Math.abs(vsol - vactu))) {
			return true;
		}

		return false;

	}

	/**
	 * retourne la proba d'acceptation en fonction de la difference de valeur et
	 * de la temperature
	 * 
	 * @param deltaValeur
	 *            difference de valeur entre solution courante et la nouvelle
	 *            solution
	 * 
	 * @return probabilite d'accepter la nouvelle solution
	 */
	private double probaMetropolis(double deltaValeur) {

		double res = 0;

		res = Math.exp(-((deltaValeur) / this.temperature));

		return res;
		// throw new Error("TODO"); // TODO a completer
	}

	/**
	 * par defaut on affiche aussi la temperature
	 */
	public String log() {
		return super.log() + "; T;" + temperature;
	}

	@Override
	public boolean amelioreSolution() {
		// TODO Auto-generated method stub
		return false;
	}

}
