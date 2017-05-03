package probleme.TSP;

import java.util.ArrayList;

import generic.*;

/**
 * probleme du TSP
 * 
 * @author vthomas
 * 
 */
public class TSP implements ProblemeAbstract {
    /**
     *  nombre d'evaluation 
     */
    
    public int nbEvaluations;

    /**
	 * nombre de villes du TSP
	 */
	public int nombreVilles;
	
	/**
	 * taille de la grille dans laquelle sont les villes
	 */
	public int taillePlan;

	
	/**
	 * liste des villes
	 */
	public ArrayList<Ville> listeVilles;

	/**
	 * créé un probleme de TSP
	 * 
	 * @param n
	 *            nombre de noeuds
	 * @param d
	 *            dimension de la grille
	 */
	public TSP(int n, int d) {
		this.nombreVilles = n;
		this.taillePlan = d;

		listeVilles = new ArrayList<Ville>();
		for (int i = 0; i < n; i++)
		    listeVilles.add(new Ville(d, i));
		// initialisation du nombre d'évaluation
		this.nbEvaluations = 0;
	}

    /**
     * retourne le nombre d'évaluations 
     */
    public int getNbEvaluations(){
	return this.nbEvaluations;
    }

    /**
     * remet a zero le nombre d'évaluations 
     */
    public void resetNbEvaluations(){
	this.nbEvaluations = 0;
    }
    
    
    
	@Override
	public double evaluation(SolutionAbstract s) {
		//teste la solution
		SolutionTSP solutionTSP=(SolutionTSP)s;
		this.nbEvaluations ++;
		return solutionTSP.calculerDistanceChemin();
		
	}

}
