

import fonctions.exND.exemple.Ackley;
import fonctions.exND.exemple.Parabole;
import fonctions.exND.exemple.SinExp;
import algos.algoND.DescenteGradientND;

public class TestMinimisation2D {

	public static void main(String[]args)
	{
		
		DescenteGradientND gd=new DescenteGradientND(new Parabole(), new double[]{5., 5.}, 0.1);
		gd.minimiser(100);
		
		
		System.out.println("\n\n\nSinEXP...");
		DescenteGradientND gd2=new DescenteGradientND(new SinExp(), new double []{0.5, 0.}, 0.01);
		gd2.minimiser(100);
		
		
		System.out.println("\n\n\nackley");
		DescenteGradientND gd3=new DescenteGradientND(new Ackley(), new double[]{-1,1},0.001);
		gd3.minimiser(100);
		
	}
	
}
