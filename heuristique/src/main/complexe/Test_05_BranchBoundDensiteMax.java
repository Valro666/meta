package main.complexe;

import algorithmes.AlgorithmeBranchAndBound;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;

public class Test_05_BranchBoundDensiteMax {

	public static void main(String args[]) {

		// System.out.println("BaB");

		// creation du probleme
		Problem probleme = ProblemSacADos.initialiseProblemeComplexe();

		// creation algorithme
		AlgorithmeBranchAndBound parcoursComplet;
		parcoursComplet = new AlgorithmeBranchAndBound(probleme, new HeuristiqueDensiteMax());

		// resultat
		SolutionPartielle resultat = parcoursComplet.construireMeilleur();
		System.out.println(resultat);

	}

}
