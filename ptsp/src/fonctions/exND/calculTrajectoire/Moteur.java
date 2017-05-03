package fonctions.exND.calculTrajectoire;

import java.util.ArrayList;

/**
 * permet de faire eevoluer une particule grace à un vecteur d'acceleration
 * 
 * @author vthomas
 * 
 */
public class Moteur {

	/**
	 * la particule à faire bouger
	 */
	Particule p;

	/**
	 * le profil d'acceleration fourni
	 */
	Solution acceleration;

	/**
	 * creation d'un moteur physique construit la particule et récupere le
	 * vecteur d'acceleration
	 * 
	 * @param s
	 *            solution correspondant à un vecteur d'acceleration
	 */
	public Moteur(Solution s) {
		this.p = new Particule();
		this.acceleration = s;
	}

	
	/**
	 * fait évoluer la particule
	 */
	public ArrayList<Double>[] evoluer()
	{
		//on initialise la particule
		this.p = new Particule();
		//resultat
		ArrayList<Double> x=new ArrayList<Double>();
		ArrayList<Double> y=new ArrayList<Double>();
		//pour chaque element du profil d'acceleration
		for (int i=0;i<this.acceleration.ax.length;i++)
		{
			//on change acceleration
			p.modifierAcceleration(this.acceleration.ax[i], this.acceleration.ay[i]);
			//on fait evoluer 10 fois
			for (int j=0;j<10;j++)
			{
				//on evolue une seconde
				p.mettreAJour(0.1);
				//System.out.println(p);
				//sauve données
				x.add(p.px);
				y.add(p.py);				
			}
		}
		//fin d'evolution
		ArrayList<Double>[]tab=new ArrayList[2];
		tab[0]=x;
		tab[1]=y;
		return(tab);
	}
	
	/**
	 * évalue la particule par rapport à un objectif
	 * @double ox objectif en x
	 * @double oy objectif en y
	 */
	public double evaluer(double ox,double oy)
	{
		//on initialise la particule
		this.p = new Particule();
		//pour chaque element du profil d'acceleration
		for (int i=0;i<this.acceleration.ax.length;i++)
		{
			//on change acceleration
			p.modifierAcceleration(this.acceleration.ax[i], this.acceleration.ay[i]);
			//on fait evoluer 10 fois
			for (int j=0;j<10;j++)
			{
				//on evolue une seconde
				p.mettreAJour(0.1);
			}
		}
		
		double dcarre=(p.px-ox)*(p.px-ox)+(p.py-oy)*(p.py-oy);
		return(Math.sqrt(dcarre));
		
		
	}
	
}
