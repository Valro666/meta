package probleme.TSP;

public class Ville {

	public int x;
	public int y;
	public int idVille; 
	
	/**
	 * grille ou situer le point
	 * @param d taille de la grille
	 */
	public Ville(int d,int n)
	{
		x=(int)(Math.random()*d);
		y=(int)(Math.random()*d);
		idVille=n;
		
	}
	
	/**
	 * retourne distance netre deux villes
	 * @param v2
	 * @return
	 */
	public double calculerDistance(Ville v2)
	{
		double dx=this.x-v2.x;
		double dy=this.y-v2.y;
		
		return(Math.sqrt(dx*dx+dy*dy));
	}
	
	
	public String toString()
	{
	return(""+idVille);	
	}
	
}

