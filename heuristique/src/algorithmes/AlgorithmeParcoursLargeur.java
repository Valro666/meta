package algorithmes;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeParcoursLargeur extends AlgorithmeAbstract {

	public AlgorithmeParcoursLargeur(Problem p) {
		super(p);
	}

	@Override
	public SolutionPartielle construireMeilleur() {
		return (calculerLargeur(this.problemeAResoudre.solutionInitiale()));
	}

	/**
	 * méthode recursive
	 * 
	 * @param solutionInitiale
	 * @return meilleur solution en dessous de la solution initiale
	 */

	ArrayList<SolutionPartielle> liste = new ArrayList<SolutionPartielle>();

	private SolutionPartielle calculerLargeur(SolutionPartielle solutionInitiale) {

		// construit liste
		// liste.add(solutionInitiale);
		bidule(solutionInitiale);

		SolutionPartielle sol = liste.get(0);
		for (SolutionPartielle a : liste) {
			if (a.estComplete()) {
				if (this.problemeAResoudre.evaluer(sol) < this.problemeAResoudre.evaluer(a)) {
					sol = a;
				}
			}
		}
		System.out.println(compteur);
		return sol;
		// throw new Error("TODO"); //TODO a completer en utilisant
		// profondeurSuivante
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

	/**
	 * cherche la meilleure solution dans une liste
	 * 
	 * @param liste
	 *            dont on cherche la meilleure solution
	 * @return meilleure solution de la liste
	 */
	private SolutionPartielle chercherMeilleureSolution(ArrayList<SolutionPartielle> liste) {
		SolutionPartielle meilleur = null;
		double max = -1;
		for (SolutionPartielle s : liste) {
			if (this.problemeAResoudre.evaluer(s) >= max) {
				max = this.problemeAResoudre.evaluer(s);
				meilleur = s;
			}
		}
		return meilleur;
	}

	/**
	 * construit la liste à une nouvelle profondeur
	 * 
	 * @param parents
	 *            liste de profondeur n
	 * @return liste de profondeur n+1
	 */
	private ArrayList<SolutionPartielle> profondeurSuivante(ArrayList<SolutionPartielle> parents) {

		ArrayList<SolutionPartielle> filles = new ArrayList<SolutionPartielle>(parents.size() * 2);

		throw new Error("TODO"); // TODO A completer

	}

	protected void filtrerGlobal(ArrayList<SolutionPartielle> nouvelles) {
		// ne fait rien
	}

	protected boolean doitEtreFiltre(SolutionPartielle fille, ArrayList<SolutionPartielle> nouvelles) {
		return (false);

	}

}
