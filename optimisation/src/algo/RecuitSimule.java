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

	/**
	 * variation de temperature par iteration
	 */
	public double DELTA_TEMPERATURE = 0.9999;

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
	public RecuitSimule(ProblemeAbstract probleme, SolutionAbstract solutionInitiale, double temperature) {
		super(probleme, solutionInitiale);
		this.temperature = temperature;
	}

	// public SolutionAbstract ppt() {
	// List<SolutionAbstract> voisin = solutionEnCours.retourneVoisinage();
	// SolutionAbstract res = voisin.get(0);
	//
	// for (SolutionAbstract sol : voisin) {
	//
	// double s = problemeATraiter.evaluation(solutionEnCours);
	// double ss = problemeATraiter.evaluation(sol);
	// if (s >= ss) {
	// res = sol;
	// }
	//
	// }
	// return res;
	// }

	@Override
	/**
	 * lance une iteration.
	 * <p>
	 * A completer en utilisant les méthodes
	 * <ul>
	 * <li>choisirHasard
	 * <li>estAccepte
	 * </ul>
	 */

	public boolean ameliorerSolution() {
		boolean truc = false;
		// temperature = 1000;
		int tour = 0;
		while (tour < 3) {

			SolutionAbstract nouvel = choisirHasard();

			double actu = problemeATraiter.evaluation(solutionEnCours);
			if (problemeATraiter.evaluation(nouvel) < actu) {

				solutionEnCours = nouvel;
				truc = true;
			} else {
				if (estAcceptee(nouvel)) {
					solutionEnCours = nouvel;

				}
			}
			tour++;
			miseAJourTemperature();
		}
		// miseAJourTemperature();

		// miseAJourTemperature();
		return truc;
	}

	public boolean ameliorerSolution2() {
		boolean truc = false;

		for (int i = 0; i < 1000; i++) {
			// System.out.println(i);
			SolutionAbstract sol = choisirHasard();

			double evalSol = problemeATraiter.evaluation(sol);
			double actu = problemeATraiter.evaluation(solutionEnCours);

			if (evalSol < actu) {
				if (estAcceptee(sol)) {
					solutionEnCours = sol;
					truc = true;
					// System.out.println("sedg");
				}
			} else {
				double p = probaMetropolis(Math.abs(evalSol - actu));
				if (p > Math.random()) {
					if (estAcceptee(sol)) {
						solutionEnCours = sol;
						// System.out.println("bte");
						truc = true;
					}
				}
			}
			this.miseAJourTemperature();

			// if (i % 900 == 0)
			// System.out.println(i);

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
		// temperature--;
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
		// System.out.println(Math.abs(vsol - vactu));

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
		// System.out.println(res);

		return res;
		// throw new Error("TODO"); // TODO a completer
	}

	/**
	 * par defaut on affiche aussi la temperature
	 */
	public String log() {
		return super.log() + "; T;" + temperature;
	}

}
