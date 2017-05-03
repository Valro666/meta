import java.util.ArrayList;

import fonctions.exND.calculTrajectoire.Moteur;
import fonctions.exND.calculTrajectoire.Solution;
import fonctions.exND.calculTrajectoire.Trajectoire;



public class Principale {

	/**
	 * test en lancant une particule
	 * @param args inutilisé
	 */
	public static void main(String args[])
	{
		Solution s=new Solution(5);
		s.ax=new double[]{0.0,-50.0,50.0,0.};
		s.ay=new double[]{0.,20.0,0.0,-20.};
	
		//on construit un moteur
		Moteur m=new Moteur(s);
		
		//on calcule la trajectoire
		ArrayList<Double>[]tab=m.evoluer();
		//on l'affiche
		new Trajectoire(tab); 
		
		//on évalue la trajectoire
		System.out.println(m.evaluer(10,10));
		
		
		
		
	}
	
}
