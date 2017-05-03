package fonctions.exND.calculTrajectoire;
/**
 * une solution au probleme
 * 
 * consiste en un vecteur d'acceleration de la particule
 * 
 * @author vthomas
 * 
 */
public class Solution {

	public double ax[];
	public double ay[];

	/**
	 * construit une suite de vecteur d'acceleration au fur et à mesure du temps
	 * 
	 * @param taille
	 *            nombre de pas de temps considérés
	 */
	public Solution(int taille) {
		ax = new double[taille];
		ay = new double[taille];
	}
	
}
