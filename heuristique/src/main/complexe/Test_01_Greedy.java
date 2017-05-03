package main.complexe;
import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeGreedy;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_01_Greedy {

	public static void main(String args [])
	{
		
		System.out.println("largeurFiltree");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		AlgorithmeAbstract greedy=new AlgorithmeGreedy(probleme);
		
		//resultat
		SolutionPartielle resultat=greedy.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
