

import fonctions.exND.minimiserCercle.MinimiserCercle;
import algos.algoND.DescenteGradientND;
import algos.algoND.GradientNDPasOptimal;

public class testMinimisationCercle {

	public static void main(String args[])
	{
		//on fait une descente de gradient du probleme minimiserCercle
		DescenteGradientND gd=new DescenteGradientND(new MinimiserCercle(), new double[]{2, 0.5, 1},0.0001);
		gd.minimiser(5000);
		
		
		System.out.println(" \n\n\n\napproche pas optimal");
		GradientNDPasOptimal gdo=new GradientNDPasOptimal(new MinimiserCercle(), new double[]{2, 0.5, 1},0.0001);
		gdo.minimiser(100);
	}
	
}
