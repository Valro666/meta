package main.complexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_05_BranchBoundDensiteMax {

	public static void main(String args [])
	{
		
		System.out.println("BaB");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		AlgorithmeBranchAndBound parcoursComplet;
		parcoursComplet=new AlgorithmeBranchAndBound(probleme,new HeuristiqueDensiteMax());
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
