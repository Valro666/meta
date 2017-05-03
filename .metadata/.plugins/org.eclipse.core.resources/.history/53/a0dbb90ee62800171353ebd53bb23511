package generic;


import probleme.quatreCouleurs.TabouFiltreAttribut;
import algo.Greedy;
import algo.RecuitSimule;
import algo.Tabou;
import algo.SLS;
import java.util.Properties;
/**
 * algorithme abstrait se base sur un probleme abstrait et des solutions
 * abstraites à implementer
 * 
 * @author vthomas@loria.fr
 * 
 */

public abstract class AlgorithmeAbstract {

    /**
     * solution en cours à modifier au fur et a mesure de l'algorithme
     */
    protected SolutionAbstract solutionEnCours;
    protected double valeurSolutionEnCours;

    protected double valeurMeilleureSolution;

    
    /**
     * probleme sur lequel appliquer la solution
     */
    protected ProblemeAbstract problemeATraiter;

    /**
     * Nombre d'itération de l'algorithme
     * incrementées dans algo
     */
    protected int iterationsEffectuee;

    /**
     * le nombre maximum d'évaluation donne dans le constructeur 
     */
    protected int maxEvaluations;
    
    /**
     * construit un algorithme à partir d'une solution initiale
     * 
     * @param probleme
     *            definition du probleme à traiter
     * @param solutionInitiale
     *            solution initiale
     */
    public AlgorithmeAbstract(ProblemeAbstract probleme,
			      SolutionAbstract solutionInitiale,
			      int maxEvaluations) {
	
	this.solutionEnCours     = solutionInitiale;
	this.problemeATraiter    = probleme;
	this.iterationsEffectuee = 0;
	this.maxEvaluations      = maxEvaluations;
	
	// evaluation de la solution initiale 
	this.valeurSolutionEnCours = probleme.evaluation(solutionInitiale);
	this.valeurMeilleureSolution = this.valeurSolutionEnCours;
    }

    /**
     * méthode a redefinir
     * 
     * @return booleen pour arreter eventuellement la boucle
     */
    public abstract boolean amelioreSolution();


    /**
     * Reinitialise l'algorithme dans le cas d'une nouvelle iteration
     */
    
    public void reset(SolutionAbstract s){
	this.solutionEnCours = s;
	this.valeurSolutionEnCours = this.problemeATraiter.evaluation(s);
	this.iterationsEffectuee = 0;
    }
 
    /**
     * Exécution complète de l'algorithme 
     *  - tant qu'il n'y a plus d'amelioration ou jusqu'a bloquée
     *  - ou arriver au nombre max d'évaluations  
     */
    public void executeJusquaFin(){
	boolean amelioration = true;
	
	while ( amelioration &&
		this.problemeATraiter.getNbEvaluations()<this.maxEvaluations) {

	    amelioration = amelioreSolution();
	    // remplace la meilleure solution si mieux 
	    if ( this.valeurSolutionEnCours < this.valeurMeilleureSolution){
		this.valeurMeilleureSolution = this.valeurSolutionEnCours;
	    }
	    
	    this.iterationsEffectuee++;
	    System.out.println(log());
	
	}
    }


    /**
     * permet de retourner la valeur de la solution courante
     * 
     * @return valeur de s selon probleme pb
     */
    public double valeur() {
	return this.valeurSolutionEnCours;
    }

    /**
     * permet d'afficher le contenu de l'algo
     * 
     * @return par defaut la valeur
     */
    public String log() {
       	return ""+problemeATraiter.getNbEvaluations()+" "+iterationsEffectuee+" "+valeur();
    }

    public SolutionAbstract getSolutionEnCours() {
	return this.solutionEnCours;
    }

    public double getValeurMeilleureSolution() {
	return this.valeurMeilleureSolution;
    }

    

    /**
     * factory simple permet recuperer un algorithme donné
     * 
     * @param probleme
     *            le probleme à resoudre
     * @param solutionInitiale
     *            la solution initiale
     * @param nom
     *            le nom de l'algo
     */
    public static AlgorithmeAbstract getAlgo(String nom,
					     ProblemeAbstract probleme, 
					     SolutionAbstract solutionInitiale,
					     int maxEvaluations){
	switch (nom) {
	case "greedy":
	    return new Greedy(probleme, solutionInitiale, maxEvaluations);
	case "recuit":
	    return new RecuitSimule(probleme, solutionInitiale, 1000, maxEvaluations);
	case "tabou":
	    return new Tabou(probleme, solutionInitiale, 
			     new TabouFiltreAttribut(20), maxEvaluations);
	case "sls":
	    return new SLS(probleme, solutionInitiale, maxEvaluations);
	    
	}
	return (null);
    }


   

}
