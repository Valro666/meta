import generic.*;
import algo.*;
import probleme.quatreCouleurs.*;
import probleme.TSP.*;

import java.util.Properties;

public class ILS {

	public static void main(String[] args) {

		Properties parametres = readProperties("parametres.properties");
		if (args.length > 0)
			parametres = readProperties(args[1]);

		// read parameters
		int maxEvaluations = 10000;
		String s;
		if ((s = parametres.getProperty("maxEvaluations")) != null)
			maxEvaluations = Integer.parseInt(s);

		String nom = "";

		// Choix du probleme
		// Solution4Couleurs solution = new Solution4Couleurs(probleme)
		// ------------------------
		Probleme4Couleurs probleme = new Probleme4Couleurs(10);
		SolutionAbstract solution = new Solution4Couleurs(probleme);

//		TSP probleme = new TSP(100, 400);
//		SolutionAbstract solution = new SolutionTSP(probleme);

		// choix de l'algorithme
		AlgorithmeAbstract LS = AlgorithmeAbstract.getAlgo("sls", probleme, solution, maxEvaluations);

		// LS = new Greedy(probleme, solution, maxEvaluations);

		System.out.println("Parametres : " + parametres + "\n");

		// TODO a ecrire etudiant

		// une execution de l'algorithme

		// solution = (SolutionTSP) solution.retourneVoisinHasard();
		LS.executeJusquaFin();
		SolutionAbstract init = LS.getSolutionEnCours();
		double val = LS.valeur();

		// sauvgarde de la solution

		// tant que notre budget en evaluation n'est pas termine

		while (probleme.getNbEvaluations() < maxEvaluations) {

			// Perturber la solution courante

			SolutionAbstract sol = LS.getSolutionEnCours().retournePerturbation(13);

			LS.reset(sol);

			LS.executeJusquaFin();

			if (val > LS.valeur()) {

				// switch (nom) {
				// case "4":
				// solution = (Solution4Couleurs) sol;
				// break;
				// case "tsp":
				// solution = (SolutionTSP) sol;
				// break;
				// }

				solution = sol;
				val = LS.valeur();

			}

			// if (probleme.evaluation(init) < probleme.evaluation(ame)) {
			// init = (SolutionTSP) ame;
			//
			// }

			// LS.reset(init);

			// Executer de l'algorithme

			// Si la solution et meilleure on remplce
			// System.out.println(LS.getValeurMeilleureSolution()+"
			// "+probleme.getNbEvaluations()+" "+maxEvaluations);

		}

		// FinTODO a ecrire etudiant

		System.out.println("# Best Ever solution value= " + LS.getValeurMeilleureSolution());
	}

	/**
	 * Lecture du fichier de parametres
	 */

	private static Properties readProperties(String fileName) {
		Properties properties = new Properties();
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
			properties.load(fis);
			fis.close();
		} catch (java.io.IOException e) {
			System.out.println("File '" + fileName + "' not found, no options read");
			e.printStackTrace();
			System.exit(1);
		}

		return properties;
	}

}
