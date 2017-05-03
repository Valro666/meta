package generic;


/**
 * permet de définir un probleme de manière abstraite
 * 
 * un probleme est défini par
 * - sa définition de voisinnage
 * - sa fonction d'évaluation
 * 
 * @author vthomas
 *
 */
public interface ProblemeAbstract {

	
	/**
	 * méthode qui retourne une évaluation de la solution donnée
	 * @param s la solution fournie
	 * @return l'évaluation de cette solution
	 */
    public abstract double evaluation(SolutionAbstract s);
    public int getNbEvaluations();
    public void resetNbEvaluations();
}
